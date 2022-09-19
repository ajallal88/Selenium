import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assignment_2 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Aqib Jallal");
		driver.findElement(By.name("email")).sendKeys("ajallal88@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Testing");
		if(driver.findElement(By.id("exampleCheck1")).isSelected())
		{
			
		}
		else
		{
			driver.findElement(By.id("exampleCheck1")).click();
		}
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(dropdown);
		gender.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("06051991");
		driver.findElement(By.className("btn-success")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/*")).getText());
	}

}
