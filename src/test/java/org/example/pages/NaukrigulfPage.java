package org.example.pages;

import org.example.constant.enumValues;
import org.example.listeners.LogListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NaukrigulfPage extends BasePage{

    public NaukrigulfPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='loginModalLoginEmail']")
    WebElement email;
    @FindBy(xpath = "//input[@id='loginPassword']")
    WebElement password;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[@id='loginModalLoginSubmit']")
    WebElement loginSubmit;

    @FindBy(xpath = "//div[text()='Enter skills, designations or company names']")
    WebElement searcBox1;

    @FindBy(xpath = "//input[@id='qsbKey']")
    WebElement searcBox2;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searcBtn;


    @FindBy(xpath = "//div[@class='ng-box srp-tuple']")
    List<WebElement> jobs;

    @FindBy (xpath = "//button[text()='Apply']")
    WebElement applyBtn;

    @FindBy(xpath = "//p[@class='jd-button applied-text']")
    WebElement alredApllied;

    @FindBy(xpath = "//button[@value='easyApply']")
    WebElement easyApply;


   @FindBy(xpath = "//button[@class='ng-btn jd-button blue']")
   WebElement easyApplyButton;




    public boolean login(String emailId,String pass){
        try {
            isElementClickableThenClick(loginBtn,20);
//            isElementClickableThenClick(loginBtn,15);
            sendText(email,emailId);
            sendText(password,pass);
            isElementClickableThenClick(loginSubmit,20);
            System.out.println(" logged in");
            return true;
        } catch (Exception e) {
            System.out.println("not logged in");
            LogListener.reportLog(enumValues.LogsType.ERROR, "Element identified by "+ " was not visible");
            return false;
        }
    }

    public boolean searc(String keword){

        try {
            isElementClickableThenClick(searcBox1,10);
            sendText(searcBox2,keword);
            isElementClickableThenClick(searcBtn,10);
            System.out.println("searc "+keword+" ");

            return true;
        } catch (Exception e) {
            System.out.println("not seac");
            return false;
        }
    }

    public boolean appl(){
        int i=0;
        isElementClickableThenClick(easyApply,15);
        for(WebElement job:jobs) {

            try {
                //div[@class='ng-box srp-tuple']//span[text()='applied']
                try {
                    Thread.sleep(2000);
                    WebElement ele =job.findElement(By.xpath("//span[text()='applied']"));
                    if(ele.getText().equalsIgnoreCase("Applied")) {
                        continue;
                    }
                }catch (Exception e){
                    isElementClickableThenClick(job, 5);
                    System.out.println("Found eas appl job");
                }

              //  isElementClickableThenClick(job, 15);
                Thread.sleep(2000);
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                try {
                    isElementClickableThenClick(easyApplyButton,5);
                    System.out.println("eas aplied job "+i++);
                    Thread.sleep(3000);
                }catch (Exception e){
                    System.out.println("not apll job");
                }
                finally {
//                    waitForElementToBeVisible(alredApllied,5);
//                    if(alredApllied.isDisplayed()){
//                        driver.close();
//                    }
                    driver.close();
                   //
                }
                driver.switchTo().window(tabs.get(0));
                // isElementClickableThenClick(searcBtn, 10);

                // return true;
            } catch (Exception e) {
                System.out.println("not seac");
                // return false;
            }
        }
        return true;
    }

}
