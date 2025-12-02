package com.ca.qa.ExtentReportListener;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportNG implements IReporter {
    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites,
                               List<ISuite> suites,
                               String outputDirectory) {
        // Initialize reporter
        String reportPath = outputDirectory + File.separator + "ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Test Automation Report");
        spark.config().setDocumentTitle("Extent Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA/UAT");
        extent.setSystemInfo("Tester", "QA Team");

        // Iterate through suites and results
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> suiteResults = suite.getResults();

            for (ISuiteResult r : suiteResults.values()) {
                ITestContext context = r.getTestContext();

                // Passed tests
                buildTestNodes(context.getPassedTests(), Status.PASS);
                // Failed tests
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                // Skipped tests
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        extent.flush();
    }

    private void buildTestNodes(org.testng.IResultMap tests, Status status) {
        if (tests.getAllResults().size() == 0) {
            return;
        }

        for (org.testng.ITestResult result : tests.getAllResults()) {
            ExtentTest test = extent.createTest(result.getMethod().getMethodName());
            test.assignCategory(result.getTestContext().getName());

            if (result.getThrowable() != null) {
                test.log(status, result.getThrowable());
            } else {
                test.log(status, "Test " + status.toString().toLowerCase());
            }
        }
    }
}
