package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_Teacher;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of teacher operation database.
 * @Author #YUbuntu
 * @Date Dec 27, 2018-9:18:12 PM
 * @version 1.0
 */
public interface Teacher_Dao
{
	/**
	 * 
	 * @Title Insert
	 * @Description Insert new teacher information into database.
	 * @param The information of teacher.
	 * @return boolean
	 * @date Dec 27, 2018-9:20:04 PM
	 * @throws no
	 *
	 */
	boolean addTeacher(Table_Teacher table_Teacher);
	
	/**
	 * 
	 * @Title Select
	 * @Description Search for information from database.
	 * @param The information of teacher.
	 * @return List<Table_Teacher>
	 * @date Dec 27, 2018-9:21:26 PM
	 * @throws no
	 *
	 */
	List<Table_Teacher> getTeacherList(Table_Teacher table_Teacher);
	
	/**
	 * 
	 * @Title Delete
	 * @Description Delete the teacher information from databse.
	 * @param The teacher' ID.
	 * @return boolean
	 * @date Dec 27, 2018-9:23:18 PM
	 * @throws no
	 *
	 */
	boolean Delete_TeacherInformation(String teacher_ID);
	
	/**
	 * 
	 * @Title Update
	 * @Description Update the teacher information from database.
	 * @param The informaton of teacher.
	 * @return boolean
	 * @date Dec 27, 2018-9:26:43 PM
	 * @throws no
	 *
	 */
	boolean Update_TeacherInformation(Table_Teacher table_Teacher);
	
	/**
	 * 
	 * @Title Select
	 * @Description Select the student information from database.
	 * @param The information of teacher.
	 * @return Table_Teacher
	 * @date Dec 27, 2018-9:30:26 PM
	 * @throws no
	 *
	 */
	Table_Teacher Login_Teacher(Table_Teacher Table_Teacher);	
}
