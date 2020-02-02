 
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	// every page must have constructor to invite the driver
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	// element library
	
	@FindBy(how = How.ID,using = "username") WebElement Email;
	@FindBy(how = How.ID,using = "password") WebElement Pwd;
	@FindBy(how = How.NAME,using = "login")WebElement Signin;
	
	
	//Method to interact with the element
	public void userLogsin(String name, String pd) {
		
		Email.sendKeys(name);
		Pwd.sendKeys(pd);
		Signin.click();;
		
	}
	
	
	
	
	
}
