import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class assignment_4
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "c:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		windows(driver);
	}
	public static void windows(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id = 'content'] div a")));
		driver.findElement(By.cssSelector("div[id = 'content'] div a")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentID = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
	}

}
