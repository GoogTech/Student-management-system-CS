package com.YUbuntu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.YUbuntu.view.DatabaseConfigInfo;

/**
 *
 * @Project Student management system
 * @Package com.YUbuntu.util
 * @Description Configure about the information for connecting to the database.
 * @Author HuangYuhui
 * @Date Feb 26, 20196:26:59 PM
 * @version 2.1
 */
public class DatabaseConfig
{
	public static DatabaseConfigInfo mailConfigInfo = new DatabaseConfigInfo();
	static
	{
		try
		{
			Properties proper = new Properties();
			proper.load(new FileInputStream("databaseConfig.properties"));

			mailConfigInfo.setUrl(proper.getProperty("Url"));
			mailConfigInfo.setUserName(proper.getProperty("UserName"));
			mailConfigInfo.setUserPassword(proper.getProperty("UserPassword"));
			mailConfigInfo.setDriverName(proper.getProperty("DriverName"));

		} catch (FileNotFoundException e)
		{
			System.err.println("error : not found the specified file: databaseConfig.properties");
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}