package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.Administrator_Dao;
import com.YUbuntu.model.Table_Administrator;
import com.YUbuntu.util.JdbcUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The operation of an administrator on a database.
 * @Author #YUbuntu
 * @Date November 11,2018
 * @version 1.0
 */
public class Administrator_DaoImpl extends BasicDao implements Administrator_Dao
{
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;

	/**
	 * 
	 * @Title The data of Table_Administrator(TABLE)
	 * @Description Get information from MySQL database
	 * @param The information of user of administrator
	 * @return Table_Administrator
	 * @date November 11,2018
	 * @throws SQLException
	 *
	 */
	public Table_Administrator Login_Administrator(Table_Administrator data)
	{
		String SQL_ADMINISTRATOR = "SELECT * FROM Table_Administrator WHERE NAME = ? AND PASSWORD = ?";

		/*
		 * In order to initialize the main interface though the user's personal information.
		 */
		Table_Administrator table_Administrator = null;

		try
		{
			/*
			 * ------------------------------------------------------------------
			 * 'connection' : Inherit the properties of 'BasicDao' 				|
			 * 																	|  
			 *  Pass SQL statements to objects that manipulate the database 	|
			 * ------------------------------------------------------------------
			 */
			preparedStatement = connection.prepareStatement(SQL_ADMINISTRATOR);

			preparedStatement.setString(1, data.getName());
			preparedStatement.setString(2, data.getPassword());
			resultSet = preparedStatement.executeQuery();

			//Store the user information
			if (resultSet.next())
			{
				table_Administrator = new Table_Administrator();
				table_Administrator.setId(resultSet.getInt("ID"));
				table_Administrator.setName(resultSet.getString("NAME"));
				table_Administrator.setPassword(resultSet.getString("PASSWORD"));
				table_Administrator.setBirthday(resultSet.getString("BIRTHDAY"));// ¨t(*¡ã¨Œ¡ã*)¨s ~ DATE !!!
			}
			
		} catch (Exception e)
		{
			System.out.println("ERROR : Fail to get the user information of Administrator from database ! ");
			e.printStackTrace();
		}finally
		{
			JdbcUtil.freeResource(resultSet, preparedStatement, connection);			
		}
		return table_Administrator;// Returns the object of the result of the query
	}

	
	/**
	 * 
	 * @Title Change user password
	 * @Description Change user pasword by update the information of MySQL database.
	 * @param The information of administrator and new password
	 * @return Result as change
	 * @date November 30,2018
	 *
	 */
	public String ChangePassword(Table_Administrator table_Administrator, String newPassword)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String result_ChanggePasswrod = null;
		String SQL_check = "SELECT * FROM Table_Administrator WHERE PASSWORD = ? AND ID = ?";
		String SQL_ChangePassword = "UPDATE Table_Administrator SET PASSWORD = ? WHERE ID = ?";

		try
		{
			// The first step : Check whether the data entered by the user is reasonable
			preparedStatement = connection.prepareStatement(SQL_check);
			preparedStatement.setString(1,table_Administrator.getPassword());
			preparedStatement.setInt(2, table_Administrator.getId());
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next())
			{
				result_ChanggePasswrod = "Warning : the old passwrod is error !";
				JdbcUtil.freeResource(resultSet, preparedStatement, connection);
				return result_ChanggePasswrod;
			}
			
			// The second step : Change the password of user
			preparedStatement = connection.prepareStatement(SQL_ChangePassword);

			preparedStatement.setString(1, newPassword);// The value passed in : The new password
			preparedStatement.setInt(2, table_Administrator.getId());

			int result = preparedStatement.executeUpdate();
			if (result > 0)
			{
				result_ChanggePasswrod = "Success to change the password of user !\n";
			}
			
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to change the user'password ! ");
			e.printStackTrace();
		}finally
		{
			JdbcUtil.freeResource(resultSet, preparedStatement, connection);			
		}
		return result_ChanggePasswrod;
	}
}
