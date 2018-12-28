package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Abstract the system function into the interface.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-5:28:24 PM
 * @version 1.0
 */
public interface AddTeacher_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Add a new teacher.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-5:30:23 PM
	 * @throws ..
	 *
	 */
	void Function_AddTeacher(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Get the class name.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-5:31:44 PM
	 * @throws ..
	 *
	 */
	void Initialize_InitializeClassName();
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-5:32:33 PM
	 * @throws ..
	 *
	 */
	void Function_ResetInformation(ActionEvent e);
}
