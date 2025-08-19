package AuditFeedback;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	String reportPath = "./ExtentReports/ExtentReport_" + timestamp + ".html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Audit Automation");
        reporter.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        
        extent.setSystemInfo("Tester", "Uma Maheshwar");
        extent.setSystemInfo("Project Name", "Audit Management System");
        extent.setSystemInfo("Module", "Audit Creation");
        extent.setSystemInfo("Environment", "QA"); 
        extent.setSystemInfo("Browser", "Chrome 125"); 
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Lead Name", "Ahmed");
        extent.setSystemInfo("Reviewer Name", "Revathi");
      
        extent.setSystemInfo("Execution Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); 
    }
}
