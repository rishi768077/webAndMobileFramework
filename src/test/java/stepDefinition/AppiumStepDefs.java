package stepDefinition;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ScreenRecording;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumStepDefs {

    public WebDriver mobDriver;
    ScreenRecording sr;

    @Before("@Appium")
    public void appiumSetUp() throws MalformedURLException {
        try {
        sr=new ScreenRecording();
        sr.startRecording();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/src/main/resources/Apps/Wego Flights Hotels Travel_v6.5.9_apkpure.com.apk");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
        mobDriver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @After("@Appium")
    public void after(){
        try {
            sr.stopRecording();
            mobDriver.quit();
            //mobDriver.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Given("User is on home page of the application")
    public void user_is_on_home_page_of_the_application() {
        Assert.assertTrue(mobDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Home']")).isDisplayed());
        mobDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Account']")).click();

    }
    @When("user tap on account to create an account")
    public void user_tap_on_account_to_create_an_account() {
        mobDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Account']")).click();
    }
    @Then("user is able to navigate to account section successfully")
    public void user_is_able_to_navigate_to_account_section_successfully() {
        Assert.assertTrue(mobDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText().equals("Account"));
    }
}
