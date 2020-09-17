package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class TaskPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TaskPage taskpage;
	String sheetName="tasks";
	public TaskPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		taskpage=homepage.clickOnTasklink();
	}
	@DataProvider
	public Object[][] getCrmTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		}
	@Test(priority=1, dataProvider="getCrmTestData")
	public void validatecreatNewTask(String tle,String com,String ident) {
		homepage.clickOnNewTaskLink();
		
		taskpage.clickOnNewTask(tle, com, ident);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
