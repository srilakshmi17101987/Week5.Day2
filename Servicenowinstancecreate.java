package Week5.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Servicenowinstancecreate extends Servicenowcommon {
	
	
	@Test(dataProvider="senddata")
	public void runcreateinstance(String filter,String description) throws InterruptedException 
	{
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(filter,Keys.ENTER);
      
        //driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='All'])[2]")).click();
        driver.findElement(By.xpath("//div[@class='sn-widget-list-title' and text()='Create New']")).click();
        WebElement frame1=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
        driver.switchTo().frame(frame1);
        Thread.sleep(2000);
           driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
           Thread.sleep(3000);
           Set<String> windowhandleset=driver.getWindowHandles();
           List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
           driver.switchTo().window(windowhandlelist.get(1));
           Thread.sleep(3000);
           driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
           Thread.sleep(3000);
           driver.switchTo().window(windowhandlelist.get(0));
           driver.switchTo().frame(frame1);
           String num=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("Value");
           System.out.println("The incident no is: "+num);
           /*JavascriptExecutor js=(JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,600)");*/
           driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(description);
           driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
           
           WebElement num1=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
           num1.sendKeys(num,Keys.ENTER);
           String srhnum=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
           
           if (srhnum.equals(num))
           {
        	   System.out.println("The number is same and the incident is created");
           }
           else
           {
        	   System.out.println("The number is not same and the incident is created");
           }
          
	}
	 @DataProvider
	public String[][] senddata() throws IOException {
		 return readExcelForServicenow.readdata("Sheet1");
		
	}
	

}
