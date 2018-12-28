package MainTestcase;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClass.AdminloginPage;
import PageClass.Adminlogout;
import PageClass.EmpPage;
import PageClass.Usercreationpage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class AppTest {
  WebDriver driver;
  ExtentReports report;
  ExtentTest logger;
  @BeforeTest
  public void Generate() {
	  report=new ExtentReports("./Reports/PomReport.html");
  }
  @BeforeMethod
  public void adminlogin() throws InterruptedException {
	  driver=new ChromeDriver();
	  driver.get("http://localhost:9090/petclinic/");
	  driver.manage().window().maximize();
  }
  @Test(description="AddOwnerandpet")
  public void Test1() throws InterruptedException {
	  logger=report.startTest("AddownerandPet");
	    driver.findElement(By.xpath("//span[contains(text(),'Owners & Pets')]")).click();
		driver.findElement(By.linkText("Add Owner")).click();
		driver.findElement(By.id("firstName")).sendKeys("Rickard");
		Thread.sleep(3000);
		driver.findElement(By.id("lastName")).sendKeys("von Essen");
		Thread.sleep(3000);
		driver.findElement(By.id("address")).sendKeys("Industrigatan 9");
		Thread.sleep(3000);
		driver.findElement(By.id("city")).sendKeys("Stockholm");
		Thread.sleep(3000);
		driver.findElement(By.id("telephone")).sendKeys("0707766552");
		Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.xpath("/html/body/div/div/h2[2]"));
	 
        if(text.getText().equals("Pets and Visits")) {
		Reporter.log("Owner Added success",true);
		logger.log(LogStatus.PASS, "Owner Added");
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Name1");
		Thread.sleep(3000);
		driver.findElement(By.id("birthDate")).clear();
		driver.findElement(By.id("birthDate")).sendKeys("2018/11/11");
		driver.findElement(By.xpath("/html/body/div[1]/div/h2")).click();
		Thread.sleep(3000);
		WebElement type = driver.findElement(By.id("type"));
		Select s= new Select(type);
		s.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pet\"]/div[2]/div/button")).click();
		logger.log(LogStatus.PASS, "Pet Added");
			
        }
        else {
		Reporter.log("Owner Added Fail",true);
		logger.log(LogStatus.FAIL, "Owner Not Added");  
	  }
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  report.flush();
	  report.endTest(logger);
	  driver.quit();
  }

}
