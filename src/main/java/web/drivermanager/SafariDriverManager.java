package web.drivermanager;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import web.capability.Capability;
import web.capability.CapabilityService;

public class SafariDriverManager extends DriverManager {

    @Inject
    @Named("web")
    private CapabilityService service;

//    protected static final String KEY_SAFARI = "please add safari driver here";

    @Override
    public WebDriver initDriver() {
        Capability caps = service.getCapability();
//        System.setProperty(KEY_SAFARI, (String) caps.get(Constants.CAPABILITY_DRIVER_PATH));
        driver.set(new SafariDriver(new MutableCapabilities(caps.getCapabilities())));
        return getDriver();
    }

}
