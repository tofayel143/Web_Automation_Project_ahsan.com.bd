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

public class BookInfo extends BaseDriver {


    ExtentTest test;
    WebDriver driver;
    public BookInfo(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath="//a[@id='ordernowUrl']")
    WebElement discription;
    @FindBy(xpath="//body/section[1]/div[1]/div[2]/div[2]/div[2]/button[1]")
    WebElement addToCard;
    @FindBy(xpath="//header/div[1]/div[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")
    WebElement goToCard;


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

    public void bookInfoPage() throws InterruptedException, IOException {

        JavascriptExecutor js = (JavascriptExecutor)PageDriver.getCurrentDriver();
        try {
            test.info("Click on litareture");
            if (discription.isDisplayed()){
                js.executeScript("arguments[0].scrollIntoView(true)", discription);
                Thread.sleep(3000);
                addToCard.click();
                Thread.sleep(3000);
                js.executeScript("arguments[0].scrollIntoView(true)", goToCard);
                Thread.sleep(3000);
                goToCard.click();
                Thread.sleep(3000);
                passCaseWithSC("Clicked goToCard", "goToCardClick");
            }

        }
        catch (Exception e){
            failCase("Could not click goToCard", "goToCardClickFail");
        }

    }

}
