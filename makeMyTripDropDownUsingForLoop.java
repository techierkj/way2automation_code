package firstAssignementSet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class makeMyTripDropDownUsingForLoop {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Latest Selenium Softwares\\chrome driver\\chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[1]/label/span")).click();
		String str = driver.findElement(By.xpath("//div/div[1]/p[1]")).getText();
		System.out.println("******" + str + "******");
		int citiesCount = driver
				.findElements(By.xpath("//*[contains(@id, 'react-autowhatever-1-section-0-item-')]/div/div[2]")).size();
		System.out.println("Popular Cities count:- " + citiesCount);
		for (int i = 0; i < citiesCount; i++) {
			String airportCode = driver
					.findElement(
							By.xpath("//*[contains(@id, 'react-autowhatever-1-section-0-item-" + i + "')]/div/div[2]"))
					.getText();
			String airportName = driver
					.findElement(By.xpath(
							"//*[contains(@id, 'react-autowhatever-1-section-0-item-" + i + "')]/div/div[1]/p[2]"))
					.getText();
			System.out.println("Airport Code:-" + airportCode + "| Airport Name:-" + airportName);
		}

		Thread.sleep(2000);
		driver.quit();
	}
}
