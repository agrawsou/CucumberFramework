package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties initProp() {
		prop = new Properties();

		try {
			FileInputStream fi = new FileInputStream(
					".\\src\\test\\resources\\config\\config.properties");
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
