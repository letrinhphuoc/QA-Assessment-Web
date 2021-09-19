package web;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import web.capability.*;
import web.drivermanager.*;
import web.drivermanager.selector.DriverSelector;
import web.drivermanager.selector.WebDriverSelector;

import static web.drivermanager.Constants.*;

@Singleton
public class WebModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(Capability.class).annotatedWith(Names.named("web.cli-args")).to(CliArgumentsCapability.class).in(Scopes.SINGLETON);
        bind(Capability.class).annotatedWith(Names.named("web.properties")).to(PropertiesFileCapability.class).in(Scopes.SINGLETON);

        bind(CapabilityService.class).annotatedWith(Names.named("web")).to(WebCapabilityService.class).in(Scopes.SINGLETON);
        bind(PageFactory.class).to(DefaultPageFactory.class);
        bind(DriverManager.class).toProvider(WebDriverProvider.class).in(Scopes.SINGLETON);
        bind(DriverSelector.class).annotatedWith(Names.named("web")).to(WebDriverSelector.class).in(Scopes.SINGLETON);

        bind(DriverManager.class).annotatedWith(Names.named(DRIVER_TYPE_CHROME)).to(ChromeDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(DRIVER_TYPE_FIREFOX)).to(FirefoxDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(DRIVER_TYPE_SAFARI)).to(SafariDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(DRIVER_TYPE_EDGE)).to(ChromeDriverManager.class).in(Scopes.SINGLETON);

        bind(DriverManager.class).annotatedWith(Names.named(ENV_LOCAL + DOT + DRIVER_TYPE_CHROME)).to(ChromeDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(ENV_LOCAL + DOT + DRIVER_TYPE_FIREFOX)).to(FirefoxDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(ENV_LOCAL + DOT + DRIVER_TYPE_SAFARI)).to(SafariDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named(ENV_LOCAL + DOT + DRIVER_TYPE_EDGE)).to(ChromeDriverManager.class).in(Scopes.SINGLETON);

    }

}
