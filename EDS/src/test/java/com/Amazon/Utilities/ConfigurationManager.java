package com.Amazon.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

	private static Properties properties;

	public static Properties initializeProperties() {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("src/test/resources/configuration.properties");
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return getProperties();
	}

	public static Properties getProperties() {
		return properties;
	}

}