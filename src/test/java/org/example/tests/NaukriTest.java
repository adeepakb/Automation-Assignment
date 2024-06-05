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
      //naukriPage.login("mayankece155@gmail.com","May_30ank");
        //naukriPage.login("deepakjagdambakumar@gmail.com","Deepak1!");
       naukriPage.login("nirajiota@gmail.com" ,"nirajbtguy");

        while (true) {
          // String[] jobStrg = { "MLOPs", "Gen Ai", "Data Science", "Machine Learning","Computer Vision","Deep Learning"}; //"QA Automation", "SDET", "Lead QA Automation", "Lead SDET", "Software Developer Engineer in Test", "Lead QA engineer", "QA Engineer",
           // String[] jobStrg = { "React Js Developer", "React Js Frontend Developer", "Mern Stack", "Mern Stack Developer","Mean Stack Developer","Node Js Developer","Javascript Developer", "Fullstack Javascript Developer", "Fullstack react developer", "Node Js Backend Developer","Javascript", "Java Script Developer","CSS Developer", "CSS And Javascript"};

            String[] jobStrg = {"Sales Manager","Sales Development","Business Development Manager","Senior sales manager","Senior business development manager","Business Development Executive","Business Development Executive Officer","Business development And Sales Manager"  };
            for (String s : jobStrg) {
                System.out.println("test  wit " + s);
                driver.get("https://www.naukri.com/");
                //naukriPage.searc("QA Automation");
                naukriPage.searc(s);
                naukriPage.appl();
            }
        }

       // System.out.println("Deepak1!");


    }


}
