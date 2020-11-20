package com.core.utility;

import com.core.base_step.TestBase;
import com.core.propert_reader.PropertyReader;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonActionUtils extends TestBase {
	Logger logger = Logger.getLogger(CommonActionUtils.class);
	static Properties prop=null;
	public static WebDriver driver;
	PropertyReader propertyReader = null;

	public void navigatetoUrl(WebDriver driver,String url) {
		try {
			logger.info("navigated to respective url");
			driver.navigate().to(url);
		} catch(Exception e) {
		   	e.getStackTrace();
		}
	}

	public void quitBrowser(WebDriver driver) {
		try {
			if(driver==null) {
				return ;
			}
			driver.quit();
			driver=null;
			logger.info("browser closed successfully");
		} catch(Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnElement(WebElement wb) {
		if (wb.isDisplayed()) {
			wb.click();
		}
		logger.info("Element clicked");
	}

	public void enterValuesInTextField(WebElement wb,String values) {
		try {
			if (wb.isDisplayed()) {
				wb.clear();
				wb.sendKeys(values);
			}
			logger.info(values + "value entered successfully");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void fileUpload(String path) throws AWTException {
		StringSelection sel = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
//	public  void takesScreenShot() throws HeadlessException, AWTException {
//		try {
//			System.out.println("taking snapshot");
//			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//
//			String currentDir = System.getProperty("user.dir");
//			System.out.println(currentDir);
//			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//			System.out.println(timeStamp);
//
//			ImageIO.write(image, "png", new File(currentDir + "/Screenshots/" + timeStamp + ".png"));
//			logger.info("snapShot captured");
//			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
//					ExtentTestManager.getTest().addScreenCapture(currentDir + "/Screenshots/" + timeStamp + ".png"));
//		} catch (IOException e1) {
//			System.out.println(e1.getLocalizedMessage());
//			logger.error("snapShot is not captured for failed testcase");
//		}

	
	public void normailWait(long millisecond) throws InterruptedException {
		Thread.sleep(millisecond);
	}

	public void implicitlyWait(WebDriver driver, long second) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

//	public Boolean expliciteWait(WebElement clickableElement, long timeooutInSecond) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, timeooutInSecond);
//			wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
//			Thread.sleep(500);
//			System.out.println("Waited for element to be Click: " + clickableElement);
//		} catch (Exception e) {
//			System.out.println("Element " + clickableElement + " was not waited for Clickable: " + e.getStackTrace());
//			return false;
//		}
//		return true;
//	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public List<WebElement> getAllElements(List<WebElement> wb) {
		return wb;
	}

	public String getText(WebElement wb) {
		return wb.getText();
	}

	public void switchToWindow(WebDriver driver) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	public void waitTillTheElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void closeAdvertiseWindow(WebDriver driver) {
		String parenWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equalsIgnoreCase(parenWindow)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(parenWindow);
	}

	public void scrolltoEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void windowSwitch(WebDriver driver)
	{
		Set<String> allWindowHandles = driver.getWindowHandles();

		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to motor policy download page");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver

		}

	}
	public Actions actionClass(WebDriver driver) {
		return new Actions(driver);
	}
}
