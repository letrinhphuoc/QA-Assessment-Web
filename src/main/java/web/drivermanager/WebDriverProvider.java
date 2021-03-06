package web.drivermanager;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import web.drivermanager.selector.DriverSelector;

public class WebDriverProvider implements Provider<DriverManager> {

    @Inject
    @Named("web")
    private DriverSelector selector;

    @Inject
    private Injector injector;

    @Override
    public DriverManager get() {
        return injector.getInstance(Key.get(DriverManager.class, Names.named(selector.get())));
    }
}
