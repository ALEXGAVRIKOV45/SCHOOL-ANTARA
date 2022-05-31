import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverListener {
	private static Logger logger = LoggerFactory.getLogger(CustomLogger.class);

//	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//		Allure.addAttachment("Скриншот",
//				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
//
//
////		logger.info(("Ищем элемент по локатору " + locator.toString()));
////		Allure.step("Ищем элемент по локатору " + locator);
//	}

//	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
//		Allure.addAttachment("Скриншот",
//				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
//		}

//	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
//		Allure.addAttachment("Скриншот",
//				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
//
//	}

		public void beforeQuit(WebDriver driver) {
		Allure.addAttachment("Итоговый скриншот",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));

	}
}
