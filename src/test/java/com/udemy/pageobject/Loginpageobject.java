package com.udemy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageobject {
	WebDriver driver;

	public Loginpageobject(WebDriver driver) {
	     this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="uid")
	WebElement email;
	@FindBy(name="password")
	WebElement pass;
	@FindBy(name="btnLogin")
	WebElement btn;
	
	public WebElement email() {
		return email;
	}
	public WebElement pass() {
		return pass;
	}public WebElement btn() {
		return btn;
	}

}
