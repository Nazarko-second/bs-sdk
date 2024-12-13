package datasources;

import configuration.ProjectConfiguration;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;


public class FileManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileManager.class);

    public static String OUTPUT_DIR = getOutputDir();

    public static String getOutputDir() {
        String directory = System.getProperty("user.dir") + File.separator + "target" + File.separator + (ProjectConfiguration.isPropertySet("Jenkins") ? "report" : System.nanoTime());
        System.setProperty("OUTPUT_DIR", directory);
        //create output dir
        try {
            FileUtils.forceMkdir(new File(directory));
        } catch (IOException e) {
            LOGGER.error("Fail create DIR" + e);
            return null;
        }
        return directory;
    }

}

