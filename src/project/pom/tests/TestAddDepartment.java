package pom.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.pages.AddDepartment;
import pom.pages.LoginPage;
import util.Commons;

public class TestAddDepartment extends Headerutility {
	LoginPage login;
	AddDepartment addDept;
	Headerutility header;
	
	public TestAddDepartment() {
		driver=Commons.startApplication(driver, "Chrome");
		login=PageFactory.initElements(driver, LoginPage.class);
		addDept=PageFactory.initElements(driver, AddDepartment.class);
		header=PageFactory.initElements(driver,Headerutility.class);
	}
	
	@BeforeMethod
	public void login() {
		login.login("admin", "admin");
		header.adddept();
		
	}
	@Test(priority=0)
	public void withoutname() {
		addDept.adddept("", "");
		Alert a=driver.switchTo().alert();
		Reporter.log(a.getText());
		assertTrue(a.getText().equals("Please provide department Name!"));
		a.accept();
	}
	@Test(priority=1)
	public void department() {
		addDept.adddept("SSE","RAM -  KUMAR");
		addDept.afteradd("493","HR","112-SHYAM-reddy","Thu Sep 12 22:44:58 IST 2019");
		
	}
	@AfterMethod
	public void logout() {
		header.logout();
		
	}
}
