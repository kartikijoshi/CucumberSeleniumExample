package com.myco.myproj;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleCheck {
	
	private WebDriver browser;

	@Given ("^Google is open google chrome$")
	public void openBrowser(){
		DesiredCapabilities chromeDesiredCapabilities = DesiredCapabilities.chrome();
		//chromeDesiredCapabilities.setCapability(ChromeDriver.);
		System.out.println("opening browser");
		this.browser = new ChromeDriver(chromeDesiredCapabilities);
		System.out.println("opened browser");
		browser.get("http://www.google.com");
		
	}
	
	@When("^I type Java in search field$")
	public void I_type_Java_in_search_field() throws Throwable {
		System.out.println("typing in google");
		browser.findElement(By.id("lst-ib")).clear();
		browser.findElement(By.id("lst-ib")).sendKeys("java");
	}

	@When("^I click search button$")
	public void I_click_search_button() throws Throwable {
		System.out.println("searching in google");
		browser.findElement(By.name("btnK")).click();
	}

	@Then("^I see search results for java$")
	public void I_see_search_results_for_java() throws Throwable {
		System.out.println("I might see results");
		Assert.assertTrue(browser.findElement(By.cssSelector("BODY")).getText().contains("Download Free Java Software"));
	}

}
