package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmpPage {
WebDriver driver;
Actions ac;
public EmpPage(WebDriver driver)
{
this.driver=driver;
}
@FindBy(id="menu_pim_viewPimModule")
WebElement Click_Pim;
@FindBy(id="btnAdd")
WebElement click_add;
@FindBy(id="firstName")
WebElement Enter_fname;
@FindBy(id="lastName")
WebElement Enter_lname;
@FindBy(id="employeeId")
WebElement Enter_Eid;
@FindBy(id="btnSave")
WebElement Click_Save;
public void Verfiy_Emp(String fname,String lname,String eid) throws InterruptedException
{
ac=new Actions(driver);
ac.moveToElement(Click_Pim).click().perform();
Thread.sleep(4000);
ac.moveToElement(click_add).click().build().perform();
Thread.sleep(4000);
this.Enter_fname.sendKeys(fname);
this.Enter_lname.sendKeys(lname);
this.Enter_Eid.clear();
this.Enter_Eid.sendKeys(eid);
ac.moveToElement(Click_Save).click().perform();
Thread.sleep(4000);
}

}

