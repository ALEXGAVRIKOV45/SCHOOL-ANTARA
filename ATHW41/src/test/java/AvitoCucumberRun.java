import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "StepDefs", tags = "@AvitoTest")

public class AvitoCucumberRun {
	@org.junit.Test
	public static void run(String[] args) {

	}

}


