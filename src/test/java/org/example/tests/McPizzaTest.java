package org.example.tests;


import org.example.factory.PageinstancesFactory;
import org.example.pages.McPizzaPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(testName = "Mac Pizaa Test", description = "Login and order Scenario")

public class McPizzaTest extends BaseTest {

    McPizzaPage mcPizzaPage;
    SoftAssert softAssert;

    @BeforeClass
    public void setUpMacPizzaTest() {
        driver.get("https://c0.avaamo.com/web_channels/cce5f713-c1f4-4666-8976-b091299cda81/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
        mcPizzaPage = PageinstancesFactory.getInstance(McPizzaPage.class);
        softAssert= new SoftAssert();
    }


    @Test
    public void macOrderTest() {
        boolean a1 = mcPizzaPage.clickOnIcon();
        boolean a2 = mcPizzaPage.verifyPopup();
        boolean a3 = mcPizzaPage.clickOnGetStarted();
        mcPizzaPage.switchToFrame("avaamoIframe");
        boolean a4 = mcPizzaPage.verifyLoginPage();
        boolean a5 = mcPizzaPage.login("deepak", "deepakjagdambakumar@gmail.com");
        boolean a6 = mcPizzaPage.verifyWelcomeMessages("Welcome to McPizza Booking Journey");
        boolean a7 = mcPizzaPage.sendChatMessage("I want to order a pizza");
      boolean a8 = mcPizzaPage.verifyChatIsSent("I want to order a pizza");
      boolean a0 = mcPizzaPage.verifyChatReceived("We have a wide variety of freshly backed pizza . What would you like to Order ?");
        boolean a10 = mcPizzaPage.selectPizzaType("veg");
       boolean a11 = mcPizzaPage.verifyChatIsSent("veg");
        boolean a12 = mcPizzaPage.selectTopplingType("Cheese");
        boolean a13 = mcPizzaPage.verifyChatReceivedSameUSer("Great ! You have Selected cheese");
        boolean a14 = mcPizzaPage.selectCrustType("Thick Crust");
        boolean a15 = mcPizzaPage.verifyPizzaSizeDescription("Pizza Size", "Great . Let's Select Your Pizza Size");
        boolean a16 = mcPizzaPage.selectPizzaSizes("Medium");
        boolean a17 = mcPizzaPage.verifyChatReceivedSameUSer("Would you like to confirm the order?");
        boolean a18 = mcPizzaPage.selectQuickReply("Yes");
        boolean a20 = mcPizzaPage.giveRating("thumpsup", "Good");
        softAssert.assertEquals(true,(a1 && a2 && a3 && a4 && a5 &&a6 && a7  && a8 && a10 && a11 && a12 && a13 && a14));

        mcPizzaPage.switchTodefaultContent();
    }

    @AfterClass
    public void after(){
        softAssert.assertAll();
    }
}
