package page;

import java.util.NoSuchElementException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddDepositPage extends BasePage {

	WebDriver driver;

	// every page must have constructor to invite the driver

	public AddDepositPage(WebDriver driver) {

		this.driver = driver;
	}

	// element library

	@FindBy(how = How.XPATH, using = "//select[@id='account']")WebElement AccountDropDown;
	@FindBy(how = How.XPATH, using = "//input[@id='description']") WebElement DescriptionField;
	@FindBy(how = How.XPATH, using = "//input[@id='amount']") WebElement AmountField;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//button[@data-dismiss='alert']")WebElement DepositSuccessMsg;

	@FindBy(how = How.XPATH, using = "//h5[text() = 'Add Deposit']")WebElement AddDepositPanelHeading;
	@FindBy(how = How.ID, using = "date")WebElement DateField;
	


	
	// Method to interact with the element
	
	public void waitForPage() {
		waitForElement(AddDepositPanelHeading, driver);
		
	}
	public void FillinDepositForm(String description, String amount) {
		
		AccountDropDown.click();
		DescriptionField.sendKeys(description);
		AmountField.sendKeys(amount);
		
		SubmitButton.click();
		
	}
public void waitForSuccess() {
	
	waitForElement(DepositSuccessMsg,driver);
}
public void selectFromDownForAccount(String string) {
	Select AccDropDown = new Select(AccountDropDown);
	AccDropDown.selectByVisibleText(string);
}
public void clearAndInputDateFromCalendar(String string) {
	DateField.clear();
	DateField.sendKeys(string);
	DateField.sendKeys(Keys.TAB);
	
}
public void inputDescriptionAndAmount(String eDescription, String eAmount) {
	DescriptionField.sendKeys(eDescription);
	AmountField.sendKeys(eAmount);
	
}
public void clickOnSubmitButton() {
	SubmitButton.click();	
	
}
public void clickAway() {
	AddDepositPanelHeading.click();
	
	
}
public boolean isSuccessMsgDisplayed() {
	
try {return DepositSuccessMsg.isDisplayed();
		}
catch(NoSuchElementException e) {
	throw new RuntimeException("java fail!");
}	
}


	
	
}
