package org.pagedriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.basedriver.BaseDriver;
import org.basedriver.PageDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.GetScreenshot;

import java.io.IOException;

public class Author extends BaseDriver {

    ExtentTest test;
    WebDriver driver;
    public Author(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath="/html/body/section[1]/div/div/div[2]/div/div[2]/div[2]/div[6]/div/div[2]/h3/a")
    WebElement litareture;


    public void failCase(String msg, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+msg+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(),""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }
    public void passCase(String msg) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+msg+"</b></p>");
    }

    public void passCaseWithSC(String msg, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+msg+"</b></p>");
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }



    public void authorSelect() throws InterruptedException, IOException {


        JavascriptExecutor js = (JavascriptExecutor)PageDriver.getCurrentDriver();
        try {
            test.info("Click on litareture");
            if (litareture.isDisplayed()){
                js.executeScript("arguments[0].scrollIntoView(true)", litareture);
                Thread.sleep(3000);
                litareture.click();
                Thread.sleep(3000);
                passCaseWithSC("Clicked litareture", "litaretureClick");
            }

        }
        catch (Exception e){
            failCase("Could not click litareture", "litaretureClickFail");
        }

    }

}
