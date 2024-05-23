package org.example.tests;

import org.example.factory.PageinstancesFactory;
import org.example.pages.McPizzaPage;
import org.example.pages.NaukriPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NaukriTest extends BaseTest{

    NaukriPage naukriPage;
    SoftAssert softAssert;

    @BeforeClass
    public void setUpMacPizzaTest() {
        driver.get("https://www.naukri.com/");
        naukriPage = PageinstancesFactory.getInstance(NaukriPage.class);
        softAssert= new SoftAssert();

    }
    @Test
    public void linkedInAppl(){
        naukriPage.login("deepakjagdambakumar@gmail.com","Deepak1!");

        String [] jobStrg= {"QA Automation","SDET","Lead QA Automation","Lead SDET","Software Developer Engineer in Test","Lead QA engineer","QA Engineer","MLOPs","Gen Ai","Data Science","Machine Learning"};
        for(String s: jobStrg){
            driver.get("https://www.naukri.com/");
            //naukriPage.searc("QA Automation");
            naukriPage.searc(s);
            naukriPage.appl();
        }

        System.out.println("Deepak1!");


    }


}
