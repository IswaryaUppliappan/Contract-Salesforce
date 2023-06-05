package contract.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateContractWmf {

	public static void main(String[] args) {
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
		 s.sendKeys("6/6/2023");
		 driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			String actual_Error=driver.findElement(By.xpath("(//li[text()='Complete this field.'])[1]")).getText();
			String expected_Error= "Complete this field.";
		    Assert.assertEquals(actual_Error,expected_Error);
		    Assert.assertTrue(actual_Error.contains("Complete this field."));

	}

}
