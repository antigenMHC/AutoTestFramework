package cn.antigenmhc.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {

	public static String getProp(String filename, String folder, String propName) throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("./target/classes/" + folder + "/" + filename + ".properties"));
		return props.getProperty(propName);
	}
}