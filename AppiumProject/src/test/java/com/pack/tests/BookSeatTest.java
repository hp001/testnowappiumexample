package com.pack.tests;

import org.testng.annotations.Test;

import com.pack.pageobjects.HomePage;
import com.pack.pageobjects.HowManyTicketsPage;
import com.pack.pageobjects.MainTabPage;
import com.pack.pageobjects.MovieDetailsPage;
import com.pack.pageobjects.MoviesPage;
import com.pack.pageobjects.PickSeatsPage;
import com.pack.pageobjects.PickVenuePage;
import com.pack.pageobjects.ShowTimesPage;
import com.pack.pageobjects.TicketsPage;
import com.pack.utilities.Utility;

public class BookSeatTest extends Utility {
	@Test
	public void testBookSeat() throws InterruptedException {
		HomePage.verifyHomePage("BookSeatTest");
		HomePage.clickIwillSkipBtn("BookSeatTest");
		MainTabPage.verifyMainTabs("BookSeatTest");
		MainTabPage.clickYouTab();
		MainTabPage.clickTicketsTab();
		TicketsPage.verifyTicketsPage("BookSeatTest");
		TicketsPage.verifyLocation();
		TicketsPage.clickMoviesMenu();
		MoviesPage.verifyMoviesPage("BookSeatTest");
		if (MoviesPage.searchForMovie()) {
			MovieDetailsPage.verifyMovieDetailsPage("BookSeatTest");
			MovieDetailsPage.clickBookBtn();
//			PickVenuePage.verifyPickVenuePage();
			if (PickVenuePage.searchForVenue("BookSeatTest")) {
//				ShowTimesPage.verifyShowTimesPage();
				if (ShowTimesPage.selectShowTime("BookSeatTest")) {
					if (ShowTimesPage.selectSeatCategory("BookSeatTest")) {
//						HowManyTicketsPage.verifyHowManyTicketsPage();
						if (HowManyTicketsPage.selectSeatsQuantity("BookSeatTest")) {
							PickSeatsPage.verifyPickSeatsPage("BookSeatTest");
							PickSeatsPage.selectSeats("BookSeatTest");
						}
					}
				}
			}
		}
	}
}