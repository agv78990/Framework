package Reporting;

import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;
    private static Object ExtentManager;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
            extent = new ExtentReports(System.getProperty("user.dir")+"/Extent-Report/ExtentReport.html", true);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
            extent.addSystemInfo("Host Name", "Tester").addSystemInfo("Environment","QA")
                    .addSystemInfo("User Name", "Team_Three");
            extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        Reporting.ExtentManager.context=context;

    }
}

