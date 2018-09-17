package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "lst-ib";

    public static void main(String[] args) {
        final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("http://www.google.com");

//        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
//        searchField.sendKeys("Kodilla");
//        searchField.submit();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(SEARCHFIELD));
            }
        });
        foo.sendKeys("Kodilla");
        foo.submit();
    }
}
