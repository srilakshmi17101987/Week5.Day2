package Week5.day2;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Servicenowdelete extends Servicenowcommon {
	
	@Test(dataProvider="senddata")
	public void runservicenowdelete(String filter,String incidentno,String delincident) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(filter,Keys.ENTER);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Open'])[1]")).click();
		Thread.sleep(3000);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		//String incno=incidentno;
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input")).sendKeys(incidentno,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		//driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//label[text()='Search']//following-sibling::input")).sendKeys(delincident,Keys.ENTER);
		String update=driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[text()='No records to display']")).getText();
		 if (update.contains("No records"))
		 {
			 System.out.println("Record delted");
		 }
		 else
		 {
			 System.out.println("Not deleted");
		 }
		
		
		
		
	}
	
	@DataProvider
	public String[][] senddata() throws IOException
	{
		return readExcelForServicenow.readdata("Sheet4");
		
	}

}
