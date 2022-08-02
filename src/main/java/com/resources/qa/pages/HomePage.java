package com.resources.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.qa.base.TestBase;

public class HomePage extends TestBase{

	
	//Page Factory - Object Repository
	@FindBy(xpath="//div[@class='home-text']/h1")
	WebElement titleheader;
	
	@FindBy(css="i.fas.fa-plus")
	WebElement filterresources;
	
	@FindBy(xpath="//div[@class='resources__wrapper_header-bar_search-bar desktop']/input")
	WebElement searchresources;
	
	@FindBy(xpath="//div[contains(@title,'Nanjing')]")
	WebElement Nanjingtab;
	
	@FindBy(xpath="//div[@class='resources__wrapper_header-bar_search-bar desktop']/i")
	WebElement searchicon;
	
	@FindBy(xpath="//div[@class='no-results-msg show']")
	WebElement noresultsmsgtitlebar;
	
	@FindBy(xpath="//div[@class='resources__wrapper_resource-container_wrapper_image-block_picture-tag']")
	WebElement tilesconfirmation;
	
	//Initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory-class and initelements-Method
		//This is points to current class Object here and instead of this we can write Homepage.class also
	}
	
	
	//Actions:Different features which are available on the pages.
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public FilterResourcesPage filterResourcestab() throws InterruptedException
	{
		Thread.sleep(2000);
		 filterresources.click();
		 
		 return new FilterResourcesPage();
	}
	
	public SearchResourcesPage searchResources(String sr) throws InterruptedException
	{
		searchresources.sendKeys(sr);
		Thread.sleep(2000);
		searchicon.click();
	  
		return new SearchResourcesPage();
		
	}
	
	public NanjinggTalePage Nanjinggtail()
	{
		Nanjingtab.click();
		return new NanjinggTalePage();
	}
	
	public String noResultsCheck()
	{
		String elementText=noresultsmsgtitlebar.getText();
		  return elementText;
	}
	
	/*
	 * public boolean tilesCountonProducts() { return
	 * tilesconfirmation.isDisplayed(); }
	 */
}



















//We have created different webelements of this page by using page factory 
	//To initialize those web elements will use Pagefactory.initElements method here
	//All the variables like titleheader ,filterresources , search resources will be initialized with driver variable
