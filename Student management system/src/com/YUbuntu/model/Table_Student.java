package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description The student information 
 * @Author #YUbuntu
 * @Date December 5,2018
 * @version 1.0
 */
public class Table_Student
{
	String Student_id;
	String Student_sex;
	String Student_name;
	String Student_password;
	String Student_ClassId;
	String Student_ClassName;

	public String getStudent_id()
	{
		return Student_id;
	}

	public void setStudent_id(String studentID)
	{
		Student_id = studentID;
	}

	public String getStudent_sex()
	{
		return Student_sex;
	}

	public void setStudent_sex(String student_sex)
	{
		Student_sex = student_sex;
	}

	public String getStudent_name()
	{
		return Student_name;
	}

	public void setStudent_name(String student_name)
	{
		Student_name = student_name;
	}

	public String getStudent_password()
	{
		return Student_password;
	}

	public void setStudent_password(String student_password)
	{
		Student_password = student_password;
	}

	public String getStudent_ClassId()
	{
		return Student_ClassId;
	}

	public void setStudent_ClassId(String string)
	{
		Student_ClassId = string;
	}

	public String getStudent_ClassName()
	{
		return Student_ClassName;
	}

	public void setStudent_ClassName(String student_ClassName)
	{
		Student_ClassName = student_ClassName;
	}
	
	/* 
	 *  Position : com.YUbuntu.view.StudentList_JInternalFrame
	 *  
	 *  addItem();
	 * --------------------------------------------------------------------------------------------------------------------
	 *	Warning:Focus and keyboard navigation problems may arise if you add duplicate String objects. 					  |
	 *  A workaround is to add new objects instead of String objects and make sure that the toString() method is defined. |
	 * --------------------------------------------------------------------------------------------------------------------
	 */
	@Override
	public String toString()
	{
		return this.Student_ClassName;
	}

}
