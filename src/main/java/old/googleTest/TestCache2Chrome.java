package old.googleTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.cognigent.iot.admin.commons.BaseTest;

public class TestCache2Chrome extends BaseTest2{
	
	@Test
	public void test() throws InterruptedException {
		WebElement e = driver.findElement(By.name("q"));
		
		Actions a=new Actions(driver);
		
		a.sendKeys(e,"selenium").build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
	
	}
	
}
