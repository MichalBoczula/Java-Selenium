package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {
    public final static String CHROME = "chrome_driver";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\Chrome\\chromedriver2.42\\chromedriver.exe");

        return driver.equalsIgnoreCase(CHROME)?
                new ChromeDriver() : null;
    }
}
