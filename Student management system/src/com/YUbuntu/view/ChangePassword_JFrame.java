package com.YUbuntu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.YUbuntu.dao.impl.Administrator_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_Administrator;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.ChangePassword_JFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of changing user's password
 * @Author #YUbuntu
 * @Date December 1,2018
 * @version 1.0
 */

/*-------------------------------------------------------------------------------------------------------
 * Attention : extend JInteralFrame																		|
 * userObject  == The object of Table_Adminstrator(The information entered by the user when logging in) |
 * ------------------------------------------------------------------------------------------------------
 */
public class ChangePassword_JFrame extends JInternalFrame /* JFrame */ implements ChangePassword_JFrame_function
{

	private JPanel contentPane;
	private JPasswordField OriginalPassword_Field;
	private JPasswordField NewPassword_Field;
	private JPasswordField ConfirmPassword_Field;

	// Extract objects for easy modification
	private JLabel CurrentUser_JLabel;

	// ########## Determine the type of user logged in ##########
	// private UserType userType;
	// private Object userObject;

	/**
	 * Launch the application.！！>(Close program entry)
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePassword_JFrame frame = new ChangePassword_JFrame();
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
	public ChangePassword_JFrame()
	{

		/*
		 * --------------------------------------- 
		 * Improve the function of the interface | 
		 * ---------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);

		setFont(new Font("Consolas", Font.BOLD, 15));
		setTitle("Change the password");

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 473, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("");

		JLabel lblTheOriginalPassword = new JLabel("Old password");
		lblTheOriginalPassword.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel lblCurrentPassword = new JLabel("New password");
		lblCurrentPassword.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel label_1 = new JLabel("");

		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 15));

		ConfirmPassword_Field = new JPasswordField();

		JButton Confirm_Button = new JButton("Comfirm");
		Confirm_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		Confirm_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Confirm_ChangePassword(e);
			}
		});

		JButton Reset_Button = new JButton("Reset");
		Reset_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Reset_Information(e);
			}
		});
		Reset_Button.setFont(new Font("Consolas", Font.PLAIN, 12));

		NewPassword_Field = new JPasswordField();

		OriginalPassword_Field = new JPasswordField();

		JLabel label_2 = new JLabel("");

		JLabel lblCurrentUser = new JLabel("Current user");
		lblCurrentUser.setFont(new Font("Consolas", Font.PLAIN, 16));

		// ########## The current user of name ##########
		CurrentUser_JLabel = new JLabel("");
		// Hides the label of the current user name
		CurrentUser_JLabel.setEnabled(false);

		CurrentUser_JLabel.setForeground(new Color(0, 255, 0));
		CurrentUser_JLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentPassword, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTheOriginalPassword, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblConfirmPassword)
						.addComponent(lblCurrentUser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(Confirm_Button, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addComponent(label))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(41)
									.addComponent(label_2))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(ConfirmPassword_Field, Alignment.LEADING)
							.addComponent(NewPassword_Field, Alignment.LEADING)
							.addComponent(OriginalPassword_Field, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(CurrentUser_JLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(Reset_Button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentUser))
						.addComponent(CurrentUser_JLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addGap(58))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(OriginalPassword_Field, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTheOriginalPassword)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(NewPassword_Field, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCurrentPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmPassword_Field, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(Confirm_Button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(Reset_Button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(label_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		/*------------------------------------------------------------------
		 * Initialize : Displays the user information of the current login |
		 *------------------------------------------------------------------
		 */
		Function_DisplayUserInformation();
		
	}
	
	/**
	 * 
	 * @Title Funciton
	 * @Description If success to Login,display the user information.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-4:43:24 PM
	 * @throws ..
	 *
	 */
	public void Function_DisplayUserInformation()
	{		
		if ("Administrator".equals(Main_JFrame.userType.getName()))
		{
			Table_Administrator table_Administrator = (Table_Administrator) Main_JFrame.userObject;
			CurrentUser_JLabel.setText("[ " + Main_JFrame.userType.getName() + " ] : " + table_Administrator.getName());
		}
		else if("Student".equals(Main_JFrame.userType.getName()))
		{
			Table_Student table_Student = (Table_Student) Main_JFrame.userObject;
			CurrentUser_JLabel.setText("[ " + Main_JFrame.userType.getName() + " ] : " + table_Student.getStudent_name());
		}
		else if("Teacher".equals(Main_JFrame.userType.getName()))
		{
			Table_Teacher table_Teacher = (Table_Teacher) Main_JFrame.userObject;
			CurrentUser_JLabel.setText("[ " + Main_JFrame.userType.getName() + " ] : " + table_Teacher.getTeacher_name());
		}
	}
	

	/**
	 * 
	 * @Title Function
	 * @Description Handles events that determine password changes
	 * @param event
	 * @date December 1,2018
	 * @return void
	 *
	 */
	public void Confirm_ChangePassword(ActionEvent e)
	{
		String oldPassword = OriginalPassword_Field.getText();
		String newPassword = NewPassword_Field.getText();
		String confirmPassword = ConfirmPassword_Field.getText();

		//The first step : Helpful hints
		if (StringUtil.IsEmpty(oldPassword))
		{
			JOptionPane.showMessageDialog(this, "Please enter your old password !", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (StringUtil.IsEmpty(newPassword))
		{
			JOptionPane.showMessageDialog(this, "Please enter your new password !", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (StringUtil.IsEmpty(confirmPassword))
		{
			JOptionPane.showMessageDialog(this, "Please enter your new password again !", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (!newPassword.equals(confirmPassword))
		{
			JOptionPane.showMessageDialog(this, "The new password is not the same as the confirmed password !",
					"Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}

		
		/*
		 *------------------------------------------------------------------
		 * Different the user type have different modification permissions |
		 *------------------------------------------------------------------
		 */
		
		//(Administrator)！！> Verify that the password change operation was successful. 
		if ("Administrator".equals(Main_JFrame.userType.getName()))
		{		
			/*
			 *=================================================
			 * userObject : It's stores the user information  |
			 *=================================================
			 */
			Table_Administrator table_Administrator = (Table_Administrator) Main_JFrame.userObject;
			
			/*---------------------------------------
			 * table_Administrator.getId ? ! 		|
			 *---------------------------------------
			 */
			Table_Administrator table_Administrator_temp = new Table_Administrator();
			table_Administrator_temp.setId(table_Administrator.getId());
			table_Administrator_temp.setPassword(oldPassword);
			try
			{
				Administrator_DaoImpl administrator_Dao = new Administrator_DaoImpl();
				JOptionPane.showMessageDialog(this,
						administrator_Dao.ChangePassword(table_Administrator_temp, newPassword), "TIP",
								JOptionPane.WARNING_MESSAGE);
				
				//Reset the data entered by the user
				Reset_Information(e);

			} catch (HeadlessException e1)
			{
				e1.printStackTrace();
			}
		}
		
		//(Student)！！> Verify that the password change operation was successful.
		if ("Student".equals(Main_JFrame.userType.getName()))
		{
			/*
			 *=================================================
			 * userObject : It's stores the user information  |
			 *=================================================
			 */
			Table_Student table_Student = (Table_Student)Main_JFrame.userObject;
			
			//Verify that the username and old password entered by the user are correct
			Table_Student table_Student_temp = new Table_Student();
			table_Student_temp.setStudent_id(table_Student.getStudent_id());
			table_Student_temp.setStudent_password(oldPassword);
			try
			{
				Student_DaoImpl student_Dao = new Student_DaoImpl();
				JOptionPane.showMessageDialog(this,
						student_Dao.ChangePassword(table_Student_temp, newPassword), "TIP",
								JOptionPane.WARNING_MESSAGE);
				
				//Reset the data entered by the user
				Reset_Information(e);

			} catch (HeadlessException e1)
			{
				e1.printStackTrace();
			}
		}
		//(Teacher)！！>Verify that the password change operation was successful.
		if("Teacher".equals(Main_JFrame.userType.getName()))
		{
			/*
			 *=========================================================
			 * userObject : It's stores the user information of table |
			 *=========================================================
			 */
			Table_Teacher table_Teacher = (Table_Teacher)Main_JFrame.userObject;
			
			//Verify that the username and old password entered by the user are correct
			Table_Teacher table_Teacher_temp = new Table_Teacher();
			table_Teacher_temp.setTeacher_id(table_Teacher.getTeacher_id());
			table_Teacher_temp.setTeacher_password(oldPassword);
			try
			{
				Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
				JOptionPane.showMessageDialog(this,
						teacher_Dao.ChangePassword(table_Teacher_temp, newPassword), "TIP",
								JOptionPane.WARNING_MESSAGE);
				
				//Reset the data entered by the user
				Reset_Information(e);

			} catch (HeadlessException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the data entered by the user
	 * @param event
	 * @date December 1,2018
	 * @return void
	 *
	 */
	public void Reset_Information(ActionEvent e)
	{
		OriginalPassword_Field.setText("");
		NewPassword_Field.setText("");
		ConfirmPassword_Field.setText("");
	}
}
