package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {
	
	public static ExtentReports getReport()
	{
	String path = System.getProperty("user.dir")+"\\Reports\\report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Luma report");
	reporter.config().setReportName("Luma Report");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "ASJ");
	
	return extent;
	}
}
