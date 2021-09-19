package cucumber;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Inject
    private DriverHooks driverHooks;

    @Before(value = "@Web")
    public void beforeWebScenario() {
        System.out.println("before web scenario");
        driverHooks.initWeb();
    }

    @After(value = "@Web")
    public void afterWebScenario(Scenario scenario) {
        System.out.println("after web scenario");
        if (scenario.isFailed())
            driverHooks.takeScreenshotWeb(scenario.getName());
        driverHooks.closeWebDriver();
    }
}
