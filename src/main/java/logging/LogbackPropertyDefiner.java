package logging;

import ch.qos.logback.core.PropertyDefinerBase;
import datasources.FileManager;

import java.io.File;


public class LogbackPropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return FileManager.OUTPUT_DIR;
    }
}
