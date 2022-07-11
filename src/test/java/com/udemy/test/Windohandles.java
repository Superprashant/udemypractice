package com.udemy.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windohandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> winh=driver.getWindowHandles();
		Iterator<String>it=winh.iterator();
		String parrentwin=it.next();
		String childwin=it.next();
		driver.switchTo().window(childwin);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		driver.switchTo().window(parrentwin);
		driver.quit();
		

	}

}
