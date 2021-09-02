package assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage
{
	@FindBy(id = "twotabsearchtextbox") private WebElement SearchBox;
	
	@FindBy(id = "nav-search-submit-button") private WebElement SearchButton;

	public AmazonHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpHomepageSearchBox()
	{
		SearchBox.sendKeys("realme mobile");
	}
	
	public void clickSearchButton()
	{
		SearchButton.click();
	}
}
