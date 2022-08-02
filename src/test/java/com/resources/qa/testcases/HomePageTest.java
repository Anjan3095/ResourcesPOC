package com.resources.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resources.qa.base.TestBase;
import com.resources.qa.pages.FilterResourcesPage;
import com.resources.qa.pages.HomePage;
import com.resources.qa.pages.NanjinggTalePage;
import com.resources.qa.pages.SearchResourcesPage;

public class HomePageTest extends TestBase{
	HomePage hp;
	SearchResourcesPage srp;
	FilterResourcesPage frt;
	NanjinggTalePage ntppp;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		 hp= new HomePage();
	}

	@Test(priority=1)
	public void homePageTitleTest()
	{
	String title=hp.validateHomePageTitle();
		Assert.assertEquals(title, "Resources");
	}
	
	@Test(priority=2)
	public void searchResourcesTest() throws InterruptedException
	{
		srp=hp.searchResources("Jinggangshan Power Plant");
			
	}
	
	@Test(priority=3)
	public void filterResourcestab() throws InterruptedException
	{
		
		frt=hp.filterResourcestab();
	}
	
	@Test(priority=4)
	public void Nanjinggtailtest()
	{
		ntppp=hp.Nanjinggtail();
	}
	

	
	
}
