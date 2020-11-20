package com.activities.page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class IxigoSearchPageObject {
	WebDriver driver = null;
	
	
	public IxigoSearchPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
  }
	
	@FindBy(xpath="//div[text()='Stops']")
    public WebElement stops;
	@FindBy(xpath="//div[contains(text(),'Departure')]")
    public WebElement departure;
	@FindBy(xpath="//div[text()='Airlines']")
    public WebElement airlance;
	@FindBys({@FindBy( xpath = "//*[@id=\"content\"]/div/div[4]/div[1]/div/div[4]/div/div/div/div[1]/div[3]/div[4]/div")})
    public List<WebElement> listOfAirlines;
	
	@FindBys({@FindBy( xpath = "//*[@id=\"content\"]/div/div[4]/div[1]/div/div[4]/div/div/div/div[1]/div[5]/div/div/span[2]")})
    public List<WebElement> priceList;
	
	@FindBy(xpath="//*[text()='Non stop']")
	public WebElement non_stop_btn;
	
	@FindBys({@FindBy(xpath ="//*[@id=\"content\"]/div/div[4]/div[1]/div/div[4]/div/div/div/div/div[3]/div[1]")})
	public List<WebElement> deoarture_time;
	

	
}
