package org.example.pages;

import org.example.constant.enumValues;
import org.example.listeners.LogListener;
import org.example.util.LoggerUtil;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @author Bharathish
 */
public class BasePage {

    /**
     * The driver.
     */
    protected WebDriver driver;

    /**
     * The waiter.
     */
    protected FluentWait<WebDriver> waiter;

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
                .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
    }


    public boolean waitForElementToBeVisible(WebElement element, int timeOut) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

    }

    public boolean isElementClickableThenClick(WebElement element, int timeOutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            // Expectedcondition for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            LogListener.reportLog(enumValues.LogsType.INFO, "Clicked on  "+element.toString());
            return true;
        } catch (NoSuchElementException e) {
            LogListener.reportLog(enumValues.LogsType.ERROR, "Did not turn to clickable" + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement element, int timeOutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            // Expectedcondition for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException e) {
            LogListener.reportLog(enumValues.LogsType.INFO, "Did not turn to clickable" + e.getMessage());
            return false;
        }
    }

    public boolean switchToFrame(String frameName) {
        try {
            driver.switchTo().frame(frameName);
            LogListener.reportLog(enumValues.LogsType.INFO, "Switched to frame " + frameName );
            return true;
        } catch (Exception e) {
            LogListener.reportLog(enumValues.LogsType.ERROR, "Couldn't find frame " + frameName + e.getMessage());
            return false;
        }

    }

    public boolean switchTodefaultContent() {
        try {
            driver.switchTo().defaultContent();
            LogListener.reportLog(enumValues.LogsType.INFO, "Switched to default content ");
            return true;
        } catch (Exception e) {
            LogListener.reportLog(enumValues.LogsType.ERROR, "Couldn't find frame default content");
            return false;
        }

    }

    public boolean sendText(WebElement element, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            // Expectedcondition for the element to be clickable
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
            LogListener.reportLog(enumValues.LogsType.INFO, "Entered "+value +" to" + element.toString());
            return true;
        } catch (NoSuchElementException e) {
            LogListener.reportLog(enumValues.LogsType.ERROR, "Couldn't enter "+value+" to "+ element.toString());
            return false;
        }
    }





}
