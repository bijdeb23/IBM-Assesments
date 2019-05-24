package com.swiss.service;

import java.util.ArrayList;

import com.swiss.bean.TransactionDto;
import com.swiss.bean.UserDto;
import com.swiss.dao.SwissBankWalletDaoClass;

public class SwissBankWalletServiceClass implements SwissBankWalletServiceInterface {

	SwissBankWalletDaoClass sbwDao = new SwissBankWalletDaoClass();
	
	@Override
	public boolean validateUser(UserDto dto) {
		
		return sbwDao.validateUser(dto);
	}

	@Override
	public boolean accountNoValidation(UserDto dto1) {
		
		return sbwDao.accountNoValidation(dto1);
	}

	@Override
	public boolean amountValidation(UserDto dto1, TransactionDto tdto) {
		
		return sbwDao.amountValidation(dto1, tdto);
	}

	@Override
	public int chkAccountNoValidation(UserDto dto2) {
		
		return sbwDao.chkAccountNoValidation(dto2);
	}

	@Override
	public boolean createAccount(UserDto dto3) {
		
		return sbwDao.createAccount(dto3);
	}

	@Override
	public ArrayList<String> printAccount(UserDto dto4) {
		
		return sbwDao.printAccount(dto4);
	}

	@Override
	public boolean depositValidation(UserDto dto1, TransactionDto tdto) {
		
		return sbwDao.depositValidation(dto1, tdto);
	}

	@Override
	public boolean withdrawlValidation(UserDto dto1, TransactionDto tdto) {
		
		return sbwDao.withdrawlValidation(dto1, tdto);
	}

}
