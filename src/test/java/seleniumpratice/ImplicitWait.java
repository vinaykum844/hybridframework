package seleniumpratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String a[]) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alaskatrips.poweredbygps.com");

		driver.findElement(By.xpath("//*[@id='wizard-tabs']/div[1]/ul/li[1]")).click();

		driver.findElement(By.xpath("//*[@id='hotel-destination-hp-hotel']")).sendKeys("nyc");

		driver.findElement(By.xpath("//*[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.DOWN);

		driver.findElement(By.xpath("//*[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[9]/label/button")).click();

		driver.findElement(By.xpath("//*[@id='resultsContainer']/section/article[1]/div[2]/div/a")).click();
	}

}
