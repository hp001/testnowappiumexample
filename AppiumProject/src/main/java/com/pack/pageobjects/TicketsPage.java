package com.pack.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class TicketsPage extends Utility{
	public final static By allMenuXpath = By.xpath("//android.widget.TextView[@text='ALL']");
//	private final static By moviesMenuId = By.id("com.bt.bms:id/menu_image_dyn");
	private final static By eventsMenuXpath = By.xpath("//android.widget.TextView[@text='EVENTS']");
	private final static By playsMenuXpath = By.xpath("//android.widget.TextView[@text='PLAYS']");
	private final static By sportsMenuXpath = By.xpath("//android.widget.TextView[@text='SPORTS']");
	private final static By searchByVenueTextXpath = By.xpath("//android.widget.TextView[@text='Search by Venue']");
	private final static By locationTextId = By.id("com.bt.bms:id/txvLocation");
	private static List<WebElement> elements;
	
	public static void verifyTicketsPage(String str) throws InterruptedException{
//		Thread.sleep(2000);
//		System.out.println(driver.getClass());
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
//		
//		try{
//			if(driver.findElement(By.id("com.bt.bms:id/btnCancel")).isDisplayed())
//				driver.findElement(By.id("com.bt.bms:id/btnCancel")).click();
//		}catch(Exception e){
//			
//		}
		elements = driver.findElements(By.className("android.widget.TextView"));
		assertTrue(driver.findElement(allMenuXpath).isDisplayed());
		assertTrue(driver.findElement(eventsMenuXpath).isDisplayed());
		assertTrue(driver.findElement(playsMenuXpath).isDisplayed());
		assertTrue(driver.findElement(sportsMenuXpath).isDisplayed());
		assertTrue(driver.findElement(searchByVenueTextXpath).isDisplayed());
		assertTrue(driver.findElement(locationTextId).isDisplayed());
		takeScreenShot(str);
		addScreenshottoReport("TicketPage");
	}
	
	public static void clickMoviesMenu(){
		clickOnElement(elements.get(6));
		waitForElement(MoviesPage.moviesTitleId);
	}
	
	public static void clickOnLocation(){
		clickOnElement(locationTextId);
		waitForElement(UnableToIdentifyLocationPopup.loactionPopupTitleId);
	}
	
	public static void verifyLocation(){
		assertEquals(driver.findElement(locationTextId).getText(), "You're in "+PickRegionPage.REGION);
	}
}