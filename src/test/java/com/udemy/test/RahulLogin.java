package com.udemy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		WebElement dropdown=driver.findElement(By.cssSelector("select[class='form-control']"));
		Select select =new Select(dropdown);
		select.selectByValue("consult");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h1.my-4")));
		String verify=driver.findElement(By.cssSelector("h1.my-4")).getText();
		Assert.assertEquals(verify, "Shop Name");
		List <WebElement> webele= driver.findElements(By.cssSelector("button.btn-info"));
		for(int i=0;i<webele.size();i++) {
			webele.get(i).click();
		}
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='nav-link btn btn-primary']")));
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		String checkout=driver.findElement(By.xpath("//button[@class='btn btn-success']")).getText();
		Assert.assertEquals(checkout, "Checkout");
		driver.close();
	}

}
