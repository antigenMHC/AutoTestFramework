package cn.antigenmhc.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	/**
	 * 根据文件名称、属性名获取相应属性值
	 */
	public static String getProp(String filename, String propName) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("./target/classes/properties/"+filename+".properties"));
		return props.getProperty(propName);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getProp("test", "test"));
    }
}