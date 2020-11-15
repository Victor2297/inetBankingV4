package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	WebDriver driver;
	String username = readConfig.getUsername();
	String password = readConfig.getPassword();
	String baseUrl = readConfig.getBaseUrl();
	Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("log");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void browserQuit() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + methodName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
}