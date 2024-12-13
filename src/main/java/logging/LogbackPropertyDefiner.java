package logging;

import ch.qos.logback.core.PropertyDefinerBase;
import datasources.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackPropertyDefiner extends PropertyDefinerBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackPropertyDefiner.class);
    public final static ReporterManager reporter = ReporterManager.Instance;
    @Override
    public String getPropertyValue() {
        LOGGER.info("getPropertyValue() in LogbackPropertyDefiner");
        reporter.info("REPORT_MESSAGE");
        return FileManager.OUTPUT_DIR;
    }
}
