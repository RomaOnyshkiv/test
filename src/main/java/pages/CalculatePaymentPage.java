package pages;

import framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CalculatePaymentPage extends ParentPage {

    public CalculatePaymentPage(WebDriver driver) {
        super(driver);
    }

    private By purchasePrice = By.xpath("//*[@id=\"form_calculateur_versements\"]/div[2]/div/div[2]/div/div[1]/div[9]");
    private By purchasePricePlus = By.id("PrixProprietePlus");
    private By purchasePriceField = By.id("sliderPrixPropriete");
    private By downPaymentSlider = By.id("MiseDeFondPlus");
    private By amortization = By.id("Amortissement");
    private By frequency = By.id("FrequenceVersement");
    private By rate = By.id("TauxInteret");
    private By calculate = By.xpath("//*[@id=\"btn_calculer\"]");
    private By paymentRes = By.id("paiement-resultats");



    public void moveSliders(){
        moveSlider(purchasePrice);
        Assert.assertTrue(validateSlider(purchasePrice));
//        increaseValue(purchasePricePlus, purchasePriceField);
        clickOn(purchasePricePlus);
        clickOn(purchasePricePlus);
        clickOn(downPaymentSlider);
    }

    public void changeDropDownsAndText(){
        selectDropDown(amortization, "15");
        enterText(rate, "5");
        selectDropDown(frequency, "52");

        clickOn(calculate);
        waitForPageLoaded();
        waitFor(5);
        Assert.assertEquals(getTextValue(paymentRes), "$ 836.75");
    }

    public void checkPayment() {
        Assert.assertEquals(getTextValue(paymentRes), "$ 836.75");
    }

}
