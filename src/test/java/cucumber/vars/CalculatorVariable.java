package cucumber.vars;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class CalculatorVariable {
    private String actualResultsGetByTesseract;
    private String actualResultsGetByJs;

    public String getActualResultsGetByTesseract() {
        return actualResultsGetByTesseract;
    }

    public void setActualResultsGetByTesseract(String actualResultsGetByTesseract) {
        this.actualResultsGetByTesseract = actualResultsGetByTesseract;
    }

    public String getActualResultsGetByJs() {
        return actualResultsGetByJs;
    }

    public void setActualResultsGetByJs(String actualResultsGetByJs) {
        this.actualResultsGetByJs = actualResultsGetByJs;
    }
}
