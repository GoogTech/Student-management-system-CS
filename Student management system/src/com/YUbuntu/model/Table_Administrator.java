package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description The information of user of administrator
 * @Author #YUbuntu
 * @Date December 30,2018
 * @version 1.0
 */
public class Table_Administrator
{
	private int id;
	private String name;
	private String password;
	private String birthday;
	private String Telephone_number;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getTelephone_number()
	{
		return Telephone_number;
	}

	public void setTelephone_number(String telephone_number)
	{
		Telephone_number = telephone_number;
	}

}
