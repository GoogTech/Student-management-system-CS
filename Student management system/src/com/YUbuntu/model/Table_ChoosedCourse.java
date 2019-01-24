package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description Course selection information sheet.
 * @Author HuangYuhui
 * @Date Jan 17, 2019-2:33:44 PM
 * @version 2.0
 */
public class Table_ChoosedCourse
{
	private int ChoosedCourse_ID;
	
	private String Class_ID;
	private String Class_name;
	
	private String Student_ID;
	private String Student_name;
	
	private String Teacher_ID;
	private String Teacher_name;
	
	private String Course_ID;
	private String Course_name;
	
	private int MaxStudentNumber;
	private int ChoosedStudentNumber;
	
	private String Course_Introduction;

	
	public int getChoosedCourse_ID()
	{
		return ChoosedCourse_ID;
	}

	public void setChoosedCourse_ID(int choosedCourse_ID)
	{
		ChoosedCourse_ID = choosedCourse_ID;
	}

	public String getClass_ID()
	{
		return Class_ID;
	}

	public void setClass_ID(String class_ID)
	{
		Class_ID = class_ID;
	}

	public String getClass_name()
	{
		return Class_name;
	}

	public void setClass_name(String class_name)
	{
		Class_name = class_name;
	}

	public String getStudent_ID()
	{
		return Student_ID;
	}

	public void setStudent_ID(String student_ID)
	{
		Student_ID = student_ID;
	}

	public String getStudent_name()
	{
		return Student_name;
	}

	public void setStudent_name(String student_name)
	{
		Student_name = student_name;
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

	public int getMaxStudentNumber()
	{
		return MaxStudentNumber;
	}

	public void setMaxStudentNumber(int maxStudentNumber)
	{
		MaxStudentNumber = maxStudentNumber;
	}

	public int getChoosedStudentNumber()
	{
		return ChoosedStudentNumber;
	}

	public void setChoosedStudentNumber(int choosedStudentNumber)
	{
		ChoosedStudentNumber = choosedStudentNumber;
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
