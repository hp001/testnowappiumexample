package com.pack.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;

import com.pack.utilities.Utility;

public class HomePage extends Utility {
	private final static By loginBtnId = By.id("com.bt.bms:id/btnLogin");
	private final static By iWillSkipBtnId = By.id("com.bt.bms:id/btnNoThanks");

	public static void verifyHomePage(String str) {
		assertEquals(driver.findElement(loginBtnId).getText(), "Login");
		assertEquals(driver.findElement(iWillSkipBtnId).getText(), "I'LL SKIP");
		takeScreenShot(str);
	}

	public static void clickIwillSkipBtn(String str) {
		clickOnElement(iWillSkipBtnId);
		try {
			if (UnableToIdentifyLocationPopup.getIsPopupVisible()) {
				LoginPage.handleRegionPage(str);
			}
		} catch (NoSuchElementException e) {
		}
		waitForElement(MainTabPage.showcaseTabXpath);
	}

	public static void clickLoginBtn() {
		clickOnElement(loginBtnId);
		waitForElement(LoginPage.titleTextId);
	}
}