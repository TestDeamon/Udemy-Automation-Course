package Tutorial;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php/");

		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkbox-example label"));
		//Grab Checkbox text
		System.out.println(checkboxes.get(1).getText());

		String textLower = checkboxes.get(1).getText().toLowerCase();
		String text = checkboxes.get(1).getText();
		
		//Click Checkbox 
		driver.findElement(By.cssSelector("input[value='"+textLower+"']")).click();


		//Select corresponding checkbox from static dropdown
		WebElement sel = driver.findElement(By.cssSelector("select[name='dropdown-class-example']"));
		Select select = new Select(sel); 
		select.selectByVisibleText(text);
		
		//Enter the step 2 text in input box
		driver.findElement(By.id("name")).sendKeys(text);
		
		//Click Alert btn 
		driver.findElement(By.id("alertbtn")).click();
		
		//Verify if text is present in alert 
		String alert = driver.switchTo().alert().getText(); 
		
		if(alert.contains(text)) {
			System.out.println("Word found!");
		}else {
			System.out.println("Word not found!");
		}
		
		
		
		
	}
}
