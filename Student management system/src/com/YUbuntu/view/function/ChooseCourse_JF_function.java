package com.YUbuntu.view.function;

import com.YUbuntu.model.Table_ChoosedCourse;
import com.YUbuntu.model.Table_Class;

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
	 * @param Table_ChoosedCourse
	 * @return void
	 * @date Jan 17, 2019-4:55:32 PM
	 *
	 */
	void Initialize_ChoosedCourseInfoTable(Table_ChoosedCourse table_SelectCourse);
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the class name.
	 * @param empty
	 * @return void
	 * @date Jan 18, 2019-5:16:40 PM
	 *
	 */
	void Initialize_InitializeClassName();
	
	
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
