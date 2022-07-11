package com.udemy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rahulsheetyform {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector(" div> input[name='name']")).sendKeys("prashant");
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("birajdar@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		WebElement dropdown=driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("#inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("15/03/1989");
		driver.findElement(By.cssSelector(" input[class='btn btn-success']")).click();
		System.out.println(driver.findElement(By.cssSelector("div:nth-child(2) >.alert-success")).getText());
		}
		


}
