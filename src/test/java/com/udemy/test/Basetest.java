package com.udemy.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.udemy.utilities.Readcon;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Basetest {
	public WebDriver driver;
	Readcon re=new Readcon();
	//public  Logger log= LogManager.getLogger(Basetest.class.getName());
	 private Logger log = LogManager.getLogger(Basetest.class.getName());

	//@BeforeTest
	public  WebDriver setup() {
		String browser = re.getbrowser();
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome") ){
			//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("chrome is starting");
			}
		else if(browser.equalsIgnoreCase("firefox") ){
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("firefox is starting");
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
		return driver;
	}
	public void screen(String testcasename,WebDriver driver) {
		
		File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\Screenshots\\"+testcasename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
	//@AfterTest
	public WebDriver teardown() {
		driver.close();
		return driver;
	}
	
}
