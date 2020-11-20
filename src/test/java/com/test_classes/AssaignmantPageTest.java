package com.test_classes;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.activities.page_action.IxigoHomePageAction;
import com.activities.page_action.IxigoSearchPage;
import com.activities.page_objects.IxigoSearchPageObject;
import com.core.base_step.TestBase;
import com.core.propert_reader.PropertyReader;
import com.core.utility.CommonActionUtils;

public class AssaignmantPageTest extends TestBase{
	 private static Logger logger = Logger.getLogger(AssaignmantPageTest.class);
	    Properties prop = null;
	    PropertyReader propertyReader = null;
	    CommonActionUtils actionUtils=null;
	    IxigoHomePageAction ixigoHomePageAction = null; 
	    IxigoSearchPage ixigoSearchPage = null;
	    
	    
	    @BeforeMethod
	    public void verifyNavigateUrl() throws InterruptedException, IOException {
	        prop = new Properties();
	        propertyReader = new PropertyReader(prop);
	        actionUtils = new CommonActionUtils();
	        actionUtils.navigatetoUrl(driver, prop.getProperty("test_url"));
	        Thread.sleep(10000);
	        actionUtils.implicitlyWait(driver,30);
	    }
	    @Test
	    public void test() throws IOException, InterruptedException {
	    	ixigoHomePageAction = new IxigoHomePageAction(driver);
	        propertyReader = new PropertyReader(prop);
	        actionUtils = new CommonActionUtils();
	        ixigoSearchPage = new IxigoSearchPage(driver);

	    	Assert.assertTrue(ixigoHomePageAction.titleVerified(),"Check the titel");
	        logger.info("Page Title verified");
	        ixigoHomePageAction.writeIntoTheFRomField(prop.getProperty("fromCityName"));
	        ixigoHomePageAction.writeIntoTheToField(prop.getProperty("toCityName"));
	        ixigoHomePageAction.clickIntoTheToDepartured();
	        ixigoHomePageAction.enterDateIntoTheDeparture();
	        ixigoHomePageAction.clickOnReturnField();
	        ixigoHomePageAction.enterDateIntoTheArrival();
	        ixigoHomePageAction.clickOnTravellerField();
	        ixigoHomePageAction.clickOnNumberOfTraveller();
	        ixigoHomePageAction.clickOnSearchButton();
	        actionUtils.implicitlyWait(driver,30);
            Assert.assertTrue(ixigoSearchPage.verifyStopsText(),"Text is not visible");
            Assert.assertTrue(ixigoSearchPage.verifyAirlinesText(),"Text is not visible");
            Assert.assertTrue(ixigoSearchPage.verifyDepartureText(),"Text is not visible");
            ixigoSearchPage.clickNonStopBox();
	        actionUtils.implicitlyWait(driver,30);
	        ixigoSearchPage.printAirLineDetails();
	    	driver.quit();

	    }
	    @AfterMethod
	    public void terminateProcess() {
	    	driver.quit();
	    }
	    

}
