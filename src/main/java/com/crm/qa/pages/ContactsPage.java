package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	@FindBy(name="first_name")
	WebElement FirstNme;
	@FindBy(name="last_name")
	WebElement LastNme;
	@FindBy(name="department")
	WebElement Dept;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifycontactslabel() {
		return contactslabel.isDisplayed();
	}
	public void createNewContact(String First,String Last,String Dep) {
		FirstNme.sendKeys(First);
		LastNme.sendKeys(Last);
		Dept.sendKeys(Dep);
		SaveBtn.click();
		
		
	}
}
