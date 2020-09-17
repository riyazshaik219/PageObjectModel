package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	String sheetName="deals";
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intilization();
		loginpage = new LoginPage();
		dealspage=new DealsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealspage=homepage.clickOnDealslink();
	}
	@Test(priority=2)
	public void verifyDealsPageLabel() {
		Assert.assertTrue(dealspage.verifyCreateNewDeal());
	}
	@DataProvider
	public Object[][] getCrmTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=1, dataProvider="getCrmTestData")
	public void validatecreatNewDeal(String nme,String des,String pro) {
		homepage.clickOnNewDealsLink();
		dealspage.createNewDeal(nme, des, pro);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
