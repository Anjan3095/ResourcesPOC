package com.resources.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.resources.qa.base.TestBase;

public class FilterResourcesPage extends TestBase {

	public List<WebElement> images;
	public List<WebElement> imagecountactual;
	
	@FindBy(xpath="//div[@class='form-header']")
	WebElement titleheader;
	
	@FindBy(xpath="//div[@id='products_select_box_chosen']")
	WebElement productscheckbox;
	
	@FindBy(css="div#segment_select_box_chosen.chosen-container.chosen-container-multi")
	WebElement Industrycheckbox;
	
	@FindBy(css="div#type_select_box_chosen.chosen-container.chosen-container-multi")
	WebElement resourcesdropdown;
	
	@FindBy(css="div#products_select_box_chosen.chosen-container.chosen-container-multi")
	WebElement productsdropdown;
	
	@FindBy(css="input#type-select-box-chosen.chosen-search-input")
	WebElement resourcesnext;
	
	@FindBy(xpath="//input[@value='Resource']")
	WebElement selectedvalue;
	
	@FindBy(xpath="//input[@id='segment-select-box-chosen']")
	WebElement industryvalue;
	
	@FindBy(xpath="//input[@id='products-select-box-chosen']")
	WebElement productsValue;
	
	@FindBy(xpath="//button[@class='submit']")
	WebElement submitbutton;
	
	@FindBy(xpath="//div[@class='resources__wrapper_resource-container']")
	WebElement imagecontainer;
	
	public FilterResourcesPage()
	{
	         PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return titleheader.getText();
	}
	
	public void resourcedropdownselectionnegative()
	{
		resourcesdropdown.click();
		selectedvalue.sendKeys("Audio");
		selectedvalue.sendKeys(Keys.ENTER);
		resourcesnext.click();
		selectedvalue.sendKeys("Blogs");
		selectedvalue.sendKeys(Keys.ENTER);
		resourcesnext.click();
		selectedvalue.sendKeys("Checklist");
		selectedvalue.sendKeys(Keys.ENTER);
		submitbutton.click();
	}
	
	public void resourceDropdownSelectionPositive() throws InterruptedException
	{
		resourcesdropdown.click();
		selectedvalue.sendKeys("3D Tours");
		selectedvalue.sendKeys(Keys.ENTER);
		submitbutton.click();
		Thread.sleep(5000);
		 images= driver.findElements(By.tagName("img"));
		System.out.println(images.size());
	WebElement resourcecontainerdriver=	imagecontainer;
	
	 imagecountactual=resourcecontainerdriver.findElements(By.tagName("img"));
	System.out.println(imagecountactual.size());
          for(int i=1;i<=imagecountactual.size();i++) {
		 
		 driver.findElement(By.xpath("//div[@class='resources__wrapper_resource-container']/div["+i+"]")).click();
		 Thread.sleep(8000);
		     }
        
		Set<String> windownames= driver.getWindowHandles();
		Iterator<String> it=windownames.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	
	}
	
	public void productsDropDownSelection() throws InterruptedException
	{
		productsdropdown.click();
		productsValue.sendKeys("Storage");
		productsValue.sendKeys(Keys.ENTER);
		submitbutton.click();
	 }
	
	public void IndustryDropdownSelectionImageValidation() throws InterruptedException
	{
		Industrycheckbox.click();
		industryvalue.sendKeys("Government");
		industryvalue.sendKeys(Keys.ENTER);
		submitbutton.click();
		 Thread.sleep(5000);
			List<WebElement> images= driver.findElements(By.tagName("img"));
			System.out.println(images.size());
		WebElement resourcecontainerdriver=	imagecontainer;
		
		List<WebElement> imagecountactual=resourcecontainerdriver.findElements(By.tagName("img"));
		System.out.println(imagecountactual.size());
		for(WebElement image:imagecountactual)
			{
				
				String imagesrc=image.getAttribute("src");
				
				try {
				URL url= new URL(imagesrc);
				URLConnection urlConnection=url.openConnection();
				HttpURLConnection httpurlconnection=(HttpURLConnection) urlConnection;
				httpurlconnection.setConnectTimeout(5000);
				httpurlconnection.connect();
				
				if(httpurlconnection.getResponseCode() == 200)
					System.out.println(imagesrc +">>"+httpurlconnection.getResponseCode()+">>"+httpurlconnection.getResponseMessage() );
				else
					System.err.println(imagesrc +">>"+httpurlconnection.getResponseCode()+">>"+httpurlconnection.getResponseMessage() );
				httpurlconnection.disconnect();
				}catch(Exception e)
				{
					System.err.println(imagesrc);
				}
			}
		
	}
}
