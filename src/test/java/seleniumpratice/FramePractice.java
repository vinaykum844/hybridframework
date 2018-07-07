package seleniumpratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https//google.com");
		FramePractice w = new FramePractice();
		int frameindex = w.framenumber(driver, By.xpath(""));
		driver.switchTo().frame(frameindex);
		driver.findElement(By.xpath("")).click();
		driver.switchTo().defaultContent();
		int frameindextwo = w.framenumber(driver, By.xpath(""));
		driver.switchTo().frame(frameindextwo);
		driver.findElement(By.xpath("")).click();
		driver.switchTo().defaultContent();
	}

	public int framenumber(WebDriver driver, By by) {
		int i;
		int count = driver.findElements(By.tagName("iframe")).size();

		for (i = 0; i < count; i++) {
			driver.switchTo().frame(i);
			int countone = driver.findElements(by).size();

			if (countone > 0) {
				break;
			}

			else {
				System.out.println("continue looping");
			}
		}
		driver.switchTo().defaultContent();
		return i;
	}
}