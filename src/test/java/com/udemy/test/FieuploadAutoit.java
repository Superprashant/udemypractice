package com.udemy.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FieuploadAutoit {

	public static void main(String[] args) throws InterruptedException, IOException {
		String downloadpath=System.getProperty("user.dir");					//project path
		WebDriverManager.chromedriver().setup();
		HashMap<String,Object>chromeprefs=new HashMap<String,Object>();
		chromeprefs.put("profile.default_content_setting.pop",0);
		chromeprefs.put("download.default_directory", downloadpath);
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", chromeprefs);
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.cssSelector("#pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Jai Hanuman\\Documents\\fileupload1.exe"); //to execute file 
		//driver.switchTo().frame(0);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));       //explicit wait
		//WebElement button=);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f=new File(downloadpath+"/pawar mahesh.docx");
		if (f.exists()) {
			Assert.assertTrue(f.exists());		
		if (f.delete()) {
			System.out.println("File deleted");
		}}
		driver.close();
	}

}
