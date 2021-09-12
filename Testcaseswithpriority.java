package Week5.day2;

import org.testng.annotations.Test;

public class Testcaseswithpriority {

@Test(priority = -1, enabled= false)
	public void login()
	{
		System.out.println("login");
	}
	
	@Test(priority=2)
	public void createlead()
	{
		System.out.println("Createlead");
	}
	@Test(priority=-1,invocationCount=3)
	
	
	
	
	public void editlead()
	{
		
		System.out.println("Editlead");
		
	}
	@Test
	public void Deletelead()
	{
		System.out.println("Deletelead");
		
	}
	@Test(priority=1)
	public void deletelead()
	{
		System.out.println("deletelead");
		
	}

}
