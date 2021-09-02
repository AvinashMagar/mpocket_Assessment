package assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass 
{
	WebDriver driver;
	
	public void initializebrowser()
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", 
				"E:\\AutomationTesting\\Eclipse\\April B21 TestNG\\Browser\\chromedriver.exe");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}