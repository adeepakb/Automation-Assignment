package org.example.constant;

import org.example.util.CommonUtils;




/** The Constants are saved here*/
public class Constants {

    private static String time = CommonUtils.now();


    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

    public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult_"+time+"_.html";

    public final static String PROJECT_NAME = "Automation Project";

    public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

    public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";

    public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
}
