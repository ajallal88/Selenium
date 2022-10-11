import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) throws InterruptedException
	{
		String URL = "https://rahulshettyacademy.com/locatorspractice/",
				User_Name = "Aqib",
				Password = "Password",
				Email = "aqibjallal@practise.com",
				PhoneNumber = "1234567890";
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajallal\\Downloads\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get(URL);
			driver.findElement(By.id("inputUsername")).sendKeys(User_Name);
			driver.findElement(By.name("inputPassword")).sendKeys(Password);
			driver.findElement(By.id("chkboxOne")).click();
			driver.findElement(By.id("chkboxTwo")).click();
			driver.findElement(By.className("signInBtn")).click();
			Thread.sleep(2000L);
			Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "* Incorrect username or password");
			driver.findElement(By.xpath("//div/a")).click();
			driver.findElement(By.cssSelector("input[Placeholder = 'Name']")).sendKeys(User_Name);
			driver.findElement(By.cssSelector("input[Placeholder = 'Email']")).sendKeys(Email);
			driver.findElement(By.cssSelector("input[Placeholder = 'Phone Number']")).sendKeys(PhoneNumber);
			driver.findElement(By.className("PhoneNumber")).click();
			String NewPassword = driver.findElement(By.className("infoMsg")).getText().split("'")[1].split("'")[0];
			driver.findElement(By.className("go-to-login-btn")).click();
			Thread.sleep(1000L);
			driver.findElement(By.id("chkboxOne")).clear();
			driver.findElement(By.id("chkboxTwo")).clear();
			driver.findElement(By.id("inputUsername")).sendKeys(User_Name);
			driver.findElement(By.name("inputPassword")).sendKeys(NewPassword);
			driver.findElement(By.id("chkboxOne")).click();
			driver.findElement(By.id("chkboxTwo")).click();
			driver.findElement(By.className("signInBtn")).click();
			
			


		// TODO Auto-generated method stub

	}

}
