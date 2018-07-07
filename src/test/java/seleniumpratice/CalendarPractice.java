package seleniumpratice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractice {

	public WebDriver driver;

	public void getBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
			// log.info("creating object of" + browser);
			driver = new ChromeDriver();
		}

	}

	public void getUrl(String URL) {
		// log.info("navigating to" + URL);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void calendar(String yea, String Mon, String Dat) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		// Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[2]")).click();

		String w = driver.findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[2]")).getText();
		String[] x = w.split("-");

		if (Integer.parseInt(x[1]) < Integer.parseInt(yea)) {
			driver.findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[3]")).click();
		}

		List<WebElement> years = driver.findElements(By.className("year"));

		for (int i = 0; i < years.size(); i++) {
			String year = years.get(i).getText();
			if (year.equalsIgnoreCase(yea)) {
				driver.findElements(By.className("year")).get(i).click();
				break;
			}
		}

		List<WebElement> months = driver.findElements(By.className("month"));
		for (int i = 0; i < years.size(); i++) {
			if (months.get(i).getText().equalsIgnoreCase(Mon)) {
				driver.findElements(By.className("month")).get(i).click();
				break;
			}
		}

		List<WebElement> days = driver.findElements(By.className("day"));

		for (int i = 0; i < days.size(); i++) {
			if (days.get(i).getText().equalsIgnoreCase(Dat)) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}
