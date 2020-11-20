package com.core.base_step;
import org.openqa.selenium.WebDriver;

public class InitiateDriver {
	public WebDriver driver;

	public WebDriver getDriver() {
        if (driver == null) {
            this.driver = driver;
        }
        return driver;
    }

}
