import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Wait_practise
{
	public static void main(String[] args)
	{
		String[] items = {"Brocolli", "Beans", "Potato"};
		List<String> items_List = Arrays.asList(items);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		addItems(driver, items_List);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoinfo")).getText(), "Code applied ..!");
		System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());

	}
	
	static void addItems(WebDriver driver, List<String> items_List)
	{
		int count = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<products.size(); i++)
		{
			String[] product = products.get(i).getText().split("-");
			String item_name = product[0].trim();
			if(items_List.contains(item_name))
			{
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(count == items_List.size())
					break;
				
			}
			
		}
		
	}

}
