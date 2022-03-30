package gov.di_ipv_core.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static String getOrchestratorUrl (){

        String orchestratorStubUrl = System.getenv("ORCHESTRATOR_STUB_URL");
        if (orchestratorStubUrl==null){
            throw new IllegalArgumentException("Environment variable ORCHESTRATOR_STUB_URL is not set");
        }
        return orchestratorStubUrl;
    }


}