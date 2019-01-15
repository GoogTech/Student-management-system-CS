package com.YUbuntu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.YUbuntu.dao.impl.Administrator_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_Administrator;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.model.UserType;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.Login_JFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The login interface of user
 * @Author #YUbuntu
 * @Date November 29,2018
 * @version 1.0
 */
public class Login_JFrame extends JFrame implements Login_JFrame_function
{

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New label");

	// ---------- the information entered by the user ----------
	private JTextField UserName_TextField;
	private JPasswordField User_PasswordField;
	private JComboBox UserType_ComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		/*------------------
		 *  Design for UI  |
		 *------------------
		 */
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		/*
		 * The entry to the program.
		 */
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{		
					Login_JFrame frame = new Login_JFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.s
	 */
	public Login_JFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_JFrame.class.getResource("/icon/#YUbuntu logo.jpg")));
		setTitle("Login interface \uFF08Progress : a quarter\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Center the login screen
		setLocationRelativeTo(null);

		JLabel lblNewLabel_1 = new JLabel("Student management system");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setIcon(new ImageIcon(Login_JFrame.class.getResource("")));
		lblUserName.setFont(new Font("Consolas", Font.PLAIN, 13));

		JLabel lblUserPassword = new JLabel("User password");
		lblUserPassword.setIcon(new ImageIcon(Login_JFrame.class.getResource("")));
		lblUserPassword.setFont(new Font("Consolas", Font.PLAIN, 13));

		UserName_TextField = new JTextField();
		UserName_TextField.setColumns(10);

		User_PasswordField = new JPasswordField();

		JLabel lblTheUserTypes = new JLabel("The user types");
		lblTheUserTypes.setIcon(new ImageIcon(Login_JFrame.class.getResource("")));
		lblTheUserTypes.setFont(new Font("Consolas", Font.PLAIN, 13));

		UserType_ComboBox = new JComboBox();
		UserType_ComboBox.setFont(new Font("Consolas", Font.PLAIN, 12));

		// ########## Receive the user type object ##########
		// UserType_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Teacher", "Student"}));
		UserType_ComboBox.setModel(new DefaultComboBoxModel(new UserType[] { UserType.Adminstrator, UserType.Teacher, UserType.Student }));

		JButton LoginIn_JButton = new JButton("Login");
		LoginIn_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LoginEvent(e);
			}
		});
		LoginIn_JButton.setIcon(new ImageIcon(Login_JFrame.class.getResource("")));
		LoginIn_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));

		JButton Reset_JButton = new JButton("Reset");
		Reset_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_ResetInformation(e);
			}
		});
		Reset_JButton.setIcon(new ImageIcon(Login_JFrame.class.getResource("")));
		Reset_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblTheUserTypes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblUserPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
										.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(UserName_TextField, 181, 181, 181)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(User_PasswordField)
											.addComponent(UserType_ComboBox, 0, 181, Short.MAX_VALUE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(LoginIn_JButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(Reset_JButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName)
						.addComponent(UserName_TextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserPassword)
						.addComponent(User_PasswordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTheUserTypes)
						.addComponent(UserType_ComboBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginIn_JButton)
						.addComponent(Reset_JButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 
	 * @Title Function
	 * @Description Handing login events
	 * @param event
	 * @date November 29,2018
	 * @exception no
	 */
	public void LoginEvent(ActionEvent e)
	{

		// Get the information entered by the user
		String userName = UserName_TextField.getText().toString();
		// Be careful : getPassword();
		String userPassword = User_PasswordField.getText().toString();
		/*-------------------------------------------------
		 * Return : The type of user selected by the user |
		 *-------------------------------------------------
		 */
		UserType UserType_selectItem = (UserType) UserType_ComboBox.getSelectedItem();

		if (StringUtil.IsEmpty(userName))
		{
			JOptionPane.showMessageDialog(this, "Please enter the name of user !");
			// return; //End program
		}
		if (StringUtil.IsEmpty(userPassword))
		{
			JOptionPane.showMessageDialog(this, "Please enter the password of user !");
			return;
		}

		/*
		 * ------------------------------------------------------------------- 
		 * Determine the user type, different types of different permissions |
		 * -------------------------------------------------------------------
		 */
		if ("Administrator".equals(UserType_selectItem.getName()))
		{
						
			//Store personal information entered by users.
			Table_Administrator table_Administrator_temp = new Table_Administrator();
			table_Administrator_temp.setName(userName);
			table_Administrator_temp.setPassword(userPassword);
			
			/*
			 * ----------------------------------------------------------- 
			 * Verify that the login data entered by the user is correct |
			 * -----------------------------------------------------------
			 */
			Administrator_DaoImpl administrator_Dao = new Administrator_DaoImpl();
			Table_Administrator table_Administrator = administrator_Dao.Login_Administrator(table_Administrator_temp);

			//Friendly tips
			if (table_Administrator == null)
			{ 	
				JOptionPane.showMessageDialog(this, "The user name or password is error !");
				return;
			} 
			else
			{
				JOptionPane.showMessageDialog(this,  "Welcome : " + UserType_selectItem + " : "
						+ table_Administrator.getName());
				// Close the interface of login
				this.dispose();

				/*==================================================================================
				 * Pararms : Initialize the main interface though the user's personal information. |
				 *==================================================================================
				 */
				new Main_JFrame(UserType_selectItem, table_Administrator).setVisible(true);
			}

		}
		else if ("Student".equals(UserType_selectItem.getName()))
		{
			//Store personal information entered by users
			Table_Student table_Student_temp = new Table_Student();
			table_Student_temp.setStudent_name(userName);
			table_Student_temp.setStudent_password(userPassword);
			
			//Verify that login data entered by the user is correct
			Student_DaoImpl student_Dao = new Student_DaoImpl();
			Table_Student table_Student = student_Dao.Login_Student(table_Student_temp);
			
			//Friendly tip
			if(table_Student == null)
			{
				JOptionPane.showMessageDialog(this, "The user name or password is error !");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this,  "Welcome : " + UserType_selectItem + " : "
						+ table_Student.getStudent_name());
				
				// Close the interface of login
				this.dispose();
				
				/*==================================================================================
				 * Pararms : Initialize the main interface though the user's personal information. |
				 *==================================================================================
				 */
				new Main_JFrame(UserType_selectItem, table_Student).setVisible(true);
			}	
		} 
		
		else if("Teacher".equals(UserType_selectItem.getName()))
		{
			//Store personal information entered by users
			Table_Teacher table_Teacher_temp = new Table_Teacher();
			table_Teacher_temp.setTeacher_name(userName);
			table_Teacher_temp.setTeacher_password(userPassword);
			
			//Verify that login data entered by the user is correct
			Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
			Table_Teacher table_Teacher = teacher_Dao.Login_Teacher(table_Teacher_temp);
			
			//Friendly tip
			if(table_Teacher == null)
			{
				JOptionPane.showMessageDialog(this, "The user name or password is error !");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Welcome : " + UserType_selectItem + " : "
						+ table_Teacher.getTeacher_name());
				
				// Close the interface of login
				this.dispose();
				new Main_JFrame(UserType_selectItem, table_Teacher).setVisible(true);
			}
		}
	}
	
	
	/**
	 * 
	 * @Title Function 
	 * @Description Reset the inforamtion entered by the user 
	 * @param event 
	 * @date November 29,2018
	 */
	public void Function_ResetInformation(ActionEvent e)
	{

		UserName_TextField.setText("");
		User_PasswordField.setText("");
		UserType_ComboBox.setSelectedIndex(0);
	}
}
