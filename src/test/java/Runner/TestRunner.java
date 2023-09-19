package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/Badal/Eclipse-Workspace/DeepThought/Features/Registration.feature",
				 glue={"StepDefinations", "Hooks"},
				 publish = true,
				 dryRun = false,
				 monochrome = true,
				 plugin = {"pretty","html:target/cucumber-reports/reports1.html",
									"json:target/cucumber-reports/reports2.json",
									"junit:target/cucumber-reports/reports3.xml"}
                 
				)
public class TestRunner {

}
