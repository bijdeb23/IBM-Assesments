package com.swiss.dao;

import java.sql.Connection;
import java.lang.Long;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.swiss.bean.TransactionDto;
import com.swiss.bean.UserDto;

public class SwissBankWalletDaoClass implements SwissBankWalletDaoInterface {
	PreparedStatement stmt;
	java.sql.Timestamp timestamp;

	public boolean validateUser(UserDto dto) {
		boolean result = false;
		
		DatabaseUtility dbU = new DatabaseUtility();
		try {
		
		Connection conn = dbU.connectToDatabase();
		
		String sql = "SELECT userName, password from userDetails WHERE userName= ? and password= ? ";
		
		
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, dto.getUserName());
            stmt.setString(2, dto.getPassword());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                result = true;
                System.out.println("User Account Matched!!!");

            }
            
            conn.close();
            stmt.close();
            
		} catch (SQLException e) {
			
			System.out.println("Issues while Login  : " + e);
		}
		
		
		
		return result;
	}
	

	public boolean accountNoValidation(UserDto dto1) {
		boolean result = false;
		
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
		Connection conn = dbU.connectToDatabase();
		
		String sql = "SELECT accountNo from userDetails WHERE accountNo= ? ;";
		
		
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, dto1.getAccountNo());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                result = true;
                System.out.println("Given Account Matched!!!!");

            }
            
            conn.close();
            stmt.close();
			
		} catch (SQLException e) {
			
			System.out.println("Issues while Account Searching  : " + e);
		}
		
		return result;
	}
	

	public boolean amountValidation(UserDto dto1, TransactionDto tdto) {
		
		boolean result = false;
		int userId = 0, newBalance = 0, newUserId = 0, chkBalance = 0;
		String chkAccountNo = null;
				
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
					Connection conn = dbU.connectToDatabase();
					   //check the balance of the sender before transferring
			            String sql5 = "SELECT userId, accountNo from userDetails WHERE userName = ? ;";
					
						stmt = conn.prepareStatement(sql5);
						
						stmt.setString(1, dto1.getUserName());
			            
			            ResultSet rs3 = stmt.executeQuery();
			            
			            while (rs3.next()) {
			            	
			            	newUserId = rs3.getInt("userId");
			            	chkAccountNo = rs3.getString("accountNo");
			            				        		
			            }
			            
			            String sql6 = "SELECT MAX(transactionTime) AS transactionTime from transactiondetails WHERE userId= ? and accountNo = ? ;";
			            
			            stmt = conn.prepareStatement(sql6);
						
						stmt.setInt(1, newUserId);
						stmt.setString(2, chkAccountNo);
									            
			            ResultSet rs4 = stmt.executeQuery();
			            
			            while (rs4.next()) {
			            	
			            	timestamp = rs4.getTimestamp("transactionTime");
			            	
			            }
			            
			            String sql7 = "SELECT balance from transactiondetails WHERE  accountNo = ? and transactionTime = ?;";
			            
			            stmt = conn.prepareStatement(sql7);
						
			            stmt.setString(1, chkAccountNo);
						stmt.setTimestamp(2, timestamp);
						
			            ResultSet rs5 = stmt.executeQuery();
			            
			            while (rs5.next()) {
			            	
			            	chkBalance = rs5.getInt("balance");
			            	
			            }
			            
			            if(chkBalance != 0) {
			            			//update the sender balance after sending account
					            	chkBalance = chkBalance - tdto.getDepositAmount();
					            	
					            	String sql8 = "INSERT into transactiondetails(userID, transactionTime , transactionType, withdrawlAmount, balance, accountNo) VALUES (?,?,?,?,?,?);";
					                
					                stmt = conn.prepareStatement(sql8);
					    			
					    			stmt.setInt(1,newUserId);
					    			stmt.setTimestamp(2,getCurrentJavaSqlTimestamp());
					    			stmt.setString(3, "Withdraw by Fund Transfer");
					    			stmt.setInt(4, tdto.getDepositAmount());
					    			stmt.setInt(5, chkBalance);
					    			stmt.setString(6, chkAccountNo);
					                
					                int row1 = stmt.executeUpdate();
					                
					                if(row1 > 0)
					                {
					                	result = true;
					                	System.out.println("Sender Account is Updating......");
					                }
					                
					                
					              //fetch userId by given account no. from userDetails table
									String sql = "SELECT userId from userDetails WHERE accountNo= ? ";
									
										stmt = conn.prepareStatement(sql);
										
										stmt.setString(1, dto1.getAccountNo());
							            
							            ResultSet rs = stmt.executeQuery();
							            
							            while (rs.next()) {
							            		userId = rs.getInt("userId");
							            }
							            //fetch last date when balance was updated for the given user
							            String sql2 = "SELECT MAX(transactionTime) AS transactionTime from transactiondetails WHERE userId= ? ";
							            
							            stmt = conn.prepareStatement(sql2);
										
										stmt.setInt(1, userId);
							            
							            ResultSet rs1 = stmt.executeQuery();
							            
							            while (rs1.next()) {
							            	
							            	timestamp = rs1.getTimestamp("transactionTime");
							            }
							            
							            //fetch the last balance of the given account no. by date
							            String sql3 = "SELECT balance from transactiondetails WHERE transactionTime = ? and accountNo = ? ";
							            
							            stmt = conn.prepareStatement(sql3);
										
										stmt.setTimestamp(1, timestamp);
										stmt.setString(2, dto1.getAccountNo());
							            
							            ResultSet rs2 = stmt.executeQuery();
							            
							            while (rs2.next()) {
							            	
							            	newBalance = rs2.getInt("balance");
							           
							            }
							            
							            newBalance = newBalance + tdto.getDepositAmount(); 
							            
							            //add new value to the transactionDetails table                      
							            String sql4 = "INSERT into transactiondetails(userID, transactionTime , transactionType, depositAmount, balance, accountNo) VALUES (?,?,?,?,?,?);";
							            
							            stmt = conn.prepareStatement(sql4);
										
										stmt.setInt(1,userId);
										stmt.setTimestamp(2,getCurrentJavaSqlTimestamp());
										stmt.setString(3, "Deposit by Fund Transfer");
										stmt.setInt(4, tdto.getDepositAmount());
										stmt.setInt(5, newBalance);
										stmt.setString(6, dto1.getAccountNo());
							            
							            int row = stmt.executeUpdate();
							            
							            if (row > 0) {
							
							               result = true;
							               System.out.println("Receiver Account is Updating.....");
							
							            }
			                
			    			}
			            	else
			            	{
			            		System.out.println("You Have Insufficient balence");
			            	}
			            
			            
			            conn.close();
			            stmt.close();
			            
			            
		} catch (SQLException e) {
			
			System.out.println("Issues while Transfering Funds  : " + e);
		}         
         
		
		return result;
	}


	public int chkAccountNoValidation(UserDto dto2) {
		
		int userId = 0, newBal = 0;
		String accountNo = null;
		
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
		Connection conn = dbU.connectToDatabase();
		
		//fetch userId by given account no. from userDetails table
		String sql = "SELECT userId, accountNo from userDetails WHERE userName = ? ";
		
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, dto2.getUserName());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            		userId = rs.getInt("userId");
            		accountNo = rs.getString("accountNo");
            }
            
            //fetch last date when balance was updated for the given user
            String sql1 = "SELECT MAX(transactionTime) AS transactionTime from transactiondetails WHERE userId= ? and accountNo = ? ";
            
            stmt = conn.prepareStatement(sql1);
			
			stmt.setInt(1, userId);
			stmt.setString(2, accountNo);
            
            ResultSet rs1 = stmt.executeQuery();
            
            while (rs1.next()) {
            	
            	timestamp = rs1.getTimestamp("transactionTime");
            }
            
            //fetch the last balance of the given account no. by date
            String sql3 = "SELECT balance from transactiondetails WHERE transactionTime = ? and accountNo = ? ";
            
            stmt = conn.prepareStatement(sql3);
			
			stmt.setTimestamp(1, timestamp);
			stmt.setString(2, accountNo);
            
            ResultSet rs2 = stmt.executeQuery();
            
            while (rs2.next()) {
            	
            	newBal = rs2.getInt("balance");
            }
            
            conn.close();
            stmt.close();
            
		} catch (SQLException e) {
			
			System.out.println("Issues while Login  : " + e);
		}			
		
		return newBal;
	}


	public boolean createAccount(UserDto dto3) {
		
		boolean result = false;
		String accountNo = null;
		long newAccountNo = 0L;
		
		
		
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
				Connection conn = dbU.connectToDatabase();
				//fetch last account no. which was created
				String sql = "SELECT MAX(accountNo) AS accountNo from userdetails";
				stmt = conn.prepareStatement(sql);
				
				ResultSet rs1 = stmt.executeQuery();
				
				while (rs1.next()) {
					
					accountNo = rs1.getString("accountNo");
					
				}
				
				newAccountNo = Long.parseLong(accountNo) + 1;
				
				//fetch userId by given account no. from userDetails table
				String sql1 = "INSERT INTO userdetails(userName, password, phoneNo, accountNo) VALUES(?,?,?,?);";
				
				stmt = conn.prepareStatement(sql1);
				
				stmt.setString(1, dto3.getUserName());
				stmt.setString(2,dto3.getPassword());
				stmt.setString(3, dto3.getPhoneNo());
				stmt.setString(4, String.valueOf(newAccountNo));
				
				int row2 = stmt.executeUpdate();
				
				if(row2 > 0)
				{
					result = true;
					System.out.println("Account is Creating.......");
				}
				
				
				conn.close();
		        stmt.close();
            
		} catch (SQLException e) {
			
			System.out.println("Issues while Creating Accounts  : " + e);
		}
		
		
		return result;
	}
	
	public static java.sql.Timestamp getCurrentJavaSqlTimestamp() {
	    java.util.Date date = new java.util.Date();
	    return new java.sql.Timestamp(date.getTime());
	  }


	public ArrayList<String> printAccount(UserDto dto4) {
		
		int userId = 0;
		ArrayList<String> list = new ArrayList<String>();
		String table = "";
			
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
				Connection conn = dbU.connectToDatabase();
				
				String sql = "SELECT userId from userdetails WHERE userName = ?";
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, dto4.getUserName());
				
				ResultSet rs1 = stmt.executeQuery();
				
				while (rs1.next()) {
					
					userId = rs1.getInt("userId");
					
				}
				
				String sql1 = "SELECT userId, transactionTime, transactionType, withdrawlAmount, depositAmount, balance, accountNo FROM transactiondetails WHERE userId = ?;";
				
				stmt = conn.prepareStatement(sql1);
				
				stmt.setInt(1, userId);
				
				ResultSet rs2 = stmt.executeQuery();
				
				while(rs2.next()) {
				
					table = "User Id: " +rs2.getInt("userId")+ ",  Transaction Time: " +rs2.getTimestamp("transactionTime")+ ",  Transaction Type: " +rs2.getString("transactionType")+ ",  Withdrawl Amount: " +rs2.getInt("withdrawlAmount")+ ",  Deposit Amount: " +rs2.getInt("depositAmount")+ ",  Balance: " +rs2.getInt("balance")+ ",  Account No: " +rs2.getString("accountNo");
					list.add(table);
					table = "";
				
				}
				
				conn.close();
	            stmt.close();
				
            
		} catch (SQLException e) {
			
			System.out.println("Issues while Printing Transactions  : " + e);
		}
		
		return list;
	}


	public boolean depositValidation(UserDto dto1, TransactionDto tdto) {
		boolean result = false;
		int userId = 0, newBalance = 0;
		String accountNo = null;
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
				Connection conn = dbU.connectToDatabase();
				//fetch last account no. which was created
				String sql = "SELECT userId, accountNo from userdetails WHERE userName = ?;";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, dto1.getUserName());
				
				ResultSet rs1 = stmt.executeQuery();
				
				while (rs1.next()) {
					
					userId = rs1.getInt("userId");
					accountNo = rs1.getString("accountNo");
					
				}
				
				
				
				String sql2 = "SELECT MAX(transactionTime) AS transactionTime from transactiondetails WHERE userId= ? AND accountNo = ?;";
	            
	            stmt = conn.prepareStatement(sql2);
				
				stmt.setInt(1, userId);
				stmt.setString(2, accountNo);
	            
	            ResultSet rs2 = stmt.executeQuery();
	            
	            while (rs2.next()) {
	            	
	            	timestamp = rs2.getTimestamp("transactionTime");
	            }
	            
	            //fetch the last balance of the given account no. by date
	            String sql3 = "SELECT balance from transactiondetails WHERE transactionTime = ? and accountNo = ? ";
	            
	            stmt = conn.prepareStatement(sql3);
				
				stmt.setTimestamp(1, timestamp);
				stmt.setString(2, accountNo);
	            
	            ResultSet rs3 = stmt.executeQuery();
	            
	            while(rs3.next()) {
	            	
	            	newBalance = rs3.getInt("balance");
	           
	            }
	            
	            newBalance = newBalance + tdto.getDepositAmount(); 
	            
	            //add new value to the transactionDetails table                      
	            String sql4 = "INSERT into transactiondetails(userID, transactionTime , transactionType, depositAmount, balance, accountNo) VALUES (?,?,?,?,?,?);";
	            
	            stmt = conn.prepareStatement(sql4);
				
				stmt.setInt(1,userId);
				stmt.setTimestamp(2,getCurrentJavaSqlTimestamp());
				stmt.setString(3, "Deposit by OWN");
				stmt.setInt(4, tdto.getDepositAmount());
				stmt.setInt(5, newBalance);
				stmt.setString(6, accountNo);
	            
	            int row = stmt.executeUpdate();
	            
	            if (row > 0) {
	
	               result = true;
	               System.out.println("transaction is running........");
	
	            }
				
	            conn.close();
	            stmt.close();
				
		} catch (SQLException e) {
					
					System.out.println("Issues while Printing Transactions  : " + e);
				}
		
		
		
		return result;
	}


	public boolean withdrawlValidation(UserDto dto1, TransactionDto tdto) {
		
		boolean result = false;
		int newUserId = 0, chkBalance = 0;
		String chkAccountNo = null;
				
		DatabaseUtility dbU = new DatabaseUtility();
		
		try {
		
						Connection conn = dbU.connectToDatabase();
					   //check the balance of the sender before transferring
			            String sql5 = "SELECT userId, accountNo from userDetails WHERE userName = ? ;";
					
						stmt = conn.prepareStatement(sql5);
						
						stmt.setString(1, dto1.getUserName());
			            
			            ResultSet rs3 = stmt.executeQuery();
			            
			            while (rs3.next()) {
			            	
			            	newUserId = rs3.getInt("userId");
			            	chkAccountNo = rs3.getString("accountNo");
			            				        		
			            }
			            
			            String sql6 = "SELECT MAX(transactionTime) AS transactionTime from transactiondetails WHERE userId= ? and accountNo = ? ;";
			            
			            stmt = conn.prepareStatement(sql6);
						
						stmt.setInt(1, newUserId);
						stmt.setString(2, chkAccountNo);
									            
			            ResultSet rs4 = stmt.executeQuery();
			            
			            while (rs4.next()) {
			            	
			            	timestamp = rs4.getTimestamp("transactionTime");
			            	
			            }
			            
			            String sql7 = "SELECT balance from transactiondetails WHERE  accountNo = ? and transactionTime = ?;";
			            
			            stmt = conn.prepareStatement(sql7);
						
			            stmt.setString(1, chkAccountNo);
						stmt.setTimestamp(2, timestamp);
						
			            ResultSet rs5 = stmt.executeQuery();
			            
			            while (rs5.next()) {
			            	
			            	chkBalance = rs5.getInt("balance");
			            	
			            }
			            
			            if(chkBalance != 0) {
			            			//update the sender balance after sending account
					            	chkBalance = chkBalance - tdto.getWithdrawlAmount();
					            	
					            	String sql8 = "INSERT into transactiondetails(userID, transactionTime , transactionType, withdrawlAmount, balance, accountNo) VALUES (?,?,?,?,?,?);";
					                
					                stmt = conn.prepareStatement(sql8);
					    			
					    			stmt.setInt(1,newUserId);
					    			stmt.setTimestamp(2, getCurrentJavaSqlTimestamp());
					    			stmt.setString(3, "Withdraw by OWN");
					    			stmt.setInt(4, tdto.getWithdrawlAmount());
					    			stmt.setInt(5, chkBalance);
					    			stmt.setString(6, chkAccountNo);
					                
					                int row1 = stmt.executeUpdate();
					                
					                if(row1 > 0)
					                {
					                	result = true;
					                	System.out.println("Transaction is Running......");
					                }
			            }
			            else
			            {
			            	System.out.println("You Have Insufficient balence");
			            }
			            
			            
			            conn.close();
			            stmt.close();
			            
			            
			            
        } catch (SQLException e) {
			
			System.out.println("Issues while Printing Transactions  : " + e);
		}
		
		
		
		return result;
	}

}
