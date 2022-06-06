import io.qameta.allure.Allure;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverListener {
	private static Logger logger = LoggerFactory.getLogger(CustomLogger.class);

	public void beforeQuit(WebDriver driver) {
		Allure.addAttachment("Итоговый скриншот",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
	}
}
