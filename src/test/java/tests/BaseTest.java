package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;
	public Properties pro;
	public String path;
	public FileInputStream fis;

	public AndroidDriver startAppiumServer() throws InterruptedException, IOException {
		path = System.getProperty("user.dir");
		fis = new FileInputStream(path + "\\src\\main\\java\\resources\\variable.properties");
		pro = new Properties();
		pro.load(fis);
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName(pro.getProperty("setDeviceName"));
		option.setApp(pro.getProperty("setApp"));
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		Thread.sleep(2000);
		return driver;
	}

}
