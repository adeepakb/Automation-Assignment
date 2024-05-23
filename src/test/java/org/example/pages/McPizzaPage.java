package org.example.pages;

import org.example.constant.enumValues.LogsType;
import org.example.listeners.LogListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class McPizzaPage extends BasePage {

    @FindBy(id = "avaamo__popup")
    private WebElement popUp;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "email")
    private WebElement email;


    @FindBy(xpath = "//button[@class='send btn']")
    private WebElement sendBtn;

    @FindBy(className = "avaamo__icon")
    private WebElement icon;

    @FindBy(className = "get-started-link")
    private WebElement getStartedButton;

    @FindBy(xpath = "//p[@class='desc text-content ']")
    private WebElement welcomeMessage;



    @FindBy(xpath = "//div[@class='default_card_image']")
    private WebElement welcomeImage;

    @FindBy(xpath = "//p[@class='desc text-content ']")
    private List<WebElement> allMessages;

    @FindBy(id = "queryTextbox")
    private WebElement queryTextbox;

    @FindBy(xpath = "//button[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='conversation-item clearfix not-mine']")
    List<WebElement> notMineChat;

    @FindBy(xpath = "//div[@class='conversation-item clearfix not-mine sameUserSendMessage']")
    List<WebElement> notMineChatSameUser;

    @FindBy(xpath = "//div[@class='conversation-item clearfix mine']")
    List<WebElement> mineChat;


    @FindBy(xpath = "//a[@class='quick-reply']")
    List<WebElement> quickReplies;


    @FindBy(xpath = "//label[@class='composer__container__preview__option']")
    List<WebElement> topplingTypes;


    @FindBy(xpath = "//button[@class='btn default_card_submit']")
    WebElement submitBtnForToppling;


    @FindBy(xpath = "//a[@type='deeplink']")
    List<WebElement> crustTypeTexts;


    @FindBy(xpath = "//div[@class='default_card_title']")
    List<WebElement> pizzaSizeTitle;


    @FindBy(xpath = "//div[@class='default_card_description']")
    WebElement pizzaSizeDescription;


    @FindBy(xpath = "//div[@class='default_card_link']")
    List<WebElement> pizzaSizes;


   @FindBy(xpath = "//button[@class='thumbs-up locale-trans']")
   WebElement thumpsUp;

    @FindBy(xpath = "//button[@class='thumbs-down locale-transs']")
    WebElement thumpsDown;

    @FindBy(xpath = "//input[@class='textbox picklist-textbox avm_pick_list_input locale-trans']")
    WebElement ratingSelect;

    @FindBy(xpath = "//li[@class='item']")
    List<WebElement> ratingItems;

    @FindBy(xpath = "//button[@class='btn default_card_cancel']")
    WebElement ratingCancel;

    @FindBy(xpath = "//button[@class='btn default_card_submit']")
    WebElement ratingSubmit;



    @FindBy(id ="email")
    WebElement emailInsta;

    @FindBy(id="password")
    WebElement password;


    @FindBy(id="years")
    WebElement years;

    @FindBy(id="show-results")
    WebElement showResults;

    @FindBy(id = "interested-btn")
    WebElement interestedBtn;


    @FindBy(xpath = "//button[text()='Apply']")
    WebElement Apply;


    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginBtn;
    public McPizzaPage(WebDriver driver) {
        super(driver);
    }



    public boolean loginNew(String emailId,String pass){
        try {
            waitForElementToBeVisible(emailInsta,15);
            sendText(emailInsta,emailId);
            sendText(password,pass);
            isElementClickableThenClick(loginBtn,10);

            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + icon.toString() + " was not visible");
            return false;
        }
    }

    public boolean waitForIcon() {
        try {
            waitForElementToBeVisible(icon, 5);
            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + icon.toString() + " was not visible");
            return false;
        }
    }

    public boolean clickOnIcon() {
        try {
            isElementClickableThenClick(icon, 5);
            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + icon.toString() + " was not visible");
            return false;
        }
    }

    public boolean verifyPopup() {
        try {
            waitForElementToBeVisible(popUp, 7);
            waitForElementToBeVisible(getStartedButton,7);
            LogListener.reportLog(LogsType.INFO, "Element identified by " + popUp.toString() + " was  visible");
            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + popUp.toString() + " was not visible");
            return false;
        }
    }

    public boolean clickOnGetStarted() {
        try {
            isElementClickableThenClick(getStartedButton, 5);
            LogListener.reportLog(LogsType.INFO, "Element identified by " + popUp.toString() + " was  visible");
            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + popUp.toString() + " was not visible");
            return false;
        }
    }

    public boolean verifyLoginPage(){

        try {

            waitForElementToBeVisible(firstName, 7);
            waitForElementToBeVisible(email,7);
            LogListener.reportLog(LogsType.INFO, "Element identified by " + firstName.toString() + " was  visible");
            LogListener.reportLog(LogsType.INFO, "Element identified by " + email.toString() + " was  visible");
            return true;
        } catch (Exception e) {
            LogListener.reportLog(LogsType.ERROR, "Element identified by " + firstName.toString() + " was not visible");
            return false;
        }
    }

    public boolean login(String name, String mail) {
        try {
            sendText(firstName,name);
            sendText(email,mail);
            isElementClickableThenClick(sendBtn,10);
            LogListener.reportLog(LogsType.INFO, "Logged in successfully to "+name+"and "+email);
            return true;
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Log in unsuccessfully to "+name+"and "+email+e.getMessage());
            return false;
        }

    }

    public boolean verifyWelcomeMessages(String welcomeToMcPizzaBookingJourney) {
        try {
            boolean isVisible =waitForElementToBeVisible(welcomeMessage,10) && welcomeMessage.getText().equalsIgnoreCase(welcomeToMcPizzaBookingJourney);
            boolean isWelcomeImageVisible = welcomeImage.isDisplayed();
            if(isVisible&&isWelcomeImageVisible){
                LogListener.reportLog(LogsType.INFO, "Welcome message and image is shown");
                return true;
            }else {
                LogListener.reportLog(LogsType.ERROR, "Welcome messages not shown");;
                return false;
            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Welcome messages not shown");;
            return false;
        }

    }

    public boolean sendChatMessage(String s) {
        try {
            sendText(queryTextbox,s);
            isElementClickableThenClick(sendButton,5);
            LogListener.reportLog(LogsType.INFO, "Sent chat "+s);
            return true;
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Couldn’t send chat "+s);
            return false;
        }
    }
    public boolean verifyChatIsSent(String message){
        boolean result= verifMessage(mineChat,message);
        if(result){
            LogListener.reportLog(LogsType.INFO, "Sent chat messages  is   verified"+message);
        }else {
            LogListener.reportLog(LogsType.ERROR, "Sent chat messages is not  verified"+message);
        }
        return result;
    }

    public boolean verifyChatReceived(String message){
        boolean result= verifMessage(notMineChat,message);
        if(result){
            LogListener.reportLog(LogsType.INFO, "Received Chat messages is   verified"+message);
        }else {
            LogListener.reportLog(LogsType.ERROR, "Received chat messages is not  verified"+message);
        }
        return result;
    }

    public boolean verifyChatReceivedSameUSer(String message){
        boolean result= verifMessage(notMineChatSameUser,message);
        if(result){
            LogListener.reportLog(LogsType.INFO, "Received Chat messages is   verified"+message);
        }else {
            LogListener.reportLog(LogsType.ERROR, "Received chat messages is not  verified"+message);
        }
        return result;
    }

    private boolean verifMessage(List<WebElement> chats, String message) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean result = false;
        try {
            for(WebElement elemnt:chats){

                if(message.equalsIgnoreCase(elemnt.getText().toLowerCase())){
                    result =true;
                    break;
                }else {

                }
            }
        }
        catch (Exception e){
        }

        return result;
    }

    public boolean selectPizzaType(String type){
        boolean success= false;
        try {
            for(WebElement element: quickReplies){
                if(element.getText().equalsIgnoreCase(type)){
                    element.click();
                    LogListener.reportLog(LogsType.INFO, "Option selected:"+type);
                    success =true;
                    break;
                }
            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.INFO, "Couldn’t  select option:"+type);
        }
        return success;
    }

    public boolean selectTopplingType(String type){
        boolean success= false;
        try {
            for(WebElement element: topplingTypes){
                if(element.getText().equalsIgnoreCase(type)){
                    element.click();
                    submitBtnForToppling.click();
                    LogListener.reportLog(LogsType.INFO, "Option selected:"+type);
                    success =true;
                    break;
                }
            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.INFO, "Couldn’t  select option:"+type);
        }
        return success;
    }

    public boolean selectCrustType(String type){
        boolean success= false;
        try {
            for(WebElement element: crustTypeTexts){

                if(element.getText().equalsIgnoreCase(type.toLowerCase())){
                    element.click();
                    LogListener.reportLog(LogsType.INFO, "Option selected:"+type);
                    success =true;
                    break;
                }
            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Couldn’t  select option:"+type);
        }
        return success;
    }


    public boolean verifyPizzaSizeDescription(String pizzaSizeTitleText,String pizzaSizeDescriptionText){
        try {
            waitForElementToBeVisible(pizzaSizeDescription,5);
            boolean isPizzaSizeDseriptionBeingShown =pizzaSizeDescription.getText().equalsIgnoreCase(pizzaSizeDescriptionText.toLowerCase());
            boolean isPizzaSizeTitleShown= false;
            for(WebElement el: pizzaSizeTitle){
                if(el.getText().equalsIgnoreCase(pizzaSizeTitleText.toLowerCase())){
                    isPizzaSizeTitleShown=true;
                }
            }

            if(isPizzaSizeTitleShown && isPizzaSizeDseriptionBeingShown){
                LogListener.reportLog(LogsType.INFO, "Pizza size description shown" +pizzaSizeDescriptionText +" and "+pizzaSizeTitleText);
                return true;
            }else {
                LogListener.reportLog(LogsType.ERROR, "Pizza size title and description not shown correctly");
                return false;

            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Pizza size title and description not shown");
            return false;
        }

    }

    public boolean selectPizzaSizes(String type){
        boolean success= false;
        try {
            for(WebElement element: pizzaSizes){

                if(element.getText().equalsIgnoreCase(type)){
                    element.findElement(By.xpath("./child::*")).click();                    element.click();
                    LogListener.reportLog(LogsType.INFO, "Size  selected:"+type);
                    success =true;
                    break;
                }
            }
        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Couldn’t  select size:"+type);
        }
        return success;
    }

    public boolean selectQuickReply(String type) {

        boolean success= false;
        try {
            for(WebElement element: quickReplies){

                if(element.getText().equalsIgnoreCase(type)){
                    element.click();
                    LogListener.reportLog(LogsType.INFO, "Quick reply"+type+"  selected:");
                    success =true;
                    break;
                }
            }

        }catch (Exception e){
            LogListener.reportLog(LogsType.ERROR, "Couldn’t  select Quick reply"+type);
        }
        return success;
    }

    public boolean giveRating(String thumpsup,String ratingType) {
        boolean success =false;
        if(thumpsup.equalsIgnoreCase("thumpsup")){
            thumpsUp.click();

            ratingSelect.click();
            try {
                waitForElementToBeVisible(ratingItems.get(0),5);

            }catch (Exception e){
                LogListener.reportLog(LogsType.INFO, "Rating items not found"+ratingType);
            }

            for(WebElement element: ratingItems){
                if(element.getText().equalsIgnoreCase(ratingType)){
                    element.click();
                    ratingSubmit.click();
                    success =  true;
                    LogListener.reportLog(LogsType.INFO, "Rating items found"+ratingType);
                    break;
                }
            }
        } else if (thumpsup.equalsIgnoreCase("thumpsdown")) {
            thumpsDown.click();
            success =  true;
        }else {
            success=false;
        }
        return success;
    }

    public void enterEars(String number) {
        try {
            waitForElementToBeVisible(years,30);
            years.clear();
            sendText(years,number);
            isElementClickableThenClick(showResults,15);
            System.out.println("Started aplling jobs");
        }catch (Exception e){
            System.out.println("ee wala error");
        }

    }

    public void appl(){

            try {
                try {
                    isElementClickableThenClick(interestedBtn,15);
                }catch (Exception e){
                    System.out.println("failed to find 1st job");
                }

                int i=0;
                while (true){
                    try {
                        waitForElementToBeVisible(Apply,25);
                        isElementClickableThenClick(Apply,30);
                        System.out.println("Apllied" +i++);
                    }catch (Exception e){
                        System.out.println("broke");
                        break;
                    }

                }


            }catch (Exception e){
                System.out.println("failed to find  job appl button");
            }


    }
}
