package com.sathya.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sathya.dao.LoginDao;
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private  JdbcTemplate  jt;

	public boolean isExists(String username, String password) {
		int i = jt.queryForObject("select count(*) from  Login_tab  where  username=? and  password=?",Integer.class,username,password);
		if (i==1) {
			return  true;
		}
		else {
			return false;
		}
	}
}





