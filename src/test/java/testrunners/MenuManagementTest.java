package testrunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/linkedinlearning/cucumbercourse/features"},
        glue = {"stepdefinitions", "hooks"},
        //tags = {"@ScenarioOutlineExample"}, //{"@SmokeTest or @NightlyBuildTest"}, //{"not @NightlyBuildTest"}, // {"@SmokeTest or @RegularTest and @NightlyBuildTest"},
        plugin = {"pretty", "html:target/systemTestReports/html",
                "json:target/systemTestReports/json/report.json",
                "junit:target/systemTestReports/junit/report.xml"
        }
)
public class MenuManagementTest {
}
