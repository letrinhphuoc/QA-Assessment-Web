package cucumber;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import web.drivermanager.DriverManager;
import web.exceptions.TakeScreenshotException;

import java.io.File;
import java.io.IOException;

@Singleton
public class DriverHooks {
    @Inject
    private Injector injector;

    private WebDriver webDriver;
    private DriverManager manager;

    public void initWeb() {
        manager = injector.getInstance(DriverManager.class);
        webDriver = manager.getDriver();
    }

    public void takeScreenshotWeb(String image) {
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(image);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new TakeScreenshotException("There's a problem during take screenshot", e.getCause());
        }
    }

    public void closeWebDriver() {
        webDriver.quit();
    }


}
