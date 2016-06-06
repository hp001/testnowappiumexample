package com.pack.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;


public class MainTabPage extends Utility {
	public final static By showcaseTabXpath = By
			.xpath("//android.widget.TextView[@text='SHOWCASE']");
	private final static By ticketsTabXpath = By
			.xpath("//android.widget.TextView[@text='TICKETS']");
	private final static By youTabXpath = By
			.xpath("//android.widget.TextView[@text='YOU']");
	private final static By discoverTabXpath = By
			.xpath("//android.widget.TextView[@text='DISCOVER']");
//	private final static By adsDialogeCloseBtnId = By
//			.id("com.bt.bms:id/iBtnCloseDialog");
	
	public static void verifyMainTabs(String str) {
		assertTrue(driver.findElement(showcaseTabXpath).isDisplayed());
		assertTrue(driver.findElement(ticketsTabXpath).isDisplayed());
		assertTrue(driver.findElement(youTabXpath).isDisplayed());
		assertTrue(driver.findElement(discoverTabXpath).isDisplayed());
		takeScreenShot(str);
		addScreenshottoReport("DashboardPage");
	}

	public static void clickTicketsTab() {
		clickOnElement(ticketsTabXpath);
		waitForElement(TicketsPage.allMenuXpath);
	}

	public static void clickYouTab() {
		clickOnElement(youTabXpath);
		waitForElement(YouPage.saveYourCreditCardsTextId);
	}

	public static void clickYouTabAfterLogin() {
		clickOnElement(youTabXpath);
		waitForElement(YouPage.myWalletTextId);
	}
}