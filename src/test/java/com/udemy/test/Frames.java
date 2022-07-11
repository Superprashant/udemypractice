package com.udemy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		WebElement middle=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middle);
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
	}

}
