package com.coupang.marketplace.client.sample.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Read vendor.properties file with vendor-defined properties when calling OpenAPIs
 */
public class VendorConfig {
    private final static String VENDOR_CONFIG_PATH = "/config/vendor.properties";
    private final Properties properties = new Properties();

    public VendorConfig() {
        this(VENDOR_CONFIG_PATH);
    }

    public VendorConfig(String path) {
        try (InputStream input = getClass().getResourceAsStream(path)) {
            properties.load(input);
        } catch (IOException ioe) {
            System.err.println("Error when reading vendor.properties file! " + VENDOR_CONFIG_PATH );
            ioe.printStackTrace();
        }
    }

    // get vendor-defined property value
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
