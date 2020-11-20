package com.activities.page_action;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.activities.page_objects.IXigoHomePageObjects;
import com.activities.page_objects.IxigoSearchPageObject;

public class IxigoSearchPage {
    public static WebDriver driver=null;
    IxigoSearchPageObject ixigoSearchPageObject = null;
	 public IxigoSearchPage(WebDriver driver)
	    {
	        this.driver=driver;
	        ixigoSearchPageObject = new IxigoSearchPageObject(driver);

	    }
	 public boolean verifyStopsText() {
		 String actualText = "Stops";
		 String exceptedText = ixigoSearchPageObject.stops.getText();
		 
		 return actualText.equals(exceptedText);
		 
	 }
	 public boolean verifyAirlinesText() {
		 String actualText = "Airlines";
		 String exceptedText = ixigoSearchPageObject.airlance.getText();
		return actualText.equals(exceptedText); 
	 }
	 public boolean verifyDepartureText() {
		 String actualText = "Departure";
		 String exceptedText = ixigoSearchPageObject.departure.getText();
		return exceptedText.contains(actualText	); 
	 }
	 public void clickNonStopBox() {
		 ixigoSearchPageObject.non_stop_btn.click();
	 }
	 public void printAirLineDetails() {
		 List<WebElement> listOfAirLine = ixigoSearchPageObject.listOfAirlines;
		 List<WebElement> listOfFair = ixigoSearchPageObject.priceList;
		 List<WebElement> listOfDepartureTime = ixigoSearchPageObject.deoarture_time;
         int i =listOfDepartureTime.size();
         int j =0;
         while(i-->=0) {
        	 try {
        		 String price = listOfFair.get(i).getText();
        		 int numberprice = Integer.parseInt(price);
        		 if(numberprice<6000) {
        		 String[] airline = listOfAirLine.get(i).getText().split(" ");
        		 
        		 System.out.print("The airline Details :" +airline[airline.length-1]);
        		 System.out.print("           ");
        		 System.out.print(listOfDepartureTime.get(i).getText());
        		 System.out.print("           ");
        		 System.out.print(numberprice);
        		 System.out.println();
        		  }
        		 
        	 
        	 
        	 }catch (Exception e) {}
	 
	   }
	 }
	  
}
