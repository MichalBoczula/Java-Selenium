package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://michalboczula.github.io/";
    private final WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
    private final Random random = new Random();

    @Before
    public void initTests() throws InterruptedException {
        webDriver.get(BASE_URL);
        waitFewSeconds(3);
    }

    @After
    public void cleanUpAfterTests() throws InterruptedException {
        waitFewSeconds(3);
        webDriver.close();
    }

    private String createCrudAppTestTask() {
        final String XPATH_TASK_NAME = "//form[contains(@class, \"row datatable\")]/fieldset[1]/input[1]";
        final String XPATH_TASK_CONTENT = "//form[contains(@class, \"row datatable\")]/fieldset[2]/textarea[1]";
        final String XPATH_BUTTON = "//form[contains(@class, \"row datatable\")]/fieldset[3]/button";
        final String taskName = "test " + random.nextInt(1000000);
        final String taskContent = "content " + random.nextInt(1000000);
        final WebElement taskElement = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        taskElement.sendKeys(taskName);
        final WebElement contentElement = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        contentElement.sendKeys(taskContent);
        final WebElement buttonElement = webDriver.findElement(By.xpath(XPATH_BUTTON));
        buttonElement.click();
        return taskName;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        final String taskName = createCrudAppTestTask();
        addCardToTrello(taskName);
    }

    @Test
    public void deleteTaskFromTrello() throws InterruptedException {
        final String taskName = createCrudAppTestTask();
        deleteCardFromTrello(taskName);
    }

    private String findTaskInApplication(String taskName) throws InterruptedException {
        waitFewSeconds(3);
        int n = Math.toIntExact(webDriver.findElements(By.xpath("//form[contains(@class,\"datatable__row\")]")).stream().count());
        int i = 1;
        String xPath = "";
        do {
            if (webDriver.findElement(By.xpath("/html/body/main/section[2]/div/form[" + i + "]/fieldset[1]/p")).getText().equals(taskName)) {
                xPath = "/html/body/main/section[2]/div/form[" + i + "]";
                break;
            }
            i++;
        } while (i <= n);
        return xPath;
    }

    private void addCardToTrello(String taskName) throws InterruptedException {
        final String xPathToBoardSelector = findTaskInApplication(taskName) + "/div/fieldset[2]/select[1]";
        final String xPathToButton = findTaskInApplication(taskName) + "/div/fieldset[2]/button";
        final WebElement boardTypeSelector = webDriver.findElement(By.xpath(xPathToBoardSelector));
        final WebElement buttonCreateACard = webDriver.findElement(By.xpath(xPathToButton));
        final Select selectBoardType = new Select(boardTypeSelector);
        selectBoardType.selectByIndex(1);
        buttonCreateACard.click();
    }

    private void deleteCardFromTrello(String taskName) throws InterruptedException {
        waitFewSeconds(3);
        final String xPathDeleteButton = findTaskInApplication(taskName) + "/div/fieldset[1]/button[4]";

        WebElement deleteButton = webDriver.findElement(By.xpath(xPathDeleteButton));
        deleteButton.click();
    }

    private void waitFewSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}