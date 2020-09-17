package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase {
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement tasklabel;
	@FindBy(name="title")
	WebElement Title;
	@FindBy(name="completion")
	WebElement comp;
	@FindBy(name="identifier")
	WebElement iden;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
public TaskPage() {
	PageFactory.initElements(driver, this);
}
public boolean validateTaskLabel() {
	return tasklabel.isDisplayed();
}
public void clickOnNewTask(String tle,String com,String ident) {
	Title.sendKeys(tle);
	comp.sendKeys(com);
	iden.sendKeys(ident);
	SaveBtn.click();
}
}
