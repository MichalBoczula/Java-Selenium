package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String FIND_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String FIND_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String FIND_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";
    public static void main(String[] args){
        final WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com/");
        while (!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());
        final WebElement findDay = webDriver.findElement(By.xpath(FIND_DAY));
        final Select selectDay = new Select(findDay);
        selectDay.selectByIndex(1);
        while (!webDriver.findElement(By.xpath("//select[2]")).isDisplayed());
        final WebElement findMonth = webDriver.findElement(By.xpath(FIND_MONTH));
        final Select selectMonth = new Select(findMonth);
        selectMonth.selectByIndex(1);
        while (!webDriver.findElement(By.xpath("//select[3]")).isDisplayed());
        final WebElement findYear = webDriver.findElement(By.xpath(FIND_YEAR));
        final Select selectYear = new Select(findYear);
        selectYear.selectByVisibleText("2000");
    }
}
