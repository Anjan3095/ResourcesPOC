package com.resources.qa.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resources.qa.base.TestBase;
import com.resources.qa.pages.FilterResourcesPage;
import com.resources.qa.pages.HomePage;

public class FilterResourcesTest extends TestBase {

	HomePage hp;
	FilterResourcesPage frt;
	
	public FilterResourcesTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		 hp= new HomePage();
		frt=hp.filterResourcestab();
	}
	
	@Test(priority=1)
	public void filterResourcePageTitleTest()
	{
		String title=frt.verifyPageTitle();
		Assert.assertEquals(title, "FILTER RESOURCES");
	}
	
	@Test(priority=2)
	public void NoResultsTitlebarCheck()
	{
		frt.resourcedropdownselectionnegative();
		Assert.assertEquals(hp.noResultsCheck(), "No Results Found for this search criteria");
	}
	
	@Test(priority=3)
	public void imgValidationCheck() throws InterruptedException
	{
		frt.productsDropDownSelection();
	}
	
	@Test(priority=4)
	public void industryimagevalidation() throws InterruptedException
		{
			frt.IndustryDropdownSelectionImageValidation();
		}
	
	@Test(priority=5)
	public void tileValidationCheck() throws InterruptedException
	{
		frt.resourceDropdownSelectionPositive();
	}
	
}
