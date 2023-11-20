package org.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.basedriver.BaseDriver;
import org.pagedriver.Author;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utilities.ExtentFactory;

import java.io.IOException;

public class AuthorTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start() {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Test</b></p>").assignAuthor("QA").assignDevice("windows");
    }

    @Test
    public void testAuthor() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>AUTHOR TEST</b></p>");
        Author selectAuthor = new Author(childTest);
        selectAuthor.authorSelect();
    }

    @AfterClass
    public void report() {
        report.flush();
    }

}
