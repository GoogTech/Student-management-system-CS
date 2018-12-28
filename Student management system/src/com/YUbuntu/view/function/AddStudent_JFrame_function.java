package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description  
 * @Author #YUbuntu
 * @Date Dec 28, 2018-5:06:32 PM
 * @version 1.0
 */
public interface AddStudent_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Add a new student.
	 * @param performed action
	 * @return void
	 * @date Dec 28, 2018-5:07:27 PM
	 * @throws ..
	 *
	 */
	void Function_AddStudent(ActionEvent e);
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Get class name.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-5:13:21 PM
	 * @throws ..
	 *
	 */
	void Initialize_InitializeClassName();
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information.
	 * @param performed action
	 * @return void
	 * @date Dec 28, 2018-5:15:08 PM
	 * @throws 
	 *
	 */
	void Function_ResetInformation(ActionEvent e);	
}
