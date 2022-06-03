package StepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


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

	@FindBy(xpath = "//span[contains(@class, 'checkbox') and .='только с фото']")
	public WebElement checkboxWithImage;

	@FindBy(xpath = "//button[@data-marker='search-form/submit-button']")
	public WebElement clickSearchFormButton;

	public SiteAvitoMainPage(WebDriver driver) {
		super(driver);

	}
}

