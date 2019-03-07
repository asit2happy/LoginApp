package com.sathya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.dao.LoginDao;
import com.sathya.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDao  dao;

	public boolean isUserValid(String username, String password) {
		return  dao.isExists(username, password);
	}
}
