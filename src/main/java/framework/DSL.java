package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class DSL extends ReporterForMyTest{
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getEl(By by){
        return driver.findElement(by);
    }

    protected void clickOn(By by) {
        driver.findElement(by).click();
        reporter.log("Clicked element " + by.toString(), true);
    }

    protected void enterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        reporter.log("Entered text " + text, true);
    }

    protected String pageTitle(){
        reporter.log("The title is " + driver.getTitle(), true);
        return driver.getTitle();
    }

    protected void waitForPageLoaded(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    protected void moveSlider(By by) {
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.clickAndHold(getEl(by)).moveByOffset(50, 0).release().build();
        action.perform();
        reporter.log("Slider is moved", true);
    }

    protected String getTextValue(By by){
        String rez = getEl(by).getText();
        reporter.log("The text is " + rez, true);
        return rez;
    }

    protected boolean validateSlider(By by){
        boolean pass;
        if (getEl(by).getCssValue("style") != "left: 0%;") {
            pass = true;
            reporter.log("Slider is moved (Validation)", true);
        } else {
            pass = false;
            reporter.log("Slider was not moved (validation)", true);
        }
        return pass;
    }

    protected void selectDropDown(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        reporter.log("Selected value is " + value, true);
    }

    protected void waitFor(int sec){
        try {
            Thread.sleep(sec * 1000);
            reporter.log("Wait for " + sec + " seconds", true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
