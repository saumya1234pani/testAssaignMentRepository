package com.activities.page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class IXigoHomePageObjects {
    WebDriver driver = null;

	@FindBy(xpath="//*[text()='From']/following-sibling::input")
    public WebElement from_button;
	@FindBy(xpath="	//*[text()='To']/following-sibling::input")
    public WebElement to_button;
	@FindBy(xpath="//*[text()='Departure']/following-sibling::input")
    public WebElement depature_button;
	@FindBy(xpath="//*[text()='Return']/following-sibling::input")
    public WebElement return_button;
	
    @FindBy(xpath="//*[contains(text(),'Travellers')]/following-sibling::input")
    public WebElement nu_of_traveller;
    @FindBy(xpath="//*[*[*[*[contains(text(),'Travellers')]/following-sibling::input]]]/following-sibling::div[1]/button")
    public WebElement search_button;
    @FindBy(xpath="//*[div[contains(text(),'Adult')]]/following-sibling::div/span[$]")
    public WebElement number_of_adult;
    @FindBy(xpath="//*[div[contains(text(),\"December 2020\")]]//tr[3]/td[5]")
    public WebElement date_from_select;
    @FindBys({@FindBy(xpath="//*[div[contains(text(),\"January 2021\")]]//tr[5]/td[1]")})
    public List<WebElement> date_to_select;
    @FindBy(xpath="//div[6]/div[2]/div[2]//tr[4]/td[5]/div[1]")
    public WebElement month_select_file;
    @FindBy(xpath="//*[div[text()='Adult']]/following-sibling::div/span[2]\n")
    public WebElement select_nuof_adtults;
    

     public IXigoHomePageObjects(WebDriver driver) {
         PageFactory.initElements(driver, this);
   }
}
