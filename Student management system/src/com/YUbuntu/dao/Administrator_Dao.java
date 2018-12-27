package com.YUbuntu.dao;

import com.YUbuntu.model.Table_Administrator;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The ability of an administrator to manipulate a database.
 * @Author #YUbuntu
 * @Date Dec 26, 2018-7:22:51 PM
 * @version 1.0
 */
public interface Administrator_Dao
{
	/**
	 * 
	 * @Title Check
	 * @Description Select information from MySQL database
	 * @param The information of administrator
	 * @return Table_Administrator
	 * @date Dec 26, 2018-7:27:41 PM
	 * @throws no
	 *
	 */
	Table_Administrator Login_Administrator(Table_Administrator data);
	
	/**
	 * 
	 * @Title Update
	 * @Description Update user information from database.
	 * @param  The information of administrator
	 * @return String
	 * @date Dec 26, 2018-7:31:07 PM
	 * @throws no
	 *
	 */
	String ChangePassword(Table_Administrator table_Administrator, String newPassword);	
}
