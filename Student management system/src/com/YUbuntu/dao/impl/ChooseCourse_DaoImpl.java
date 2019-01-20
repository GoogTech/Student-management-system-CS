package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.ChooseCourse_Dao;
import com.YUbuntu.model.Table_ChoosedCourse;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.util.JDBCUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao.impl
 * @Description Operation of course selection information in the database.
 * @Author HuangYuhui
 * @Date Jan 18, 2019-3:50:42 PM
 * @version 2.0
 */
public class ChooseCourse_DaoImpl extends BasicDao implements ChooseCourse_Dao
{
	@Override
	public List<Table_ChoosedCourse> getChoosedCourseList(Table_ChoosedCourse table_SelectCourse)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Table_ChoosedCourse> list = new ArrayList<Table_ChoosedCourse>();
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT * FROM TABLE_CHOOSEDCOURSE");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Table_ChoosedCourse table_ChooseCourse = new Table_ChoosedCourse();
				table_ChooseCourse.setChoosedCourse_ID(resultSet.getInt("ChoosedCourse_ID"));
				table_ChooseCourse.setStudent_ID(resultSet.getString("Student_ID"));
				table_ChooseCourse.setStudent_Name(resultSet.getString("Student_Name"));
				table_ChooseCourse.setTeacher_ID(resultSet.getString("Teacher_ID"));
				table_ChooseCourse.setTeacher_Name(resultSet.getString("Teacher_Name"));
				table_ChooseCourse.setCourse_ID(resultSet.getString("Course_ID"));
				table_ChooseCourse.setCourse_Name(resultSet.getString("Course_Name"));
				table_ChooseCourse.setMaxStudentNumber(resultSet.getInt("MaxStudentNumber"));
				table_ChooseCourse.setChoosedStudentNumber(resultSet.getInt("ChoosedStudentNumber"));
				table_ChooseCourse.setCourse_Introduction(resultSet.getString("Course_Introduction"));

				list.add(table_ChooseCourse);
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO READ THE INFORMATION OF COURSE SELECTION !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return list;

	}

	/**
	 * 
	 * @Title Function
	 * @Description Get the student ID by the student name.
	 * @param String(Student name)
	 * @return String(Student ID)
	 * @date Jan 18, 2019-8:27:10 PM
	 *
	 */
	public String getStudentID(String studentName)
	{
		String studentID = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT STUDENT_ID FROM TABLE_STUDENT WHERE STUDENT_NAME = ?");
			preparedStatement.setString(1,studentName);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				studentID = resultSet.getString("STUDENT_ID");
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE STUDENT ID FROM THE DATABASE !\n");
			e.printStackTrace();
		}
		
		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		//JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return studentID;
	}

	
	/**
	 * 
	 * @param table_Course 
	 * @Title Function 
	 * @Description Add the information of course selection into the database.
	 * @param Table_ChoosedCourse
	 * @return void
	 * @date Jan 18, 2019-8:34:05 PM
	 *
	 */
	public boolean AddCourseSelectionInfo(Table_ChoosedCourse table_ChoosedCourse)
	{
		PreparedStatement preparedStatement = null;
		String SQL_addCourseInfo = "INSERT INTO TABLE_CHOOSEDCOURSE "
				+ "(Student_ID,Student_name,Teacher_ID,Teacher_name,Course_ID,Course_name,MaxStudentNumber,ChoosedStudentNumber,Course_Introduction)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try
		{
			/*
			 * ERROR : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
			 */
			preparedStatement = connection.prepareStatement(SQL_addCourseInfo);
			
			preparedStatement.setString(1, table_ChoosedCourse.getStudent_ID());
			preparedStatement.setString(2, table_ChoosedCourse.getStudent_Name());
			preparedStatement.setString(3, table_ChoosedCourse.getTeacher_ID());
			preparedStatement.setString(4, table_ChoosedCourse.getTeacher_Name());
			preparedStatement.setString(5, table_ChoosedCourse.getCourse_ID());
			preparedStatement.setString(6, table_ChoosedCourse.getCourse_Name());
			preparedStatement.setInt(7, table_ChoosedCourse.getMaxStudentNumber());
			preparedStatement.setInt(8,table_ChoosedCourse.getChoosedStudentNumber());
			preparedStatement.setString(9, table_ChoosedCourse.getCourse_Introduction());
			
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO ADD THE NEW COURSE INFORMATION INTO THE DATABASE !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
}
