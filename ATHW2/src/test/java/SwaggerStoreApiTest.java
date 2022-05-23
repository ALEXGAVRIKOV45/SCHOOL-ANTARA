import com.google.gson.JsonObject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

import static com.google.gson.JsonParser.parseString;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class SwaggerStoreApiTest {


	private static String jsonsGetter(String path, String regex) {
		String jsons = "";
		File[] files = new File(path).listFiles(
				(dir, name) -> Pattern.compile(regex).matcher(name).find());
		JsonObject json;
		String petString;
		File file = files[0];
		System.out.println("file is: " + file);
		try {
			petString = new String(Files.readAllBytes(file.toPath()));
			json = parseString(petString).getAsJsonObject();
			jsons = (json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsons;
	}

	@Test
	void postStoreOrder() {
		String storeJson = String.valueOf(jsonsGetter("src/main/resources/", "store_post.json"));

		given().contentType("application/json").body(storeJson).
				when().log().body().post("https://petstore.swagger.io/v2/store/order").
				then().log().body().assertThat().statusCode(HttpStatus.SC_OK).body(equalTo(storeJson));
	}

	@Test
	void getStoreOrderId() {
		int storeID = 56;
		String petJson = String.valueOf(jsonsGetter("src/main/resources/", "store_post.json"));

		given().contentType("application/json").
				when().log().body().get("https://petstore.swagger.io/v2/store/order/" + storeID).
				then().log().body().assertThat().statusCode(HttpStatus.SC_OK).body(equalTo(petJson));
	}

	@Test
	void storeDeleteOrderId() {
		int storeID = 56;
		when().delete("https://petstore.swagger.io/v2/store/order/" + storeID)
				.then().log().body().assertThat().statusCode(200);
	}

	@Test
	void storeGetInventory() {

		when().get("https://petstore.swagger.io/v2/store/inventory")
				.then().log().body().assertThat().statusCode(200);
	}
}
