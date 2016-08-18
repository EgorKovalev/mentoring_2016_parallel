package webdriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {
    private Properties properties = new Properties();
    protected static Logger logger = Logger.getInstance();

    public PropertiesManager(final String resourceName) {
        properties = getFromResource(properties, resourceName);
    }

    private Properties getFromResource(final Properties objProperties, final String resourceName) {
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inStream != null) {
            try {
                objProperties.load(inStream);
                inStream.close();
            } catch (IOException e) {
                logger.error("File reading error");
            }
        } else {
            logger.error(String.format("Resource \"%1$s\" could not be found", resourceName));
        }
        return objProperties;
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    public String getProperty(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
