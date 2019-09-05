package com.cg.ums.service;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.ums.dto.Login;

public interface ILoginService
{

	   
	   public ArrayList<Login> getAllUsers();
	   public Login addUser(Login log);
	   public Login getUserByUserName(String unm);  
	   public void deleteUserByUserName( @Param("unm") String unm); 
	   public void updateUserInfo(@Param("pw") String newpwd,@Param("nm") String unm);
	   
}
