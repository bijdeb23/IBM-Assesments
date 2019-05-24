package com.swiss.dao;

import java.util.ArrayList;

import com.swiss.bean.TransactionDto;
import com.swiss.bean.UserDto;

public interface SwissBankWalletDaoInterface {
	
	boolean validateUser(UserDto dto);
	boolean accountNoValidation(UserDto dto1);
	boolean amountValidation(UserDto dto, TransactionDto tdto);
	int chkAccountNoValidation(UserDto dto);
	boolean createAccount(UserDto dto3);
	ArrayList<String> printAccount(UserDto dto4);
	boolean depositValidation(UserDto dto1, TransactionDto tdto);
	boolean withdrawlValidation(UserDto dto1, TransactionDto tdto);

}
