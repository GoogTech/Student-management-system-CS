package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.YUbuntu.model.Table_Student;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Extract panel functionality into the interface.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-6:16:21 PM
 * @version 1.0
 */
public interface StudentList_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Modify the student information
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:17:57 PM
	 * @throws ..
	 *
	 */
	void Function_ConfirmModify(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description reset the information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:19:39 PM
	 * @throws ..
	 *
	 */
	void Function_ClearData();
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected student information to the pointing location.
	 * @param Mouse click.
	 * @return void
	 * @date Dec 28, 2018-6:20:55 PM
	 * @throws ..
	 *
	 */
	void Initialize_SelectStudentTableRow(MouseEvent e);
	
	/**
	 * 
	 * @Title Function 
	 * @Description Delete the specified student information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:25:02 PM
	 * @throws ..
	 *
	 */
	void Function_DeleteStudent(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Search the specified student information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:26:15 PM
	 * @throws ..
	 *
	 */
	void Function_SearchStudent(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Initializes the information in the student table.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:27:36 PM
	 * @throws ..
	 *
	 */
	void Function_InitializedStudentTable(Table_Student table_Student);
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Get class name.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:28:58 PM
	 * @throws ..
	 *
	 */
	void Initialize_InitializeClassName();
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Set user permissions.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:29:45 PM
	 * @throws ..
	 *
	 */
	void Initialize_SetUserPermissions();
}
