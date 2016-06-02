package com.pack.utilities;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Utility {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	// set up appium
	private static final File classpathRoot = new File(
			System.getProperty("user.dir"));
	private static final File appDir = new File(classpathRoot,
			"src/test/resources/apps");
	private static final File app = new File(appDir, "BookMyShow-4.3.2.apk");
	public static final String destDir = "target/Screenshots";
	private static DateFormat dateFormat;
	public static String destFile;
	public static String imagePath;
	public static String screenShotBase64;

	@BeforeClass
	public static void setUp() throws MalformedURLException {
		readFileData();
		System.out.println(System.getenv("DEVICENAME"));
		System.out.println(System.getenv("VERSION"));
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set your device name.
		// capabilities.setCapability("deviceName",
		// prop.getProperty("devicename"));
		capabilities.setCapability("deviceName", System.getenv("DEVICENAME"));

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		// Set android VERSION desired capability. Set your mobile device's OS
		// version.
		// capabilities.setCapability(CapabilityType.VERSION,
		// prop.getProperty("version"));
		capabilities.setCapability(CapabilityType.VERSION,
				System.getenv("VERSION"));
		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("app", app.getAbsolutePath());
		// capabilities.setCapability("noReset", true);
		// capabilities.setCapability("fullReset", false);

		// Set android appPackage desired capability. It is
		// com.bt.bms for BookMyShow application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.bt.bms");
		// Set android appActivity desired capability. It is
		// com.bt.bms.activities.IntroActivity for BookMyShow application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity",
				"com.bt.bms.activities.IntroActivity");

		capabilities.setCapability("newCommandTimeout", 300);
		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		// Create folder under project with name "screenshots" provided to
		// destDir.
//		new File(destDir).mkdirs();
//		new File("Report").mkdirs();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	public static void clickOnElement(By elementToClick) {
		driver.findElement(elementToClick).click();
	}

	public static void clickOnElement(WebElement elementToClick) {
		elementToClick.click();
	}

	public static void sendKeys(By textElement, String text) {
		driver.findElement(textElement).sendKeys(text);
	}

	public static void waitForElement(By elementForWait) {
		wait = new WebDriverWait(driver, 480);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(elementForWait));
	}

	public static void readFileData() {
		File file = new File("src/main/resources/datafile.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenShot(String filename) {
		// Set folder name to store screenshots.
		// Capture screenshot.
//		File scrFile = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
//		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		screenShotBase64 = ((TakesScreenshot) driver)
		.getScreenshotAs(OutputType.BASE64);
		// Set file name using current date time.
		// String destFile = dateFormat.format(new Date()) + ".png";
//		String time = dateFormat.format(new Date());
//		destFile = filename + time + ".jpg";
//		imagePath = "Screenshots" + "/" + destFile;
//		try {
//			// Copy paste file at destination folder location
//			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static void addScreenshottoReport(String linkName) {
//		Reporter.log("<a href= '../" + imagePath + "'<img src='../" + imagePath
//				+ "' hight='100' width='100'/>" + linkName + " </a>");
		Reporter.log("<a href='data:image/png;base64,"+screenShotBase64+"'" + "'<img src='" + screenShotBase64
				+ "' hight='100' width='100'/>" + linkName + " </a>");
	}
}
