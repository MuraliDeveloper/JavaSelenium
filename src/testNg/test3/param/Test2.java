package test3.param;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 How to pass values from testng xml to test class?
   
    1.changes in the testng.xml:
        Write parameter with name and value in xml. 
    	<parameter name = "userName" value="admin"/> 
        
        -Where can we write the parameter Tag?
    	 A)  Global level (it is avilable to all the tests)
	    	write <parameter>  tag inside the <suite> 
	    	ex:
	    	<suite name="Test1">
					<parameter name = "userName" value="admin"/> 
			</suite>
		B) specific to Test
		   write <parameter>  tag inside the <test> 
	    	ex:
	    	<suite name = "empDemo">
   						<test name = "register">
								<parameter name = "userName" value="admin"/> 
						</test>
						
			</suite>

  2.changes in the Test class
        Write @Parameters(value = {"userName"}) 
       
       -Where can we write the @Parameters annotations?
        solution)
        1.Along with @BeforeMethod, 
        2.Along with @BeforeTest
        3.Along with @Test
 
 */
public class Test2 {

	@Test
	@Parameters(value = {"userName", "password"})
	public void test1(@Optional("NA") String myName,String password) {
		System.out.println("test1::username value is : " + myName);
		System.out.println("test1::password value is : " + password);
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	
}
