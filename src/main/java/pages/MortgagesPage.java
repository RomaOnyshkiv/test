package pages;

import framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MortgagesPage extends ParentPage{

    public MortgagesPage(WebDriver driver) {
        super(driver);
    }

    private By calcPayment = By.partialLinkText("Calculate your payments");

    public void calculateYourPayments(){
        reporter.log("Method 'calculateYourPayments' is started", true);
        clickOn(calcPayment);
    }
}
