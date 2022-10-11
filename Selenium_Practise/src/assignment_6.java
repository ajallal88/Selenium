import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_6
{

	public static void main(String[] args)
	{
		String option_text, popUp_text;
		System.setProperty("webdriver.chrome.driver", "C://Users//ajallal//Downloads//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption2")).click();
		option_text = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		WebElement dropdown_locator = driver.findElement(By.id("dropdown-class-example"));
		dropdown_locator.click();
		Select dropDown = new Select(dropdown_locator);
		dropDown.selectByVisibleText(option_text);
		driver.findElement(By.id("name")).sendKeys(option_text);
		driver.findElement(By.id("alertbtn")).click();
		popUp_text = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		if(popUp_text.equals(option_text))
		{
			System.out.println("The grabbed text is present in the Pop-up");
		}
		else 
		{
			System.out.println("The grabbed text is not-present in the Pop-up");
		}
		driver.switchTo().alert().accept();
	}

}
