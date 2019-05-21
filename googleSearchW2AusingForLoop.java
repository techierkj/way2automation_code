package firstAssignementSet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearchW2AusingForLoop {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Latest Selenium Softwares\\chrome driver\\chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		String searchText="way2automation";
		driver.findElement(By.xpath("//div[2]/div/div[1]/div/div[1]/input")).sendKeys(searchText);
		int searchCount=driver.findElements(By.xpath("//div[2]/div/div[2]/div[2]/ul//div/div/div/span")).size();
		for(int i=1;i<=searchCount;i++) {
			String searchListValue=driver.findElement(By.xpath("(//div[2]/div/div[2]/div[2]/ul//div/div/div/span)["+i+"]")).getText();
			System.out.println(searchListValue);
		}
		Thread.sleep(500);
		driver.close();
	}

}
