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

    @FindBy(xpath = "//div[@class='chatbot_DrawerContentWrapper']")
    WebElement detailFrame;


    @FindBy (xpath = "//div[@class='botMsg msg ']")
    List<WebElement> botMessages;

    @FindBy(xpath = "//div[@class='textArea']")
    WebElement inputArea;

    @FindBy(xpath = "//div[@class='sendMsg']")
    WebElement sendDetail;




    public boolean login(String emailId,String pass){
        try {
         isElementClickableThenClick(loginBtn,20);
//            isElementClickableThenClick(loginBtn,15);
            sendText(email,emailId);
            sendText(password,pass);
            isElementClickableThenClick(loginSubmit,20);
            System.out.println(" logged in");
            Thread.sleep(3000);
            return true;
        } catch (Exception e) {
            System.out.println("not logged in");
            LogListener.reportLog(enumValues.LogsType.ERROR, "Element identified by "+ " was not visible");
            return false;
        }
    }

    public boolean searc(String keword){

        try {
            isElementClickableThenClick(searcBox1,20);
            sendText(searcBox2,keword);
            isElementClickableThenClick(searcBtn,15);
            System.out.println("searc "+keword+" ");

            return true;
        } catch (Exception e) {
            System.out.println("not seac");
            return false;
        }
    }

    public boolean appl(){
        int i=0;
        for(WebElement job:jobs) {

            try {
                isElementClickableThenClick(job, 5);
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                try {
                    isElementClickableThenClick(applyBtn,5);
                    System.out.println("aaplied job "+i++);
                   // fillform();
                    Thread.sleep(3000);
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

//    private void fillform() {
//
//        try {
//            waitForElementToBeVisible(detailFrame,10);
//            waitForElementToBeVisible(botMessages.get(botMessages.size()-1),10);
//
//
//            while (true){
//                Thread.sleep(1000);
//                String message = botMessages.get(botMessages.size()-1).getText();
//                switch (message.toLowerCase().contains()){
//                    case "first name":
//                        sendText(inputArea,"Mayank Kumar");
//                        waitForElementToBeVisible(sendDetail,5);
//                        break;
//                    case "Last Name":
//                        sendText(inputArea,"Mayank Kumar");
//                        waitForElementToBeVisible(sendDetail,5);
//                        break;
//
//
//
//                }
//
//
//            }
//
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


    public NaukriPage(WebDriver driver) {
        super(driver);
    }
}
