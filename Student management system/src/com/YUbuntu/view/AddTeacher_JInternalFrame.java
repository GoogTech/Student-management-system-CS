package com.YUbuntu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.StringUtil;

public class AddTeacher_JInternalFrame extends JInternalFrame
{
	private JTextField TeacherName_TextField;
	private JTextField TeacherID_TextField;
	private JTextField TeacherTitle_TextField;
	private JTextField TeacherTelephone_TextField;

	// Button group creation feature: restricts the user to selecting only one of the buttons
	private ButtonGroup buttonGroup;
	private JRadioButton TeacherSex_Male_JRadioButton;
	private JRadioButton TeacherSex_Female_JRadioButton;
	private JTextField TeacherAge_TextField;
	private JPasswordField TeacherPassword_PasswordField;

	// Extract objects for easy operation
	private JComboBox ChooseClassName_JComboBox;

	/**
	 * Create the frame.
	 */
	public AddTeacher_JInternalFrame()
	{
		/*
		 * ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);

		setTitle("Add new teacher information");
		setBounds(100, 100, 644, 582);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherName_TextField = new JTextField();
		TeacherName_TextField.setColumns(10);

		JLabel lblAge = new JLabel("Sex");
		lblAge.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherID_TextField = new JTextField();
		TeacherID_TextField.setColumns(10);

		TeacherSex_Male_JRadioButton = new JRadioButton("Male");
		TeacherSex_Male_JRadioButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		TeacherSex_Female_JRadioButton = new JRadioButton("Female");
		TeacherSex_Female_JRadioButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		/*
		 * Button group creation feature: restricts the user to selecting only one of the buttons
		 */
		buttonGroup = new ButtonGroup();
		buttonGroup.add(TeacherSex_Male_JRadioButton);
		buttonGroup.add(TeacherSex_Female_JRadioButton);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherTitle_TextField = new JTextField();
		TeacherTitle_TextField.setColumns(10);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherTelephone_TextField = new JTextField();
		TeacherTelephone_TextField.setColumns(10);

		JButton Confirm_JButton = new JButton("Confirm");
		Confirm_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_AddTeacher(e);
			}
		});
		Confirm_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));

		JButton Reset_JButton = new JButton("Reset");
		Reset_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_ResetInformation(e);
			}
		});
		Reset_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));

		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherAge_TextField = new JTextField();
		TeacherAge_TextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 15));

		TeacherPassword_PasswordField = new JPasswordField();

		ChooseClassName_JComboBox = new JComboBox();

		JLabel lblClassName = new JLabel("Class name");
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblName, Alignment.LEADING).addComponent(lblId, Alignment.LEADING)
						.addComponent(lblTelephone, Alignment.LEADING).addComponent(lblTitle, Alignment.LEADING)
						.addComponent(lblAge, Alignment.LEADING).addComponent(lblNewLabel, Alignment.LEADING)
						.addComponent(lblPassword, Alignment.LEADING)
						.addComponent(lblClassName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(Confirm_JButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(TeacherID_TextField, Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(TeacherSex_Male_JRadioButton)
										.addGap(38).addComponent(TeacherSex_Female_JRadioButton))
								.addComponent(TeacherAge_TextField, 241, 241, Short.MAX_VALUE)
								.addComponent(ChooseClassName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TeacherPassword_PasswordField).addComponent(TeacherName_TextField)
								.addComponent(TeacherTitle_TextField).addComponent(TeacherTelephone_TextField))
						.addContainerGap(163, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Reset_JButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(135)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(46)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblId).addComponent(
								TeacherID_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
								.addComponent(TeacherName_TextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword)
								.addComponent(TeacherPassword_PasswordField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(ChooseClassName_JComboBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblClassName))
						.addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(TeacherAge_TextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAge)
								.addComponent(TeacherSex_Male_JRadioButton)
								.addComponent(TeacherSex_Female_JRadioButton))
						.addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTitle)
								.addComponent(TeacherTitle_TextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTelephone)
								.addComponent(TeacherTelephone_TextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(Confirm_JButton)
								.addComponent(Reset_JButton))
						.addGap(22)));
		getContentPane().setLayout(groupLayout);

		/*
		 * -------------------------------------------------------------------------------- 
		 * Initializes the class name and displays it in the 'ChooseClassName_JComboBox'  |
		 * --------------------------------------------------------------------------------
		 */
		Initialize_InitializeClassName();
	}

	/**
	 * 
	 * @Title Function
	 * @Description Add new teacher information into MySQL database. 
	 * @param ActionEvent e 
	 * @return void 
	 * @date December 16, 2018-8:35:14 AM 
	 * @throws
	 *
	 */
	protected void Function_AddTeacher(ActionEvent e)
	{
		String teacherID = TeacherID_TextField.getText().toString();
		String teacherName = TeacherName_TextField.getText().toString();
		String teacherPassword = TeacherPassword_PasswordField.getText();
		int teacherAge;
		// So simple ! (っ•̀ω•́)っ✎⁾⁾ ~
		String teacherSex = TeacherSex_Male_JRadioButton.isSelected() ? TeacherSex_Male_JRadioButton.getText()
				: TeacherSex_Female_JRadioButton.getText();
		String teacherTitle = TeacherTitle_TextField.getText().toString();
		String teacherTelephone = TeacherTelephone_TextField.getText().toString();

		// User friendly prompts.
		try
		{
			teacherAge = Integer.parseInt(TeacherAge_TextField.getText().toString());
		} catch (Exception e2)
		{
			JOptionPane.showMessageDialog(this, "Please fill in the correct age format !");
			TeacherAge_TextField.setText("");
			return;
		}
		if (StringUtil.IsEmpty(teacherID) || StringUtil.IsEmpty(teacherName) || StringUtil.IsEmpty(teacherPassword)
				|| StringUtil.IsEmpty(TeacherAge_TextField.getText().toString()) || StringUtil.IsEmpty(teacherTitle)
				|| StringUtil.IsEmpty(teacherTelephone))
		{
			JOptionPane.showMessageDialog(this, "Please add the information completely !");
			return;
		}

		// The first step : Initializes the student information.
		Table_Class table_Class = (Table_Class) ChooseClassName_JComboBox.getSelectedItem();
		Table_Teacher table_Teacher = new Table_Teacher();

		/*-----------------------------------------------------------------------------------------------------------
		 * Initializes the user's class ID and class name information based on the class name selected by the user. |
		 *-----------------------------------------------------------------------------------------------------------
		 */
		table_Teacher.setTeacher_ClassID(table_Class.get_CLASS_ID());
		table_Teacher.setTeacher_ClassName(table_Class.get_CLASS_NAME());

		table_Teacher.setTeacher_id(teacherID);
		table_Teacher.setTeacher_name(teacherName);
		table_Teacher.setTeacher_password(teacherPassword);
		table_Teacher.setTeacher_age(teacherAge);
		table_Teacher.setTeacher_sex(teacherSex);
		table_Teacher.setTeacher_title(teacherTitle);
		table_Teacher.setTeacher_telephone(teacherTelephone);

		// The second step : stores the student information into the MySQL database.
		Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
		if (teacher_Dao.addTeacher(table_Teacher))
		{
			JOptionPane.showMessageDialog(this, "Success to add teacher !");
		} else
		{
			JOptionPane.showMessageDialog(this, "Fail to add teacher !");
		}

		// The last step : Reset the data entered by the user
		Function_ResetInformation(e);

	}

	/**
	 * 
	 * @Title
	 * @Description TODO 
	 * @param @return void 
	 * @date Dec 17, 20188:52:17 AM 
	 * @throws
	 *
	 */
	private void Initialize_InitializeClassName()
	{
		Class_DaoImpl class_Dao = new Class_DaoImpl();
		List<Table_Class> list = class_Dao.getClassList(new Table_Class());

		for (Table_Class table : list)
		{
			/*
			 * addItem();
			 * -------------------------------------------------------------------------------------------------------------------- 
			 * Warning:Focus and keyboard navigation  problems may arise if you add duplicate String objects.					  | 
			 * A workaround is to add new objects instead of String objects and make sure that the toString() method is defined.  |
			 * --------------------------------------------------------------------------------------------------------------------
			 */
			ChooseClassName_JComboBox.addItem(table);

			/*
			 * System.err.println(table); [ Before overwriting the toString method, the class name is shown as follows: ]
			 * 
			 * com.YUbuntu.model.Table_Class@6d907fb3 eg:(@6d907fb3)	<———— The address of object in memory com.YUbuntu.model.Table_Class@328a3c2d
			 * com.YUbuntu.model.Table_Class@760f2d0d ...
			 */
		}
	}

	/**
	 * 
	 * @Title Function
	 * @Description Reset the data entered by the user
	 * @param ActionEvent e
	 * @return void
	 * @date Dec 15, 2018-9:30:29 PM
	 * @throws no
	 *
	 */
	protected void Function_ResetInformation(ActionEvent e)
	{
		TeacherID_TextField.setText("");
		TeacherName_TextField.setText("");
		TeacherPassword_PasswordField.setText("");
		TeacherAge_TextField.setText("");
		buttonGroup.clearSelection();
		TeacherTitle_TextField.setText("");
		TeacherTelephone_TextField.setText("");
	}
}
