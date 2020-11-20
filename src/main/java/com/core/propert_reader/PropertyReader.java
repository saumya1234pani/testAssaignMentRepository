package com.core.propert_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	static Properties prop = null;

	public PropertyReader(Properties prop) throws IOException {
		this.prop = prop;

		String currentDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(currentDir + "//src//main//resources//configuration//config.properties");
		prop.load(fis);
	}
}
