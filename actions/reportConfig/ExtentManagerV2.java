/*
package reportConfig;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import commons.GlobalConstants;

public class ExtentManagerV2 {
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    private static ExtentReports extent = ExtentManagerV2.getReporter();

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(GlobalConstants.RELATIVE_PROJECT_PATH + "/extentReport/HTMLReportV2.html", true);
        }
        return extent;
    }

    */
/**
     * Khi test parallel, se collect toan bo result de tao ra va log vao HTMLReportV2.html
    * *//*

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
*/
