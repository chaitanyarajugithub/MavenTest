package PageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Usercreationpage {
WebDriver driver;
Actions ac;
public Usercreationpage(WebDriver driver)
{
this.driver=driver;
}
@FindBy(id="menu_admin_viewAdminModule")
WebElement Click_Admin;
@FindBy(id="menu_admin_UserManagement")
WebElement Click_Usermana;
@FindBy(id="menu_admin_viewSystemUsers")
WebElement Click_Users;
@FindBy(id="btnAdd")
WebElement Click_Add;
@FindBy(id="systemUser_userType")
WebElement Select_Role;
@FindBy(id="systemUser_employeeName_empName")
WebElement Enter_emp;
@FindBy(id="systemUser_userName")
WebElement Enter_username;
@FindBy(id="systemUser_password")
WebElement Enter_password;
@FindBy(id="systemUser_confirmPassword")
WebElement Enter_cpassword;
@FindBy(id="btnSave")
WebElement Click_save;
public void Verify_Usercreation(int role,String ename,
String username,String password,String cpassword) throws InterruptedException
{
	ac=new Actions(driver);
	ac.moveToElement(Click_Admin).click().perform();
	Thread.sleep(4000);
	ac.moveToElement(Click_Usermana).click().perform();
	Thread.sleep(4000);
	ac.moveToElement(Click_Users).click().perform();
	Thread.sleep(4000);
	ac.moveToElement(Click_Add).click().perform();
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	new Select(Select_Role).selectByIndex(1);
	this.Enter_emp.sendKeys(ename);
	this.Enter_username.sendKeys(username);
	this.Enter_password.sendKeys(password);
	this.Enter_cpassword.sendKeys(cpassword);
	ac.moveToElement(Click_save).click().perform();
	Thread.sleep(4000);
}


}













