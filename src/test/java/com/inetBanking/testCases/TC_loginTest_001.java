package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass {
	@Test
	public void loginPage() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserID(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(this.verifyAlert() == true) {
			driver.switchTo().alert().accept();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
			captureScreen(driver, "loginPage");
			logger.info("Test failed");
			Assert.assertTrue(false);
			}
		}
	}
	public boolean verifyAlert() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	//ghgzjkl
}