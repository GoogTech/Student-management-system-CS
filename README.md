## :mortar_board::book: Student management system
`Desktop applications developed using the Java programming language and MySQL database ~`

### 项目概述

#### 项目阶段介绍  (:speech_balloon: stop update)
- *第一阶段：+学生信息管理功能 :white_check_mark:*
- *第二阶段：+学生选课管理功能 :white_check_mark:*
- *第三阶段：+学生考勤管理功能 :x:*
- *第四阶段：+学生成绩管理功能 :x:*


### 系统截屏

- *登录界面*

![](https://raw.githubusercontent.com/YUbuntu0109/YUbuntu0109.github.io/HexoBackup/2019/03/09/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F-Java-swing/Login_Interface.PNG)

- *选课界面*

![](https://raw.githubusercontent.com/YUbuntu0109/YUbuntu0109.github.io/HexoBackup/2019/03/09/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F-Java-swing/Main_Interface.PNG)


### 项目结构
```
│  LICENSE
│  README.md
│
└─Student management system
    │  .classpath
    │  .gitignore
    │  .project
    │  databaseConfig.properties
    │  reference document.txt
    │
    ├─.settings
    │      org.eclipse.core.resources.prefs
    │      org.eclipse.jdt.core.prefs
    │
    ├─bin
    │  ├─com
    │  │  └─YUbuntu
    │  │      ├─basicDao
    │  │      │      
    │  │      │      
    │  │      │(略...)
    │
    │
    │
    ├─Database
    │  └─Dump20190130
    │          student_management_system_table_administrator.sql
    │          student_management_system_table_choosedcourse.sql
    │          student_management_system_table_class.sql
    │          student_management_system_table_course.sql
    │          student_management_system_table_student.sql
    │          student_management_system_table_teacher.sql
    │
    ├─lib
    │      JTattoo-1.6.11.jar
    │      mysql-connector-java-8.0.11.jar
    │
    └─src
        ├─com
        │  └─YUbuntu
        │      ├─basicDao
        │      │      BasicDao.java
        │      │      package-info.java
        │      │
        │      ├─dao
        │      │  │  Administrator_Dao.java
        │      │  │  ChooseCourse_Dao.java
        │      │  │  Class_Dao.java
        │      │  │  Course_Dao.java
        │      │  │  package-info.java
        │      │  │  Student_Dao.java
        │      │  │  Teacher_Dao.java
        │      │  │
        │      │  └─impl
        │      │          Administrator_DaoImpl.java
        │      │          ChooseCourse_DaoImpl.java
        │      │          Class_DaoImpl.java
        │      │          Course_DaoImpl.java
        │      │          package-info.java
        │      │          Student_DaoImpl.java
        │      │          Teacher_DaoImpl.java
        │      │
        │      ├─model
        │      │      package-info.java
        │      │      Table_Administrator.java
        │      │      Table_ChoosedCourse.java
        │      │      Table_Class.java
        │      │      Table_Course.java
        │      │      Table_Student.java
        │      │      Table_Teacher.java
        │      │      UserType.java
        │      │
        │      ├─util
        │      │      .gitignore
        │      │      DatabaseConfig.java
        │      │      JdbcUtil.java
        │      │      package-info.java
        │      │      StringUtil.java
        │      │
        │      └─view
        │          │  AddClass_JFrame.java
        │          │  AddCourse_JFrame.java
        │          │  AddStudent_JFrame.java
        │          │  AddTeacher_JInternalFrame.java
        │          │  ChangePassword_JFrame.java
        │          │  ChooseCourse_JInternalFrame.java
        │          │  ClassList_JFrame.java
        │          │  CourseList_JInternalFrame.java
        │          │  DatabaseConfigInfo.java
        │          │  Login_JFrame.java
        │          │  Main_JFrame.java
        │          │  package-info.java
        │          │  StudentList_JInternalFrame.java
        │          │  TeacherList_JInternalFrame.java
        │          │
        │          └─function
        │                  AddClass_JFrame_function.java
        │                  AddCourse_JFrame_function.java
        │                  AddStudent_JFrame_function.java
        │                  AddTeacher_JFrame_function.java
        │                  ChangePassword_JFrame_function.java
        │                  ChooseCourse_JF_function.java
        │                  ClassList_JFrame_function.java
        │                  CourseList_JInternalFrame_function.java
        │                  Login_JFrame_function.java
        │                  Main_JFrame_function.java
        │                  package-info.java
        │                  StudentList_JFrame_function.java
        │                  TeacherList_JFrame_function.java
        │
        └─icon
                #YUbuntu logo.jpg
                About author.png
                Add.png
                AddTeacher_Confirm.png
                AddTeacher_Reset.png
                Age.png
                ChooseCourseJMenu.png
                Class introduction.png
                Class list.png
                Class management.png
                Class name.png
                Confirm login in.png
                Confirm.png
                Course  management.png
                Delete.png
                Exit.png
                Gender.png
                Help.png
                Id card.png
                List.png
                Modify password.png
                password.png
                Reset.png
                Search.png
                Student.png
                Studnet management.png
                System setup.png
                Teacher management.png
                Teacher name.png
                Teacher password.png
                Teacher sex.png
                Teacher telephone.png
                Teacher title.png
                Title.png
                User list.png
                User name.png
                User type.png
```

#### 项目结构说明-数据库表文件
```
Database
```

#### 项目结构说明-连接数据库的配置信息文件
```
databaseConfig.properties
```

 
 
*:books:更多有趣项目及详细学习笔记请前往我的个人博客哟（づ￣3￣）づ╭❤～ : https://yubuntu0109.github.io/* 
 
:coffee: Look forward to your contribution !

:man_student: If you need any help, please contact me ~ QQ : 3083968068
