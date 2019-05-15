package com.jp.insurance.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




/*
 * @RequestMapping(@Path)
 * 	-used at class level
 * 	-method level
 * 	-spring 4.3 onward method level request mapping made more simpler
 * @GetMapping -Get method
 * @PostMapping -Post method
 * @PutMapping -Put method
 * @DeleteMapping -Delete method
 *  @PatchMapping -?//home work
 */

@RestController
public class MyHomeController {
	
	@ResponseBody
	@GetMapping("/")
	public String greetUser(){
		return "Welcome to Vehicle Insurance Portal"; 
	}
	
	@ResponseBody
	@GetMapping("/db")
	public String greetDb(){
		String RDS_HOSTNAME = "@//insurance.c9sw0helcuxe.ap-south-1.rds.amazonaws.com";
		String message="error in connecting db";
		// if (System.getenv("RDS_HOSTNAME") != null) {
			 if (RDS_HOSTNAME != null) {
		      try {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
//		      String dbName = System.getenv("RDS_DB_NAME");
//		      String userName = System.getenv("RDS_USERNAME");
//		      String password = System.getenv("RDS_PASSWORD");
//		      String hostname = System.getenv("RDS_HOSTNAME");
//		      String port = System.getenv("RDS_PORT");
		      //String jdbcUrl = "jdbc:oracle:thin:" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
		      //String jdbcUrl = "jdbc:oracle:thin:aa1qjnloo038fiu.c9sw0helcuxe.ap-south-1.rds.amazonaws.com:1521/EBDB?user=insurance&password=insurance";
				 
		      // logger.trace("Getting remote connection with connection string from environment variables.");
		      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//insurance.c9sw0helcuxe.ap-south-1.rds.amazonaws.com:1521/ORCL","insurance","insurance");
		     // logger.info("Remote connection successful.");
		      System.out.println("Remote connection successful.");
		      message =  "Remote connection successful.";
		    }
		    catch (ClassNotFoundException e) { e.printStackTrace();}
		    catch (SQLException e) { System.out.println("sql error"+e);e.printStackTrace();message ="sql error"+e;}
		    }
		  
		return message; 
	}
	
	
	
}
