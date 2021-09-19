package cucumber.xendit;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.DriverHooks;
import cucumber.Hooks;
import cucumber.vars.CalculatorVariable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class CalculatorSteps {

    @Inject
    private CalculatorPageObject calculatorPageObject;

    @Inject
    private CalculatorHomePage calculatorHomePage;

    @Inject
    private DriverHooks driver;

    @Inject
    private Hooks hooks;

    @Inject
    CalculatorVariable calculatorVariable;

    @Given("Open chrome browser and start application")
    public void openChromeBrowserAndStartApplication() throws InterruptedException {
        calculatorPageObject.openPage("https://www.online-calculator.com/full-screen-calculator/");
    }

    @When("I enter following values and press CE button$")
    public void iEnterFollowingValuesAndPressCEButton(DataTable table) throws Exception {
        List<List<String>> rows = table.asLists(String.class);
        String value1 = rows.get(0).get(1);
        String value2 = rows.get(1).get(1);
        String operator = rows.get(2).get(1);
        calculatorHomePage.switchToCalculatorIframe();
        calculatorHomePage.actionSendKeys(value1);
        calculatorHomePage.actionSendKeys(operator);
        calculatorHomePage.actionSendKeys(value2);
        calculatorHomePage.actionSendKeys("=");
//        calculatorVariable.setActualResultsGetByTesseract(calculatorHomePage.getActualResult()); {Tesseract unstable}
        calculatorVariable.setActualResultsGetByJs(calculatorHomePage.getTextByJs("return exportRoot.showscreen_txt.text;"));
        calculatorHomePage.actionSendKeys("C");
    }

    @Then("I should be able to see (.*)$")
    public void iShouldBeAbleToSeeExpected(String expected) {
//        String valueFromTesseract = calculatorVariable.getActualResultsGetByTesseract();
        String valueFromJs = calculatorVariable.getActualResultsGetByJs();
//        Assert.assertEquals(valueFromTesseract, expected);
        Assert.assertEquals(valueFromJs, expected);
    }
}
