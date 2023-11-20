package org.pagedriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.basedriver.BaseDriver;
import org.basedriver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.GetScreenshot;

import java.io.IOException;

public class CheckoutPage extends BaseDriver {

    ExtentTest test;


    public CheckoutPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//span[@id='ClickHereForLogin']")
    WebElement login;
    @FindBy(xpath = "//input[@id='userId']")
    WebElement userId;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='loginBtnHere']")
    WebElement loginButton;
    @FindBy(xpath = "//body/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")
    WebElement name;
    @FindBy(xpath = "//input[@id='customer_email33']")
    WebElement email;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobile;
    @FindBy(xpath = "//input[@id='mobile_number_optional']")
    WebElement opMobile;
    @FindBy(xpath = "//textarea[@id='delivery_address']")
    WebElement address;
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement home;

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

    public void setAddress() throws IOException {
        Actions action = new Actions(PageDriver.getCurrentDriver());
        try {
            test.info("Click on Login");
            if (login.isDisplayed()) {
                action.moveToElement(login).build().perform();
                Thread.sleep(3000);
                login.click();
                passCaseWithSC("Clicked Login", "LoginClick");
                try {
                    test.info("click on userId");
                    if(userId.isDisplayed()) {
                        userId.sendKeys("01518907007");
                        Thread.sleep(3000);
                        passCaseWithSC("Clicked userId", "userIdClick");
                        try {
                            test.info("Click on password");
                            if(password.isDisplayed()) {
                                password.sendKeys("t30a12s91");
                                Thread.sleep(3000);
                                passCaseWithSC("Clicked Password", "PasswordClick");
                                try {
                                    test.info("Click on loginButton");
                                    if(loginButton.isDisplayed()) {
                                        loginButton.click();
                                        Thread.sleep(3000);
                                        passCaseWithSC("Clicked LoginButton", "LoginButtonClick");
                                        try {
                                            test.info("Click on PersonName");
                                            if(name.isDisplayed()) {
                                                action.moveToElement(name).build().perform();
                                                Thread.sleep(2000);
                                                password.sendKeys("Tofayel Ahmed Sajib");
                                                Thread.sleep(3000);
                                                passCaseWithSC("Clicked PersonName", "PersonNameClick");
                                                try {
                                                    test.info("Click on email");
                                                    if(email.isDisplayed()) {
                                                        action.moveToElement(email).build().perform();
                                                        Thread.sleep(2000);
                                                        email.sendKeys("tofayelsajib.aff@gmail.com");
                                                        Thread.sleep(3000);
                                                        passCaseWithSC("Clicked email", "emailClick");
                                                        try {
                                                            test.info("Click on Mobile");
                                                            if(mobile.isDisplayed()) {
                                                                action.moveToElement(login).build().perform();
                                                                Thread.sleep(2000);
                                                                mobile.sendKeys("01518907007");
                                                                Thread.sleep(3000);
                                                                passCaseWithSC("Clicked mobile", "mobileClick");
                                                                try {
                                                                    test.info("Click on opMobile");
                                                                    if(opMobile.isDisplayed()) {
                                                                        action.moveToElement(opMobile).build().perform();
                                                                        Thread.sleep(2000);
                                                                        opMobile.sendKeys("01719347159");
                                                                        Thread.sleep(3000);
                                                                        passCaseWithSC("Clicked opMobile", "opMobileClick");
                                                                        try {
                                                                            test.info("Click on address");
                                                                            if(address.isDisplayed()) {
                                                                                action.moveToElement(address).build().perform();
                                                                                Thread.sleep(2000);
                                                                                address.sendKeys("House# 26, Road No. 3/B, Mohammad Housing Limited, Mohammadpur, Dhaka - 1207.");
                                                                                Thread.sleep(3000);
                                                                                passCaseWithSC("Clicked address", "addressClick");
                                                                                try{
                                                                                    test.info("Back to home");
                                                                                    if(home.isDisplayed()){
                                                                                        action.moveToElement(home).build().perform();
                                                                                        Thread.sleep(3000);
                                                                                        home.click();
                                                                                    }
                                                                                }
                                                                                catch (Exception e) {
                                                                                    failCase("Could not click address", "addressClickFail");
                                                                                }
                                                                            }
                                                                        }
                                                                        catch (Exception e) {
                                                                            failCase("Could not click address", "addressClickFail");
                                                                        }
                                                                    }
                                                                }
                                                                catch (Exception e) {
                                                                    failCase("Could not click opMobile", "opMobileClickFail");
                                                                }
                                                            }
                                                        }
                                                        catch (Exception e) {
                                                            failCase("Could not click mobile", "mobileClickFail");
                                                        }
                                                    }
                                                }
                                                catch (Exception e) {
                                                    failCase("Could not click email", "emailClickFail");
                                                }
                                            }
                                        }
                                        catch (Exception e) {
                                            failCase("Could not click PersonName", "PersonNameClickFail");
                                        }
                                    }
                                }
                                catch (Exception e) {
                                    failCase("Could not click LoginButton", "LoginButtonClickFail");
                                }
                            }
                        }
                        catch (Exception e) {
                            failCase("Could not click Password", "PasswordClickFail");
                        }
                    }
                }
                catch (Exception e) {
                    failCase("Cloud not click userId", "userIdClickFail");
                }
            }
        } catch (Exception e) {
            failCase("Could Not Click Login", "LoginClickFail");
        }
    }
}
