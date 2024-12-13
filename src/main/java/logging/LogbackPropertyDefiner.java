package logging;

import ch.qos.logback.core.PropertyDefinerBase;
import datasources.FileManager;


public class LogbackPropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return FileManager.OUTPUT_DIR;
    }
}
