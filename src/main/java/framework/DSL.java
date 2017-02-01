package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DSL extends Reporter{
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOn(By by) {
        driver.findElement(by).click();
    }

    public void enterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public String pageTitle(){
        return driver.getTitle();
    }

    public void waitForPageLoaded(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
