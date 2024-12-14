//package configuration;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//
//public class SessionManager {
//    private static final Logger logger = LoggerFactory.getLogger(SessionManager.class);
//
//    private static Properties sessionProperties = new Properties();
//
//    public static String getSessionID() {
//        logger.info("getSessionID() in SessionManager");
//        if(sessionProperties.get("SESSION_ID") == null) {
//            sessionProperties.put("SESSION_ID", getCurDateTime());
//            logger.info("Session ID: " + (String) sessionProperties.get("SESSION_ID"));
//        }
//        return (String) sessionProperties.get("SESSION_ID");
//    }
//
//    public static String getCurDateTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        return sdf.format(new Date(System.currentTimeMillis()));
//    }
//
//}
