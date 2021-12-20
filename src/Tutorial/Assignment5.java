package Tutorial;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Nested Frame link
		WebElement nestedFrameLink = driver.findElement(By.cssSelector("#content ul li:nth-child(34) a")); 
		
		//Click nested frame link
		nestedFrameLink.click();
		
		Thread.sleep(2000); 
		
		//Switch to Frames to Identify frame 
		driver.switchTo().frame(driver.findElement(By.name("frame-top"))); 
		
		driver.switchTo().frame(driver.findElement(By.name("frame-middle"))); 
				
		//Identify middle frame content 
		System.out.println(driver.findElement(By.id("content")).getText()); 
		
		Thread.sleep(2000);
//		Switch back to normal view 
		driver.switchTo().defaultContent(); 
		
		

	}
}
