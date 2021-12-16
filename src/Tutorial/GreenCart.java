package Tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> productNames = driver.findElements(By.cssSelector("div.product h4.product-name"));
		List<WebElement> addToCart = driver.findElements(By.cssSelector("div.product button"));
		
		//Array to Store All Product name on the Website 

		String [] arrays = new String[productNames.size()]; 
		String [] toBeClicked = {"Mushroom", "Tomato", "Cucumber"};
		
		int count = 0;
		//Get All products Name 
		for(WebElement productName : productNames) {
			String temp = productName.getText(); 
			arrays[count] = temp.split(" ")[0].trim(); 
			count++;
		}

		
		//Convert Array to ArrayList 
		List<String> itemsNeeded = Arrays.asList(toBeClicked); 
		//Iterate through names and compare with the list to be clicked and click add to cart 
		for(int i = 0; i<arrays.length; i++) {
			if(itemsNeeded.contains(arrays[i])) {
				addToCart.get(i).click(); 
				
			}

		}
		
		WebElement checkoutIcon = driver.findElement(By.cssSelector("a.cart-icon")); 
		//Click Checkout Icon 
		checkoutIcon.click();
		
		WebElement callToAction = driver.findElement(By.cssSelector("div.cart-preview.active .action-block button")); 
		WebElement proceed = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(callToAction)); 
		proceed.click();

		String promoCode = "rahulshettyacademy"; 
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promoCode); 
		
		WebElement apply = driver.findElement(By.cssSelector("button.promoBtn")); 
		apply.click();
		
		WebElement codeApply = new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.promoInfo"))));

		WebElement placeOrder = driver.findElement(By.cssSelector("div.products div:nth-child(4) > button:nth-child(14)")); 
		//Click Place Order
		placeOrder.click(); 
		
		WebElement sel = driver.findElement(By.tagName("select")); 
		Select select = new Select(sel); 
		select.selectByValue("Nigeria"); 
		
		//Agree to Terms 
		driver.findElement(By.cssSelector(".chkAgree")).click(); 
		
		//Proceed
		driver.findElement(By.tagName("button")).click(); 
		
		Thread.sleep(5000); 
		
		driver.quit();
	}

}
