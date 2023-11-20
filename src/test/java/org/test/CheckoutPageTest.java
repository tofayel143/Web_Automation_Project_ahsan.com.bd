package org.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.basedriver.BaseDriver;
import org.pagedriver.CheckoutPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utilities.ExtentFactory;

import java.io.IOException;

public class CheckoutPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start() {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Test</b></p>").assignAuthor("QA").assignDevice("windows");
    }

    @Test
    public void checkOutTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CHECKOUT TEST</b></p>");
        CheckoutPage testCheckout = new CheckoutPage(childTest);
        testCheckout.setAddress();
    }

    @AfterTest
    public void report() {
        report.flush();
    }

}
