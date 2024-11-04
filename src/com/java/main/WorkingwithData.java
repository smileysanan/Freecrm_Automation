package com.java.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class WorkingwithData {

	public static void main(String[] args) throws Exception {
		GetPropertydata("qa");
		GettingTxtData("dev");
	}

	public static void GetPropertydata(String execution) throws Exception {

		String requiredpath = null;
		String ProjectPth = System.getProperty("user.dir");
		System.out.println(" curent projectpath:" + ProjectPth);
		File foLderpath = new File(ProjectPth + "/congfiguration");
		File[] AtualFiles = foLderpath.listFiles();
		for (File ExpectedFile : AtualFiles) {
			System.out.println("all property files:" + ExpectedFile);
			if (ExpectedFile.getName().trim().toLowerCase().contains(execution.trim().toString())) {
				// System.out.println("required propertyfile:" +
				// ExpectedFile.getAbsolutePath());
				requiredpath = ExpectedFile.getAbsolutePath();
				System.out.println(requiredpath);
				break;
			}
		}
		try {
			FileInputStream fis = new FileInputStream(requiredpath);
			Properties pr = new Properties();
			HashMap<String, String> GettingMapDataIntoFile = new HashMap<>();
			pr.load(fis);
			for (String key : pr.stringPropertyNames()) {
				String value = pr.getProperty(key);
				pr.put(key, value);
				// System.out.println("map data:" + pr);
			}
			System.out.println("map data:" + pr);
		} catch (Exception e) {

		}

	}

	public static void GettingTxtData(String env) {

		String requiredTxtfile = null;

		String projectpath = System.getProperty("user.dir");
		System.out.println("current project path :" + projectpath);
		File Txtfiles = new File(projectpath + "/textfiles");
		File[] listfiles = Txtfiles.listFiles();
		for (File curentfile : listfiles) {
			if (curentfile.getName().toLowerCase().toString().contains(env.trim().toString())) {
				requiredTxtfile = curentfile.getAbsolutePath();
				System.out.println(requiredTxtfile);
			}

		}

		try {

			String str;
			FileReader fr = new FileReader(new File(requiredTxtfile));
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {

		}

	}

}
