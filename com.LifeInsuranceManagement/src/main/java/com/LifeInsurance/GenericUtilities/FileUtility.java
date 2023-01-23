package com.LifeInsurance.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	
	public String getPropertyData(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}	
}
