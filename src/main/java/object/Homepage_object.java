package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Action_Reusable;

public class Homepage_object extends Action_Reusable {

	public AndroidDriver driver;

	public Homepage_object(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	private WebElement selectallow;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
	private WebElement setmobilenumer;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='PROCEED']")
	private WebElement proceed;

	public void givepermission() throws InterruptedException {
		wait(3000);
		selectallow.click();

	}

	public void setnumber(String number) throws InterruptedException {
		wait(2000);
		selectallow.click();
		proceed.click();
		setmobilenumer.click();
		setmobilenumer.sendKeys(number);
	

	}

}
