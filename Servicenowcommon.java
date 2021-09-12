package Week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Servicenowcommon {
	
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	
	public void precondition(String url,String username,String password) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	WebElement frame=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
	//driver.findElement(By.xpath("//button[@id='usernameSubmitButton']")).click();
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	
}
	
	@AfterMethod
	public void potscondition()
	{
		driver.close();
	}
	
}
