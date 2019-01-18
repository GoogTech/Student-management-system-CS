package com.YUbuntu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.YUbuntu.model.UserType;
import com.YUbuntu.view.function.Main_JFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The main interface of user operation
 * @Author #YUbuntu
 * @Date December 1,2018
 * @version 1.0
 */
public class Main_JFrame extends JFrame implements Main_JFrame_function
{

	private JPanel contentPane;

	//Extract objects for easy modification
	private JDesktopPane desktopPane;
	//Inorder to easy to set user permissions
	private JMenu ClassManagement_JMenu;
	private JMenu TeacherManagement_JMenu;
	private JMenu StudentManagement_JMenu;
	private JMenuItem AddStudent_JMenultem;
	private JMenuItem AddTeacher_JMenuItem;

	/*
	 *========================================================
	 * Determine the type of user logged in 				 |
	 * 														 |
	 * public static : All feature panels share this data 	 |
	 *========================================================
	 */
	public static UserType userType;
	public static Object userObject;


	/**
	 * Launch the application.¡ª¡ª>(Close program entry)
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main_JFrame frame = new Main_JFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/*=================================================											
	 * Object : user's personal information.(Table)   |		   											    																									|
	 *=================================================
	 */
	public Main_JFrame(UserType userType_, Object userObject_)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_JFrame.class.getResource("/icon/#YUbuntu logo.jpg")));
		setResizable(false);
		this.userType = userType_;
		this.userObject = userObject_;

		setFont(new Font("Consolas", Font.BOLD, 12));
		setTitle("Student management system \uFF08Progress : a quarter and The poet : HuangYuhui\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 665);
		setLocationRelativeTo(null);// Center the login screen

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("");
		menuBar.add(menu);

		JMenu mnSystemSettings = new JMenu("System Settings ");
		mnSystemSettings.setFont(new Font("Consolas", Font.BOLD, 11));
		mnSystemSettings.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/System setup.png")));
		menuBar.add(mnSystemSettings);

		/*
		 * INTERFACE : User interface for changing passwords
		 */
		JMenuItem mntmChangeThePassword = new JMenuItem("Change the password");
		mntmChangeThePassword.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_ChangePassword(e);
			}
		});
		mntmChangeThePassword.setFont(new Font("Consolas", Font.BOLD, 13));
		mntmChangeThePassword
				.setIcon(null);
		mnSystemSettings.add(mntmChangeThePassword);

		/*
		 * INTERFACE : Exit system interface
		 */
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_Login_Out(e);
			}
		});
		mntmLogOut.setIcon(null);
		mntmLogOut.setFont(new Font("Consolas", Font.BOLD, 13));
		mnSystemSettings.add(mntmLogOut);
		
		TeacherManagement_JMenu = new JMenu("Teacher management ");
		TeacherManagement_JMenu.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/Teacher management.png")));
		TeacherManagement_JMenu.setFont(new Font("Consolas", Font.BOLD, 11));
		menuBar.add(TeacherManagement_JMenu);
		
		/*
		 * INTERFACE : Add teacher interface 
		 */
		AddTeacher_JMenuItem = new JMenuItem("Add teacher");
		AddTeacher_JMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Interface_AddTeacher(e);
			}
		});
		AddTeacher_JMenuItem.setFont(new Font("Consolas", Font.BOLD, 13));
		AddTeacher_JMenuItem.setIcon(null);
		TeacherManagement_JMenu.add(AddTeacher_JMenuItem);
		
		/*
		 * INTERFACE : teacher information management interface 
		 */
		JMenuItem mntmTeacherList = new JMenuItem("Teacher list");
		mntmTeacherList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				Interface_TeacherListManagement(e);
			}
		});
		mntmTeacherList.setIcon(null);
		mntmTeacherList.setFont(new Font("Consolas", Font.BOLD, 13));
		TeacherManagement_JMenu.add(mntmTeacherList);

		StudentManagement_JMenu = new JMenu("Student management");
		StudentManagement_JMenu.setFont(new Font("Consolas", Font.BOLD, 11));
		StudentManagement_JMenu
				.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/Studnet management.png")));
		menuBar.add(StudentManagement_JMenu);

		/*
		 * INTERFACE : Add student interface
		 */
		AddStudent_JMenultem = new JMenuItem("Add student");
		AddStudent_JMenultem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_AddStudent(e);
			}
		});
		AddStudent_JMenultem.setIcon(null);
		AddStudent_JMenultem.setFont(new Font("Consolas", Font.BOLD, 13));
		StudentManagement_JMenu.add(AddStudent_JMenultem);

		/*
		 * INTERFACE : student information management interface
		 */
		JMenuItem mntmStudentList= new JMenuItem("Student list");
		mntmStudentList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_StudentListManagement(e);
			}
		});
		mntmStudentList.setIcon(null);
		mntmStudentList.setFont(new Font("Consolas", Font.BOLD, 13));
		StudentManagement_JMenu.add(mntmStudentList);

		JMenuItem menuItem = new JMenuItem("");
		StudentManagement_JMenu.add(menuItem);

		ClassManagement_JMenu = new JMenu("Class management");
		ClassManagement_JMenu.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/Class management.png")));
		ClassManagement_JMenu.setFont(new Font("Consolas", Font.BOLD, 11));
		menuBar.add(ClassManagement_JMenu);

		/*
		 * INTERFACE : Add class information interface
		 */
		JMenuItem mntmAddClass = new JMenuItem("Add class");
		mntmAddClass.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_AddClass(e);
			}
		});
		mntmAddClass.setIcon(null);
		mntmAddClass.setFont(new Font("Consolas", Font.BOLD, 13));
		ClassManagement_JMenu.add(mntmAddClass);

		/*
		 * INTERFACE : Class management interface
		 */
		JMenuItem mntmClassList = new JMenuItem("Class list");
		mntmClassList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Interface_ClassManagement(e);
			}
		});
		mntmClassList.setIcon(null);
		mntmClassList.setFont(new Font("Consolas", Font.BOLD, 13));
		ClassManagement_JMenu.add(mntmClassList);
		
		JMenu mnCourseManagement = new JMenu("Course management");
		mnCourseManagement.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/Course  management.png")));
		mnCourseManagement.setFont(new Font("Consolas", Font.BOLD, 11));
		menuBar.add(mnCourseManagement);
		
		JMenuItem mntmAddCourse = new JMenuItem("Add course");
		mntmAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Interface_AddCourse(e);
			}
		});
		mntmAddCourse.setFont(new Font("Consolas", Font.BOLD, 13));
		mnCourseManagement.add(mntmAddCourse);
		
		JMenuItem mntmCourseList = new JMenuItem("Course list");
		mntmCourseList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Interface_CourseListManagement(e);
			}
		});
		mntmCourseList.setFont(new Font("Consolas", Font.BOLD, 13));
		mnCourseManagement.add(mntmCourseList);
		
		JMenu mnSelectCourseManagement = new JMenu("Choose course management");
		mnSelectCourseManagement.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/ChooseCourseJMenu.png")));
		mnSelectCourseManagement.setFont(new Font("Consolas", Font.BOLD, 11));
		menuBar.add(mnSelectCourseManagement);
		
		JMenuItem mntmCourseManagement = new JMenuItem("Choose course list");
		mntmCourseManagement.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Interface_ChooseCourseManagement(e);
			}
		});
		mntmCourseManagement.setFont(new Font("Consolas", Font.PLAIN, 13));
		mnSelectCourseManagement.add(mntmCourseManagement);

		JMenu mnHelping = new JMenu("Helping");
		mnHelping.setIcon(new ImageIcon(Main_JFrame.class.getResource("/icon/Help.png")));
		mnHelping.setFont(new Font("Consolas", Font.BOLD, 11));
		menuBar.add(mnHelping);

		/*
		 * INTERFACE : Author information interface
		 */
		JMenuItem mntmCreator = new JMenuItem("Creator");
		mntmCreator.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					try
					{
						About_YUbuntu(e);
					} catch (URISyntaxException e1)
					{
						e1.printStackTrace();
					}
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		mntmCreator.setFont(new Font("Consolas", Font.BOLD, 13));
		mnHelping.add(mntmCreator);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/*---------------------------------------------------------------------------------------
		 * DesktopPane(Main_JFrame) + JInternalFrame(ChangePassword_JFrame+..others xxx_JFrame) |
		 *---------------------------------------------------------------------------------------
		 */
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 255, 47));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		/*-------------------------------------
		 * Initialize : Set user permissions. |
		 *-------------------------------------
		 */
		Initialize_SetUserPermissions();
	}

	
	/**
	 * 
	 * @Title Interface
	 * @Description Course selection management.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 17, 2019-4:00:28 PM
	 *
	 */
	public void Interface_ChooseCourseManagement(ActionEvent e)
	{
		ChooseCourse_JInternalFrame chooseCourse_JInternalFrame = new ChooseCourse_JInternalFrame();
		chooseCourse_JInternalFrame.setVisible(true);
		
		desktopPane.add(chooseCourse_JInternalFrame);
	}


	/**
	 * 
	 * @Title Interface
	 * @Description manage the course inforamtion.
	 * @param Performed action
	 * @return void
	 * @date Jan 15, 2019-2:24:11 PM
	 *
	 */
	public void Interface_CourseListManagement(ActionEvent e)
	{
		CourseList_JInternalFrame courseList_JInternalFrame = new CourseList_JInternalFrame();
		courseList_JInternalFrame.setVisible(true);
		
		desktopPane.add(courseList_JInternalFrame);
	}


	/**
	 * 
	 * @Title Interface
	 * @Description Add a the new course information.
	 * @param Performed action
	 * @return void
	 * @date Dec 29, 2018-7:17:26 PM
	 * @throws ..
	 *
	 */
	public void Interface_AddCourse(ActionEvent e)
	{
		AddCourse_JFrame addCourse_JFrame = new AddCourse_JFrame();
		addCourse_JFrame.setVisible(true);
		
		desktopPane.add(addCourse_JFrame);
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Management teacher information
	 * @param ActionEvent e
	 * @return void
	 * @date Dec 16, 2018-9:26:55 PM
	 * @throws
	 *
	 */
	public void Interface_TeacherListManagement(ActionEvent e)
	{
		TeacherList_JInternalFrame teacherList_JInternalFrame = new TeacherList_JInternalFrame();
		teacherList_JInternalFrame.setVisible(true);
		
		desktopPane.add(teacherList_JInternalFrame);	
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Add new teacher information into MySQL database.
	 * @param ActionEvent e
	 * @return void
	 * @date Dec 16, 2018-9:55:28 AM
	 * @throws
	 *
	 */
	public void Interface_AddTeacher(ActionEvent e)
	{
		AddTeacher_JInternalFrame addTeacher_JInternalFrame = new AddTeacher_JInternalFrame();
		addTeacher_JInternalFrame.setVisible(true);

		// Add this interface to the DesktopPane !
		desktopPane.add(addTeacher_JInternalFrame);	
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Management student information
	 * @param event
	 * @date December 8,2018
	 * @return void
	 *
	 */
	public void Interface_StudentListManagement(ActionEvent e)
	{
		StudentList_JInternalFrame studentList_JInternalFrame = new StudentList_JInternalFrame();
		studentList_JInternalFrame.setVisible(true);

		// Add this interface to the DesktopPane £¡
		desktopPane.add(studentList_JInternalFrame);
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Add new student information into MySQL database.
	 * @param event
	 * @date December 8,2018
	 * @return void
	 *
	 */
	public void Interface_AddStudent(ActionEvent e)
	{
		AddStudent_JFrame addStudent_JFrame = new AddStudent_JFrame();
		addStudent_JFrame.setVisible(true);

		// Add this interface to the DesktopPane !
		desktopPane.add(addStudent_JFrame);
	}


	/**
	 * 
	 * @Title Interface
	 * @Description Class management interface
	 * @param event
	 * @return void
	 * @date December 5,2018
	 *
	 */
	public void Interface_ClassManagement(ActionEvent e)
	{
		ClassList_JFrame classList_JFrame = new ClassList_JFrame();
		classList_JFrame.setVisible(true);

		// Add this interface to the DesktopPanel !
		desktopPane.add(classList_JFrame);
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Add class information interface
	 * @param event
	 * @return void
	 * @date December 5,2018
	 *
	 */
	public void Interface_AddClass(ActionEvent e)
	{
		AddClass_JFrame addClass_JFrame = new AddClass_JFrame();
		addClass_JFrame.setVisible(true);

		// Add this interface to the DesktopPane !
		desktopPane.add(addClass_JFrame);
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Exit the system
	 * @param event
	 * @return void
	 * @date December 1,2018
	 *
	 */
	public void Interface_Login_Out(ActionEvent e)
	{
		if (JOptionPane.showConfirmDialog(Main_JFrame.this, "You don't love me anymore ?", "Exit the system",
				JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Change the password of user
	 * @param event
	 * @return void
	 * @date December 1,2018
	 *
	 */
	public void Interface_ChangePassword(ActionEvent e)
	{
		ChangePassword_JFrame changePassword_JFrame = new ChangePassword_JFrame();
		changePassword_JFrame.setVisible(true);

		// Add the change password panel to the DesktopPanel !
		desktopPane.add(changePassword_JFrame);
	}

	/**
	 * 
	 * @Title Interface
	 * @Description Show me my personal informaiton
	 * @param event
	 * @return void
	 * @date December 1,2018
	 *
	 */
	public void About_YUbuntu(ActionEvent e) throws IOException, URISyntaxException
	{

		String message = "(My personal website)Study hungry Study foolish ~";
		String[] button = { "GO", "NO" };
		int button_result = JOptionPane.showOptionDialog(this, message, "About Creator : #YUbuntu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Login_JFrame.class.getResource("")), button, null);

		// Call the system browser to open the specified url
		URI url = new URI("https://yubuntu0109.github.io/");
		if (button_result == 0)
		{
			if (Desktop.getDesktop().isSupported(Action.BROWSE))
			{
				// The first access method
				Desktop.getDesktop().browse(url);		
			}
			else
			{
				// The second access method
				Runtime.getRuntime().exec("explorer https://yubuntu0109.github.io/");			
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Embarrassed ~");	
		}
	}
	
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initializes user permissions to use system functions.
	 * @param no
	 * @return void
	 * @date Dec 19, 2018-3:24:37 PM
	 * @throws no
	 *
	 */
	public void Initialize_SetUserPermissions()
	{
		if("Student".equals(userType.getName()))
		{
			ClassManagement_JMenu.setEnabled(false);
			TeacherManagement_JMenu.setEnabled(false);
			AddStudent_JMenultem.setEnabled(false);
		}
		if("Teacher".equals(userType.getName()))
		{
			ClassManagement_JMenu.setEnabled(false);
			AddTeacher_JMenuItem.setEnabled(false);
		}
	}
}
