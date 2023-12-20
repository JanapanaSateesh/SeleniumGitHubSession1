package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties pro;
	
	
	
	public ReadConfig() throws IOException {
		File f=new File("./Configuration/config.properties");
		pro=new Properties();
		FileInputStream fi=new FileInputStream(f);
		pro.load(fi);

	}
	
	public String url() {
		String url=pro.getProperty("url");
		return url;
	}
	
	public String uname() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String pwd() {
		String password= pro.getProperty("password");
		return password;
	}
}
