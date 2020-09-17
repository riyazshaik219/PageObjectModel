package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement DealLabel;
	@FindBy(name="title")
	WebElement name;
	@FindBy(name="description")
	WebElement desc;
	@FindBy(name="probability")
	WebElement prob;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
		
	}
	public boolean verifyCreateNewDeal() {
		return DealLabel.isDisplayed();
		
	}
	public void createNewDeal(String nme,String des,String pro ) {
		name.sendKeys(nme);
		desc.sendKeys(des);
		prob.sendKeys(pro);
		SaveBtn.click();
	
		

}
}