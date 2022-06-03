package StepDefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static org.openqa.selenium.OutputType.BYTES;

public class StepDef {
	WebDriver driver;
	WebDriverWait webDriverWait;
	SiteAvitoMainPage mainpage;

	private final static String AVITO_BASE_URL = "http://avito.ru";

	@Step("Открыт ресурс авито")
	@Пусть("открыт ресурс авито")
	public void openSiteAvito() {
		System.setProperty("webdriver.chrome.driver", "ATHW41/src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(AVITO_BASE_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mainpage = new SiteAvitoMainPage(driver);
		makeScreenShot();
	}

	@Step("Выбор категории поиска")
	@И("в выпадающем списке категорий выбрана {category}")
	public void setCategorySearch(CategorySearch cat) {
		mainpage.categoryID.selectByVisibleText(cat.getTitle());
		makeScreenShot();
	}

	@Step("Ввод текста в строку поиска")
	@И("в поле поиска введено значение {string}")
	public void inputProductSearch(String product) {
		mainpage.inputSearch.sendKeys(product);
		driver.findElement(By.cssSelector("#app>div")).click();
		makeScreenShot();
	}

	@Step("Активирован чекбокс 'Только с фотографией'")
	@И("активирован чекбокс только с фотографией")
	public void checkboxWithImage() {
		if (mainpage.checkboxWithImage.isSelected() == false) {
			mainpage.checkboxWithImage.click();
		}
		makeScreenShot();
	}

	@Step("Клик по выбору локации")
	@Тогда("кликнуть по выпадаещему списка региона")
	public void clickChoiceLocation() {
		mainpage.choiceLocation.click();
		makeScreenShot();
	}

	@Step("Ввод названия локации")
	@Тогда("в поле регион введено значение {string}")
	public void inputLocationSearch(String location) {
		mainpage.inputCity.sendKeys(location);
		mainpage.choiceLocationCity.click();
		makeScreenShot();
	}

	@Step("Нажата кнопка показать объявления")
	@И("нажата кнопка показать объявления")
	public void clickButtonShowADS() {
		mainpage.clickLocationButton.click();
		makeScreenShot();
	}

	@Step("Открылась страница результаты по запросу")
	@Тогда("открылась страница результаты по запросу принтер")
	public void openPageResultsSearch() {
		mainpage.clickSearchFormButton.click();
		makeScreenShot();
	}

	@Step("В выпадающем списке сортировка выбрано значение")
	@И("в выпадающем списке сортировка быбрано значение {sortingMode}")
	public void setSorningMode(SortingMode sort) {
		mainpage.selectSorting = new Select(driver.findElement(By.xpath("//div[contains(@class,'index-topPanel')]//child::select")));
		mainpage.selectSorting.selectByVisibleText(sort.getTitle());
		makeScreenShot();
	}

	@Step("В консоль выведено значение названия и цены первых товаров")
	@И("в консоль выведено значение названия и цены {int} первых товаров")
	public void printFindGoods(int productNum) {
		for (int i = 0; i < productNum; i++) {
			System.out.println(mainpage.titleProduct.get(i).getText());
			System.out.println(mainpage.priceProduct.get(i).getText());
			Allure.addAttachment("Товар " + (i + 1), mainpage.titleProduct.get(i).getText());
			Allure.addAttachment("Цена " + (i + 1), mainpage.priceProduct.get(i).getText());
		}

		makeScreenShot();
		driver.quit();
	}

	public void makeScreenShot() {
		Allure.addAttachment("Скриншот",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
	}

	@ParameterType(".*")
	public CategorySearch category(String cat) {
		return CategorySearch.valueOf(cat);
	}

	@ParameterType(".*")
	public SortingMode sortingMode(String sort) {
		return SortingMode.valueOf(sort);
	}
}


