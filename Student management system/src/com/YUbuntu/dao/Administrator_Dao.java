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
	 * @Title The login function.
	 * @Description Get information from MySQL database
	 * @param The information of user of administrator
	 * @return Table_Administrator
	 * @date Dec 26, 2018-7:27:41 PM
	 * @throws no
	 *
	 */
	Table_Administrator Login_Administrator(Table_Administrator data);
	
	/**
	 * 
	 * @Title The function of modifying password.
	 * @Description Change user pasword by update the information of MySQL database.
	 * @param  The information of administrator and new password
	 * @return String
	 * @date Dec 26, 2018-7:31:07 PM
	 * @throws no
	 *
	 */
	String ChangePassword(Table_Administrator table_Administrator, String newPassword);	
}
