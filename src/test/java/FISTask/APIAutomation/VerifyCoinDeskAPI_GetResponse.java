package FISTask.APIAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCoinDeskAPI_GetResponse {


		@Test
	    public void verifyBPIData() {
			
	        // Step 1: Send the GET request
	        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
	        Response response = RestAssured.get(url);

	        // Check if the request was successful
	        Assert.assertEquals(response.getStatusCode(), 200, "Failed to retrieve data. Status code is not 200.");

	        // Parse the JSON response
	        JsonPath jsonPath = response.jsonPath();

	        // Step 2: Verify the response contains the required data
	        // a. Verify there are 3 BPIs: USD, GBP, EUR
	        Assert.assertTrue(jsonPath.getMap("bpi").keySet().containsAll(java.util.Arrays.asList("USD", "GBP", "EUR")),
	                "Expected BPIs (USD, GBP, EUR) are not present.");

	        // b. Verify the GBP 'description' equals 'British Pound Sterling'
	        String gbpDescription = jsonPath.getString("bpi.GBP.description");
	        Assert.assertEquals(gbpDescription, "British Pound Sterling",
	                "GBP description is not 'British Pound Sterling'.");
	    }

	

}
