import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SiteAvito {
	public static void main(String[] args) {
		final String AVITO_BASE_URL = "http://avito.ru";

		System.setProperty("webdriver.chrome.driver", "ATHW31/src/main/resources/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebDriverManager.chromedriver().setup();

		driver.get(AVITO_BASE_URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Select categoryID = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
		categoryID.selectByVisibleText("Оргтехника и расходники");
		driver.findElement(By.xpath("//input[@type='text' and @data-marker='search-form/suggest']"))
				.sendKeys("Принтер");
		driver.findElement(By.xpath("//div[@class='main-text-_Thor']")).click();
		driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']"))
				.sendKeys("Владивосток");
		driver.findElement(By.xpath("//strong[.='Владивосток']")).click();
		driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
		driver.findElement(By.xpath("//button[@data-marker='search-form/submit-button']")).click();

		if (driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).isSelected() == false) {

			driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).click();
			driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
		}


		Select selectSorting = new Select(driver.findElement(By.xpath("//div[@class='index-topPanel-McfCA']/descendant::select[@class='select-select-IdfiC']")));
		selectSorting.selectByVisibleText("Дороже");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		for (int i = 1; i < 4; i++) {

			System.out.println(driver.findElement(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item' and position()=" + i + "]//a[@target='_blank']"))
					.getAttribute("title"));
			System.out.println(driver.findElement(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item' and position()=" + i + "]//meta[@itemprop='price']"))
					.getAttribute("content"));
		}

		driver.quit();

	}
}
