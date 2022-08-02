package com.resources.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.resources.qa.util.Testutil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream fis= new FileInputStream( System.getProperty("user.dir")+"\\src\\main\\java\\com\\resources\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization()
	{
	String browserName =prop.getProperty("browser");
		
	if(browserName.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}else if(browserName.equals("FF"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}else if(browserName.equals("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	}
}

