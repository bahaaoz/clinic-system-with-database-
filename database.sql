-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbclinic
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `date2patient`
--

DROP TABLE IF EXISTS `date2patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `date2patient` (
  `patientId` int NOT NULL,
  `dateId` int NOT NULL,
  `stat` int DEFAULT NULL,
  PRIMARY KEY (`patientId`,`dateId`),
  KEY `dateId` (`dateId`),
  CONSTRAINT `date2patient_ibfk_1` FOREIGN KEY (`patientId`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `date2patient_ibfk_2` FOREIGN KEY (`dateId`) REFERENCES `dates` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date2patient`
--

LOCK TABLES `date2patient` WRITE;
/*!40000 ALTER TABLE `date2patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `date2patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates`
--

DROP TABLE IF EXISTS `dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dates` (
  `doctorId` int DEFAULT NULL,
  `dateD` date DEFAULT NULL,
  `timeD` time DEFAULT NULL,
  `phoneNumberD` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `patientId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `doctorId` (`doctorId`),
  CONSTRAINT `dates_ibfk_1` FOREIGN KEY (`doctorId`) REFERENCES `doctorsdate` (`doctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates`
--

LOCK TABLES `dates` WRITE;
/*!40000 ALTER TABLE `dates` DISABLE KEYS */;
INSERT INTO `dates` VALUES (214328,'2022-03-03','05:00:00',56324324,14,53);
/*!40000 ALTER TABLE `dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doc2spec`
--

DROP TABLE IF EXISTS `doc2spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doc2spec` (
  `idDoc` int NOT NULL,
  `idSpec` int NOT NULL,
  PRIMARY KEY (`idDoc`,`idSpec`),
  KEY `idSpec` (`idSpec`),
  CONSTRAINT `doc2spec_ibfk_1` FOREIGN KEY (`idDoc`) REFERENCES `doctors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doc2spec_ibfk_2` FOREIGN KEY (`idSpec`) REFERENCES `specialization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doc2spec`
--

LOCK TABLES `doc2spec` WRITE;
/*!40000 ALTER TABLE `doc2spec` DISABLE KEYS */;
INSERT INTO `doc2spec` VALUES (214329,17),(214327,18),(214328,18),(214327,19);
/*!40000 ALTER TABLE `doc2spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `namedc` varchar(50) DEFAULT NULL,
  `age` double DEFAULT NULL,
  `numPhone` int DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `idLab` int DEFAULT NULL,
  `SIN` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idLab` (`idLab`,`id`),
  CONSTRAINT `doctors_ibfk_1` FOREIGN KEY (`idLab`) REFERENCES `lab` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=214331 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (214327,'ali',40,56234324,'Male',NULL,213123),(214328,'sama',38,56324324,'Female',NULL,213123),(214329,'abed othman',60,58324234,'Male',NULL,213123),(214330,'Hala',25,456262,'Female',NULL,562422);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctorsdate`
--

DROP TABLE IF EXISTS `doctorsdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctorsdate` (
  `doctorId` int NOT NULL,
  `dates` date NOT NULL,
  `timee` time NOT NULL,
  PRIMARY KEY (`doctorId`,`dates`,`timee`),
  CONSTRAINT `doctorsdate_ibfk_1` FOREIGN KEY (`doctorId`) REFERENCES `doctors` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorsdate`
--

LOCK TABLES `doctorsdate` WRITE;
/*!40000 ALTER TABLE `doctorsdate` DISABLE KEYS */;
INSERT INTO `doctorsdate` VALUES (214327,'2021-02-24','03:00:00'),(214327,'2021-02-24','04:00:00'),(214327,'2021-03-29','03:00:00'),(214328,'2021-03-29','03:00:00'),(214328,'2022-03-03','05:00:00'),(214329,'2021-03-29','03:00:00');
/*!40000 ALTER TABLE `doctorsdate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lab` (
  `id` int NOT NULL,
  `roomNumber` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab`
--

LOCK TABLES `lab` WRITE;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med2rec`
--

DROP TABLE IF EXISTS `med2rec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `med2rec` (
  `idMed` int NOT NULL,
  `idRec` int NOT NULL,
  PRIMARY KEY (`idMed`,`idRec`),
  KEY `idRec` (`idRec`),
  CONSTRAINT `med2rec_ibfk_1` FOREIGN KEY (`idMed`) REFERENCES `medicine` (`id`),
  CONSTRAINT `med2rec_ibfk_2` FOREIGN KEY (`idRec`) REFERENCES `recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med2rec`
--

LOCK TABLES `med2rec` WRITE;
/*!40000 ALTER TABLE `med2rec` DISABLE KEYS */;
/*!40000 ALTER TABLE `med2rec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicine` (
  `id` int NOT NULL,
  `nameMed` varchar(50) DEFAULT NULL,
  `HowToUse` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine1`
--

DROP TABLE IF EXISTS `medicine1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicine1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idmed` int DEFAULT NULL,
  `BillDate` date DEFAULT NULL,
  `medName` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `productDate` date DEFAULT NULL,
  `expireDate` date DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `medicine1_ibfk_1` (`idmed`),
  CONSTRAINT `medicine1_ibfk_1` FOREIGN KEY (`idmed`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine1`
--

LOCK TABLES `medicine1` WRITE;
/*!40000 ALTER TABLE `medicine1` DISABLE KEYS */;
INSERT INTO `medicine1` VALUES (1,49,'2022-02-15','BAHAA','SASDASD','2022-02-09','2022-02-08',23,12),(4,49,'2022-02-21','cfgfd','fdssd','2022-02-10','2022-02-16',12,12),(6,48,'2022-02-16','isjkjkk','d455','2022-02-09','2022-02-18',54,2);
/*!40000 ALTER TABLE `medicine1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurses`
--

DROP TABLE IF EXISTS `nurses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nurses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nameNurse` varchar(50) DEFAULT NULL,
  `age` double DEFAULT NULL,
  `numPhone` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `SIN` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurses`
--

LOCK TABLES `nurses` WRITE;
/*!40000 ALTER TABLE `nurses` DISABLE KEYS */;
INSERT INTO `nurses` VALUES (20,'basem',28,56325324,'Male',3242342),(22,'layla',20,2466,'Female',46432);
/*!40000 ALTER TABLE `nurses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` double DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `numphone` int DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `idLab` int DEFAULT NULL,
  `Corona_doses_received` int DEFAULT NULL,
  `booladmin` tinyint(1) DEFAULT NULL,
  `boolpharmacy` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idLab` (`idLab`),
  CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`idLab`) REFERENCES `lab` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (48,'bahaa',23,'safsaf','Male',123123,'bahaa@gmail.com',NULL,NULL,1,1),(49,'sadsa',123,'dasdsa','Male',21312,'baahaaa@gmail.com',NULL,NULL,NULL,1),(51,'bahaa',32,'assda','Male',12312,'asdadsa@gmail.com',NULL,NULL,NULL,1),(52,'adsdas',21,'asda','Male',332423,'bahaa@gmail.com',NULL,NULL,NULL,0),(53,'sujood',20,'jjhhhh','Female',568653,'ismaeeel@gmail.com',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recipe` (
  `id` int NOT NULL,
  `dateR` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signintable`
--

DROP TABLE IF EXISTS `signintable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `signintable` (
  `username` varchar(100) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `passwd` varchar(30) DEFAULT NULL,
  `patientId` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `signintable_ibfk_1` (`patientId`),
  CONSTRAINT `signintable_ibfk_1` FOREIGN KEY (`patientId`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signintable`
--

LOCK TABLES `signintable` WRITE;
/*!40000 ALTER TABLE `signintable` DISABLE KEYS */;
INSERT INTO `signintable` VALUES ('bahaa','bahaa@gmail.com','123',48),('bahaa1','baahaaa@gmail.com','123',49),('bahaa2001','bahaa@gmail.com','1234567',52),('bahaa4','asdadsa@gmail.com','123',51),('sujood','ismaeeel@gmail.com','123',53);
/*!40000 ALTER TABLE `signintable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `specialization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nameofspe` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization`
--

LOCK TABLES `specialization` WRITE;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` VALUES (17,'internal Medicine doctor'),(18,'orthopedist'),(19,'eye');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visit` (
  `id` int NOT NULL,
  `docid` int DEFAULT NULL,
  `patid` int DEFAULT NULL,
  `nursid` int DEFAULT NULL,
  `recid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `docid` (`docid`),
  KEY `patid` (`patid`),
  KEY `nursid` (`nursid`),
  KEY `recid` (`recid`),
  CONSTRAINT `visit_ibfk_1` FOREIGN KEY (`docid`) REFERENCES `doctors` (`id`),
  CONSTRAINT `visit_ibfk_2` FOREIGN KEY (`patid`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `visit_ibfk_3` FOREIGN KEY (`nursid`) REFERENCES `nurses` (`id`),
  CONSTRAINT `visit_ibfk_4` FOREIGN KEY (`recid`) REFERENCES `recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27  0:40:31
