package com.YUbuntu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.ChooseCourse_DaoImpl;
import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Course_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.model.Table_ChoosedCourse;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.view.function.ChooseCourse_JF_function;


/**
 *
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description Course selection interface.
 * @Author HuangYuhui
 * @Date Jan 17, 2019-3:07:35 PM
 * @version 2.0
 */
public class ChooseCourse_JInternalFrame extends JInternalFrame implements ChooseCourse_JF_function
{
	private JComboBox ClassName_JComboBox;
	private JComboBox<Table_Student> StudentName_JComboBox;
	private JComboBox CourseName_JComboBox ;
	private JTable CourseInformation_JTable;
	private JComboBox<Table_Student> ModifyStudentName_JComboBox;
	private JComboBox ModifyCourseName_JComboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ChooseCourse_JInternalFrame frame = new ChooseCourse_JInternalFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseCourse_JInternalFrame()
	{
		/* 
		 * Improve the function of the interface (You can close it, you can icon it) ~
		 */
		setClosable(true);
		setIconifiable(true);
		
		setTitle("Choose course interface");
		setBounds(100, 100, 1020, 558);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		StudentName_JComboBox = new JComboBox();
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		CourseName_JComboBox = new JComboBox();
		
		JButton ConfirmChooseCourse_JButton = new JButton("Confirm choose");
		ConfirmChooseCourse_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ChooseCourse(e);
			}
		});
		ConfirmChooseCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modify the course selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Class name");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		ClassName_JComboBox = new JComboBox();
		
		/*
		 * Test the JComboBox of item event !
		 */
		ClassName_JComboBox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				Initialize_DisplayStudentName(e);
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ClassName_JComboBox, 0, 143, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblStudentName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblCourseName)
							.addGap(29)
							.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(ConfirmChooseCourse_JButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE))
					.addContainerGap(32, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmChooseCourse_JButton)
						.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(ClassName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseName)
						.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentName))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		JLabel lblStudentName_1 = new JLabel("Student name");
		lblStudentName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyStudentName_JComboBox = new JComboBox();
		
		JLabel lblCourseName_1 = new JLabel("Course name");
		lblCourseName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyCourseName_JComboBox = new JComboBox();
		
		JButton ConfirmModifyCourse_JButton = new JButton("Confirm modify");
		ConfirmModifyCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton ConfirmExitCourse_JButton = new JButton("Exit course");
		ConfirmExitCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStudentName_1)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(ModifyStudentName_JComboBox, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCourseName_1)
							.addGap(38)
							.addComponent(ModifyCourseName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 495, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ConfirmExitCourse_JButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ConfirmModifyCourse_JButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName_1)
						.addComponent(ConfirmModifyCourse_JButton)
						.addComponent(ModifyStudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName_1)
						.addComponent(ConfirmExitCourse_JButton)
						.addComponent(ModifyCourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		CourseInformation_JTable = new JTable();
		CourseInformation_JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial number", "Student ID", "Student name", "Teacher ID", "Teacher name", "Course ID", "Course name", "Head count", "Remaining", "Course introduce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CourseInformation_JTable.getColumnModel().getColumn(0).setPreferredWidth(91);
		CourseInformation_JTable.getColumnModel().getColumn(1).setPreferredWidth(71);
		CourseInformation_JTable.getColumnModel().getColumn(2).setPreferredWidth(87);
		CourseInformation_JTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		CourseInformation_JTable.getColumnModel().getColumn(5).setPreferredWidth(67);
		CourseInformation_JTable.getColumnModel().getColumn(6).setPreferredWidth(122);
		CourseInformation_JTable.getColumnModel().getColumn(7).setPreferredWidth(71);
		CourseInformation_JTable.getColumnModel().getColumn(8).setPreferredWidth(65);
		CourseInformation_JTable.getColumnModel().getColumn(9).setPreferredWidth(221);
		scrollPane.setViewportView(CourseInformation_JTable);
		getContentPane().setLayout(groupLayout);
		
		/*
		 * Initializes the class name and displays it in the specified place.
		 */
		Initialize_InitializeClassName();

		/*
		 * Initializes the course name and displays it in the specified place.
		 */
		Initialize_InitializeCourseName();
		
		/*
		 * Initizlize the table of course selection.
		 */
		Initialize_ChoosedCourseInfoTable(new Table_ChoosedCourse());
	}
	
	
	/**
	 * @Title Function
	 * @Description The function of course selection.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 18, 2019-8:02:12 PM
	 *
	 */
	protected void Function_ChooseCourse(ActionEvent e)
	{
		ChooseCourse_DaoImpl chooseCourse_DaoImpl = new ChooseCourse_DaoImpl();
		Table_ChoosedCourse table_ChoosedCourse = new Table_ChoosedCourse();
		
		/*
		 * Get the specified student information by the student name.
		 */
		String studentName = StudentName_JComboBox.getSelectedItem().toString();
		String studentID = chooseCourse_DaoImpl.getStudentID(studentName);
		 
		
		/*
		 * Get the all of course information by the course name.
		 */
		String courseName = CourseName_JComboBox.getSelectedItem().toString();	
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
		Table_Course table_Course = course_DaoImpl.getCourseInfo(courseName);
		
		/*
		 * Store the information about the course selection.
		 */
		table_ChoosedCourse.setStudent_ID(studentID);
		table_ChoosedCourse.setStudent_Name(studentName);

		table_ChoosedCourse.setTeacher_ID(table_Course.getTeacher_ID());
		table_ChoosedCourse.setTeacher_Name(table_Course.getTeacher_name());
		table_ChoosedCourse.setCourse_ID(table_Course.getCourse_ID());
		table_ChoosedCourse.setCourse_Name(table_Course.getCourse_name());
		table_ChoosedCourse.setMaxStudentNumber(table_Course.getCourse_MaxStudentNumber());
		table_ChoosedCourse.setChoosedStudentNumber(table_Course.getSelected_StudentNumber());
		table_ChoosedCourse.setCourse_Introduction(table_Course.getCourse_Introduction());
			
		/*
		 * Determine whether the operation is successful.
		 */
		if(chooseCourse_DaoImpl.AddCourseSelectionInfo(table_ChoosedCourse))
		{
			JOptionPane.showMessageDialog(this, "Success to add new course !");
			Initialize_ChoosedCourseInfoTable(new Table_ChoosedCourse());
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Sorry ! Fail to add new course !", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	

	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the informaton of course selection into the table.
	 * @param Table_ChoosedCourse
	 * @return void
	 * @date Jan 17, 2019-4:53:46 PM
	 *
	 */
	public void Initialize_ChoosedCourseInfoTable(Table_ChoosedCourse table_SelectCourse)
	{
		
		//Gets the model object for the table.
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseInformation_JTable.getModel();
		//Clear the list of tables.
		defaultTableModel.setRowCount(0);
		
		//Obtain teacher information.
		ChooseCourse_DaoImpl chooseCourse_DaoImpl = new ChooseCourse_DaoImpl();
	
		List<Table_ChoosedCourse> list = chooseCourse_DaoImpl.getChoosedCourseList(table_SelectCourse);
		
		//Write the obtained course information into the table of course selection.
		for (Table_ChoosedCourse table_SelectCourse_ : list)
		{
			Vector<Object> vector = new Vector<Object>();
			
			vector.add(table_SelectCourse_.getChoosedCourse_ID());
			vector.add(table_SelectCourse_.getStudent_ID());
			vector.add(table_SelectCourse_.getStudent_Name());
			vector.add(table_SelectCourse_.getTeacher_ID());
			vector.add(table_SelectCourse_.getTeacher_Name());
			vector.add(table_SelectCourse_.getCourse_ID());
			vector.add(table_SelectCourse_.getCourse_Name());
			vector.add(table_SelectCourse.getMaxStudentNumber());
			vector.add(table_SelectCourse.getChoosedStudentNumber());
			vector.add(table_SelectCourse_.getCourse_Introduction());
			
			defaultTableModel.addRow(vector);
		}
	}
	
	
	/**
	 * @Title Initialize the student name by the class name.
	 * @Description Display the student name by the class name.
	 * @param empty
	 * @return void
	 * @date Jan 18, 2019-6:40:51 PM
	 *
	 */
	protected void Initialize_DisplayStudentName(ItemEvent e)
	{	
		/*
		 * Clear the student item.
		 */
		StudentName_JComboBox.setSelectedIndex(-1);
		
		/*
		 * Get the class name.
		 */
		String className = ClassName_JComboBox.getSelectedItem().toString();		
		
		/*
		 * Get the student name by the class name.
		 */
		Student_DaoImpl student_DaoImpl = new Student_DaoImpl();
		List<Table_Student> list_studentName = student_DaoImpl.getStudentName(className);
	
		for (Table_Student table_Student : list_studentName)
		{
			StudentName_JComboBox.addItem(table_Student);
			ModifyStudentName_JComboBox.addItem(table_Student);
		}
	}
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the class name.
	 * @param empty
	 * @return void
	 * @date Jan 18, 2019-5:15:59 PM
	 *
	 */
	public void Initialize_InitializeClassName()
	{
		Class_DaoImpl class_DaoImpl = new Class_DaoImpl();
		List<Table_Class> list = class_DaoImpl.getClassList(new Table_Class());
		
		for (Table_Class table_Class : list)
		{
			ClassName_JComboBox.addItem(table_Class);
		}
	}
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the course name.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:50:06 PM
	 *
	 */
	public void Initialize_InitializeCourseName()
	{
		Course_DaoImpl class_Dao = new Course_DaoImpl();
		List<Table_Course> list = class_Dao.getCourseList(new Table_Course());
				
		for (Table_Course table_Course : list)
		{
			/*
			 * Attention : The method of addItem.
			 */
			CourseName_JComboBox.addItem(table_Course);
			ModifyCourseName_JComboBox.addItem(table_Course);
			
		}
	}
}
