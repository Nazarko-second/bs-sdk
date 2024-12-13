package logging;

import ch.qos.logback.core.PropertyDefinerBase;
import configuration.ProjectConfiguration;
import datasources.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackPropertyDefiner extends PropertyDefinerBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackPropertyDefiner.class);
    @Override
    public String getPropertyValue() {
        LOGGER.info("getPropertyValue() in LogbackPropertyDefiner");
        return FileManager.OUTPUT_DIR;
    }
}
