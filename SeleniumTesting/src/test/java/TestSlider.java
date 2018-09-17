import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

public class TestSlider {
	
	public static WebDriver driver;
	public static Properties OR=new Properties();
	public static Properties Config=new Properties();
	
	
	public static void click(String locator) 
	{
		if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		
		else if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		
		else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		
		
	}
	
	public static void type(String locator,String value)
	{
		if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		
		else if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		
		else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
	}
	
	public static void Loc(String locator) 
	{
		if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		
	}	

	
	
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		
		System.out.println(OR.getProperty("username_XPATH"));
		System.out.println(Config.getProperty("testsiteURL"));
		
		
		if(Config.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\SeleniumTesting\\target\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if (Config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\eclipse-workspace\\Framework\\target\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		
		else if(Config.getProperty("browser").equals("opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\Users\\user\\eclipse-workspace\\SeleniumTesting\\target\\operadriver.exe");
			driver=new OperaDriver();
		}
		
		else if(Config.getProperty("browser").equals("ie"))
		{
			driver = new InternetExplorerDriver();

		}
		
		driver.get(Config.getProperty("testsiteURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		Actions action=new Actions(driver);
		
				
		
	}

}
