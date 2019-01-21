package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.YUbuntu.model.Table_ChoosedCourse;

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
	 * @Description Get the data which click the specified row in the table.
	 * @param MouseEvent e
	 * @return void
	 * @date Jan 21, 2019-5:49:44 PM
	 *
	 */
	void Initialize_ClickCourseTableRow(MouseEvent e);
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the data in the specified position. 
	 * @param empty
	 * @return void
	 * @date Jan 21, 2019-4:33:00 PM
	 *
	 */
	void Function_ClearData();
	
	
	/**
	 * 
	 * @Title Function
	 * @Description Exit the specified course which you don't like.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 21, 2019-4:07:00 PM
	 *
	 */
	void Function_ExitCourse(ActionEvent e);
	
	
	/**
	 * 
	 * @Title Function 
	 * @Description Modify the information about the course selection.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 21, 2019-4:03:33 PM
	 *
	 */
	void Function_ModifyCourseSelectionInfo(ActionEvent e);
	
	
	/**
	 *
	 * @Title Function
	 * @Description Choose the specified course.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 21, 2019-4:05:47 PM
	 *
	 */
	void Function_ChooseCourse(ActionEvent e);
	
	
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
	 * @Description Initialize the class name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 18, 2019-5:16:40 PM
	 *
	 */
	void Initialize_InitializeClassName();
	
	
	/**
	 * 
	 * @Title Initialize 
	 * @Description Initialize the course name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:55:32 PM
	 *
	 */
	void Initialize_InitializeCourseName();
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the teacher name in the JComboBox.
	 * @param Empty
	 * @return void
	 * @date Jan 21, 2019-6:33:32 PM
	 *
	 */
	void Initialize_InitializeTeacherName();
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the student name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 21, 2019-6:11:59 PM
	 *
	 */
	void Initialize_InitializeStudentName();
	
}
