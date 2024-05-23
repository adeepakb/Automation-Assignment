package org.example.pages;

import org.example.constant.enumValues;
import org.example.listeners.LogListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NaukriPage extends BasePage{



    @FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
    WebElement email;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//a[@title='Jobseeker Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginSubmit;

    @FindBy(xpath = "//span[text()='Search jobs here']")
    WebElement searcBox1;

    @FindBy(xpath = "//input[@class='suggestor-input ']")
    WebElement searcBox2;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searcBtn;


    @FindBy(xpath = "//div[@class='srp-jobtuple-wrapper']")
    List<WebElement> jobs;

    @FindBy (xpath = "//button[@id='apply-button']")
    WebElement applyBtn;




    public boolean login(String emailId,String pass){
        try {
         isElementClickableThenClick(loginBtn,15);
//            isElementClickableThenClick(loginBtn,15);
            sendText(email,emailId);
            sendText(password,pass);
            isElementClickableThenClick(loginSubmit,10);

            return true;
        } catch (Exception e) {
            LogListener.reportLog(enumValues.LogsType.ERROR, "Element identified by "+ " was not visible");
            return false;
        }
    }

    public boolean searc(String keword){

        try {
            isElementClickableThenClick(searcBox1,15);
            sendText(searcBox2,keword);
            isElementClickableThenClick(searcBtn,10);

            return true;
        } catch (Exception e) {
            System.out.println("not seac");
            return false;
        }
    }

    public boolean appl(){

        for(WebElement job:jobs) {

            try {
                isElementClickableThenClick(job, 15);
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                try {
                    isElementClickableThenClick(applyBtn,10);
                }catch (Exception e){
                    System.out.println("not apll job");
                }
                finally {
                    Thread.sleep(3);

                    driver.close();
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


    public NaukriPage(WebDriver driver) {
        super(driver);
    }
}
