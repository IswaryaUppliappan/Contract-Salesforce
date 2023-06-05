package contract.salesforce;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateContract {

	public static void main(String[] args) throws ParseException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement c = driver.findElement(By.xpath("//p[text()='Contracts']"));
		driver.executeScript("arguments[0].click();", c);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		WebElement e = driver.findElement(By.xpath("(//div[@title='Credits'])[1]"));
		 driver.executeScript("arguments[0].click();", e);
		 WebElement s = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		 s.sendKeys("6/5/2023");
		 WebElement t = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		 t.sendKeys("6");
		 driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		 String actual_Result=driver.findElement(By.xpath("//div[@class='entityNameTitle slds-line-height_reset']")).getText();
	     String  expected_Result= "Contract";
	     Assert.assertEquals(actual_Result,expected_Result);
	     driver.findElement(By.xpath("//div[@title='00000209']")).getText();
	     WebElement f = driver.findElement(By.xpath("(//span[text()='Contracts'])[1]"));
		 driver.executeScript("arguments[0].click();", f);
		 LocalDate d1=LocalDate.of(2023, 6, 5);
		 LocalDate d2=LocalDate.of(2023, 12, 4);
		 int months = Period.ofMonths(6).getMonths();	 
		String actual_Result1=driver.findElement(By.xpath("//span[@class='slds-truncate uiOutputNumber']")).getText();
	    String  expected_Result1= "6";
	    Assert.assertEquals(actual_Result1,expected_Result1);
	    if (months==6){
			 System.out.println("Contract matched");
		 }
	    else if (months<6) {
			System.out.println("not matched");
		}
		 
  }
}
		 
	
		
	
	
		


