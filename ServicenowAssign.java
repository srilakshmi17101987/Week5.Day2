package Week5.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServicenowAssign extends Servicenowcommon{
	
	@Test(dataProvider="senddata")
	public void runservicenowassign(String filter,String incidentno,String Assigngroup) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(filter,Keys.ENTER);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Open'])[1]")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input")).sendKeys(incidentno,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[6]")).click();
		Set<String> windowhandleset=driver.getWindowHandles();
        List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
        driver.switchTo().window(windowhandlelist.get(1));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input[@class='form-control']")).sendKeys(Assigngroup,Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='Software']")).click();
        driver.switchTo().window(windowhandlelist.get(0));
        driver.switchTo().frame(frame1);
        String str=driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getAttribute("value");
		System.out.println(str);
		Thread.sleep(3000);
		driver.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("sample java");
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		
	}

	@DataProvider
	public String[][] senddata() throws IOException
	{
		return readExcelForServicenow.readdata("Sheet3");
		
	}
}
