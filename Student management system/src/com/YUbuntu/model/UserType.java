package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description Implementation of login-in logic.
 * @Author #YUbuntu
 * @Date November 30,2018
 * @version 1.0
 */
public enum UserType
{
	Adminstrator("Administrator", 0), Teacher("Teacher", 1), Student("Student", 2);

	private String name;
	private int index;

	/*------------------------------------
	 * The structure of enumeration type |
	 *------------------------------------
	 */
	private UserType(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	@Override


	/**
	 * Return the type name of the user,not the address value
	 */
	public String toString()
	{
		return this.name();
	}
}
