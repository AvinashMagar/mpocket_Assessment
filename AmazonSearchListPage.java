package assessment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonSearchListPage
{
	@FindBy(tagName = "a") private List<WebElement> SearchList;
	@FindBy(xpath= "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]") private WebElement selectProduct;
	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]") private WebElement addToCartButton;
	@FindBy(xpath= "//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input") private WebElement sideSheetCartButton;
	@FindBy(xpath= "//*[@id=\"a-autoid-0-announce\"]") private WebElement quatityButton;
	@FindBy(xpath= "//*[@id=\"sc-subtotal-amount-activecart\"]") private WebElement subTotalAmount;
	@FindBy(xpath= "(//*[@id=\"quantity_10\"])[2]") private WebElement selectQuantity;
	@FindBy(name= "quantityBox") private WebElement QuantityTextBox;
	@FindBy(xpath= "(//a[@class='a-button-text'])[5]") private WebElement updateButton;
	@FindBy(xpath= "(//span[@class='a-size-base'])[5]") private WebElement errorMsg;
	@FindBy(name= "submit.delete.C7b3ff635-1a3c-44a0-b75f-4674db73e43f") private WebElement DeleteButton;
	@FindBy(xpath= "//*[@id=\"sc-item-C7b3ff635-1a3c-44a0-b75f-4674db73e43f\"]/div[3]/div[1]/span") private WebElement removedMsg;


	public AmazonSearchListPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSearchBox()
	{
		int count=0;
		String expResult="realme";
		for(WebElement list:SearchList)
		{
			String actResult = list.getText();
			if(actResult.equalsIgnoreCase(expResult))
			{
				count++;
			}
			
		}
		System.out.println(count);
	}
	
	public void clickSelectProduct() 
	{
		selectProduct.click();
	}
	
	public void clickAddToCartButton(WebDriver driver) 
	{
		String urltoclick = selectProduct.getAttribute("href");
	
		String currentWindow=driver.getWindowHandle();
		Set<String> mulWindows = driver.getWindowHandles();
		for(String actual:mulWindows)
		{
		
			if(!actual.equalsIgnoreCase(currentWindow))
				{
					driver.switchTo().window(actual);
					driver.get(urltoclick);
					addToCartButton.click();
					
					System.out.println("clicked on autocart button");
				}
				else
				{
					System.out.println("there is no child window");
				}
			
		}
		
			
	}
	
	public void verifyCart()
	{
		sideSheetCartButton.click();
	}
	
	public void clickQuantityButton()
	{
		String subtotal=subTotalAmount.getText();
		System.out.println(subtotal);
		quatityButton.click();
		selectQuantity.click();
		QuantityTextBox.sendKeys("10");
		updateButton.click();
		String expErrorMsg="This seller has a limit of 1 per customer. To see if more are available from another seller, go to the product detail page.";
		Assert.assertEquals(errorMsg, expErrorMsg);
		DeleteButton.click();
		String expRemoveMsg="Redmi 9 Power (Blazing Blue, 6GB RAM, 128GB Storage) - 6000mAh B... was removed from Shopping Cart.";
		String actRemoveMsg=removedMsg.getText();
		Assert.assertEquals(actRemoveMsg, expRemoveMsg, "both msg are different");
		
	}
	
	
}
