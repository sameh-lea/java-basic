package com.e2eTests.automatedTests.demoQA.mouseHover.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automatedTests.utils.CommonMethods;
import com.e2eTests.automatedTests.utils.Setup;

public class mouseHoverPageObjects {

	/* locator */
	final static String ITEM2_XPATH = "//*[@id='nav']/li[2]/a";
	final static String MENU_XPATH = "//body/div[@id='app']/div[1]"; 

	/* FindBY */

	@FindBy(how = How.XPATH, using = ITEM2_XPATH)
	public static WebElement mainitem2;
	@FindBy(how = How.XPATH, using = MENU_XPATH)
	public static WebElement allPage;
	
	
	/*instance */
	
	CommonMethods common = new CommonMethods();

	/* Methods */
	public void mouseHoverAction() {

		Actions actions = new Actions(Setup.driver);
		actions.moveToElement(mainitem2).perform();

	}
	public void takeScreen() {
		common.takeScreenShot(allPage);
		
	}

}
