import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Static_Dropdown {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select DropDown = new Select(staticdropdown);
		DropDown.selectByIndex(2);
		Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "AED");
		System.out.println(DropDown.getFirstSelectedOption().getText());
		DropDown.selectByValue("USD");
		Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "USD");
		System.out.println(DropDown.getFirstSelectedOption().getText());
		DropDown.selectByVisibleText("INR");
		Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "INR");
		System.out.println(DropDown.getFirstSelectedOption().getText());
		driver.close();
		driver.quit();

	}

}
