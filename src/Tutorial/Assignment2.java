package Tutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Depart on field 
		WebElement departOn = driver.findElement(By.cssSelector("div.homeCalender button"));
		
		//Click depart on to see calender 
		departOn.click(); 
		
		//Get all days in an array 
		List<WebElement> days = driver.findElements(By.cssSelector("div[class*='day-gridContent']"));
		
		//Wait until calender appearss
		WebElement today = new WebDriverWait(driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.visibilityOf(days.get(5)));
		
		//Iterate to locate element 
		for(WebElement day : days) {
			
//			System.out.println(day.getText());
			
			if(day.getText().equalsIgnoreCase("16")) {
				//Click day
				day.click();
				break;
			}
		}
		
		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'pt-3')][2]//div/select"));

		
		//Select No of Adults
		Select s = new Select(options.get(0)); 
		s.selectByIndex(3); 
		
		//Select No of Children
		Select a = new Select(options.get(1)); 
		a.selectByVisibleText("4"); 
		
		//Select No of Infants
		Select Infant = new Select(options.get(2)); 
		Infant.selectByValue("0");
		
		//Click Show more options 
		driver.findElement(By.cssSelector("div.mb-4 a")).click();
		
		Thread.sleep(3000); 
		
		driver.findElement(By.cssSelector("div.p-relative input[placeholder='Airline name']")).sendKeys("Emirate", Keys.ENTER); 
		
		
		driver.findElement(By.xpath("(//p[@class='fs-3 fw-600 c-neutral-900'])[1]")).click(); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
		//Vertical scroll down by 600  pixels		
        js.executeScript("window.scrollBy(0,600)");
        
        Thread.sleep(2000);
		WebElement searchFlight = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[2]/button[1]")); 
		searchFlight.click();
		
		
		
		//Wait until Error appears
		WebElement error = new WebDriverWait(driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.col-24 span"))));
		
		
		System.out.println(driver.findElement(By.cssSelector("div.col-24 span")).getText()); 
				
		
		driver.quit();
	}

}
