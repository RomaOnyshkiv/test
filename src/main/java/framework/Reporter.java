package framework;



import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Reporter {

    private static ExtentReports extentReports;

    private static ExtentReports getInstance(){
        if (extentReports == null) {
            extentReports = new ExtentReports("/src/test/results/Report.html", true);
        }
        return extentReports;
    }

    public static void closeReporter(){
        getInstance().flush();
    }

    @BeforeMethod(alwaysRun = true)
    public void startReporting(Method method){

    }

}
