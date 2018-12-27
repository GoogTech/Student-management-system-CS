package com.YUbuntu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.util.StringUtil;

/**
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of adding new student information
 * @Author #YUbuntu
 * @Date  December 5,2018
 * @version 1.0
 * 
 */
public class AddStudent_JFrame extends /*JFrame*/ JInternalFrame
{

	//Extract objects for easy operation
	private JPanel contentPane;
	private JTextField StudentID_textField;
	private JTextField StudentName_textField;
	private JPasswordField Student_PasswordField;
	
	/*
	 * Type safety: The method addItem(Object) belongs to the raw type JComboBox. 
	 * References to generic type JComboBox<E> should be parameterized
	 */
	private JComboBox<Table_Class> StudentClassName_ComboBox;
	
	//Button group creation feature: restricts the user to selecting only one of the buttons
	private ButtonGroup buttonGroup; 
	private JRadioButton Male_JRadioButton;
	private JRadioButton Female_JRadioButton;
	

	/**
	 * Launch the application.——>(Close program entry)
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddStudent_JFrame frame = new AddStudent_JFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 */
	public AddStudent_JFrame()
	{
		/* ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);
		
		setFont(new Font("Consolas", Font.PLAIN, 20));
		setTitle("Add student");
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 399, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		StudentName_textField = new JTextField();
		StudentName_textField.setFont(new Font("幼圆", Font.PLAIN, 15));
		StudentName_textField.setColumns(10);
		
		JLabel lblClass = new JLabel("class");
		lblClass.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		StudentClassName_ComboBox = new JComboBox<Table_Class>();
		//StudentClassName_ComboBox.setModel(new DefaultComboBoxModel<Table_Class>());
		StudentClassName_ComboBox.setFont(new Font("幼圆", Font.PLAIN, 15));
		//StudentClassName_ComboBox.setMaximumRowCount(10);
			
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Student_PasswordField = new JPasswordField();
		Student_PasswordField.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Male_JRadioButton = new JRadioButton("Male");
		Male_JRadioButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Female_JRadioButton = new JRadioButton("Female");
		Female_JRadioButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		//Button group creation feature: restricts the user to selecting only one of the buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(Male_JRadioButton);
		buttonGroup.add(Female_JRadioButton);
		
		JButton btnConfirm = new JButton("confirm");
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_AddStudent(e);
			}
		});
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ResetInformation(e);
			}
		});
		btnReset.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnReset.setIcon(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		StudentID_textField = new JTextField();
		StudentID_textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(btnConfirm)
					.addGap(236))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblClass)
						.addComponent(lblId)
						.addComponent(lblName)
						.addComponent(lblSex))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Male_JRadioButton)
							.addGap(37)
							.addComponent(Female_JRadioButton))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(StudentClassName_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(StudentID_textField, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
							.addComponent(Student_PasswordField)
							.addComponent(StudentName_textField)
							.addComponent(btnReset, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(StudentName_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(StudentID_textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClass)
						.addComponent(StudentClassName_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(Student_PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(Male_JRadioButton)
						.addComponent(Female_JRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirm)
						.addComponent(btnReset))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		
		/* --------------------------------------------------------------------------------
		 * Initializes the class name and displays it in the 'StudentClassName_ComboBox'  |
		 * --------------------------------------------------------------------------------
		 */
		Initialize_InitializeClassName();
	}
	
	

	/**
	 * 
	 * @Title Function
	 * @Description Add new student to MySQL database
	 * @param ActionEvent e
	 * @return void
	 * @date December 5,2018
	 *
	 */
	protected void Function_AddStudent(ActionEvent e) 
	{
		String studentName = StudentName_textField.getText().toString();
		String studentID = StudentID_textField.getText().toString();
		String studentPassword = Student_PasswordField.getText();
		
		if(StringUtil.IsEmpty(studentName))
		{
			JOptionPane.showMessageDialog(this, "Please enter the student name !");
			return;
		}
		if(StringUtil.IsEmpty(studentID))
		{
			JOptionPane.showMessageDialog(this, "Please enter the student ID !");
			return;
		}
		if(StringUtil.IsEmpty(studentPassword))
		{
			JOptionPane.showMessageDialog(this,"Please enter the student password !");
			return;
		}
		
		//The first step : Initializes the student information.
		Table_Class table_Class = (Table_Class) StudentClassName_ComboBox.getSelectedItem();		
		Table_Student table_Student = new Table_Student();
		
		/*-----------------------------------------------------------------------------------------------------------
		 * Initializes the user's class ID and class name information based on the class name selected by the user. |
		 *-----------------------------------------------------------------------------------------------------------
		 */
		table_Student.setStudent_ClassId(table_Class.get_CLASS_ID());
		table_Student.setStudent_ClassName(table_Class.get_CLASS_NAME());		
		table_Student.setStudent_name(studentName);
		table_Student.setStudent_id(studentID);
		table_Student.setStudent_password(studentPassword);	
		//So simple ! (っ•̀ω•́)っ✎⁾⁾  ~
		String sex = Male_JRadioButton.isSelected() ? Male_JRadioButton.getText() : Female_JRadioButton.getText();
		table_Student.setStudent_sex(sex);
		
		//The second step :  stores the student information into the MySQL database.
		Student_DaoImpl student_Dao = new Student_DaoImpl();
		if(student_Dao.addStudent(table_Student))
		{
			JOptionPane.showMessageDialog(this,"Success to add student !");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Fail to add student !");
		}
		
		//The last step : Reset the data entered by the user
		Function_ResetInformation(e);
	}


	/**
	 * 
	 * @Title Initialize
	 * @Description Get class information from MySQL database.
	 * @param no
	 * @return void
	 * @date December 5,2018
	 *
	 */
	private void Initialize_InitializeClassName()
	{
		Class_DaoImpl class_Dao = new Class_DaoImpl();
		List<Table_Class> list = class_Dao.getClassList(new Table_Class());
			
		for (Table_Class table : list)
		{
			/*  addItem();
			 * --------------------------------------------------------------------------------------------------------------------
			 *	Warning:Focus and keyboard navigation problems may arise if you add duplicate String objects. 					  |
			 *  A workaround is to add new objects instead of String objects and make sure that the toString() method is defined. |
			 * --------------------------------------------------------------------------------------------------------------------
			 */
			StudentClassName_ComboBox.addItem(table);
				
			/*	System.err.println(table); 
			 *  [ Before overwriting the toString method, the class name is shown as follows: ]
			 * 
			 * 	com.YUbuntu.model.Table_Class@6d907fb3 		eg:(@6d907fb3)<———— The address of object in memory
			 *	com.YUbuntu.model.Table_Class@328a3c2d
			 *	com.YUbuntu.model.Table_Class@760f2d0d
			 *  ...
			 */
		}
		Male_JRadioButton.setSelected(true);//Default:male
	}

	
	/**
	 * 
	 * @Title Funciton
	 * @Description Reset the data entered by the user
	 * @param ActionEvent e
	 * @return void
	 * @date December 5,2018
	 *
	 */
	protected void Function_ResetInformation(ActionEvent e) 
	{
		StudentName_textField.setText("");
		StudentID_textField.setText("");
		Student_PasswordField.setText("");
		StudentClassName_ComboBox.setSelectedIndex(0);
		buttonGroup.clearSelection();
		//Male_JRadioButton.setSelected(true);//Default:male
	}
}
