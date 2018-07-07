package seleniumpratice;

import org.testng.annotations.Test;

public class SampleProgram extends CalendarPractice {

	@Test
	public void test1() throws InterruptedException {
		getBrowser("chrome");
		getUrl("https://www.path2usa.com/travel-companions");
		calendar("2020", "Jun", "20");

	}

}
