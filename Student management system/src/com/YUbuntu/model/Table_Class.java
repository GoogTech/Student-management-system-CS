package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description The class information
 * @Author #YUbuntu
 * @Date December 2,2018
 * @version 1.0
 * 
 */
public class Table_Class
{
	private String _CLASS_ID;
	private String _CLASS_NAME;
	private String _CLASS_Introduce;

	public String get_CLASS_ID()
	{
		return _CLASS_ID;
	}

	public void set_CLASS_ID(String classID)
	{
		this._CLASS_ID = classID;
	}

	public String get_CLASS_NAME()
	{
		return _CLASS_NAME;
	}

	public void set_CLASS_NAME(String _CLASS_NAME)
	{
		this._CLASS_NAME = _CLASS_NAME;
	}

	public String get_CLASS_Introduce()
	{
		return _CLASS_Introduce;
	}

	public void set_CLASS_Introduce(String _CLASS_Introduce)
	{
		this._CLASS_Introduce = _CLASS_Introduce;
	}

	/* 
	 *  Position : com.YUbuntu.view.AddStudent_JFrame
	 *  
	 *  addItem();
	 * --------------------------------------------------------------------------------------------------------------------
	 *	Warning:Focus and keyboard navigation problems may arise if you add duplicate String objects. 					  |
	 *  A workaround is to add new objects instead of String objects and make sure that the toString() method is defined. |
	 * --------------------------------------------------------------------------------------------------------------------
	 */
	@Override
	public String toString()
	{
		return this._CLASS_NAME;
	}
}
