import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Greencart_test1 {

	public static void main(String[] args)
	{
		int count = 0, i;
		String[] items = {"Cauliflower", "Beans"};
		List<String> items_needed = Arrays.asList(items);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(i=0; i<products.size(); i++)
		{
			String[] product = products.get(i).getText().split("-");
			String product_name = product[0].trim();
			if(items_needed.contains(product_name))
			{
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(count == items.length)
					break;
			}
		}

	}

}
