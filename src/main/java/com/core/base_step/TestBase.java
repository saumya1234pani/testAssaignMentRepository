package com.core.base_step;

import com.core.report_and_listener.ExtentTestManager;
import com.core.utility.CommonActionUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestBase {
	static boolean flag=false;
	public static WebDriver driver=null;
	public static Properties prop=null;
	static String currentdir=null;
	
	public static void initiateDriver() throws IOException {
		InitiateDriver ini=new InitiateDriver();
		driver=ini.getDriver();
		Logger log=Logger.getLogger("TestBase");
		log.info("driver initialized started");
		currentdir=System.getProperty("user.dir");
		File log4j=new File(currentdir + "//src//main//resources//configuration//log4j.properties");
		PropertyConfigurator.configure(log4j.getAbsolutePath());

		if(!flag) {
		   System.out.println("initializing driver");
		   prop=new Properties();

		   try {
			   FileInputStream fis = new FileInputStream(currentdir + "//src//main//resources//configuration//config.properties");
			   prop.load(fis);

			   if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				   WebDriverManager.chromedriver().setup();
				   driver = new ChromeDriver();
				   driver.manage().window().maximize();

			   } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				   WebDriverManager.firefoxdriver().setup();
				   driver = new FirefoxDriver();
				   driver.manage().window().maximize();
			   } else {
				   WebDriverManager.iedriver().setup();
				   driver = new InternetExplorerDriver();
				   driver.manage().window().maximize();
			   }
		   } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		   System.out.println("initilization done");
		}
	}
	@Parameters({ "Browser", "appURL" })	//enable when want to do crossbrowser testing
	@BeforeMethod(enabled = false)
	public void launchBrowser(String Browser, String appURL) throws IOException, InterruptedException//enable when u want to do crossbrowser testing
	{
		   launchBrowserForParallel(Browser,appURL);  //enable when u want to do crossbrowser testing
	}
	@BeforeMethod(enabled=true)
		public void launchBrowser() throws IOException {
		initiateDriver();
	}

	@AfterMethod(alwaysRun=true)
	public void quitBrowsers() throws IOException {
		CommonActionUtils actionUtils = new CommonActionUtils();
		actionUtils.quitBrowser(driver);
	}

	private void launchBrowserForParallel(String Browser, String appURL) {
		switch (Browser) {
			case "chrome":
				driver = initChromeDriver(appURL);
				break;
			case "firefox":
				driver = initFirefoxDriver(appURL);
				break;
			case "safari":
				driver = initSafariDriver(appURL);
				break;
			default:
				System.out.println("browser : " + Browser + " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initSafariDriver(String appURL) {
		System.out.println("Launching safari browser..");
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	public static String capture(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\target\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}
}
