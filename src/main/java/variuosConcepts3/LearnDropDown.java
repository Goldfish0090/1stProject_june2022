package variuosConcepts3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LearnDropDown {

	
	WebDriver driver;
	
	By USERNAME = By.xpath("//*[@id=\"username\"]");
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER = By.xpath("//span[contains(text(), 'Customers')]");
	
	
	By ADDCUSTOMER = By.xpath("//a[contains(text(), 'Add Customer')]");
	By FULLNAME =By.xpath("//*[@id=\"account\"]");
	
	By Title= By.xpath("/html/head/title");
	
	String username = "demo@techfios.com";
	String password = "abc123";
	String expectedTile = "Dashboard" ;
	


@Before
public void initDriver() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nesar Ahmed\\eclipse-workspace\\LearningSelenium\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://techfios.com/billing/?ng=admin");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
@Test
public void loginTest() {
	
	driver.findElement(USERNAME).sendKeys(username);
	driver.findElement(PASSWORD).sendKeys(password);
	driver.findElement(LOGIN).click();
	//String DashBOard= driver.findElement(DASHBOARD).getText();
	

	//Assert.assertEquals("Page Not found brother", "Dashboard", DashBOard);
	
	Assert.assertEquals("Page not found mama", "Dashboard- iBilling", driver.getTitle());
}

@Test
public void addCustomer() {
	
	driver.findElement(USERNAME).sendKeys(username);
	driver.findElement(PASSWORD).sendKeys(password);
	driver.findElement(LOGIN).click();
	
	  //To wait for element visible

	  WebDriverWait wait = new WebDriverWait(driver, 15);

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Customers')]")));
		
	    driver.findElement(CUSTOMER).click();
		driver.findElement(ADDCUSTOMER).click();
		driver.findElement(FULLNAME).sendKeys("Nesar Ahmed");
		
		WebElement WE =driver.findElement(By.xpath("//*[@id=\"cid\"]"));
		Select sel= new Select(WE);
		sel.selectByVisibleText("ATT");
		sel.getAllSelectedOptions();
}
@After

    public void tearDown() {
    driver.close();
	driver.quit();
}
}