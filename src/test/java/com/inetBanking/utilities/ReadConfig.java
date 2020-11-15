package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig() {
		File src = new File("./Configuration//config.properties");
	try {
		FileInputStream file = new FileInputStream(src);
		p = new Properties();
		p.load(file);
	}
	catch(Exception e) {
		System.out.println("Error is: " + e.getMessage());
	}
	}
	
	public String getUsername() {
		String username = p.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
	public String getBaseUrl() {
		String url = p.getProperty("baseUrl");
		return url;
	}
	public String getChromePath() {
		String chromePath = p.getProperty("chDriver");
		return chromePath;
	}
	public String getFirefoxPath() {
		String firefoxPath = p.getProperty("gcDriver");
		return firefoxPath;
	}
}