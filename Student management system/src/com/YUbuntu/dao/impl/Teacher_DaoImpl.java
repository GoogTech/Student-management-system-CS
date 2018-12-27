package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.Teacher_Dao;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.JDBCUtil;
import com.YUbuntu.util.StringUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The operation of an teacher on a database.
 * @Author #YUbuntu
 * @Date Dec 16, 2018-9:10:20 AM
 * @version 1.0
 */
public class Teacher_DaoImpl extends BasicDao implements Teacher_Dao
{

	/**
	 * @Title Insert
	 * @Description Add new teacher information into MySQL database.
	 * @param The teacher information
	 * @return boolean(Added results)
	 * @date Dec 16, 20189:12:06 AM
	 * @throws
	 *
	 */
	public boolean addTeacher(Table_Teacher table_Teacher)
	{
		
		PreparedStatement preparedStatement = null;
		String SQL_addTeacher = "INSERT INTO Table_Teacher VALUES (?,?,?,?,?,?,?,?,?)";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_addTeacher);
			preparedStatement.setString(1, table_Teacher.getTeacher_id());
			preparedStatement.setString(2, table_Teacher.getTeacher_name());
			preparedStatement.setString(3, table_Teacher.getTeacher_password());
			preparedStatement.setString(4, table_Teacher.getTeacher_sex());
			preparedStatement.setInt(5, table_Teacher.getTeacher_age());
			preparedStatement.setString(6, table_Teacher.getTeacher_title());
			preparedStatement.setString(7, table_Teacher.getTeacher_ClassID());
			preparedStatement.setString(8,table_Teacher.getTeacher_ClassName());
			preparedStatement.setString(9, table_Teacher.getTeacher_telephone());
			
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to add the new teacher information to MySQL database !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	/**
	 * 
	 * @Title Select
	 * @Description Search for information about the specified teacher based on the information(Teacher name) entered by the user.
	 * @param The teacher information(Attention : It's null now !)
	 * @return List<Table_Teacher>
	 * @date Dec 16, 2018-9:40:38 PM
	 * @throws
	 *
	 */
	public List<Table_Teacher> getTeacherList(Table_Teacher table_Teacher)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Table_Teacher> list = new ArrayList<Table_Teacher>();

		/*
		 * Default: displays all student information
		 */
		StringBuffer SQL_GetTeacherInformation = new StringBuffer("SELECT * FROM TABLE_TEACHER");

		/*----------------------------------------------
		 * For : Function_SearchTeacher(ActionEvent e) |
		 *----------------------------------------------
		 */
		if (!StringUtil.IsEmpty(table_Teacher.getTeacher_name()))
		{
			// If 'getTeacher_name()' is null ¡ª¡ª> false (Not execute)
			SQL_GetTeacherInformation.append(" AND Teacher_name LIKE '%" + table_Teacher.getTeacher_name() + "%' ");
		}
		if (!StringUtil.IsEmpty(table_Teacher.getTeacher_ClassName()))
		{
			//Or Change 'getTeacher_ClassName' into 'Student_ClassID'
			SQL_GetTeacherInformation.append(" AND Teacher_ClassName = '" + table_Teacher.getTeacher_ClassName() + "' ");
		}
	
		
		try
		{
			/*
			 * 	Note the logical relationship.
			 */
			preparedStatement = connection.prepareStatement(SQL_GetTeacherInformation.toString().replaceFirst("AND", "WHERE"));
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_Teacher table_Teacher_ = new Table_Teacher();
				table_Teacher_.setTeacher_id(resultSet.getString("Teacher_ID"));
				table_Teacher_.setTeacher_name(resultSet.getString("Teacher_name"));
				table_Teacher_.setTeacher_password(resultSet.getString("Teacher_password"));
				table_Teacher_.setTeacher_sex(resultSet.getString("Teacher_sex"));
				table_Teacher_.setTeacher_age(resultSet.getInt("Teacher_age"));
				table_Teacher_.setTeacher_title(resultSet.getString("Teacher_title"));		
				table_Teacher_.setTeacher_ClassID(resultSet.getString("Teacher_ClassID"));
				table_Teacher_.setTeacher_ClassName(resultSet.getString("Teacher_ClassName"));		
				table_Teacher_.setTeacher_telephone(resultSet.getString("Teacher_telephone"));
				
				list.add(table_Teacher_);
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Failed to read teacher information in MySQL database !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return list;
	}

	
	/**
	 * 
	 * @Title Delete
	 * @Description Delete the specified teacher information from MySQL database.
	 * @param The teacher'ID
	 * @return boolean
	 * @date Dec 17, 2018-5:49:16 PM
	 * @throws
	 *
	 */
	public boolean Delete_TeacherInformation(String teacher_ID)
	{
		PreparedStatement preparedStatement = null;
		String SQL_Delete_StudentInformation = "DELETE FROM TABLE_TEACHER WHERE TEACHER_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Delete_StudentInformation);
			preparedStatement.setString(1, teacher_ID);

			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR :Fail to delete teacher information with the specified teacher' ID !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	
	/**
	 * 
	 * @Title Update
	 * @Description Update the specified teacher information
	 * @param The teacher information
	 * @return boolean
	 * @date Dec 17, 2018-6:52:12 PM
	 * @throws
	 *
	 */
	public boolean Update_TeacherInformation(Table_Teacher table_Teacher)
	{
		PreparedStatement preparedStatement = null;
		String SQL_Update_TeacherInformation = "UPDATE TABLE_TEACHER SET TEACHER_NAME = ? , TEACHER_PASSWORD = ? , TEACHER_AGE = ? ,"
											+ "TEACHER_CLASSID = ?, TEACHER_CLASSNAME = ?, TEACHER_TELEPHONE = ? WHERE TEACHER_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Update_TeacherInformation);
			preparedStatement.setString(1, table_Teacher.getTeacher_name());
			preparedStatement.setString(2, table_Teacher.getTeacher_password());
			preparedStatement.setInt(3, table_Teacher.getTeacher_age());
			preparedStatement.setString(4, table_Teacher.getTeacher_ClassID());
			preparedStatement.setString(5, table_Teacher.getTeacher_ClassName());
			preparedStatement.setString(6, table_Teacher.getTeacher_telephone());
			preparedStatement.setString(7, table_Teacher.getTeacher_id());
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to update teacher information with the specified teacher' ID !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	
	/**
	 * 
	 * @Title Select
	 * @Description Use the information in database to check out the personal information entered by the user.
	 * @param The teacher information(Including: name+password)
	 * @return A Object that stores teacher information
	 * @date Dec 18, 2018-11:09:36 AM
	 * @throws
	 *
	 */
	public Table_Teacher Login_Teacher(Table_Teacher Table_Teacher)
	{
		String SQL_TEACHER_LOGIN = "SELECT * FROM TABLE_TEACHER WHERE TEACHER_NAME = ? AND TEACHER_PASSWORD = ?";
		/*
		 * In order to initialize the main interface though the user's personal information.
		 */
		Table_Teacher table_Teacher_temp = null;
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			/*
			 * ------------------------------------------------------------------------------
			 * 'connection' : Pass SQL statements to objects that manipulate the database	|
			 *  From Connection com.YUbuntu.dao.BasicDao.connection 						|
			 * ------------------------------------------------------------------------------
			 */
			preparedStatement = connection.prepareStatement(SQL_TEACHER_LOGIN);

			preparedStatement.setString(1, Table_Teacher.getTeacher_name());
			preparedStatement.setString(2, Table_Teacher.getTeacher_password());
			resultSet = preparedStatement.executeQuery();

			//Store the user information
			if (resultSet.next())
			{		
				/*---------------------------------------------------------------------------------------------------------------------------------
				 * Stores the data of Teacher_ID and .. so that in order to initialize the main interface though the user's personal information. |
				 *---------------------------------------------------------------------------------------------------------------------------------
				 *///Such as it's be used when change user's password !
				table_Teacher_temp = new Table_Teacher();
				table_Teacher_temp.setTeacher_id(resultSet.getString("TEACHER_ID"));
				table_Teacher_temp.setTeacher_name(resultSet.getString("TEACHER_NAME"));
				table_Teacher_temp.setTeacher_password(resultSet.getString("TEACHER_PASSWORD"));
				table_Teacher_temp.setTeacher_ClassID(resultSet.getString("TEACHER_CLASSID"));//Inorder to easy set user premissions.
				//...
			}
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to check the specified information of teacher from the MySQL database ! \n");
			e.printStackTrace();
		}		
		JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return table_Teacher_temp;	
	}

	
	/**
	 * 
	 * @Title Update
	 * @Description Change the user's password
	 * @param The teacher information and new password
	 * @return String (The result of changing)
	 * @date Dec 18, 2018-12:11:31 PM
	 * @throws
	 *
	 */
	public String ChangePassword(Table_Teacher table_Teacher,String newPassword)
	{	
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String result_ChanggePasswrod = null;
		String SQL_check = "SELECT * FROM TABLE_TEACHER WHERE TEACHER_ID = ? AND TEACHER_PASSWORD = ? ";
		String SQL_ChangePassword = "UPDATE TABLE_TEACHER SET TEACHER_PASSWORD = ? WHERE TEACHER_ID = ?";

		try
		{
			//The first step: Check whether the data entered by the user is reasonable
			preparedStatement = connection.prepareStatement(SQL_check);	
			preparedStatement.setString(1, table_Teacher.getTeacher_id());
			preparedStatement.setString(2, table_Teacher.getTeacher_password());
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next())
			{
				result_ChanggePasswrod = "Warning : the old passwrod is error !";
				JDBCUtil.freeResource(resultSet, preparedStatement, connection);
				return result_ChanggePasswrod;
			}

			//The second step: Change the user'password
			preparedStatement = connection.prepareStatement(SQL_ChangePassword);

			//The value passed in : The new password
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, table_Teacher.getTeacher_id());

			int result = preparedStatement.executeUpdate();
			if (result > 0)
			{
				result_ChanggePasswrod = "Success to change the password of user !";
			}
			
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to change the user's password !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return result_ChanggePasswrod;
	}
}
