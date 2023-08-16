package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class Homepagetest extends BaseClass
{
	@Test(priority=2)
	public void validatehomepagetitle()
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle.contains("cogmento"), false);
		
	}
	@Test(priority=3)
	public void validatehomepageurl()
	{
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		Assert.assertEquals(actualurl.contains("ui.cogmento"), true);
	}
	
	
}
