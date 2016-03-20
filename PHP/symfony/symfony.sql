-- MySQL dump 10.16  Distrib 10.1.12-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: symfony
-- ------------------------------------------------------
-- Server version	10.1.12-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `patronym` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dob` datetime NOT NULL,
  `gender` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Тарасов','Дмитрий','Михайлович','zero@gmail.com','1988-12-03 00:00:00',1),
	(2,'Тарасов','Игор','Михайлович','one@gmail.com','1988-12-03 00:00:00',1),
	(3,'Кирилловский','Владимир','Игоревич','123@gmail.com','2011-01-01 00:00:00',1),
	(4,'Осипов','Данислав','Давидович','123@gmail.com','2011-01-01 00:00:00',1),
	(5,'Дорофеев','Всеволод','Глебович','123@gmail.com','2011-01-01 00:00:00',1),
	(6,'Анисимов','Жерар','Абрамович','123@gmail.com','2011-01-01 00:00:00',1),
	(7,'Веселов','Данислав','Игоревич','123@gmail.com','2011-01-01 00:00:00',1),
	(8,'Филиппов','Игнат','Артёмович','123@gmail.com','2011-01-01 00:00:00',1),
	(9,'Трофимова','Анна','Абрамовна','123@gmail.com','2011-01-01 00:00:00',0),
	(10,'Ларионова','Игната','Глебовна','123@gmail.com','2011-01-01 00:00:00',0),
	(11,'Пахомов','Данислав','Теймуразович','123@gmail.com','2011-01-01 00:00:00',1),
	(12,'Игнатов','Владимир','Фёдорович','123@gmail.com','2011-01-01 00:00:00',1),
	(13,'Белозёров','Владимир','Евсеевич','123@gmail.com','2011-01-01 00:00:00',1),
	(14,'Виноградов','Всеволод','Артурович','123@gmail.com','2011-01-01 00:00:00',1),
	(15,'Богданов','Георгий','Евсеевич','123@gmail.com','2011-01-01 00:00:00',1),
	(16,'Воробьёв','Георгий','Артурович','123@gmail.com','2011-01-01 00:00:00',1),
	(17,'Тарасов','Иннокентий','Валерьевич','123@gmail.com','2011-01-01 00:00:00',1),
	(18,'Белов','Лев','Фёдорович','123@gmail.com','2011-01-01 00:00:00',1),
	(19,'Баранов','Марк','Валерьевич','123@gmail.com','2011-01-01 00:00:00',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-20 21:12:22
