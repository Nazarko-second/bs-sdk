package logging;

import ch.qos.logback.core.PropertyDefinerBase;

import java.io.File;


public class LogbackPropertyDefiner extends PropertyDefinerBase {

    final String OUTPUT_DIRECTORY = System.getProperty("user.dir") + File.separator + "target" + File.separator + System.nanoTime();
    @Override
    public String getPropertyValue() {
        return OUTPUT_DIRECTORY;
    }
}
