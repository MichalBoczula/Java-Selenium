package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.kodilla.testing2.config.WebDriverConfig.CHROME;

public class CrudAppTestingApp {
    public static void main(String[] args){
        final WebDriver webDriver = WebDriverConfig.getDriver(CHROME);
        webDriver.get("https://michalboczula.github.io/");
        final WebElement find = webDriver.findElement(By.xpath("/html/body/main/section/form/fieldset/input"));
        find.sendKeys("robotic test");
        final WebElement find2 = webDriver.findElement(By.xpath("/html/body/main/section/form/fieldset[2]/textarea"));
        find2.sendKeys("robotic second test");
        while (!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());
        final WebElement selectCombo = webDriver.findElement(By.xpath("//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]"));
        final Select select = new Select(selectCombo);
        select.selectByIndex(1);
    }
}
