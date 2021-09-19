package web;

import com.google.inject.Inject;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import web.drivermanager.DriverManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

/**
 * The base class for all pages.
 */
public abstract class BaseWebPage<TPage extends BaseWebPage> {

    /**
     * url
     */
    public String url;

    protected WebDriver driver; // DriverManager must be injected and initialized first

    @Inject
    public void initElements(DriverManager manager) {
        driver = manager.getDriver();
        ElementFactory.initElements(driver, this);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public TPage open() throws InterruptedException {
        if (url != null)
            return open(url);
        return null;
    }

    /**
     * open page with a specific url
     */
    @SuppressWarnings("unchecked")
    public TPage open(String url) throws InterruptedException {
        driver.get(url);
        jsWaitForPageToLoad(30);
        driver.manage().window().maximize();
        return (TPage) this;
    }

    /**
     * When overridden in subclasses, releases all resources being used by the page if necessary.
     */
    public TPage close() {
        driver.close();
        driver = null;
        return (TPage) this;
    }


    /**
     * getTitle
     *
     * @return title of page
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void actionSendKeys(String keys) {
        Actions actions = new Actions(driver);
        String[] arr = keys.split("");
        for (String key : arr) {
            actions.sendKeys(key).build().perform();
        }
    }

    public String getTextByJs(String jsStr) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        return (String) executor.executeScript(jsStr);
    }

    public String readTextFromImage(WebElement element) throws Exception {
        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath("/Users/mb048/baemin-autoqa/example-testrail-integration/tessdata/");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long currentTime = timestamp.getTime();
        File calculatorFullImage = new File("target/screenshots/" + currentTime + "Calculator.png");
        FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), calculatorFullImage);
        BufferedImage buffImg = ImageIO.read(calculatorFullImage);
        BufferedImage calculatorCropImage = buffImg.getSubimage(409, 33, 158, 93);
        File croppedImgFile = new File("target/screenshots/" + currentTime + "CalculatorCrop.png");
        ImageIO.write(calculatorCropImage, "png", croppedImgFile);
        File testFile = new File(croppedImgFile.getAbsolutePath());
        String value = iTesseract.doOCR(testFile).replaceAll("[\\r\\n\\|]+", "").replace(" ", "");
        System.out.println(value);
        return value;
    }

    public void jsWaitForPageToLoad(int timeOutInSeconds) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsCommand = "return document.readyState";
        if (js.executeScript(jsCommand).toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < timeOutInSeconds; i++) {
            Thread.sleep(3000);
            if (js.executeScript(jsCommand).toString().equals("complete")) {
                break;
            }
        }
    }

}
