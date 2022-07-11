package com.udemy.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.udemy.test.Basetest;

public class jdbc extends Basetest {

	@Test
	public void dbtest() {
		
		String host="localhost";
		String port="3306";
	
		try {
		 Connection con=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/mydbp", "root", "Rajveer_15");
		 Statement s=con.createStatement();
		
		 //String show= "insert into employeed values(8,'sagar','devop',2500000,'solapur')";
			//s.execute(show);
		ResultSet rs=s.executeQuery("select * from employeed where name='prashant';");
		 
		while(rs.next()) {
	
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys(rs.getString("role"));
			driver.findElement(By.id("pass")).sendKeys(rs.getString("salary"));
			driver.findElement(By.xpath("//button[@value='1']")).click();
			System.out.println(rs.getString("role"));
			System.out.println(rs.getString("salary"));
		}
		
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
