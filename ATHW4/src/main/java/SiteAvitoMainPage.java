import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.openqa.selenium.OutputType.BYTES;


public class SiteAvitoMainPage extends BaseView {

	@FindBy(xpath = "//select[@name='category_id']")
	public Select categoryID = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));

	@FindBy(xpath = "//input[@type='text' and @data-marker='search-form/suggest']")
	public WebElement inputSearch;

	@FindBy(xpath = "//div[@class='main-text-_Thor']")
	public WebElement choiceLocation;

	@FindBy(xpath = "//input[@data-marker='popup-location/region/input']")
	public WebElement inputCity;

	@FindBy(xpath = "//span[@class='suggest-suggest_content-_LYs8']//strong[position()=1]")
	public WebElement choiceLocationCity;

	@FindBy(xpath = "//button[@data-marker='popup-location/save-button']")
	public WebElement clickLocationButton;

	@FindBy(xpath = "//span[@data-marker='delivery-filter/text']")
	public WebElement checkBoxAvitoDelivery;

	@FindBy(xpath = "//button[@data-marker='search-filters/submit-button']")
	public WebElement clickButtonShowAds;


	@FindBy(xpath = "//div[contains(@class,'index-topPanel')]//child::select")
	public Select selectSorting;

	@FindBy(xpath = "//div[@data-marker='catalog-serp']//h3[@itemprop='name']")
	public List<WebElement> titleProduct;

	@FindBy(xpath = "//div[starts-with(@class,'iva-item-priceStep')]")
	public List<WebElement> priceProduct;


	public void makeScreenShot() {
		Allure.addAttachment("Скриншот",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));

	}

	@Step("Выбор категории поиска")
	public SiteAvitoMainPage setCategoryID(String category) {
		categoryID.selectByVisibleText(category);
		makeScreenShot();
		return this;
	}

	@Step("Ввод текста в стрку поиска")
	public SiteAvitoMainPage setInputSearch(String inputSearchText) {
		inputSearch.sendKeys(inputSearchText);
		makeScreenShot();
		return this;
	}

	@Step("Клик по выбору локации")
	public SiteAvitoMainPage setLocationSearch() {
		choiceLocation.click();
		makeScreenShot();
		return this;
	}

	@Step("Ввод названия локации")
	public SiteAvitoMainPage setInputCity(String Location) {
		inputCity.sendKeys(Location);
		makeScreenShot();
		return this;
	}

	@Step("Выбор локации")
	public SiteAvitoMainPage clickInputCity() {
		choiceLocationCity.click();
		makeScreenShot();
		return this;
	}

	@Step("Клин по кнопке 'Показать объявления' локации")
	public SiteAvitoMainPage clickButtonShow() {
		clickLocationButton.click();
		makeScreenShot();
		return this;
	}

	@Step("Если Авито доставка не выбрана то выбрать ее")
	public SiteAvitoMainPage setCheckBoxAvitoDelivery() {
		if (checkBoxAvitoDelivery.isSelected() == false) {
			checkBoxAvitoDelivery.click();
			makeScreenShot();
		}
		return this;
	}

	@Step("Клик по кнопке 'Показать объявления'")
	public SiteAvitoMainPage clickButtonShowAds() {
		clickButtonShowAds.click();
		makeScreenShot();
		return this;
	}

	@Step("Выбор режима сортировки")
	public SiteAvitoMainPage setSelectSorting(String sortingAds) {
		selectSorting = new Select(driver.findElement(By.xpath("//div[contains(@class,'index-topPanel')]//child::select")));
		selectSorting.selectByVisibleText(sortingAds);
		makeScreenShot();
		return this;
	}

	@Step("Печать 3-х самых дорогих принтеров с ценой")
	public SiteAvitoMainPage printTitleProduct() {
		for (int i = 0; i < 3; i++) {
			System.out.println(titleProduct.get(i).getText());
			System.out.println(priceProduct.get(i).getText());
		}
		return this;
	}


	public SiteAvitoMainPage(WebDriver driver) {
		super(driver);

	}
}
