package pages;

import framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends ParentPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By lang = By.id("topLangMenuItem");
    private By Loans = By.className("icone-menu-prets");
    private By Mortgages = By.partialLinkText("Mortgages");


    public void changeLangAndGoToMortgages(){
        clickOn(lang);
        waitForPageLoaded();
        clickOn(Loans);
        clickOn(Mortgages);
        Assert.assertEquals(pageTitle(), "Mortgage - Mortage rates | iA Financial Group");

    }

}
