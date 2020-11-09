package testFb;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BaseTest;
import util.Commons;

public class Test3MultiWindows extends BaseTest {

	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(Commons.BASE_URL + "window1.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 How to get the current window name?
	   String parentWindowHandle = driver.getWindowHandle();
	 
	 
	 How to get all window handles?
	   Set<String> allWindowHandles = driver.getWindowHandles();
	 
	 How to switch between the windows?
	   driver.switchTo().window("<window name>");
	 
	 
   steps:
   --------
   assert the parent window title
   Get the parent window name
   click on the link  ---> open the child window
   get the child window name
   
   switch to the child window using the child window name
   assert/validate child window title
   enter the data for the fields in child window
   
   switch to the parent window using the parent window name
   assert/validate the parent window title
   enter the data to the field in parent window
  
  <a id="gLink1" href="test.html" onclick="window.open('test.html', 
                         'newwindow', 
                         'width=700,height=750');return false;">Open Window</a>
                         
  */
	@Test
	public void testWindow() throws InterruptedException {
		//assert the parent window title
		assertEquals(driver.getTitle() , "In window1", "Invalid title");
		
		//Get the parent window name
		String parentWindowHandle = driver.getWindowHandle();

		//click on the link ---> open the child window
		driver.findElement(By.id("gLink1")).click();
		Thread.sleep(3000);

		//get the child window name
		String childWindowHandle = getchildWIndowName(driver, parentWindowHandle);
		
		// switch to the child window using the child window name
		driver.switchTo().window(childWindowHandle);
		
		//assert/validate child window title
	    assertEquals(driver.getTitle() , "Hello Python", "Invalid title");
		Thread.sleep(2000);
		
		//enter the data for the fields in child window
		driver.findElement(By.name("name")).sendKeys("user1");
		driver.findElement(By.name("password")).sendKeys("user1");
		Thread.sleep(2000);
		
		//switch to the parent window using parent window name
		driver.switchTo().window(parentWindowHandle);
		Thread.sleep(2000);
		
		//assert/validate the parent window title
		assertEquals(driver.getTitle() , "In window1", "Invalid title");
		
		//enter the data to the field in parent window
		driver.findElement(By.name("uName")).sendKeys("kumar");
		
		Thread.sleep(3000);
	}

	private String getchildWIndowName(WebDriver driver, String parentWindowHandle) {
		String childWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				childWindowHandle = handle;
				break;
			}
		}
		return childWindowHandle;
	}
}