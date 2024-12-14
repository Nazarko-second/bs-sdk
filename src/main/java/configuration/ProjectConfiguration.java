package configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.util.Properties;


public class ProjectConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectConfiguration.class);
    static public String CONFIG_FILE = System.getProperty("config");
    static String PROPERTIES_FILE = "src/test/automation/config/" + ((CONFIG_FILE == null) ? "default" : CONFIG_FILE) + ".properties";
    static public ThreadLocal<Properties> threadProperties = new ThreadLocal<Properties>();
    static private Properties localProps;

    static {
        localProps = loadProperties();
    }

    public static Properties loadProperties() {
        String caller = new Throwable().getStackTrace()[2].getMethodName();
        LOGGER.info("loadProperties() called by: " + caller);
//        LOGGER.info("loadProperties() in ProjectConfiguration");
        LOGGER.info("CONFIG_DATA in Project Configuration");
        LOGGER.info("Property file: {}", PROPERTIES_FILE);
        LOGGER.info("qTest integration: {}", System.getProperty("qTest"));
        LOGGER.info("Config: {}", System.getProperty("config"));
        LOGGER.info("Groups: {}", System.getProperty("groups"));
        LOGGER.info("browserstack.config: {}", System.getProperty("browserstack.config"));

        Properties props = new Properties();

        try {
            FileInputStream fileInput = new FileInputStream(PROPERTIES_FILE);
            props = new Properties();
            props.load(fileInput);
            fileInput.close();
        } catch (Exception e) {
            LOGGER.info("Config was not found");
        }

        return props;
    }

    public static String getConfigProperty(String fieldName) {
        String caller = new Throwable().getStackTrace()[2].getMethodName();
        LOGGER.info("getConfigProperty() called by: " + caller);
        LOGGER.info("getConfigProperty() in ProjectConfiguration: " + fieldName);
        String result = null;

        if (System.getProperty(fieldName) != null)
            return System.getProperty(fieldName);

        if (localProps.getProperty(fieldName) != null)
            return localProps.getProperty(fieldName);

        if (threadProperties.get() != null && threadProperties.get().getProperty(fieldName) != null)
            return threadProperties.get().getProperty(fieldName);

        return result;
    }

    public static boolean isPropertySet(String property) {
        LOGGER.info("isPropertySet() in ProjectConfiguration");
        String valueFromProperties = getConfigProperty(property);
        if (valueFromProperties != null)
            return Boolean.parseBoolean(valueFromProperties);
        return false;
    }

}

