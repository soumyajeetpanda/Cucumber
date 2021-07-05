package codes;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class Steps {

	final static String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

	@Given("get the response body")
	public void get_the_response_body() {
		RestAssured.given().when().get(url).then().log().all();

		RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php").then()
				.log().body();
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@When("get the response status")
	public void get_the_response_status() {
		int statusCode = RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php")
				.getStatusCode();
		System.out.println("The response status is " + statusCode);

		RestAssured.given().when().get(url).then().assertThat().statusCode(200);
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@When("get the response headers")
	public void get_the_response_headers() {
		System.out.println("The headers in the response " + RestAssured.get(url).then().extract().headers());
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@When("get the response time")
	public void get_the_response_time() {
		System.out.println("The time taken to fetch the response " + RestAssured.get(url).timeIn(TimeUnit.MILLISECONDS)
				+ " milliseconds");
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("get the response content type")
	public void get_the_response_content_type() {
		System.out.println("The content type of response " + RestAssured.get(url).then().extract().contentType());
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

}
