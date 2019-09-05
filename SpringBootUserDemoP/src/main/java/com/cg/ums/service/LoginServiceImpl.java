package com.cg.ums.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ums.dao.LoginRepository;
import com.cg.ums.dto.Login;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService
{
	
	@Autowired
	LoginRepository logDao;

	@Override
	public ArrayList<Login> getAllUsers() {
	
		return logDao.getAllUsers();
	}

	@Override
	public Login addUser(Login log) {
		
		return logDao.save(log);
	}

	@Override
	public Login getUserByUserName(String unm) {
		
		return logDao.getUserByUserName(unm);
	}


	@Override
	public void deleteUserByUserName(String unm) {
		
		logDao.deleteUserByUserName(unm);
		
	}

	@Override
	public void updateUserInfo(String newpwd, String unm) {
		
		System.out.println("in service class.....update()");
		logDao.updateUserInfo(newpwd, unm);
	}

}
