package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.Course_Dao;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.JDBCUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao.impl
 * @Description TODO
 * @Author #YUbuntu
 * @Date Dec 29, 2018-7:51:04 PM
 * @version 2.0
 */
public class Course_DaoImpl extends BasicDao implements Course_Dao
{
	/**
	 * 
	 * @Title Select
	 * @Description Get teacher name from database.
	 * @param Performed action
	 * @return List<Table_Teacher>
	 * @date Dec 29, 2018-8:06:57 PM
	 * @throws no
	 *
	 */
	public List<Table_Teacher> getTeacherName()
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Table_Teacher> list = new ArrayList<Table_Teacher>();
		String SQL_GetClassName = "SELECT TEACHER_ID,TEACHER_NAME FROM TABLE_TEACHER";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_GetClassName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_Teacher table_Teacher = new Table_Teacher();
				table_Teacher.setTeacher_id(resultSet.getString("TEACHER_ID"));
				table_Teacher.setTeacher_name(resultSet.getString("TEACHER_NAME"));
				list.add(table_Teacher);
			}

		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO SELECT TEACHER NAME FROM TABLE_TEACHER ! \n");
			e.printStackTrace();
		}finally
		{			
			JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		}
		return list;
	}

	/**
	 * 
	 * @Title Insert
	 * @Description Insert a new course into the database.
	 * @param The information of course.
	 * @return boolean
	 * @date Dec 29, 2018-9:38:35 PM
	 * @throws no
	 *
	 */
	public boolean addCourse(Table_Course table_Course)
	{
		PreparedStatement preparedStatement = null;
		String SQL_addCourse = "INSERT INTO TABLE_COURSE VALUES (?,?,?,?,?,?)";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_addCourse);
			preparedStatement.setString(1, table_Course.getCourse_ID());
			preparedStatement.setString(2, table_Course.getCourse_name());
			preparedStatement.setString(3, table_Course.getTeacher_ID());
			preparedStatement.setString(4, table_Course.getTeacher_name());
			preparedStatement.setString(5, table_Course.getCourse_MaxStudentNumber());
			preparedStatement.setString(6, table_Course.getCourse_Introduction());

			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO INSERT A NEW COURSE INTO THE DATABASE ! \n");
			e.printStackTrace();
		}			
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
}
