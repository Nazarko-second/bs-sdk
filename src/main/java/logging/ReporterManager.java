package logging;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import configuration.ProjectConfiguration;
import configuration.SessionManager;
import datasources.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.lang.reflect.Method;

public class ReporterManager {


    private static ReporterManager instance;
    public static ReporterManager Instance = (instance != null) ? instance : new ReporterManager();


    ReporterManager() {
    }

    private static ExtentReports extent;

    private static final Logger logger = LoggerFactory.getLogger(ReporterManager.class);

    public static String REPORT_FILE_LOCATION = FileManager.OUTPUT_DIR + File.separator + "Report" + (ProjectConfiguration.isPropertySet("Jenkins") ? "" : SessionManager.getSessionID()) + ".html";

    private synchronized static ExtentReports getInstance() {
        if (extent == null) {
            logger.info("Report creation: " + REPORT_FILE_LOCATION);
            extent = new ExtentReports(REPORT_FILE_LOCATION, true, NetworkMode.ONLINE);
        }
        return extent;
    }

    public void startReporting(Method m, Object[] data) {
        logger.info("Started test '" + m.getName() + "'");
        ExtentReports report = getInstance();
    }
}