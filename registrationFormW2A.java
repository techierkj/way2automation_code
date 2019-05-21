package firstAssignementSet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registrationFormW2A {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\Latest Selenium Softwares\\chrome driver\\chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.xpath("(//*[@id='load_form']/fieldset[1]/input)[2]")).sendKeys("Ravi");
		driver.findElement(By.xpath("(//*[@id='load_form']/fieldset[2]/input)[2]")).sendKeys("8793344605");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[3]/input")).sendKeys("rkjtechie11@gmail.com");
		WebElement country = driver.findElement(By.xpath("//*[@id='load_form']/fieldset[4]/select"));
		Select countrySelect = new Select(country);
		countrySelect.selectByValue("Hungary");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[5]/input")).sendKeys("Pune");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[6]/input")).sendKeys("rkjtechie");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[7]/input")).sendKeys("rkjtechie");
		driver.findElement(By.xpath("(//*[@id=\"load_form\"]/div/div[2]/input)[2]")).click();

		// Validate if user is present or not
		WebDriverWait wait = new WebDriverWait(driver, 10L);
		String message = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert"))).getText();
		if (message.length() > 0) {
			System.out.println("Username already registered");
		} else {
			System.out.println("User created successfully");
		}
		driver.close();
	}
}
