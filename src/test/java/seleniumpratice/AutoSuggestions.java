package seleniumpratice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestions {

	// public WebDriver driver;

	public static void main(String a[]) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		int i = 0;
		while (!text.equalsIgnoreCase("BENGALURU DARSHINI")) {
			i++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			if (i > 10) {
				break;
			}
		}
		if (i > 10) {

			System.out.println("element is not present");

		} else

		{
			System.out.println("element is  present");
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);

		}

	}

}
