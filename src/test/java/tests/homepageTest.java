package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import object.Homepage_object;

public class homepageTest extends BaseTest {

	Homepage_object homepage;
	public AndroidDriver driver;

	// @BeforeTest
	public void init() throws InterruptedException, IOException {
		driver = startAppiumServer();
		homepage = new Homepage_object(driver);

	}

	@Test(priority = 1)
	public void grantpermisson() throws InterruptedException {
		homepage.givepermission();
	}

	@Test(priority = 2)
	public void entermobilenumber() throws InterruptedException {
		homepage.setnumber("6161616161");

	}

	@Test
	public void test() {
		path = System.getProperty("user.dir");
		System.out.println(path);
	}
}
