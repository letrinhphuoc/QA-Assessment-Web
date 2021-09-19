package cucumber.xendit;

import web.BaseWebPage;
import web.annotations.FindElement;
import web.element.Element;
import web.element.WaitStrategy;
import web.element.WebLocatorType;

public class CalculatorHomePage extends BaseWebPage<CalculatorHomePage> {
    @FindElement(type = WebLocatorType.ID, value = "fullframe", waitUntil = WaitStrategy.VISIBILITY)
    private Element calculatorIframe;

    @FindElement(type = WebLocatorType.ID, value = "canvas",waitUntil = WaitStrategy.VISIBILITY)
    private Element canvas;


    public void switchToCalculatorIframe(){
        switchToFrame(calculatorIframe.getElement());
    }
    public String getActualResult() throws Exception {
        return readTextFromImage(canvas.getElement());
    }
}
