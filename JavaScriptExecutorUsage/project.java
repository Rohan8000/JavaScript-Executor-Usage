package JavaScriptExecutorUsage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class project {
static WebDriver driver;
	
	public static WebDriver createWebDriver() 
	{
		// Create WebDriver		
		WebDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Open the URL 
		driver.get(" https://www.stqatools.com/demo/Alerts.php");
		return driver;
	}
	
	public static void alert() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		//Generate alert "hello world" by clicking on “Basic Alert”
		WebElement btn = driver.findElement(By.xpath("//*[@id='btnAlert']"));
		js.executeScript("arguments[0].click()",btn);
		
		//Close the alert
		WebElement ok = driver.findElement(By.xpath("//div[@id='ezAlerts-footer']/button"));
		js.executeScript("arguments[0].click()", ok);
	}
	
	public static void navigate()
	{
		//Navigate to different webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://stqatools.com/demo/'");
	}
	
	public static void loginPage() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		//Fill the username as admin
		js.executeScript("document.getElementById('username').value='admin'");
		
		//Fill the password as admin
		js.executeScript("document.getElementById('password').value='admin'");
		
		//Click the login button
		js.executeScript("document.getElementById('login-button').click()");
		
		//Click the Home Page button
		js.executeScript("document.getElementById('home-button').click()");
	}
	
	public static void registrationForm()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Fill the Name as “Amol”
		js.executeScript("document.getElementById('name').value='Amol'");
		
		//Fill the Personal Address as “Mumbai” 
		js.executeScript("document.getElementById('address').value='Mumbai'");
		
		//Select proper gender
		js.executeScript("document.getElementById('male').click()");
		
		//Select your Hobby
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i =0;i<checkboxes.size();i++)
		{
			js.executeScript("arguments[0].click()", checkboxes.get(i));
		}
		
		//Select any Country
		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id='country']"));
		js.executeScript("arguments[0].value='Canada'",dropdown1);
		
		//Select any City
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='city']"));
		js.executeScript("arguments[0].value='New York'",dropdown2);
		
		//Select your Date of Birth
		WebElement setdate = driver.findElement(By.xpath("//*[@id='dob']"));
		js.executeScript("arguments[0].value='2024-02-17'", setdate);
		
		//Scroll the page to the bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
		//Click on “Submit”
		WebElement submit = driver.findElement(By.xpath("//*[@id='registration-form']/button"));	
		js.executeScript("arguments[0].click()", submit);
		
		//Verify Submission is successful or not
		boolean register = (boolean) js.executeScript("return document.readyState === 'complete'");
		if(register)
		{
			System.out.println("User registration successful");
		}
		else
		{
			System.out.println("User registration failed");
		}
	}
	
	public static void main(String[] args) throws Exception
	{	
		
		
		project.driver = createWebDriver();
		alert();
		navigate();
		loginPage();
		registrationForm();
		
		//Close the browser.
		driver.quit();
	}
}
