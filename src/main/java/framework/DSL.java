package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DSL extends Reporter{
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getEl(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    public void clickOn(By by) {
        driver.findElement(by).click();
        System.out.println("[INFO] Clicked on " + by.toString());
    }

    public void enterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        System.out.println("[INFO] Entered text is " + text);
    }

    public String pageTitle(){
        System.out.println("[INFO] The title is " + driver.getTitle());
        return driver.getTitle();
    }

    public void waitForPageLoaded(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void moveSlider(By by) {
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.clickAndHold(getEl(by)).moveByOffset(50, 0).release().build();
        action.perform();
        System.out.println("[INFO] Sleded is moved");
    }

    public String getTextValue(By by){
        String rez = getEl(by).getText();
        System.out.println("[INFO] the text is " + rez);
        return rez;
    }

    public boolean validateSlider(By by){
        boolean pass;
        if (getEl(by).getCssValue("style") != "left: 0%;") {
            pass = true;
            System.out.println("[INFO] Slider is moved");
        } else {
            pass = false;
            System.out.println("[INFO] Slider was not moved");
        }
        return pass;
    }

    public void selectDropDown(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        System.out.println("[INFO] Selected value is " + value);
    }

    public void waitFor(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
