import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Story("Запуск теста поиска принтеров на сайте Авито ")
public class SiteAvitoMainPageTest {

	WebDriver driver;
	WebDriverWait webDriverWait;

	private final static String AVITO_BASE_URL = "http://avito.ru";
	private final static String AVITO_CATEGORY = "Оргтехника и расходники";
	private final static String AVITO_PRODUCT_SEARCH = "Принтер";
	private final static String AVITO_LOCATION = "Владивосток";
	private final static String AVITO_ADS_SORTING = "Дороже";

	@BeforeAll
	static void registerDriver() {
		System.setProperty("webdriver.chrome.driver", "ATHW4/src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void SetupDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");
		driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver(chromeOptions));
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test
	void SiteAvitoTest() throws InterruptedException {
		driver.get(AVITO_BASE_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SiteAvitoMainPage mainpage = new SiteAvitoMainPage(driver);

		mainpage.setCategoryID(AVITO_CATEGORY)
				.setInputSearch(AVITO_PRODUCT_SEARCH)
				.setLocationSearch()
				.setInputCity(AVITO_LOCATION)
				.clickInputCity()
				.clickButtonShow()
				.setCheckBoxAvitoDelivery()
				.clickButtonShowAds()
				.setSelectSorting(AVITO_ADS_SORTING)
				.printTitleProduct();
	}

	@AfterEach
	void tearDown() throws InterruptedException {
		driver.quit();
	}
}

