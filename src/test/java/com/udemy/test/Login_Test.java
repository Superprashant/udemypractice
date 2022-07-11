package com.udemy.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.udemy.pageobject.Loginpageobject;
import com.udemy.utilities.Readcon;


public class Login_Test extends Basetest {
	 private Logger log = LogManager.getLogger(Login_Test.class.getName());
	Readcon p=new Readcon();
	String email=p.getemail();
	String pass= p.getpass();
	@Test
	public void login() { 
		driver.get("https://demo.guru99.com/V1/index.php");
		log.info("url is entered");
		Loginpageobject lp= new Loginpageobject(driver);
		lp.email().sendKeys(email);
		log.info("username is entered");
		lp.pass().sendKeys(pass);
		log.info("password is entered");
		lp.btn().click();
		log.info("submit button clicked");
		Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage12");
		//log.info("title verified");
	}
	

}
