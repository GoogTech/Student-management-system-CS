package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.Student_Dao;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.util.JdbcUtil;
import com.YUbuntu.util.StringUtil;


/**
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The operation of an student on a database
 * @Author #YUbuntu
 * @Date December 5,2018
 * @version 1.0
 */
public class Student_DaoImpl extends BasicDao implements Student_Dao
{
	/**
	 * @Description Add the new student information to the database of MySQL
	 * @param The information of student
	 * @date December 8,2018
	 * @return Added results
	 */
	public boolean addStudent(Table_Student table_Student)
	{
		PreparedStatement preparedStatement = null;
		String SQL_addStudent = "INSERT INTO Table_Student VALUES (?,?,?,?,?,?)";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_addStudent);
			preparedStatement.setString(1, table_Student.getStudent_id());
			preparedStatement.setString(2, table_Student.getStudent_name());
			preparedStatement.setString(3, table_Student.getStudent_sex());
			preparedStatement.setString(4, table_Student.getStudent_password());
			preparedStatement.setString(5, table_Student.getStudent_ClassId());
			preparedStatement.setString(6, table_Student.getStudent_ClassName());

			if (preparedStatement.executeUpdate() > 0)
			{
				JdbcUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to add the new student information to MySQL database !\n");
			e.printStackTrace();
		}
		JdbcUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
	

	/**
	 * @Description Search for information about the specified student based on the information(student name, class name) entered by the user.
	 * @param The information of student(Attention : It's null now !)
	 * @date December 8,2018
	 * @return List<Table_Student>
	 */
	public List<Table_Student> getStudentList(Table_Student table_Student)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Table_Student> list = new ArrayList<Table_Student>();

		/*
		 * Default: displays all student information
		 */
		StringBuffer SQL_GetStudentInformation = new StringBuffer("SELECT * FROM Table_Student");

		/*------------------------------------------------------------------------
		 * getStudent_name() : Get it from the information entered by the user.  |
		 * -----------------------------------------------------------------------
		 */
		if (!StringUtil.IsEmpty(table_Student.getStudent_name()))
		{
			// If 'getStudent_name()' is null ¡ª¡ª> false (Not execute)
			SQL_GetStudentInformation.append(" AND Student_name LIKE '%" + table_Student.getStudent_name() + "%' ");
		}
		if (!StringUtil.IsEmpty(table_Student.getStudent_ClassName()))
		{
			//Or Change 'Student_ClassName' into 'Student_ClassID'
			SQL_GetStudentInformation.append(" AND Student_ClassName = '" + table_Student.getStudent_ClassName() + "' ");
		}

		try
		{
			/*
			 * 	Note the logical relationship.
			 */
			preparedStatement = connection.prepareStatement(SQL_GetStudentInformation.toString().replaceFirst("AND","WHERE"));
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_Student table_Student_ = new Table_Student();
				table_Student_.setStudent_id(resultSet.getString("Student_ID"));
				table_Student_.setStudent_name(resultSet.getString("Student_name"));
				table_Student_.setStudent_sex(resultSet.getString("Student_sex"));
				table_Student_.setStudent_password(resultSet.getString("Student_password"));
				table_Student_.setStudent_ClassId(resultSet.getString("Student_ClassID"));
				table_Student_.setStudent_ClassName(resultSet.getString("Student_ClassName"));

				list.add(table_Student_);
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Failed to read student information in MySQL database!\n");
			e.printStackTrace();
		}
		JdbcUtil.freeResource(resultSet, preparedStatement, connection);
		return list;
	}
	
	
	/**
	 * 
	 * @Title Delete specified data from MySQL database
	 * @Description Deletes student information with the specified student ID.
	 * @param The student'ID
	 * @return boolean
	 * @date December 11,2018-11:53:26
	 *
	 */
	public boolean Delete_StudentInformation(String Student_ID)
	{
		PreparedStatement preparedStatement = null;
		String SQL_Delete_StudentInformation = "DELETE FROM TABLE_STUDENT WHERE STUDENT_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Delete_StudentInformation);
			preparedStatement.setString(1, Student_ID);

			if (preparedStatement.executeUpdate() > 0)
			{
				JdbcUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR :Fail to delete Student information with the specified Student' ID !\n");
			e.printStackTrace();
		}
		JdbcUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	/**
	 * 
	 * @Title Update specified data from MySQL database
	 * @Description Modify the student information specified.
	 * @param The information of student
	 * @return boolean
	 * @date December 11,2018-8:46:46
	 *
	 */
	public boolean Update_StudentInformation(Table_Student table_Student)
	{
		PreparedStatement preparedStatement = null;

		String SQL_Update_ClassInformation = "UPDATE TABLE_STUDENT SET STUDENT_NAME = ? , STUDENT_SEX = ? , STUDENT_PASSWORD = ? ,"
											+ "STUDENT_CLASSID = ?, STUDENT_CLASSNAME = ? WHERE STUDENT_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Update_ClassInformation);
			preparedStatement.setString(1, table_Student.getStudent_name());
			preparedStatement.setString(2, table_Student.getStudent_sex());
			preparedStatement.setString(3, table_Student.getStudent_password());
			preparedStatement.setString(4, table_Student.getStudent_ClassId());
			preparedStatement.setString(5, table_Student.getStudent_ClassName());
			preparedStatement.setString(6, table_Student.getStudent_id());
			if (preparedStatement.executeUpdate() > 0)
			{
				JdbcUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : Fail to update student information with the specified student ID !\n");
			e.printStackTrace();
		}
		JdbcUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
	
	
	/**
	 * 
	 * @Title Check specified data from the MySQL database.
	 * @Description Use the information in database to check out the personal information entered by the user.
	 * @param The student information(Including : student name and student password)
	 * @return A Object that stores student information
	 * @date Dec 12,2018-9:24:54 PM
	 *
	 */
	public Table_Student Login_Student(Table_Student table_Student)
	{
		String SQL_ADMINISTRATOR_LOGIN = "SELECT * FROM TABLE_STUDENT WHERE STUDENT_NAME = ? AND STUDENT_PASSWORD = ?";
		/*
		 * In order to initialize the main interface though the user's personal information.
		 */
		Table_Student table_Student_temp = null;
		
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
			preparedStatement = connection.prepareStatement(SQL_ADMINISTRATOR_LOGIN);

			preparedStatement.setString(1, table_Student.getStudent_name());
			preparedStatement.setString(2, table_Student.getStudent_password());
			resultSet = preparedStatement.executeQuery();

			//Store the user information
			if (resultSet.next())
			{		
				/*---------------------------------------------------------------------------------------------------------------------------------
				 * Stores the data of Student_ID and .. so that in order to initialize the main interface though the user's personal information. |
				 *---------------------------------------------------------------------------------------------------------------------------------
				 *///Such as it's be used when change user's password !
				table_Student_temp = new Table_Student();
				table_Student_temp.setStudent_id(resultSet.getString("Student_id"));
				table_Student_temp.setStudent_name(resultSet.getString("Student_name"));
				table_Student_temp.setStudent_password(resultSet.getString("Student_password"));
				table_Student_temp.setStudent_ClassId(resultSet.getString("Student_ClassID"));//Inorder easy to set user permissions.
				//...
			}
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to check specified information of student from the MySQL database !\n");
			e.printStackTrace();
		}		
		JdbcUtil.freeResource(resultSet, preparedStatement, connection);
		return table_Student_temp;	
	}
	
	
	/**
	 * 
	 * @Title Update specified data from MySQL database.
	 * @Description Change the student'password.
	 * @param The student information(Including:username+old password) and new password.
	 * @return String(The result of changing)
	 * @date December 12, 2018-11:37:29 PM
	 *
	 */
	public String ChangePassword(Table_Student table_Student, String newPassword)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String result_ChanggePasswrod = null;
		String SQL_check = "SELECT * FROM TABLE_STUDENT WHERE STUDENT_ID = ? AND STUDENT_PASSWORD = ? ";
		String SQL_ChangePassword = "UPDATE TABLE_STUDENT SET STUDENT_PASSWORD = ? WHERE STUDENT_ID = ?";

		try
		{
			//The first step: Check whether the data entered by the user is reasonable
			preparedStatement = connection.prepareStatement(SQL_check);
			
			preparedStatement.setString(1, table_Student.getStudent_id());
			preparedStatement.setString(2, table_Student.getStudent_password());
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next())
			{
				result_ChanggePasswrod = "Warning : the old passwrod is error !";
				JdbcUtil.freeResource(resultSet, preparedStatement, connection);
				return result_ChanggePasswrod;
			}

			//The second step: Change the password of user
			preparedStatement = connection.prepareStatement(SQL_ChangePassword);

			//The value passed in : The new password
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, table_Student.getStudent_id());

			int result = preparedStatement.executeUpdate();
			if (result > 0)
			{
				result_ChanggePasswrod = "Success to change the password of user !";
			}
			
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to change the user'password !\n");
		}

		JdbcUtil.freeResource(resultSet, preparedStatement, connection);
		return result_ChanggePasswrod;
	}

	
	/**
	 * 
	 * @Title Select
	 * @Description Get the student name by the class name.
	 * @param Table_Class(Class ID)
	 * @return List<Table_Student>
	 * @date Jan 18, 2019-5:32:41 PM
	 *
	 */
	public List<Table_Student> getStudentName(String className)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Table_Student> list = new ArrayList<Table_Student>();
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT * FROM TABLE_STUDENT WHERE STUDENT_CLASSNAME = ?");
			preparedStatement.setString(1,className);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_Student table_Student_temp = new Table_Student();
				table_Student_temp.setStudent_name(resultSet.getString("STUDENT_NAME"));
				list.add(table_Student_temp);
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE STUDENT NAME FROM THE DATABASE !\n");
			e.printStackTrace();
		}
		JdbcUtil.freeResource(resultSet, preparedStatement, connection);
		return list;
	}
}
