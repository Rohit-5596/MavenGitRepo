package com.cg.ums.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ums.dto.Login;

@Repository
@Transactional
public interface LoginRepository extends JpaRepository<Login, String>//Login is dto class,String is data type of pk
{
   @Query("SELECT userList FROM Login userList")
   public ArrayList<Login> getAllUsers();
   
   //public Login addUser(Login log);
   
   @Query("SELECT log FROM Login log WHERE log.userName= :unm")
   public Login getUserByUserName(@Param("unm") String unm);
   
  
   @Modifying
   @Query("DELETE FROM Login log WHERE log.userName= :unm")
   public void deleteUserByUserName( @Param("unm") String unm); 
   
   @Modifying
   @Query("UPDATE Login log SET log.userPass= :pw WHERE log.userName= :nm")
   public void updateUserInfo(@Param("pw") String newpwd,@Param("nm") String unm);
	
	
}
