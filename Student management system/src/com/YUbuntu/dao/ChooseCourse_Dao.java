package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_ChoosedCourse;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of course selection.
 * @Author HuangYuhui
 * @Date Jan 18, 201-93:49:58 PM
 * @version 2.0
 */
public interface ChooseCourse_Dao
{
	
	/**
	 * 
	 * @Title Delete
	 * @Description Delete the specified course.
	 * @param ChoosedCourse_ID
	 * @return boolean
	 * @date Jan 21, 2019-4:26:08 PM
	 *
	 */
	boolean Exit_Course(String ChoosedCourse_ID);
	
	/**
	 * 
	 * @Title Insert
	 * @Description Add the information of course selection.
	 * @param table_ChoosedCourse.
	 * @return boolean
	 * @date Jan 20, 2019-8:02:06 PM
	 *
	 */
	boolean AddCourseSelectionInfo(Table_ChoosedCourse table_ChoosedCourse);
	
	/**
	 * 
	 * @Title Select
	 * @Description Get the specified student ID by the student name.
	 * @param student name.
	 * @return String
	 * @date Jan 20, 2019-8:00:58 PM
	 *
	 */
	String getStudentID(String studentName);
	
	/**
	 *
	 * @Title Select 
	 * @Description Get the information about course selection.
	 * @param Table_ChoosedCourse
	 * @return List<Table_SelectCourse>
	 * @date Jan 18, 20194:01:17 PM
	 *
	 */
	List<Table_ChoosedCourse> getChoosedCourseList(Table_ChoosedCourse table_SelectCourse);
}
