package contract.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteContract {

	public static void main(String[] args) throws InterruptedException {
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
		 WebElement f = driver.findElement(By.xpath("(//span[text()='Contracts'])[1]"));
		 driver.executeScript("arguments[0].click();", f);
		 WebElement e = driver.findElement(By.xpath("//input[@name='Contract-search-input']"));
		 e.sendKeys("00000209");
		 e.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		 WebElement m = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
	      m.click();
		  driver.findElement(By.xpath("//a[@title='Delete']")).click();
		  driver.findElement(By.xpath("//span[text()='Delete']")).click();
			WebElement s = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
			s.clear();
			s.sendKeys("00000209");
	        String actual_Result=driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
			String expected_Result="No items to display.";
			Assert.assertEquals(actual_Result,expected_Result);


	}

}
