package com.pack.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class MoviesPage extends Utility{
	public final static By moviesTitleId = By.id("com.bt.bms:id/txvTitle");
	private final static By searchTbId = By.id("com.bt.bms:id/edtSearchBox");
	private final static By eventTitleId = By.id("com.bt.bms:id/EventTitle");
	private static boolean isMovieFound = false;
	public static final String MOVIENAME = prop.getProperty("moviename");
	
	public static void verifyMoviesPage(String str){
		assertEquals(driver.findElement(moviesTitleId).getText(), "MOVIES");
		assertEquals(driver.findElement(searchTbId).getText(), "Search for Movie, Language, Actor");
		takeScreenShot(str);
	}
	
//	For user specific search
	public static Boolean searchForMovie(){
//		clickOnElement(searchTbId);
//		sendKeys(searchTbId, MOVIENAME);
		List<WebElement> elements = driver.findElements(eventTitleId);
//		for(WebElement element : elements){
//			if(element.getText().equalsIgnoreCase(MOVIENAME)){
//				isMovieFound = true;
//				clickOnElement(element);
//				break;
//			}
//		}
		
		if(elements.size()>0){
			clickOnElement(elements.get(0));
			System.out.println("Movie found.");
			isMovieFound = true;
		}
		
		if(!isMovieFound){
			System.out.println("Movie not found");
			return false;
		}else
			return true;
	}
}