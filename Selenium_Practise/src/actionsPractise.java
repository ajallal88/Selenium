import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class actionsPractise {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//amazon(driver);
		windowHandle(driver);
	}
	static void amazon(WebDriver driver)
	{
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		driver.close();
	}
	static void windowHandle(WebDriver driver)
	{
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		String parentID = itr.next();
		String childId = itr.next();		
		driver.switchTo().window(childId);
		String userid = driver.findElement(By.cssSelector("p[class='im-para red'] a")).getText();
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(userid);
		driver.quit();
		
		
	}
}
