package Tutorial;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Multiple Windows Element 
		WebElement multipleWindows = driver.findElement(By.cssSelector("#content ul li:nth-child(33) a")); 
		
		//Click multiple windows link 
		multipleWindows.click();
		
		Thread.sleep(2000); 
		
		//Multiple Windows Element 
		WebElement clickHere = driver.findElement(By.cssSelector(".example a"));
		
		//Click New page link 
		clickHere.click(); 
		
		Set<String> handles = driver.getWindowHandles();
		int handleSize = handles.size(); 
		Iterator<String> it = handles.iterator(); 
		String parent = it.next();
		String child = it.next();
	
		System.out.println("Handles Size: "+handleSize);
		driver.switchTo().window(child);
		System.out.println("Switch to :" +child);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		if(driver.findElement(By.tagName("h3")).getText().equalsIgnoreCase("New Window")) {
			System.out.println("Child page title: "+driver.getTitle());
			driver.switchTo().window(parent);
			
			System.out.println(driver.findElement(By.tagName("h3")).getText());
			
		}
	}
}
