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
	 * @Title Update 
	 * @Description Update the number of student in the specified course.
	 * @param Course ID and boolean(Increase or reduce).
	 * @return boolean
	 * @date Jan 24, 2019-7:52:37 PM
	 *
	 */
	boolean updateCourseStudentNumber(String courseID,boolean increaseNumber);
	
	/**
	 * 
	 * @Title Select
	 * @Description Determine whether the specified course had been choosed. 
	 * @param Course ID and Student ID.
	 * @return boolean
	 * @date Jan 24, 2019-6:52:52 PM
	 *
	 */
	boolean isChoosedCourse(String courseID, String studentID);
	
	
	/**
	 * 
	 * @Title Select 
	 * @Description Determine whether the number of student is max.
	 * @param Course ID
	 * @return 
	 * @return void
	 * @date Jan 24, 2019-6:51:22 PM
	 *
	 */
	boolean isCourseNumberMax(String courseID);
	
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
	 * @Title Update
	 * @Description Modify the information about course selection.
	 * @param Table_ChoosedCourse
	 * @return boolean
	 * @date Jan 26, 2019-6:45:30 PM
	 *
	 */
	boolean Update_ChoosedCourseInfo(Table_ChoosedCourse table_ChoosedCourse);
	
	
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
	 * @Description Get the specified ID by the teacher name.
	 * @param Teacher name
	 * @return Teacher ID
	 * @date Jan 26, 2019-6:38:17 PM
	 *
	 */
	String getTeacherID(String teacher_name);
	
	/**
	 * 
	 * @Title Select
	 * @Description Get the specified course ID by the course name.
	 * @param Course name
	 * @return String
	 * @date Jan 24, 2019-8:23:31 PM
	 *
	 */
	String getCourseID(String courseName);
	
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
