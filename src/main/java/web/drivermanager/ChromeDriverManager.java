package web.drivermanager;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.capability.Capability;
import web.capability.CapabilityService;

public class ChromeDriverManager extends DriverManager {
    @Inject
    @Named("web")
    private CapabilityService service;
    protected static String KEY_CHROME = "webdriver.chrome.driver";

    @Override
    public WebDriver initDriver() {
        Capability caps = service.getCapability();
        System.setProperty(KEY_CHROME, (String) caps.get(Constants.CAPABILITY_DRIVER_PATH));
        driver.set(new ChromeDriver(new MutableCapabilities(caps.getCapabilities())));
        return getDriver();
    }
}
