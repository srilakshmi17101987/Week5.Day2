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


public class ServicenowUpdate extends Servicenowcommon {

	@Test(dataProvider = "senddata")
	public void runservicenowupdate(String filter, String incidentno) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(filter,Keys.ENTER);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='All'])[2]")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input")).sendKeys(incidentno,Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='INC0010011']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//select[@id='incident.urgency']//option)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//select[@id='incident.state']//option)[2]")).click();
		
		//JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='sn-stream-textarea-container']/textarea)[3]")).sendKeys("sample code");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();

		Thread.sleep(2000);
		//driver.switchTo().frame(frame1);
		//driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(filter,Keys.ENTER);
		
		//driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Incidents'])[2]")).click();
		//driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input")).sendKeys(incidentno,Keys.ENTER);
		Thread.sleep(4000);
		String priority = driver.findElement(By.xpath("(//table/tbody/tr[1]/td[text()])[2]")).getText();
Thread.sleep(3000);
		if (priority.contains("High")) {
			System.out.println("The set priority is High");
		} else {
			System.out.println("Not high");
		}

		String str = driver.findElement(By.xpath("(//table/tbody/tr[1]/td[text()])[3]")).getText();
		if (str.contains("Progress")) 
		{
			System.out.println("The state is inprogress");
		} 
		else {
			System.out.println("Not started");
		}

	}

	@DataProvider
	public String[][] senddata() throws IOException {
		return readExcelForServicenow.readdata("Sheet2");

	}

}
