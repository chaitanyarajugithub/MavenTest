package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class AdminloginPage {
	WebDriver driver;
	Actions action;
	public AdminloginPage(WebDriver driver){
		this.driver = driver;
	}
//store Repository
	@FindBy(name="txtUsername")
	WebElement Enter_Username;
	@FindBy(css="#txtPassword")
	WebElement Enter_password;
	@FindBy(css="#btnLogin")
	WebElement Click_Login;
	//Develop method
public void Verify_Login(String username,String password) throws InterruptedException
{
	action=new Actions(driver);
this.Enter_Username.sendKeys(username);	
this.Enter_password.sendKeys(password);
action.moveToElement(Click_Login).click().perform();
Thread.sleep(4000);

}
}














