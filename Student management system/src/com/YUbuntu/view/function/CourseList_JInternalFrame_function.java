package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.YUbuntu.model.Table_Course;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Extract panel functionality into the interface.
 * @Author HuangYuhui
 * @Date Jan 15, 2019-1:07:19 PM
 * @version 2.0
 */
public interface CourseList_JInternalFrame_function
{
	
	/**
	 * @Title Update
	 * @Description Update the course information.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 16, 2019-9:12:09 PM
	 *
	 */
	void Function_ModifyCourseInfo(ActionEvent e);
	
	/** 
	 * @Title Select
	 * @Description Select the specified course information.
	 * @param Performed action
	 * @return void
	 * @date Jan 15, 2019-6:42:42 PM
	 *
	 */
	void Function_SearchCourse(ActionEvent e);
	
	/**
	 * @Title Initialize
	 * @Description Add the selected course information to the pointing location.
	 * @param Mouse clicked
	 * @return void
	 * @date Jan 15, 2019-6:30:49 PM
	 *
	 */
	void Initialize_SelectCourseTableRow(MouseEvent e);
	
	/**
	 * @Title Select
	 * @Description Select the teacher information.
	 * @param empty
	 * @return void
	 * @date Jan 15, 2019-5:47:13 PM
	 *
	 */
	void Initialize_InitializeTeacherName();
	
	/**
	 * @Title Select
	 * @Description Select the course information.
	 * @param Table_Course
	 * @return void
	 * @date Jan 15, 2019-4:54:53 PM
	 *
	 */
	void Function_InitializedCourseTable(Table_Course table_Course);
}
