package tests;

import framework.ParentTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MortgagesPage;


public class Tests extends ParentTest{

    private MortgagesPage mortgagesPage;

    @BeforeTest
    public void beforeTest(){
        startBrowser();
    }

    @Test
    public void testTaskTest(){
        navigateTo();
        homePage.changeLangAndGoToMortgages();
        mortgagesPage = new MortgagesPage(getDriver());
        mortgagesPage.calculateYourPayments();
    }
}
