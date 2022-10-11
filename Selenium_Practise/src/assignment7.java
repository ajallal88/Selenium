import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;


public class assignment7
{
	public static void main(String[] args) throws InterruptedException
	{
		int i;
		System.setProperty("webdriver.chrome.driver", "C://Users//ajallal//Downloads//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println(rows.size()+" numbers of rows are available in the table.");
		List<WebElement> cols = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		System.out.println(cols.size()+" numbers of columns are available in the table.");
		for(i=0; i<cols.size();i++)
		{
			System.out.print(cols.get(i).getText()+" ");
		}	
	}
}
