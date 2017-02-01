package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest extends Reporter {

    private File driverPath = new File("./src/main/resources/driver/chromedriver");
    private static WebDriver driver;
    protected HomePage homePage;

    protected void startBrowser(){
        System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    protected void navigateTo(){
        driver.get("http://ia.ca/");
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void closeDriver(){
        if (driver != null) {
            driver.quit();
        }
    }

}
