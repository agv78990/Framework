package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Reporter;

import org.testng.ITestContext;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;
    private static Object ExtentManager;
     public static ExtentSparkReporter spark=new ExtentSparkReporter("spark.html");

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
            ExtentSparkReporter spark=new ExtentSparkReporter("Spark.html");
          //  extent = new ExtentReports(System.getProperty("user.dir")+"/Extent-Report/ExtentReport.html", true);
            extent=new ExtentReports();
            extent.attachReporter(spark);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
           // extent.addSystemInfo("Host Name", "Tester").addSystemInfo("Environment","QA")
                //    .addSystemInfo("User Name", "Team_Three");
            extent.setSystemInfo("hostname","local");
            extent.setSystemInfo("environment","QA");
            extent.setSystemInfo("userName", "huma");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("spark-reports");
            spark.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm");
            //extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));

        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        Reporting.ExtentManager.context=context;

    }
}

