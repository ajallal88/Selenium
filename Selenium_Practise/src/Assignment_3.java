import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;



public class Assignment_3
{

	public static void main(String[] args) throws InterruptedException
	{
		String[] items = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};
		String userName = "rahulshettyacademy", password = "learning";	
		List<String> items_List = Arrays.asList(items);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElements(By.cssSelector("span.checkmark")).get(1).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.cssSelector("select.form-control")).click();
		Select dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
		dropdown.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a")));
		additems(driver, items_List);
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();		
	}
	
	static void additems(WebDriver driver, List<String> items_List)
	{
		int i, count = 0;
		List<WebElement> items = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		for(i=0; i<items.size(); i++)
		{
			String item = items.get(i).getText();
			if(items_List.contains(item))
			{
				count++;
				driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
				if(count == items_List.size())
					break;
			}
		}
			
	}

}
