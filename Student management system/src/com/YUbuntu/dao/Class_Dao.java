package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_Class;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of the class operation database.
 * @Author #YUbuntu
 * @Date Dec 27, 2018-9:07:43 PM
 * @version
 */
public interface Class_Dao
{
	/**
	 * 
	 * @Title Insert
	 * @Description Insert the class information into database.
	 * @param The information of class.
	 * @return boolean
	 * @date Dec 27, 2018-9:11:24 PM
	 * @throws no
	 *
	 */
	boolean addClass(Table_Class table_Class);
	
	/**
	 * 
	 * @Title Select
	 * @Description Select the class information from database.
	 * @param The information of class.
	 * @return List<Table_Class>
	 * @date Dec 27, 2018-9:12:18 PM
	 * @throws no
	 *
	 */
	List<Table_Class> getClassList(Table_Class table_Class);
	
	/**
	 * 
	 * @Title Delete
	 * @Description Deletes class information from database.
	 * @param The information of class.
	 * @return boolean
	 * @date Dec 27, 2018-9:14:24 PM
	 * @throws no
	 *
	 */
	boolean Delete_ClassInformation(String clASS_ID);
	
	/**
	 * 
	 * @Title Update
	 * @Description Update class information from databases.
	 * @param The specified class' ID.
	 * @return boolean
	 * @date Dec 27, 2018-9:15:45 PM
	 * @throws no
	 *
	 */
	boolean Update_ClassInformation(Table_Class table_Class);
}
