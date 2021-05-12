package browerDriver;

import Reporting.ExtentManager;
import Reporting.ExtentTestManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {
    public static WebDriver driver = null;

    /**
     * ******************
     * **** Start Of Reporting Utilities ****
     * ******************
     * */

    //ExtentReport
    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
       // ExtentTestManager.getTest().(result.getStartMillis());
       // ExtentTestManager.getTest().setEndedTime(getTime(result.getEndMillis()));


        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(Status.PASS,"PASS");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(Status.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }

    }
    @AfterSuite
    public void generateReport() {
       // extent.close();
        extent.flush();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * ****************
     * ***End Of Reporting Utilities***
     * ****************
     * */


    @BeforeMethod
    public void setUp(){
        // Set driver path to the system
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\avaho\\IdeaProjects\\I\\Framework\\Utilities\\driver\\chromedriver.exe");
        // Create driver object
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Interact with Chrome driver
        // Getting Home page of the website
        // Open Chrome Browser
        driver.get("http://automationpractice.com/");

        /**
         *
         *
         * */
    }
    @AfterMethod
    public void cleanUP(){
        // Closing browser
        driver.quit();
    }
}
