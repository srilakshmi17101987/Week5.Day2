package Week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createlead1 extends Commonclass1{
	
	@Test(dataProvider="senddata")
	public void runCreatelead1(String company,String fname,String lname,String phno) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] senddata() throws IOException 
	{
		
		return readExcel.readdata("Sheet1");//read excel is a class read data is method from the same class
		//rows and columns
		/*String[][] data=new String[2][4];
		*data[0][0]= "Testleaf";
		*data[0][1]= "Sri";
		*data[0][2]= "R";
		*data[0][3]= "99";
		
		*data[1][0]= "gebb";
		*data[1][1]= "Anu";
		*data[1][2]= "M";
		*data[1][3]= "98";
		
		return data;*/
	}
	
	
}
