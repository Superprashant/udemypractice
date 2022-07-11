package com.udemy.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readcon {

	public Properties pro;
	public Readcon() {
		pro=new Properties();
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\Jai Hanuman\\eclipse-workspace\\udemy\\src\\test\\resources\\utility\\basic.properties");
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
	public String getbrowser() {
		String browser = pro.getProperty("browser");
		return browser;
		}
	public String getemail() {
		String email = pro.getProperty("username");
		return email;
		}
	public String getpass() {
		String pass = pro.getProperty("password");
		return pass;
		}
	
	public static void main(String []args) {
		Readcon p=new Readcon();
		System.out.println(p.getbrowser());
	}
}
