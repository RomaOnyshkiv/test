package tests;

import framework.ParentTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CalculatePaymentPage;
import pages.MortgagesPage;


public class Tests extends ParentTest{

    private MortgagesPage mortgagesPage;
    private CalculatePaymentPage calculatePaymentPage;

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
        calculatePaymentPage = new CalculatePaymentPage(getDriver());
        calculatePaymentPage.moveSliders();
        calculatePaymentPage.changeDropDownsAndText();
    }
}
