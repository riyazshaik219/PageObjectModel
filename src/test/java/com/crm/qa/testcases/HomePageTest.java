package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		loginpage = new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM");
	}
	@Test(priority=2)
	public void verifyuserlabelTest() {
		Assert.assertTrue(homepage.verifyuserlabel());
	}
	@Test(priority=3)
	public void verifycontactslinkTest() {
		contactspage=homepage.clickOnContactslink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
