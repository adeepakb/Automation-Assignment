package org.example.tests;

import org.example.factory.PageinstancesFactory;
import org.example.pages.NaukriPage;
import org.example.pages.NaukrigulfPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NaukriGulfTest extends BaseTest {

    NaukrigulfPage naukriPage;
    SoftAssert softAssert;

    @BeforeClass
    public void setUpMacPizzaTest() {
        driver.get("https://www.naukrigulf.com/");
        naukriPage = PageinstancesFactory.getInstance(NaukrigulfPage.class);
        softAssert = new SoftAssert();

    }

    @Test
    public void linkedInAppl() throws InterruptedException {
       naukriPage.login("mayankece155@gmail.com", "May_30ank");
       // naukriPage.login("deepakjagdambakumar@gmail.com","Deepak1!");

        while (true) {
          //  String[] jobStrg = { "QA Automation", "SDET", "Lead QA Automation", "Lead SDET", "Software Developer Engineer in Test", "Lead QA engineer", "QA Engineer","MLOPs", "Gen Ai", "Data Science", "Machine Learning","Computer Vision","Deep Learning"};
            String[] jobStrg = {"React Js Developer", "React Js Frontend Developer", "Mern Stack", "Mern Stack Developer", "Mean Stack Developer", "Node Js Developer", "React Native Developer", "Fullstack Javascript Developer", "Fullstack react developer", "Node Js Backend Developer", "Javascript", "Java Script Developer", "CSS Developer", "CSS And Javascript"};
            for (String s : jobStrg) {
                System.out.println("test  wit " + s);
                Thread.sleep(3000);
                driver.get("https://www.naukrigulf.com/");
                //naukriPage.searc("QA Automation");
                naukriPage.searc(s);
                naukriPage.appl();
            }
        }

        // System.out.println("Deepak1!");


    }
}
