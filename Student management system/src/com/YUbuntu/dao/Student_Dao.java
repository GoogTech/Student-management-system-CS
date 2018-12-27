package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_Student;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of the class operation database.
 * @Author #YUbuntu
 * @Date Dec 27, 2018-8:53:31 PM
 * @version 1.0
 */
public interface Student_Dao
{
	/**
	 * 
	 * @Title Insert
	 * @Description Add the student information into database.
	 * @param The information of student
	 * @return boolean
	 * @date Dec 27, 2018-8:56:08 PM
	 * @throws no
	 *
	 */
	boolean addStudent(Table_Student table_Student);
	
	/**
	 * 
	 * @Title Select
	 * @Description Select the student information from database.
	 * @param The informaton student
	 * @return List<Table_Student>
	 * @date Dec 27, 2018-8:57:39 PM
	 * @throws no
	 *
	 */
	List<Table_Student> getStudentList(Table_Student table_Student);
	
	/**
	 * 
	 * @Title Delete
	 * @Description Deletes the student information from database.
	 * @param The studnet' ID
	 * @return boolean
	 * @date Dec 27, 2018-8:59:19 PM
	 * @throws no
	 *
	 */
	boolean Delete_StudentInformation(String Student_ID);
	
	/**
	 * 
	 * @Title Update
	 * @Description Modify the student information from database.
	 * @param The information of student
	 * @return boolean
	 * @date Dec 27, 2018-9:00:19 PM
	 * @throws no
	 *
	 */
	boolean Update_StudentInformation(Table_Student table_Student);
	
	/**
	 * 
	 * @Title Select
	 * @Description Check the formation of logining.
	 * @param The information of student.
	 * @return A Object that stores student information
	 * @date Dec 27, 2018-9:01:49 PM
	 * @throws no
	 *
	 */
	Table_Student Login_Student(Table_Student table_Student);
	
	/**
	 * 
	 * @Title Update
	 * @Description Modify the student information from database.
	 * @param The information of student.
	 * @return String(The result of changing)
	 * @date Dec 27, 2018-9:04:00 PM
	 * @throws no
	 *
	 */
	String ChangePassword(Table_Student table_Student, String newPassword);
}
