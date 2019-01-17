package com.YUbuntu.view.function;

import com.YUbuntu.model.Table_SelectCourse;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Extract panel functionality into the interface.
 * @Author HuangYuhui
 * @Date Jan 17, 2019-3:54:16 PM
 * @version 2.0
 */
public interface ChooseCourse_JF_function
{
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the table of course selection.
	 * @param Table_SelectCourse
	 * @return void
	 * @date Jan 17, 2019-4:55:32 PM
	 *
	 */
	void Initialize_CourseInfoTable(Table_SelectCourse table_SelectCourse);
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the student name.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:55:13 PM
	 *
	 */
	void Initialize_InitializeStudentName();
	
	
	/**
	 * 
	 * @Title Initialize 
	 * @Description Initialize the course name.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:55:32 PM
	 *
	 */
	void Initialize_InitializeCourseName();
	
}
