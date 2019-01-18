package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_ChoosedCourse;
import com.YUbuntu.model.Table_Teacher;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of the course operation database.
 * @Author #YUbuntu
 * @Date Dec 29, 2018-7:36:06 PM
 * @version 2.0
 */
public interface Course_Dao
{
	
	/**
	 * 
	 * @Title Delete 
	 * @Description Delete the specified course.
	 * @param String(Course'ID)
	 * @return boolean
	 * @date Jan 17, 2019-12:22:46 PM
	 *
	 */
	boolean Delete_CourseInformation(String string);
	
	/**
	 * 
	 * @Title Update
	 * @Description Update the course information.
	 * @param Table_Course
	 * @return boolean
	 * @date Jan 16, 2019-9:44:59 PM
	 *
	 */
	boolean Update_CourseInformation(Table_Course table_Course);
	
	/**
	 * 
	 * @Title Select
	 * @Description Get the course information from the database.
	 * @param no
	 * @return List<Table_Course>
	 * @date Jan 15, 2019-4:05:31 PM
	 *
	 */
	List<Table_Course> getCourseList(Table_Course table_Course);
	
	/**
	 * 
	 * @Title Select
	 * @Description Get the teacher name from the database.
	 * @param no
	 * @return List<Table_Teacher>
	 * @date Dec 29, 2018-9:44:38 PM
	 * @throws no
	 *
	 */
	List<Table_Teacher> getTeacherName();
	
	/**
	 * 
	 * @Title Insert
	 * @Description Inset a new course into the database.
	 * @param The information of course.
	 * @return boolean
	 * @date Dec 29, 2018-9:46:17 PM
	 * @throws no
	 *
	 */
	boolean addCourse(Table_Course table_Course);
	
}
