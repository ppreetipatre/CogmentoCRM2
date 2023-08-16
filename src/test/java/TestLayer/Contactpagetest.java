package TestLayer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import UtilityLayer.ExcelReader;

public class Contactpagetest extends BaseClass {
	@Test(priority = 4, dataProvider = "getcontactdata")
	public void validateNewContactFunctionality(String fname, String mname, String lname, String email, String status)
			throws InterruptedException {
		// Thread.sleep(10000);
		// System.out.println();
		WebElement wb = driver.findElement(By.xpath("//a[@href='/contacts']"));
		//wb.click();
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(wb).click(wb).build().perform();

		driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();

		driver.findElement(By.name("first_name")).sendKeys(fname);
		driver.findElement(By.name("middle_name")).sendKeys(mname);
		driver.findElement(By.name("last_name")).sendKeys(lname);
		driver.findElement(By.name("value")).sendKeys(email);
		driver.findElement(By.name("status")).sendKeys(status);

		List<WebElement> ls = driver.findElements(By.xpath("//div[@name='status']/span"));

		for (WebElement abc : ls) {
			String a = abc.getText();
			if (a.equalsIgnoreCase(status)) {
				abc.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	@DataProvider

	public Object getcontactdata() throws IOException

	{

		ExcelReader obj = new ExcelReader("C:\\Users\\18134\\eclipse-workspace\\CogmentoCRM\\src\\main\\java\\TestData\\Cogmentotestdata.xlsx");
		// System.getProperty("user.dir")+"\\CogmentoCRM\\Testdata\\Cogmentotestdata.xlsx‪");
		Object[][] data = obj.getAllSheetData(0);
		return data;

	}

}
