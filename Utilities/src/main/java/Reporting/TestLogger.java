package Reporting;


//import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
//import org.sqlite.util.StringUtils;
import org.testng.Reporter;

public class TestLogger {
    public static void log(final String message){
        Reporter.log(message,true);
        ExtentTestManager.getTest().log(Status.INFO, message + "<br>");
    }
 // public static <StringUtils> void log(final StringUtils message){
    //    Reporter.log(message + "<br>",true);
     //   ExtentTestManager.getTest().log(Status.INFO, message + "<br>");
   // }
    public static void log(final String message, WebDriver driver){
        Reporter.log(message,true);
        ExtentTestManager.getTest().log(Status.INFO, message + "<br>");
    }
}