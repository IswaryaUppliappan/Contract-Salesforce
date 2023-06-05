package contract.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ContractSort {

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
		WebElement s = driver.findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[1]"));
	    s.click();
	    String actual_Result=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
	    String expected_Result="4 items • Sorted by Contract Number •";
	    Assert.assertEquals(actual_Result,expected_Result);
		

	}

}
