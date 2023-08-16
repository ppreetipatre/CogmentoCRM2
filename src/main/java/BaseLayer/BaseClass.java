package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	
	//	private static ThreadLocal<WebDriver> driverthreadlocal=new ThreadLocal<WebDriver>();
//		public WebDriver getDriver()
//		{
//			return driverthreadlocal.get();
//		}
		public static WebDriver driver;
		
		public  static void initialization( )
		{
//			if(browsername.equals("Chrome"))
//			{
		//		driver= new ChromeDriver();
		//	}
			//else if (browsername.equals("Edge"))
//			{
				driver=new EdgeDriver();
//			}
//			driverthreadlocal.set(driver);
//			
			
			driver.get("https://ui.cogmento.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			
					
		}
		
		

	}


