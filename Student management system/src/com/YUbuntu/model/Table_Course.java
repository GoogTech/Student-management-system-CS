package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description The information of course.
 * @Author #YUbuntu
 * @Date Dec 29, 2018-2:29:47 PM
 * @version 2.0
 */
public class Table_Course
{
	private String Course_ID;
	private String Course_name;
	private String Teacher_ID;
	private String Teacher_name;
	private String Course_MaxStudentNumber;
	private String Course_Introduction;
	
	public String getCourse_ID()
	{
		return Course_ID;
	}
	public void setCourse_ID(String course_ID)
	{
		Course_ID = course_ID;
	}
	public String getCourse_name()
	{
		return Course_name;
	}
	public void setCourse_name(String course_name)
	{
		Course_name = course_name;
	}
	public String getTeacher_ID()
	{
		return Teacher_ID;
	}
	public void setTeacher_ID(String teacher_ID)
	{
		Teacher_ID = teacher_ID;
	}
	public String getTeacher_name()
	{
		return Teacher_name;
	}
	public void setTeacher_name(String teacher_name)
	{
		Teacher_name = teacher_name;
	}
	public String getCourse_MaxStudentNumber()
	{
		return Course_MaxStudentNumber;
	}
	public void setCourse_MaxStudentNumber(String course_MaxStudentNumber)
	{
		Course_MaxStudentNumber = course_MaxStudentNumber;
	}
	public String getCourse_Introduction()
	{
		return Course_Introduction;
	}
	public void setCourse_Introduction(String course_Introduction)
	{
		Course_Introduction = course_Introduction;
	}	
}
