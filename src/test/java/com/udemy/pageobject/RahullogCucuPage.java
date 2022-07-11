package com.udemy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RahullogCucuPage {
	WebDriver driver;

	public RahullogCucuPage(WebDriver driver) {
	     this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="#username")
	WebElement email;			//email
	@FindBy(css="#password")
	WebElement pass;			//pass
	@FindBy(xpath="//*[@id=\"login-form\"]/div[4]/div/label[2]/span[2]")
	WebElement user;				//user
	@FindBy(css="#okayBtn")
	WebElement pop;					//pop
	@FindBy(css="select[class='form-control']")
	WebElement drop;				//dropdown
	@FindBy(css="#terms")
	WebElement termsradio;			//radio
	@FindBy(id="signInBtn")
	WebElement signbtn;				//signin
	@FindBy(css="h1.my-4")
	WebElement tit;					//head
	//@FindBy(css="button.btn-info")		
	//WebElement addtocart;			//addtocart
	@FindBy(xpath="//a[@class='nav-link btn btn-primary']")
	WebElement cartbtn;					//cartbtn
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement checkoutbtn;        //checkout
	
	public WebElement email() {
		return email;}
	public WebElement pass() {
		return pass;}
	public WebElement user() {
		return user;}
	public WebElement pop() {
		return pop;}
	public WebElement drop() {
		return drop;}
	public WebElement termsradio() {
		return termsradio;}
	public WebElement signbtn() {
		return signbtn;}
	public WebElement tit() {
		return tit;}
	public List<WebElement> addtocart() {
		List <WebElement> addtocart=driver.findElements(By.cssSelector("button.btn-info"));
		for(int i=0;i<addtocart.size();i++) {
			addtocart.get(i).click();
		}
		return addtocart;}
	public WebElement cartbtn() {
		return cartbtn;}
	public WebElement checkoutbtn() {
		return checkoutbtn;}
	
}
