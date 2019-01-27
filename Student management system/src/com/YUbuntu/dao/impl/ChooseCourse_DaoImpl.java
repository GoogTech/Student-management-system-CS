package com.YUbuntu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YUbuntu.basicDao.BasicDao;
import com.YUbuntu.dao.ChooseCourse_Dao;
import com.YUbuntu.model.Table_ChoosedCourse;
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
				table_ChooseCourse.setClass_name(resultSet.getString("Class_name"));
				table_ChooseCourse.setStudent_ID(resultSet.getString("Student_ID"));
				table_ChooseCourse.setStudent_name(resultSet.getString("Student_name"));
				table_ChooseCourse.setTeacher_ID(resultSet.getString("Teacher_ID"));
				table_ChooseCourse.setTeacher_name(resultSet.getString("Teacher_name"));
				table_ChooseCourse.setCourse_ID(resultSet.getString("Course_ID"));
				table_ChooseCourse.setCourse_name(resultSet.getString("Course_name"));
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
	 * @Title Select
	 * @Description Get the class ID by the specified class name. 
	 * @param Class name
	 * @return String
	 * @date Jan 24, 2019-11:04:30 AM
	 *
	 */
	public String getClassID(String className)
	{
		String classID = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT CLASS_ID FROM TABLE_CLASS WHERE CLASS_NAME = ?");
			preparedStatement.setString(1,className);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				classID = resultSet.getString("Class_ID");
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE CLASS ID FROM THE DATABASE !\n");
			e.printStackTrace();
		}
		
		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		//JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return classID;
	}
	
	

	/**
	 * @Title Select
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
	 * @Title Select
	 * @Description Get the course ID by the specified course name.
	 * @param Course name
	 * @return Course ID
	 * @date Jan 24, 2019-8:19:53 PM
	 *
	 */
	public String getCourseID(String courseName)
	{
		String courseID = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			preparedStatement = connection.prepareStatement("SELECT COURSE_ID FROM TABLE_CHOOSEDCOURSE WHERE COURSE_NAME = ?");
			preparedStatement.setString(1, courseName);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				courseID = resultSet.getString("COURSE_ID");
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE COURSE ID FROM THE DATABASE !\n");
			e.printStackTrace();
		}

		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		// JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return courseID;
	}
	
	/**
	 * @Title Select
	 * @Description Get the specified ID by the teacher name.
	 * @param Empty
	 * @return Teacher ID
	 * @date Jan 26, 2019-6:33:25 PM
	 *
	 */
	public String getTeacherID(String teacher_name)
	{
		String teacher_ID = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			preparedStatement = connection.prepareStatement("SELECT TEACHER_ID FROM TABLE_CHOOSEDCOURSE WHERE TEACHER_NAME = ?");
			preparedStatement.setString(1, teacher_name);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				teacher_ID = resultSet.getString("TEACHER_ID");
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE TEACHER ID FROM THE DATABASE !\n");
			e.printStackTrace();
		}

		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		// JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return teacher_ID;
	}
	
	
	
	
	/**
	 * @Title Insert 
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
				+ "(Class_ID,Class_name,Student_ID,Student_name,Teacher_ID,Teacher_name,Course_ID,Course_name,"
				+ "MaxStudentNumber,ChoosedStudentNumber,Course_Introduction)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			/*
			 * ERROR : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
			 */
			preparedStatement = connection.prepareStatement(SQL_addCourseInfo);
			
			preparedStatement.setString(1, table_ChoosedCourse.getClass_ID());
			preparedStatement.setString(2, table_ChoosedCourse.getClass_name());
			preparedStatement.setString(3, table_ChoosedCourse.getStudent_ID());
			preparedStatement.setString(4, table_ChoosedCourse.getStudent_name());
			preparedStatement.setString(5, table_ChoosedCourse.getTeacher_ID());
			preparedStatement.setString(6, table_ChoosedCourse.getTeacher_name());
			preparedStatement.setString(7, table_ChoosedCourse.getCourse_ID());
			preparedStatement.setString(8, table_ChoosedCourse.getCourse_name());
			preparedStatement.setInt(9, table_ChoosedCourse.getMaxStudentNumber());
			preparedStatement.setInt(10,table_ChoosedCourse.getChoosedStudentNumber());
			preparedStatement.setString(11, table_ChoosedCourse.getCourse_Introduction());
			
			if (preparedStatement.executeUpdate() > 0)
			{
				//JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO ADD THE NEW COURSE INFORMATION INTO THE DATABASE !\n");
			e.printStackTrace();
		}
		//JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}

	
	/**
	 * @Title Delete 
	 * @Description Delete the specified course information.
	 * @param ChoosedCourse_ID
	 * @return boolean
	 * @date Jan 21, 2019-4:18:13 PM
	 *
	 */
	public boolean Exit_Course(String ChoosedCourse_ID)
	{
		PreparedStatement preparedStatement = null;
		String SQL_ExitCourse = "DELETE FROM TABLE_CHOOSEDCOURSE WHERE CHOOSEDCOURSE_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_ExitCourse);
			preparedStatement.setString(1, ChoosedCourse_ID);

			if (preparedStatement.executeUpdate() > 0)
			{
				//JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR :FAIL TO DELETE THE SPECIFIED COURSE WITH THE CHOOSEDCOURSE_ID !\n");
			e.printStackTrace();
		}
		//JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}



	/**
	 * @Title Select
	 * @Description Determine whether the number of student is max.
	 * @param Empty
	 * @return boolean
	 * @date Jan 24, 2019-6:23:28 PM
	 *
	 */
	public boolean isCourseNumberMax(String courseID)
	{
		int MaxStudentNumber;
		int ChoosedStudentNumber;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT MaxStudentNumber,ChoosedStudentNumber FROM TABLE_CHOOSEDCOURSE WHERE COURSE_ID = ?");
			preparedStatement.setString(1,courseID);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				MaxStudentNumber = resultSet.getInt("MaxStudentNumber");
				ChoosedStudentNumber = resultSet.getInt("ChoosedStudentNumber");
				if (MaxStudentNumber == ChoosedStudentNumber)
				{
					return false;
				}
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET THE MaxStudentNumber AND ChoosedStudentNumber FROM THE DATABASE !\n");
			e.printStackTrace();
		}
		
		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		//JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return true;
	}


	/**
	 * @Title Select
	 * @Description Determine whether the course had been choosed.
	 * @param Course ID and Student ID.
	 * @return boolean
	 * @date Jan 24, 2019-6:44:47 PM
	 *
	 */
	public boolean isChoosedCourse(String courseID, String studentID)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
		{
			preparedStatement = connection.prepareStatement("SELECT COURSE_ID,STUDENT_ID FROM TABLE_CHOOSEDCOURSE WHERE COURSE_ID = ? AND STUDENT_ID = ?");
			preparedStatement.setString(1,courseID);
			preparedStatement.setString(2, studentID);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return false;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO GET COURSE_ID AND STUDENT_ID FROM THE DATABASE !\n");
			e.printStackTrace();
		}
		
		/*
		 * Not release the resource : java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.
		 */
		//JDBCUtil.freeResource(resultSet, preparedStatement, connection);
		return true;
	}


	/**
	 * @Title Update
	 * @Description Update the number of student in the specified course. 
	 * @param Course ID and boolean(Increase or reduce).
	 * @return boolean
	 * @date Jan 24, 2019-7:37:40 PM
	 *
	 */
	public boolean updateCourseStudentNumber(String courseID,boolean increase)
	{
		String studentNumber = "UPDATE TABLE_CHOOSEDCOURSE SET ChoosedStudentNumber = ChoosedStudentNumber - 1 WHERE COURSE_ID = ?";
		if (increase)
		{
			studentNumber = "UPDATE TABLE_CHOOSEDCOURSE SET ChoosedStudentNumber = ChoosedStudentNumber + 1 WHERE COURSE_ID = ?";
			try
			{
				PreparedStatement preparedStatement = connection.prepareStatement(studentNumber);
				preparedStatement.setString(1, courseID);
				if (preparedStatement.executeUpdate() > 0)
				{
					return true;
				}

			} catch (Exception e)
			{
				e.printStackTrace();
				System.err.println("ERROR : FAIL TO UPDATE THE STUDENT NUMBER IN THE DATABASE !\n");
			}
		}
		return false;
	}

	
	/**
	 * @Title Update
	 * @Description Modify the information about course selection.
	 * @param Table_ChoosedCourse
	 * @return boolean
	 * @date Jan 26, 2019-6:43:48 PM
	 *
	 */
	public boolean Update_ChoosedCourseInfo(Table_ChoosedCourse table_ChoosedCourse)
	{
		PreparedStatement preparedStatement = null;
		String SQL_Update_TeacherInformation = "UPDATE TABLE_CHOOSEDCOURSE SET "
				+ "CLASS_NAME = ? , TEACHER_NAME = ? , STUDENT_NAME = ? ,COURSE_NAME = ? WHERE CHOOSEDCOURSE_ID = ?";
		try
		{
			preparedStatement = connection.prepareStatement(SQL_Update_TeacherInformation);
			preparedStatement.setString(1, table_ChoosedCourse.getClass_name());
			preparedStatement.setString(2, table_ChoosedCourse.getTeacher_name());
			preparedStatement.setString(3, table_ChoosedCourse.getStudent_name());
			preparedStatement.setString(4, table_ChoosedCourse.getCourse_name());
			preparedStatement.setInt(5, table_ChoosedCourse.getChoosedCourse_ID());
			if (preparedStatement.executeUpdate() > 0)
			{
				JDBCUtil.freeResource(null, preparedStatement, connection);
				return true;
			}
		} catch (SQLException e)
		{
			System.err.println("ERROR : FAIL TO UPDATE INFORMATION ABOUT COURSE SELECTION !\n");
			e.printStackTrace();
		}
		JDBCUtil.freeResource(null, preparedStatement, connection);
		return false;
	}
}
