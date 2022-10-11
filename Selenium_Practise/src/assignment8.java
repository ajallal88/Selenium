import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class assignment8
{

	public static void main(String[] args) 
	{
		int i;
		String country = "United Arab Emirates";
		System.setProperty("webdriver.chrome.driver", "C://Users//ajallal//Downloads//chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys(country.substring(0, 3));
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		System.out.println(countries.size());
		for(i=0;i<countries.size();i++)
		{
			if(countries.get(i).getText().equalsIgnoreCase(country))
			{
				countries.get(i).click();
				break;
			}
		}
		

	}

}
