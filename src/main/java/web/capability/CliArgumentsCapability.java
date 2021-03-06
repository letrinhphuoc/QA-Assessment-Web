package web.capability;

import web.drivermanager.Constants;

import java.util.List;

public class CliArgumentsCapability extends Capability {
    private String prefix = Constants.CLI_PARAMETER_PREFIX_WEB;
    private List<String> listArgs = Constants.cliParameters;

    @Override
    public Capability load() {
        for (String key : listArgs) {
            String value = System.getProperty(prefix + key);
            if (value != null && !value.isEmpty()) {
                caps.put(key, value);
            }
        }
        return this;
    }
}
