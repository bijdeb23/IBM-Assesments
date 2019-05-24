package com.swiss.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.swiss.bean.TransactionDto;
import com.swiss.bean.UserDto;
import com.swiss.service.SwissBankWalletServiceClass;
import com.swiss.service.SwissBankWalletServiceInterface;

public class FrontPage {
	
	private static Scanner sc = new Scanner(System.in);
	private static boolean flag1 = false, flag2 = false, flag4 = false, flag5 =false, flag6 = false, flag7 = false, flag8 = false;
	
	public static void main(String[] args) {
		
		 SwissBankWalletServiceInterface sbwsi = new SwissBankWalletServiceClass();
		 
		do {
		System.out.println("<-*-*-*-*WELCOME TO SWISS BANK-*-*-*->");
		System.out.println("Press 1 for Existing LogIn");
		System.out.println("Press 2 for Create Account");
		System.out.print("Enter Your Choice:");
		int choice = 0;
		while (true) {
	        try {
	        	choice = sc.nextInt();
	            	
	            break;
	        }
	        catch (InputMismatchException e) {

	        	System.out.print("Please Give the Correct Input: ");
	            sc.next();
	    	}
	    }
		switch(choice) {
		
				case 1: do {
								System.out.println("\n");
								System.out.println("<-*-*-*-*WELCOME TO SWISS BANK LOGIN-*-*-*->");
								System.out.print("Enter Your User Name: ");
								String userName = sc.nextLine();
								System.out.print("Enter Your Password: ");
								String password = sc.nextLine();
								
								UserDto dto = new UserDto();
								dto.setUserName(userName);
								dto.setPassword(password);
								
								
								boolean isValid = sbwsi.validateUser(dto); 
								if(isValid == true) {
									
									do {
											System.out.println("\n");
											System.out.println("Welcome Back '" +userName+"'");
											System.out.println("-----------------------------------");
											System.out.println("Press 1 for Fund Transfer to a different user");
											System.out.println("Press 2 for Deposit");
											System.out.println("Press 3 for Withdrawl");
											System.out.println("Press 4 for Check Balance of Your Account");
											System.out.println("Press 5 for See Transaction Details");
											System.out.println("Press 6 for Logout");
											System.out.print("Enter Your Choice:");
											int ch = 0;
											while (true) {
										        try {
										        	ch = sc.nextInt();
										            	
										            break;
										        }
										        catch (InputMismatchException e) {

										        	System.out.print("Please Give the Correct Input: ");
										            sc.next();
										    	}
										    }											
											switch(ch) {
											
											case 1: do {
																System.out.println("\n");
																System.out.print("Enter Account no. of the Receiver: ");
																String rAccount = sc.nextLine();
																
																UserDto dto1 = new UserDto();
																
																dto1.setAccountNo(rAccount);
																dto1.setUserName(userName);
																
																boolean accountValidate = sbwsi.accountNoValidation(dto1);
																
																if(accountValidate == true) {
																	System.out.println("\n");
																	System.out.print("Enter the Amount you want to Transfer: ");
																	int amount = 0;
																	while (true) {
																        try {
																        	amount = sc.nextInt();
																            	
																            break;
																        }
																        catch (InputMismatchException e) {

																        	System.out.print("Please Give the Correct Input: ");
																            sc.next();
																    	}
																    }
																	
																	TransactionDto tdto = new TransactionDto();
																	tdto.setDepositAmount(amount);
																	
																	boolean amountValidation = sbwsi.amountValidation(dto1,tdto);
																	if(amountValidation == true) {
																		
																		System.out.println("Amount is Transferred of Rs. " +amount);
																		flag2 = true;
																		flag6 = false;
																		
																	}
																	else
																	{
																		System.out.println("You have to deposit money your account");
																		flag2 = false;
																	}
																	
																}
																else 
																{
																	System.out.println("Please Check The Account Number!!!");
																	flag2 = false;
																}
													}while(flag2 == false);
											
													break;
													
													
											case 2: do {													
															System.out.println("\n");
															System.out.print("Enter the Amount you want to Deposit: ");
															int amount1 = sc.nextInt();
															while (true) {
														        try {
														        	amount1 = sc.nextInt();
														            	
														            break;
														        }
														        catch (InputMismatchException e) {

														        	System.out.print("Please Give the Correct Input: ");
														            sc.next();
														    	}
														    }
															
															UserDto dto1 = new UserDto();
															dto1.setUserName(userName);
															
															TransactionDto tdto = new TransactionDto();
															tdto.setDepositAmount(amount1);
															
															boolean depositValidation = sbwsi.depositValidation(dto1,tdto);
															if(depositValidation == true)
															{
																System.out.println("Amount is Deposited Rs." +amount1);
																flag7 = true;
																flag6 = false;
															}
															else
															{
																System.out.println("Something Problem Occurs, Please Enter Amount Again");
																flag7 =false;
															}
													}while(flag7 == false);
											
													break;
													
												
												
											case 3:	 do {													
															System.out.println("\n");
															System.out.print("Enter the Amount you want to Withdrawl: ");
															int amount2 = sc.nextInt();
															while (true) {
														        try {
														        	amount2 = sc.nextInt();
														            	
														            break;
														        }
														        catch (InputMismatchException e) {

														        	System.out.print("Please Give the Correct Input: ");
														            sc.next();
														    	}
														    }
															
															UserDto dto1 = new UserDto();
															dto1.setUserName(userName);
															
															TransactionDto tdto = new TransactionDto();
															tdto.setWithdrawlAmount(amount2);
															
															boolean withdrawlValidation = sbwsi.withdrawlValidation(dto1,tdto);
															if(withdrawlValidation == true)
															{
																System.out.println("Amount is Withdrawled Rs." +amount2);
																flag8 = true;
																flag6 = false;
															}
															else
															{
																System.out.println("Something Problem Occurs, Please Enter Amount Again");
																flag8 =false;
															}
															
													}while(flag8 == false);
											
													break;
													
											case 4: UserDto dto2 = new UserDto();
													dto2.setUserName(userName);
														
														int currentBalance = sbwsi.chkAccountNoValidation(dto2);
														
														System.out.println("Your Current Balance is : " + currentBalance);
														flag6 = false;
											
													break;
											
											case 5: UserDto dto4 = new UserDto();
													dto4.setUserName(userName);
													
													ArrayList<String> list = sbwsi.printAccount(dto4);
													
													System.out.println("The Transaction Details: ");
													for(String s: list)
													{
														System.out.println(s);
													}
													flag6 = false;
													
													break;
												
												
												
												
												
												
											case 6: System.out.println("You are Successfully Logged Out");
													System.out.println("\n");
													flag1 = true;
													flag6 = true;
													flag5 = false;
													
													break;
											
											
											default: System.out.println("Invalid Choice, Check Again!!!");
														flag6 = false;
												
												
											}
								
									}while(flag6 == false);
								}
								else
								{
									System.out.println("Check Your UserName and Password Agin!!!");
									flag1 = false;
								}
						}while(flag1 == false);
						
						break;
						
				case 2: do {
								System.out.println("\n");
								System.out.print("Enter your User Name: ");
								String uName = sc.nextLine();
								System.out.print("Enter your Password: ");
								String pass = sc.nextLine();
								System.out.print("Enter your Phone No: ");
								String phoneNo = sc.nextLine();
								
								UserDto dto3 = new UserDto();
								
								dto3.setUserName(uName);
								dto3.setPassword(pass);
								dto3.setPhoneNo(phoneNo);
								
								boolean rEsult = sbwsi.createAccount(dto3);
								if(rEsult == true)
								{
									System.out.println("New Account is Created!!!");
									flag4 = true;
									flag5 = false;
								}
								else
								{
									System.out.println("Check your entry details");
									flag4 = false;
								}
						
						}while(flag4 == false);
						
						break;
						
				default:System.out.println("Invalid Choice, Please check it agian!!!");
						flag5 = false;
			
				}
		
	}while(flag5 == false);
		}
		
	}
	
