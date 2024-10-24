package utilities;

import java.util.Properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PropertyLoader {

	private Properties properties;

    public PropertyLoader() {
        properties = new Properties();
        loadProperties();
    }

    private void  loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties file not found in the classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

	
}
