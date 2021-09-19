package cucumber.xendit;

import com.google.inject.Inject;
import cucumber.state.KeywordState;
import web.BaseWebPage;

public class CalculatorPageObject extends BaseWebPage<CalculatorPageObject> {

    @Inject
    private KeywordState state;

    public void openPage(String url) throws InterruptedException {
        open(url);
        state.setState(url);
    }


}
