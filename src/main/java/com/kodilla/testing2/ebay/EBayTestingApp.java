package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static void main(String[] args){
        final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("http://www.ebay.com");

        WebElement findLaptop = driver.findElement(By.id("gh-ac"));
        findLaptop.sendKeys("laptop");
        findLaptop.submit();
    }
}
