CREATE DATABASE  IF NOT EXISTS `student_management_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `student_management_system`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: student_management_system
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `table_administrator`
--

DROP TABLE IF EXISTS `table_administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_administrator` (
  `ID` int(20) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `Telephone_number` varchar(12) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Administrator data';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `table_choosedcourse`
--

DROP TABLE IF EXISTS `table_choosedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_choosedcourse` (
  `ChoosedCourse_ID` int(10) NOT NULL,
  `Class_ID` varchar(20) NOT NULL,
  `Class_name` varchar(20) NOT NULL,
  `Student_ID` varchar(20) NOT NULL,
  `Student_name` varchar(10) NOT NULL,
  `Teacher_ID` varchar(20) NOT NULL,
  `Teacher_name` varchar(15) NOT NULL,
  `Course_ID` varchar(20) NOT NULL,
  `Course_name` varchar(30) NOT NULL,
  `MaxStudentNumber` int(3) NOT NULL,
  `ChoosedStudentNumber` int(3) NOT NULL DEFAULT '0',
  `Course_Introduction` varchar(200) NOT NULL,
  PRIMARY KEY (`ChoosedCourse_ID`),
  KEY `Student_foreginKey_idx` (`Student_ID`),
  KEY `Course_foreignKey_idx` (`Course_ID`),
  KEY `Teacher_foreignKey_idx` (`Teacher_ID`),
  KEY `Class_foreignKey_idx` (`Class_ID`),
  CONSTRAINT `Course_foreignKey` FOREIGN KEY (`Course_ID`) REFERENCES `table_course` (`course_id`),
  CONSTRAINT `Student_foreignKey` FOREIGN KEY (`Student_ID`) REFERENCES `table_student` (`student_id`),
  CONSTRAINT `Teacher_foreignKey` FOREIGN KEY (`Teacher_ID`) REFERENCES `table_teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Course selection information sheet .';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `table_class`
--

DROP TABLE IF EXISTS `table_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_class` (
  `CLASS_ID` varchar(20) NOT NULL,
  `CLASS_NAME` varchar(30) NOT NULL,
  `CLASS_INTRODUCE` varchar(200) NOT NULL,
  PRIMARY KEY (`CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Class management';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `table_course`
--

DROP TABLE IF EXISTS `table_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_course` (
  `Course_ID` varchar(20) NOT NULL,
  `Course_name` varchar(30) NOT NULL,
  `Teacher_ID` varchar(20) NOT NULL,
  `Teacher_name` varchar(20) NOT NULL,
  `Course_MaxStudentNumber` int(3) NOT NULL,
  `Selected_StudentNumber` int(3) DEFAULT '0',
  `Course_Introduction` varchar(200) NOT NULL,
  PRIMARY KEY (`Course_ID`),
  KEY `Course_Teacher_Key_idx` (`Teacher_ID`),
  CONSTRAINT `Course_Teacher_Key` FOREIGN KEY (`Teacher_ID`) REFERENCES `table_teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The information of course.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `table_student`
--

DROP TABLE IF EXISTS `table_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_student` (
  `Student_id` varchar(20) NOT NULL,
  `Student_name` varchar(15) NOT NULL,
  `Student_sex` varchar(10) NOT NULL,
  `Student_password` varchar(20) NOT NULL,
  `Student_ClassId` varchar(20) NOT NULL,
  `Student_ClassName` varchar(25) NOT NULL,
  PRIMARY KEY (`Student_id`),
  UNIQUE KEY `Student_id_UNIQUE` (`Student_id`),
  KEY `Class_Student_key_idx` (`Student_ClassId`),
  CONSTRAINT `Class_Student_key` FOREIGN KEY (`Student_ClassId`) REFERENCES `table_class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The student information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `table_teacher`
--

DROP TABLE IF EXISTS `table_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_teacher` (
  `Teacher_ID` varchar(20) NOT NULL,
  `Teacher_NAME` varchar(20) NOT NULL,
  `Teacher_PASSWORD` varchar(20) NOT NULL,
  `Teacher_SEX` varchar(6) NOT NULL,
  `Teacher_AGE` int(3) NOT NULL,
  `Teacher_TITLE` varchar(40) NOT NULL,
  `Teacher_CLASSID` varchar(20) NOT NULL,
  `Teacher_CLASSNAME` varchar(30) NOT NULL,
  `Teacher_TELEPHONE` varchar(12) NOT NULL,
  PRIMARY KEY (`Teacher_ID`),
  UNIQUE KEY `Teacher_ID_UNIQUE` (`Teacher_ID`),
  KEY `Teacher_ClassID_key_idx` (`Teacher_CLASSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The Teacher information';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-29  8:47:10
