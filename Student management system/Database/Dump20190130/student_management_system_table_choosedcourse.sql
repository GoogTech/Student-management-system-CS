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
-- Table structure for table `table_choosedcourse`
--

DROP TABLE IF EXISTS `table_choosedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table_choosedcourse` (
  `ChoosedCourse_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Class_ID` varchar(45) NOT NULL,
  `Class_name` varchar(45) NOT NULL,
  `Student_ID` varchar(45) NOT NULL,
  `Student_name` varchar(45) NOT NULL,
  `Teacher_ID` varchar(45) NOT NULL,
  `Teacher_name` varchar(45) NOT NULL,
  `Course_ID` varchar(45) NOT NULL,
  `Course_name` varchar(45) NOT NULL,
  `MaxStudentNumber` int(4) NOT NULL,
  `ChoosedStudentNumber` int(4) NOT NULL DEFAULT '0',
  `Course_Introduction` varchar(200) NOT NULL,
  PRIMARY KEY (`ChoosedCourse_ID`),
  KEY `Student_foreginKey_idx` (`Student_ID`),
  KEY `Course_foreignKey_idx` (`Course_ID`),
  KEY `Teacher_foreignKey_idx` (`Teacher_ID`),
  KEY `Class_foreignKey_idx` (`Class_ID`),
  CONSTRAINT `Class_foreignKey` FOREIGN KEY (`Class_ID`) REFERENCES `table_class` (`class_id`),
  CONSTRAINT `Course_foreignKey` FOREIGN KEY (`Course_ID`) REFERENCES `table_course` (`course_id`),
  CONSTRAINT `Student_foreignKey` FOREIGN KEY (`Student_ID`) REFERENCES `table_student` (`student_id`),
  CONSTRAINT `Teacher_foreignKey` FOREIGN KEY (`Teacher_ID`) REFERENCES `table_teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='Course selection information sheet .';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-30 19:50:19
