package web.capability;

import web.drivermanager.Constants;
import web.properties.PropertiesLoader;

public class PropertiesFileCapability extends Capability {
    @Override
    public Capability load() {
        String propertyFile = System.getProperty("config.web");
        if (propertyFile == null || propertyFile.isEmpty()) {
            propertyFile = Constants.WEB_CONFIG_FILE;
        }
        caps = PropertiesLoader.getMap(propertyFile);
        return this;
    }
}
