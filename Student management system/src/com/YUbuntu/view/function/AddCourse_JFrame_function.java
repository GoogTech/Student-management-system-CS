package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Extract panel functionality into the interface.
 * @Author #YUbuntu
 * @Date Dec 29, 2018-7:23:39 PM
 * @version 2.0
 */
public interface AddCourse_JFrame_function
{
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initialize the teacher name
	 * @param no
	 * @return void
	 * @date Dec 29, 2018-8:19:29 PM
	 * @throws no
	 *
	 */
	void Initialize_InitializeTeacherName();
	
	/**
	 * 
	 * @Title Function
	 * @Description Add a new course.
	 * @param Performed action
	 * @return void
	 * @date Dec 29, 2018-7:31:28 PM
	 * @throws no
	 *
	 */
	void Function_ConfirmAddCourse(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information.
	 * @param Performed action
	 * @return void
	 * @date Dec 29, 2018-7:32:16 PM
	 * @throws no
	 *
	 */
	void Function_ResetInformation(ActionEvent e);
}
