package driverInstance;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public WebDriver driver;

	public WebDriver createDriver(String browserName){
		try {
			if ("chrome".equals(browserName)) {
				WebDriverManager.chromedriver().setup();
				DesiredCapabilities caps = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				Map<String, Object> profile = new HashMap<String, Object>();
				Map<String, Object> contentSettings = new HashMap<String, Object>();
				contentSettings.put("cookies", 2);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				options.setExperimentalOption("prefs", prefs);
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return driver;

	}
}