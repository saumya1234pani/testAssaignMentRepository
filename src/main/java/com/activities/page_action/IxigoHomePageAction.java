package com.activities.page_action;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.activities.page_objects.IXigoHomePageObjects;
import com.core.propert_reader.PropertyReader;
import com.core.utility.CommonActionUtils;

public class IxigoHomePageAction {
    private static Logger logger = Logger.getLogger(IxigoHomePageAction.class);
    PropertyReader propertyReader = null;
    CommonActionUtils actionUtils = null;
    IXigoHomePageObjects iXigoHomePageObjects = null;
    public static WebDriver driver=null;
    public IxigoHomePageAction(WebDriver driver)
    {
        this.driver=driver;
    	iXigoHomePageObjects = new IXigoHomePageObjects(driver);
    	actionUtils = new CommonActionUtils();
    	

    }
    
    public void writeIntoTheFRomField(String fromCityName) throws InterruptedException {
        logger.info("Click on the FromField");
        iXigoHomePageObjects.from_button.sendKeys(fromCityName);
        Thread.sleep(4000);
        actionUtils.actionClass(driver).sendKeys(Keys.ENTER).build().perform();;
        logger.info("fromCityName selected");

    }
    
    public void writeIntoTheToField(String toCityName) throws InterruptedException {
        logger.info("toCityName Clicked");
        iXigoHomePageObjects.to_button.sendKeys(toCityName);
        Thread.sleep(4000);
        actionUtils.actionClass(driver).sendKeys(Keys.ENTER).build().perform();;
        logger.info("toCityName selected");

    }
    public void clickIntoTheToDepartured() {
        logger.info("Click on the departure field");
        iXigoHomePageObjects.depature_button.click();
    }
    public void enterDateIntoTheDeparture() {
        logger.info("Click on the FromField");
        iXigoHomePageObjects.date_from_select.click();
    }
    
    public void clickOnReturnField() {
    	iXigoHomePageObjects.return_button.click();
        logger.info("Click on the return Button");
    }
    public void enterDateIntoTheArrival() {
        logger.info("Click on the FromField");
        iXigoHomePageObjects.date_to_select.get(1).click();
    }
    public void clickOnTravellerField() {
    	iXigoHomePageObjects.nu_of_traveller.click();
    }
    public void clickOnNumberOfTraveller() {
    	iXigoHomePageObjects.select_nuof_adtults.click();
    }
    public void clickOnSearchButton() {
    	iXigoHomePageObjects.search_button.click();
    }
    
    public boolean titleVerified() {
    	String actualTitle = "ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels";

    	System.out.println(driver.getTitle().trim());
    	System.out.println("abc"+actualTitle+"abc");
    	String exceptedTitel = driver.getTitle().trim();
    	System.out.println("abc"+exceptedTitel+"abc");
    	return exceptedTitel.equals(actualTitle);
    }
   
    
    
    


}
