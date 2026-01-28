package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/Reports/cucumber-report.json",
                "html:target/cucumber/cucumber.html",
                "junit:target/surefire-reports/cucumber-results.xml"
        },
        glue = { "scenarios.stepDefinitions", "hooks" },
        features = "src/test/java/scenarios/features",
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        // Create report directories before tests run
        createDirectoryIfNotExists("target/Reports");
        createDirectoryIfNotExists("target/cucumber");
        createDirectoryIfNotExists("target/surefire-reports");
    }

    private void createDirectoryIfNotExists(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Created directory: " + path);
            }
        }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}