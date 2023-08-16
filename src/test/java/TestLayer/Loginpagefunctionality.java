package TestLayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class Loginpagefunctionality extends BaseClass
	{
	
	@BeforeTest
	//@Parameters({"browsername"})
	
	public void setup()
	{
		BaseClass.initialization();
		
	}
	@Test(priority=1)
	public void validateloginpage()
	{
		driver.findElement(By.xpath("//div[text()='Login']/preceding::input[2]")).sendKeys("prafulp1010@gmail.com");
		driver.findElement(By.xpath("//div[text()='Login']/preceding::input[1]")).sendKeys("Pr@ful0812");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
	}
//	@Test(priority=3)
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//	}	

}
