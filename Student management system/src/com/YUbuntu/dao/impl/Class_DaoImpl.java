package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.Class_Dao;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.util.JDBCUtil;
import com.YUbuntu.util.StringUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The operation of an class management on a database
 * @Author #YUbuntu
 * @Date December 2,2018
 * @version 1.0
 */
public class Class_DaoImpl extends BasicDao implements Class_Dao
{
	/**
	 * 
	 * @Title Insert specified data into MySQL database
	 * @Description Add the new class information to MySQL database
	 * @param The information of class
	 * @return boolean (Determine whether add the new class information operation is successful.)
	 * @date December 3,2018
	 *
	 */
	public boolean addClass(Table_Class table_Class)
	{
		PreparedStatement preparedStatement = null;
		String SQL_addClass = "INSERT INTO Table_Class VALUES (?,?,?)";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_addClass);
			preparedStatement.setString(1, table_Class.get_CLASS_ID());
			preparedStatement.setString(2, table_Class.get_CLASS_NAME());
			preparedStatement.setString(3, table_Class.get_CLASS_Introduce());
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to add the new class information to MySQL database !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	/**
	 * 
	 * @Title Select specified data from MySQL database
	 * @Description Operate class information.
	 * @param The class information
	 * @return List<Table_Class> (A collection object that stores class information)
	 * @date December 3,2018
	 *
	 */
	public List<Table_Class> getClassList(Table_Class table_Class)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Table_Class> list = new ArrayList<Table_Class>();

		/*
		 * Default: displays all class information
		 */
		String SQL_GetClassInformation = "SELECT * FROM Table_Class";

		/*-----------------------------------------------------------------------
		 * get_CLASS_NAME() : Get  it from the information entered by the user. |
		 * ----------------------------------------------------------------------
		 */
		if (!StringUtil.IsEmpty(table_Class.get_CLASS_NAME()))// If 'get_CLASS_NAME' is null ！！> false (Not execute)
		{
			SQL_GetClassInformation += " WHERE CLASS_NAME LIKE '%" + table_Class.get_CLASS_NAME() + "%' ";
		}

		try
		{
			preparedStatement = connection.prepareStatement(SQL_GetClassInformation);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_Class table_Class2 = new Table_Class();
				table_Class2.set_CLASS_ID(resultSet.getString("CLASS_ID"));
				table_Class2.set_CLASS_NAME(resultSet.getString("CLASS_NAME"));
				table_Class2.set_CLASS_Introduce(resultSet.getString("CLASS_Introduce"));

				list.add(table_Class2);
			}

		} catch (SQLException e)
		{
			System.err.println("ERROR : Failed to read class information in MySQL database!\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return list;
	}

	/**
	 * 
	 * @Title Delete specified data from MySQL database
	 * @Description Deletes class information with the specified class ID.
	 * @param The class ID
	 * @return boolean
	 * @date December 3,2018
	 *
	 */
	public boolean Delete_ClassInformation(String clASS_ID)
	{
		PreparedStatement preparedStatement = null;
		String SQL_Delete_ClassInformation = "DELETE FROM TABLE_CLASS WHERE CLASS_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Delete_ClassInformation);
			preparedStatement.setString(1, clASS_ID);

			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR :Fail to delete class information with the specified number(Class ID) !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	/**
	 * 
	 * @Title Update specified data from MySQL database
	 * @Description Update class information with the specified Class ID
	 * @param The class inforamtion
	 * @return boolean
	 * @date December 4,2018
	 *
	 */
	public boolean Update_ClassInformation(Table_Class table_Class)
	{
		PreparedStatement preparedStatement = null;

		/*
		 * ERROR : Data truncation: Truncated incorrect DOUBLE value: xxx.. 
		 * Soultion : Change and to : ',' ！！！！！！> https://stackoverflow.com/questions/3456258/mysql-truncated-incorrect-double-value
		 */
		String SQL_Update_ClassInformation = "UPDATE TABLE_CLASS SET CLASS_NAME = ? , CLASS_Introduce = ? WHERE CLASS_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Update_ClassInformation);
			preparedStatement.setString(1, table_Class.get_CLASS_NAME());
			preparedStatement.setString(2, table_Class.get_CLASS_Introduce());
			preparedStatement.setString(3, table_Class.get_CLASS_ID());
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to update class information with the specified number(Class ID) !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
}
