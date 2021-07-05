package codes;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(features = "src/test/resources/Features", glue = { "codes" }, monochrome = true,plugin = {"pretty", "html:target/Destination.html"} )

	public class RunnerClass extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
}
