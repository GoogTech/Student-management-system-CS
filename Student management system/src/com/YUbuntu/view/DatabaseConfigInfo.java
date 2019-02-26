package com.YUbuntu.view;


/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description Stores configuration information about connecting to the database.
 * @Author HuangYuhui
 * @Date Feb 26, 2019-6:30:18 PM
 * @version 2.1
 */
public class DatabaseConfigInfo
{
	private String Url;
	private String UserName;
	private String UserPassword;
	private String DriverName;
	
	public String getUrl()
	{
		return Url;
	}
	public void setUrl(String url)
	{
		Url = url;
	}
	public String getUserName()
	{
		return UserName;
	}
	public void setUserName(String userName)
	{
		UserName = userName;
	}
	public String getUserPassword()
	{
		return UserPassword;
	}
	public void setUserPassword(String userPassword)
	{
		UserPassword = userPassword;
	}
	public String getDriverName()
	{
		return DriverName;
	}
	public void setDriverName(String driverName)
	{
		DriverName = driverName;
	}
	
	
}
