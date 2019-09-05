package com.cg.ums.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ums.dto.Login;
import com.cg.ums.exception.UserNotFoundException;
import com.cg.ums.service.ILoginService;

@RestController
public class UserRestController {

	@Autowired
	ILoginService logSer;
	
	@RequestMapping(value ="/showAllUsers", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<Login> showAllUsers()
	{
		System.out.println("....UserRestController....showAllUsers() called");
		return logSer.getAllUsers();
	}
	
	/**********to insert data into Login(cg_users)************/
	
	@PostMapping(value="/addUser", consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public Login createUser(@RequestBody Login log)//requestbody used where object is passed
	{
		logSer.addUser(log);
		Login lgg=logSer.getUserByUserName(log.getUserName());
		return lgg;
	}
	
	/***********************DeleteUser*************************/
	
	@DeleteMapping(value="/deleteUser/{uid}",headers="Accept=application/json")
	public void deleteUser(@PathVariable("uid") String unm)
	{
		logSer.deleteUserByUserName(unm);
		System.out.println("Data deleted....");
	}
	
	/***********************UpdateUser*************************/

	@PutMapping(value="/user/update", consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public void updateUser(@RequestBody Login lg)
	{
		logSer.updateUserInfo(lg.getUserPass(), lg.getUserName());
		System.out.println("Data updated for...."+lg.getUserName());
	}
	
	/***********************getUserByUserName*************************/

	@GetMapping(value="searchUser/{uid}")
	public Login searchUserById(@PathVariable("uid") String unm) throws UserNotFoundException
	{
		Login lgg=logSer.getUserByUserName(unm);
		if(lgg==null)
		{
			throw new UserNotFoundException("No user with this id");
		}
		else
		{
		return lgg;
		}
	}
}

