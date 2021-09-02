package assessment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass
{
	AmazonHomePage homepage;
	AmazonSearchListPage searchPage;
	@BeforeClass
	public void openBrowser()
	{
		initializebrowser();
		homepage= new AmazonHomePage(driver);
		searchPage= new AmazonSearchListPage(driver);
	}
	@Test
	public void AmazonHomePage()
	{
		homepage.inpHomepageSearchBox();
		homepage.clickSearchButton();
		
		searchPage.inpSearchBox();
		searchPage.clickSelectProduct();
		searchPage.verifyCart();
		searchPage.clickQuantityButton();
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
	
}
