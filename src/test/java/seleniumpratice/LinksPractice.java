package seleniumpratice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[5]/a")).click();
		driver.manage().window().maximize();

		int totallinkcount = driver.findElements(By.tagName("a")).size();
		System.out.println("The total links count in the page" + totallinkcount);

		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));

		int footerlinkscount = footer.findElements(By.tagName("a")).size();
		System.out.println("The total links count in the footer" + footerlinkscount);

		WebElement discount = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int countdis = discount.findElements(By.tagName("a")).size();
		System.out.println("The total links count in the footer" + countdis);
		for (int i = 1; i < countdis; i++) {
			String chrod = Keys.chord(Keys.CONTROL, Keys.ENTER);
			discount.findElements(By.tagName("a")).get(i).sendKeys(chrod);
			Thread.sleep(2000);
		}

		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();

		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}

	}

}
