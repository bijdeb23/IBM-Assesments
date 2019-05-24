package com.swiss.service;

import java.util.ArrayList;

import com.swiss.bean.TransactionDto;
import com.swiss.bean.UserDto;

public interface SwissBankWalletServiceInterface {
	
	public boolean validateUser(UserDto dto);

	public boolean accountNoValidation(UserDto dto1);

	public boolean amountValidation(UserDto dto1, TransactionDto tdto);

	public int chkAccountNoValidation(UserDto dto2);

	public boolean createAccount(UserDto dto3);

	public ArrayList<String> printAccount(UserDto dto4);

	public boolean depositValidation(UserDto dto1, TransactionDto tdto);

	public boolean withdrawlValidation(UserDto dto1, TransactionDto tdto);

}
