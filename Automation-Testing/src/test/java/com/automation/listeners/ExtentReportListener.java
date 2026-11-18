package com.automation.listeners;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class ExtentReportListener implements ITestListener {
 private static ExtentReports extent; private static final ThreadLocal<ExtentTest> current=new ThreadLocal<>();
 private static synchronized ExtentReports report(){
  if(extent==null){try{Files.createDirectories(Path.of("reports"));}catch(Exception e){throw new RuntimeException(e);}
   extent=new ExtentReports();extent.attachReporter(new ExtentSparkReporter("reports/BuyerTestReport.html"));
   extent.setSystemInfo("Framework","Maven + Selenium + POM + TestNG + Keywords");}
  return extent;
 }
 public void onTestStart(ITestResult r){current.set(report().createTest(r.getMethod().getMethodName()));}
 public void onTestSuccess(ITestResult r){current.get().pass("Test passed");}
 public void onTestFailure(ITestResult r){current.get().fail(r.getThrowable());}
 public void onTestSkipped(ITestResult r){current.get().skip("Test skipped");}
 public void onFinish(ITestContext c){if(extent!=null)extent.flush();}
 public static void logPass(String message) {
	    ExtentTest test = current.get();

	    if (test != null) {
	        test.pass(message);
	    }
	}

	public static void logInfo(String message) {
	    ExtentTest test = current.get();

	    if (test != null) {
	        test.info(message);
	    }
	}
}
