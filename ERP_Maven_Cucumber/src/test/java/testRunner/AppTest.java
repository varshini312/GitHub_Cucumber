package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
features = {"./FeatureFile/StockAccounting.feature"},tags = (" @customer,@suppliers")
,monochrome = true,
glue = {"stockaccountingStepDefination"},
plugin = {"pretty","html:target/report/cucumber"})
public class AppTest extends AbstractTestNGCucumberTests {

}
