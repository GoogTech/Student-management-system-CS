package com.YUbuntu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.Course_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_SelectCourse;
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
	private JComboBox StudentName_JComboBox;
	private JComboBox CourseName_JComboBox ;
	private JTable CourseInformation_JTable;
	private JComboBox ModifyStudentName_JComboBox;
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
		setBounds(100, 100, 780, 557);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		StudentName_JComboBox = new JComboBox();
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		CourseName_JComboBox = new JComboBox();
		
		JButton ConfirmChooseCourse_JButton = new JButton("Confirm choose");
		ConfirmChooseCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modify the course selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStudentName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblCourseName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(ConfirmChooseCourse_JButton))
						.addComponent(panel, 0, 0, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseName)
						.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmChooseCourse_JButton))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStudentName_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ModifyStudentName_JComboBox, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCourseName_1)
							.addGap(18)
							.addComponent(ModifyCourseName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
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
						.addComponent(ModifyStudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmModifyCourse_JButton))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName_1)
						.addComponent(ModifyCourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmExitCourse_JButton))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		CourseInformation_JTable = new JTable();
		CourseInformation_JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial number", "Student name", "Teacher name", "Course name", "Head count", "Remaining", "Course introduce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CourseInformation_JTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		CourseInformation_JTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		CourseInformation_JTable.getColumnModel().getColumn(2).setPreferredWidth(86);
		CourseInformation_JTable.getColumnModel().getColumn(3).setPreferredWidth(78);
		CourseInformation_JTable.getColumnModel().getColumn(4).setPreferredWidth(70);
		CourseInformation_JTable.getColumnModel().getColumn(5).setPreferredWidth(65);
		CourseInformation_JTable.getColumnModel().getColumn(6).setPreferredWidth(221);
		scrollPane.setViewportView(CourseInformation_JTable);
		getContentPane().setLayout(groupLayout);
		
		/*
		 * Initializes the student name and displays it in the specified place.
		 */
		Initialize_InitializeStudentName();
		
		/*
		 * Initializes the course name and displays it in the specified place.
		 */
		Initialize_InitializeCourseName();
	}
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the informaton of course selection into the table.
	 * @param Table_SelectCourse
	 * @return void
	 * @date Jan 17, 2019-4:53:46 PM
	 *
	 */
	public void Initialize_CourseInfoTable(Table_SelectCourse table_SelectCourse)
	{
		
		//Gets the model object for the table.
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseInformation_JTable.getModel();
		//Clear the list of tables.
		defaultTableModel.setRowCount(0);
		
		//Obtain teacher information.
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
	
		List<Table_SelectCourse> list = course_DaoImpl.getChooseCourseList(table_SelectCourse);
		
		//Write the obtained course information into the table of course selection.
		for (Table_SelectCourse table_SelectCourse_ : list)
		{
			Vector<Object> vector = new Vector<Object>();
			
			vector.add(table_SelectCourse_.getCourse_ID());
			vector.add(table_SelectCourse_.getStudent_Name());
			vector.add(table_SelectCourse_.getTeacher_Name());
			vector.add(table_SelectCourse_.getCourse_Name());
			vector.add(table_SelectCourse_.getCourse_Introduction());
			/*
			 * This is an implementation of TableModel thatuses a Vector of Vectors to store thecell value objects.
			 */
			defaultTableModel.addRow(vector);
		}
	}
	
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the student name.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:37:20 PM
	 *
	 */
	public void Initialize_InitializeStudentName()
	{
		Student_DaoImpl student_DaoImpl = new Student_DaoImpl();
		List<Table_Student> list = student_DaoImpl.getStudentList(new Table_Student());
				
		for (Table_Student table_Student : list)
		{
			/*
			 * Attention : The method of addItem.
			 */
			StudentName_JComboBox.addItem(table_Student);
			ModifyStudentName_JComboBox.addItem(table_Student);
			
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
