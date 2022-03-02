package com.e2eTests.automatedTests.demoQA.mouseHover.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automatedTests.demoQA.mouseHover.pageObjects.mouseHoverPageObjects;
import com.e2eTests.automatedTests.utils.CommonMethods;
import com.e2eTests.automatedTests.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class mouseHoverStepDefinition {
	public WebDriver driver = null;
	private mouseHoverPageObjects mouseHoverPage = new mouseHoverPageObjects();
	private CommonMethods commonmethods = new CommonMethods();
	
	public mouseHoverStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, mouseHoverPageObjects.class);
	}
	
	@Given("^je me connecte sur application demo qa \"([^\"]*)\"$")
	public void jeMeConnecteSurApplicationDemoQa(String arg1) throws Throwable {
		commonmethods.readFileConfig(arg1);

	}

	@When("^je met le souris sur Main item(\\d+)$")
	public void jeMetLeSourisSurMainItem(int arg1) throws Throwable {
		
		mouseHoverPage.mouseHoverAction();
	}

	@When("^je fais une capture écran$")
	public void jeFaisUneCaptureÉcran() throws Throwable {
		
		mouseHoverPage.takeScreen();
	}

	@Then("^je vérifie les items sont affichés et les captures écrans sont conformes$")
	public void jeVérifieLesItemsSontAffichésEtLesCapturesÉcransSontConformes() throws Throwable {
		
	    
	}



}
