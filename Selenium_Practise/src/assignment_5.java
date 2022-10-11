import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.By;


public class assignment_5
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Nested Frames")).click();
		//driver.switchTo().frame(0);
		driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());	
	}

}
