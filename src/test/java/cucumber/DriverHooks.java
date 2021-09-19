package cucumber;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import web.drivermanager.Constants;
import web.drivermanager.DriverManager;
import web.exceptions.TakeScreenshotException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss.SSS");
        String now = format.format(new Date(System.currentTimeMillis()));
        File destFile = new File(Constants.SCREENSHOT_PATH + "/" + image + now + ".png");
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
