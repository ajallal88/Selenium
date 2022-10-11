import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;



public class calendar
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String day = "12", mon = "Mar", year = "2023";
		int i = 0;
		System.setProperty("webdriver.chrome.driver", "C://Users//ajallal//Downloads//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		//List<WebElement> years = driver.findElements(By.cssSelector("span.ui-datepicker-year"));
		//System.out.println(years.size());
		while(i == 0)
		{
			List<WebElement> years = driver.findElements(By.cssSelector("span.ui-datepicker-year"));
			List<WebElement> months = driver.findElements(By.cssSelector("span.ui-datepicker-month"));
			if(years.get(i).getText().equalsIgnoreCase(year) && months.get(i).getText().contains(mon))
			{
				List<WebElement> dates = driver.findElements(By.cssSelector("a.ui-state-default"));
				while(i<dates.size())
				{
					if(dates.get(i).getText().equalsIgnoreCase(day))
					{
						dates.get(i).click();
						break;
					}
					else
					{
						i++;
					}
				}
			}
			else
			{
				driver.findElement(By.cssSelector("a[data-handler='next']")).click();
			}
		}
	}

}
