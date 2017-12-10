-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket_app_web
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `accepted_orders`
--

DROP TABLE IF EXISTS `accepted_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accepted_orders` (
  `id` int(11) NOT NULL,
  `id_employee` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_employee` (`id_employee`),
  CONSTRAINT `accepted_orders_ibfk_1` FOREIGN KEY (`id`) REFERENCES `orders` (`id`),
  CONSTRAINT `accepted_orders_ibfk_2` FOREIGN KEY (`id`) REFERENCES `orders` (`id`),
  CONSTRAINT `accepted_orders_ibfk_3` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accepted_orders`
--

LOCK TABLES `accepted_orders` WRITE;
/*!40000 ALTER TABLE `accepted_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `accepted_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id_employee` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id_employee`),
  CONSTRAINT `out_key` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'tranduyhung','tranhung'),(2,'tranhuy','tranhuy'),(3,'dinhthang','dinhthang');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id_product` int(11) NOT NULL,
  `id_orders` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id_orders`,`id_product`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costs_incurred`
--

DROP TABLE IF EXISTS `costs_incurred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costs_incurred` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `total` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costs_incurred`
--

LOCK TABLES `costs_incurred` WRITE;
/*!40000 ALTER TABLE `costs_incurred` DISABLE KEYS */;
/*!40000 ALTER TABLE `costs_incurred` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `default_salary`
--

DROP TABLE IF EXISTS `default_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `default_salary` (
  `default_salary` int(11) NOT NULL,
  PRIMARY KEY (`default_salary`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `default_salary`
--

LOCK TABLES `default_salary` WRITE;
/*!40000 ALTER TABLE `default_salary` DISABLE KEYS */;
INSERT INTO `default_salary` VALUES (1000000);
/*!40000 ALTER TABLE `default_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `birth_date` varchar(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  `coefficient_salary` int(11) NOT NULL,
  `position` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Tran Duy Hung','women','2017-11-09','Kieu Ki','0362154256',30,'employee'),(2,'tranviethuy','men','1997-12-16','HungYen','0973248051',50,'manager'),(3,'Nguyen Dinh Thang ','men','2017-11-08','Chuong My','0932536251',32,'manager'),(4,'Ho huu hai','women','2017-12-13','Vinh','0973252362',20,'employee');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_manager`
--

DROP TABLE IF EXISTS `employee_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_manager` (
  `id_manager` int(11) NOT NULL,
  `commission` int(11) NOT NULL,
  PRIMARY KEY (`id_manager`),
  CONSTRAINT `employee_manager_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_manager`
--

LOCK TABLES `employee_manager` WRITE;
/*!40000 ALTER TABLE `employee_manager` DISABLE KEYS */;
INSERT INTO `employee_manager` VALUES (2,5),(3,5);
/*!40000 ALTER TABLE `employee_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `export_receipt`
--

DROP TABLE IF EXISTS `export_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `export_receipt` (
  `id_receipt` int(11) NOT NULL AUTO_INCREMENT,
  `id_employee` int(11) NOT NULL,
  `date` varchar(11) NOT NULL,
  PRIMARY KEY (`id_receipt`),
  KEY `employee_idx` (`id_employee`),
  CONSTRAINT `employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export_receipt`
--

LOCK TABLES `export_receipt` WRITE;
/*!40000 ALTER TABLE `export_receipt` DISABLE KEYS */;
INSERT INTO `export_receipt` VALUES (1,1,'2017-12-03'),(2,1,'2017-12-03'),(3,1,'2017-12-03'),(4,1,'2017-12-04'),(5,1,'2017-12-04'),(6,1,'2017-12-11');
/*!40000 ALTER TABLE `export_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_receipt`
--

DROP TABLE IF EXISTS `import_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import_receipt` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_receipt`,`id_product`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `import_receipt_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `receipt_manager_supplier` (`id_receipt`),
  CONSTRAINT `import_receipt_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_receipt`
--

LOCK TABLES `import_receipt` WRITE;
/*!40000 ALTER TABLE `import_receipt` DISABLE KEYS */;
INSERT INTO `import_receipt` VALUES (1,1,50,20000),(1,2,30,20000),(2,3,30,2000),(2,4,10,200000),(2,5,5,60000),(3,6,10,25000),(3,7,5,200000),(4,8,20,60000),(5,9,10,20000),(6,10,10,20000),(7,11,10,20000),(8,12,3,30000),(9,13,10,30000),(10,14,20,60000),(10,15,10,70000),(11,16,20,20000),(11,17,10,250000),(12,18,10,200000),(12,19,10,100000);
/*!40000 ALTER TABLE `import_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `title` text,
  `name` varchar(50) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address1` varchar(100) NOT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Banh My',20000,5),(2,'Chocopie',20000,10),(3,'Bim Bim',2000,30),(4,'Quan Bo',200000,8),(5,'Ao Thun',60000,4),(6,'Ao Khoac Da',25000,10),(7,'Quan Thun',200000,4),(8,'Ao The Thao',60000,20),(9,'Tat The Thao',20000,10),(10,'Mu len',20000,9),(11,'Ao Mua',20000,7),(12,'Mu luoi Chai',30000,2),(13,'Mu len',30000,10),(14,'Quan ngu',60000,19),(15,'Quan bo',70000,10),(16,'Mu hip hop',20000,20),(17,'ao bo',250000,10),(18,'Quan vai',200000,10),(19,'Quan ngo',100000,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_item`
--

DROP TABLE IF EXISTS `receipt_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt_item` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_receipt`,`id_product`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `receipt_item_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `export_receipt` (`id_receipt`),
  CONSTRAINT `receipt_item_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_item`
--

LOCK TABLES `receipt_item` WRITE;
/*!40000 ALTER TABLE `receipt_item` DISABLE KEYS */;
INSERT INTO `receipt_item` VALUES (1,1,20000,20),(1,2,20000,10),(2,1,20000,10),(2,2,20000,10),(3,1,20000,5),(4,1,20000,10),(4,4,200000,2),(5,11,20000,3),(6,5,60000,1),(6,7,200000,1),(6,10,20000,1),(6,12,30000,1),(6,14,60000,1);
/*!40000 ALTER TABLE `receipt_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_manager_supplier`
--

DROP TABLE IF EXISTS `receipt_manager_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt_manager_supplier` (
  `id_receipt` int(11) NOT NULL AUTO_INCREMENT,
  `id_manager` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `date` varchar(11) NOT NULL,
  PRIMARY KEY (`id_receipt`),
  KEY `id_manager` (`id_manager`),
  KEY `id_supplier` (`id_supplier`),
  CONSTRAINT `receipt_manager_supplier_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee_manager` (`id_manager`),
  CONSTRAINT `receipt_manager_supplier_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_manager_supplier`
--

LOCK TABLES `receipt_manager_supplier` WRITE;
/*!40000 ALTER TABLE `receipt_manager_supplier` DISABLE KEYS */;
INSERT INTO `receipt_manager_supplier` VALUES (1,2,1,'2017-11-29'),(2,2,2,'2017-11-30'),(3,2,3,'2017-12-01'),(4,2,4,'2017-12-01'),(5,2,5,'2017-12-01'),(6,2,6,'2017-12-01'),(7,2,7,'2017-12-01'),(8,2,8,'2017-12-01'),(9,2,9,'2017-12-03'),(10,2,10,'2017-12-03'),(11,2,11,'2017-12-04'),(12,2,12,'2017-12-11');
/*!40000 ALTER TABLE `receipt_manager_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save`
--

DROP TABLE IF EXISTS `save`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save` (
  `check_save` int(11) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`check_save`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save`
--

LOCK TABLES `save` WRITE;
/*!40000 ALTER TABLE `save` DISABLE KEYS */;
INSERT INTO `save` VALUES (1,'tranhuy','tranhuy',2),(2,'tranduyhung','tranhung',1),(3,'tranhuy','tranhuy',2),(4,'tranduyhung','tranhung',1),(5,'tranhuy','tranhuy',2);
/*!40000 ALTER TABLE `save` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipper` (
  `id_shiper` int(11) NOT NULL,
  PRIMARY KEY (`id_shiper`),
  CONSTRAINT `abc` FOREIGN KEY (`id_shiper`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `success_order`
--

DROP TABLE IF EXISTS `success_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `success_order` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `success_order_ibfk_1` FOREIGN KEY (`id`) REFERENCES `accepted_orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `success_order`
--

LOCK TABLES `success_order` WRITE;
/*!40000 ALTER TABLE `success_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `success_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Mr Hung','Kieu Ki','hungkute@gmail.com','0973248051'),(2,'Mr Hung ','Kieu Ki','hungkute@gmail.com','0935256525'),(3,'Dinh Thang ','Chuong My','thangkuto@gmail.com','0625232533'),(4,'Mr Hong','Kieu Ki','hong123@gmail.com','0931562563'),(5,'Mr hung','kieu ki','hungngua@gmail.com','0935525452'),(6,'Tran Hung','KieuKi','hung1234@gmail.com','0322022000'),(7,'TranHung','123TranDaiNghia','hung123@gmail.com','0932326266'),(8,'Mr Lam','Hung Yen','lamsky@gmail.com','0333332522'),(9,'Mr Giam','KienXuong','giamna@gmail.com','0973248051'),(10,'Mr Cuong','Hung Yen','cuongbich@gmail.com','0936252565'),(11,'minhmucian','chuongmy','minhancut@gmai.com','0973225211'),(12,'Mr hung','Kieu ki','hung123@gmail.com','0973252153');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin_history`
--

DROP TABLE IF EXISTS `userlogin_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlogin_history` (
  `id` int(11) NOT NULL,
  `Time` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  KEY `id_idx` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin_history`
--

LOCK TABLES `userlogin_history` WRITE;
/*!40000 ALTER TABLE `userlogin_history` DISABLE KEYS */;
INSERT INTO `userlogin_history` VALUES (1,'2017-12-03 12:57:52','tranduyhung'),(1,'2017-12-03 13:01:10','tranduyhung'),(1,'2017-12-03 13:02:35','tranduyhung'),(1,'2017-12-03 13:47:42','tranduyhung'),(1,'2017-12-03 13:48:31','tranduyhung'),(1,'2017-12-03 13:49:55','tranduyhung'),(1,'2017-12-03 14:12:29','tranduyhung'),(1,'2017-12-03 14:14:21','tranduyhung'),(1,'2017-12-03 14:22:37','tranduyhung'),(1,'2017-12-03 14:32:31','tranduyhung'),(1,'2017-12-03 14:33:15','tranduyhung'),(1,'2017-12-03 14:34:09','tranduyhung'),(1,'2017-12-03 18:36:50','tranduyhung'),(1,'2017-12-03 18:38:52','tranduyhung'),(1,'2017-12-03 18:39:22','tranduyhung'),(1,'2017-12-03 18:42:41','tranduyhung'),(1,'2017-12-03 18:44:03','tranduyhung'),(1,'2017-12-03 18:47:32','tranduyhung'),(1,'2017-12-03 18:49:40','tranduyhung'),(1,'2017-12-03 18:50:22','tranduyhung'),(1,'2017-12-03 18:52:10','tranduyhung'),(1,'2017-12-03 18:56:13','tranduyhung'),(1,'2017-12-03 18:57:05','tranduyhung'),(1,'2017-12-03 18:58:27','tranduyhung'),(1,'2017-12-03 19:00:22','tranduyhung'),(1,'2017-12-03 19:02:39','tranduyhung'),(1,'2017-12-03 19:05:19','tranduyhung'),(1,'2017-12-03 19:05:45','tranduyhung'),(1,'2017-12-03 19:07:23','tranduyhung'),(1,'2017-12-03 19:10:16','tranduyhung'),(1,'2017-12-03 19:11:39','tranduyhung'),(1,'2017-12-03 19:12:44','tranduyhung'),(1,'2017-12-03 21:13:43','tranduyhung'),(1,'2017-12-03 21:14:34','tranduyhung'),(1,'2017-12-03 21:20:56','tranduyhung'),(1,'2017-12-03 21:22:13','tranduyhung'),(1,'2017-12-03 21:51:16','tranduyhung'),(1,'2017-12-03 21:54:03','tranduyhung'),(1,'2017-12-03 21:56:58','tranduyhung'),(1,'2017-12-03 21:58:50','tranduyhung'),(1,'2017-12-03 22:53:33','tranduyhung'),(2,'2017-12-03 22:53:46','tranhuy'),(2,'2017-12-03 23:03:17','tranhuy'),(2,'2017-12-03 23:05:23','tranhuy'),(2,'2017-12-03 23:28:42','tranhuy'),(2,'2017-12-03 23:29:25','tranhuy'),(2,'2017-12-03 23:46:27','tranhuy'),(2,'2017-12-04 07:38:38','tranhuy'),(1,'2017-12-04 07:39:13','tranduyhung'),(1,'2017-12-04 08:30:07','tranduyhung'),(2,'2017-12-04 09:29:12','tranhuy'),(1,'2017-12-04 09:30:17','tranduyhung'),(2,'2017-12-04 09:31:14','tranhuy'),(2,'2017-12-04 09:34:41','tranhuy'),(2,'2017-12-04 09:35:34','tranhuy'),(2,'2017-12-08 16:38:53','tranhuy'),(2,'2017-12-08 16:42:21','tranhuy'),(2,'2017-12-08 16:43:59','tranhuy'),(2,'2017-12-08 16:45:30','tranhuy'),(2,'2017-12-08 16:49:18','tranhuy'),(2,'2017-12-08 16:51:31','tranhuy'),(2,'2017-12-08 16:53:34','tranhuy'),(2,'2017-12-08 16:56:24','tranhuy'),(2,'2017-12-08 17:01:44','tranhuy'),(2,'2017-12-08 17:53:23','tranhuy'),(2,'2017-12-08 18:07:19','tranhuy'),(2,'2017-12-08 18:08:17','tranhuy'),(2,'2017-12-08 18:10:42','tranhuy'),(2,'2017-12-09 14:45:44','tranhuy'),(2,'2017-12-09 14:46:32','tranhuy'),(2,'2017-12-10 21:18:19','tranhuy'),(2,'2017-12-10 21:22:25','tranhuy'),(2,'2017-12-10 21:23:52','tranhuy'),(2,'2017-12-10 21:24:23','tranhuy'),(2,'2017-12-10 21:28:01','tranhuy'),(2,'2017-12-10 21:29:40','tranhuy'),(2,'2017-12-10 21:41:20','tranhuy'),(2,'2017-12-10 21:42:36','tranhuy'),(2,'2017-12-10 21:53:48','tranhuy'),(2,'2017-12-10 21:56:39','tranhuy'),(2,'2017-12-10 21:58:08','tranhuy'),(2,'2017-12-10 22:07:30','tranhuy'),(2,'2017-12-10 22:17:18','tranhuy'),(2,'2017-12-10 22:22:09','tranhuy'),(2,'2017-12-10 22:26:04','tranhuy'),(2,'2017-12-10 22:28:37','tranhuy'),(2,'2017-12-10 22:30:31','tranhuy'),(2,'2017-12-10 23:03:29','tranhuy'),(2,'2017-12-10 23:14:07','tranhuy'),(2,'2017-12-10 23:23:04','tranhuy'),(2,'2017-12-10 23:44:05','tranhuy'),(2,'2017-12-10 23:53:54','tranhuy'),(2,'2017-12-11 00:04:26','tranhuy'),(2,'2017-12-11 00:09:05','tranhuy'),(2,'2017-12-11 00:13:31','tranhuy'),(2,'2017-12-11 00:16:22','tranhuy'),(2,'2017-12-11 00:23:53','tranhuy'),(2,'2017-12-11 00:26:07','tranhuy'),(2,'2017-12-11 00:28:07','tranhuy'),(2,'2017-12-11 00:37:01','tranhuy'),(1,'2017-12-11 00:41:52','tranduyhung'),(2,'2017-12-11 00:43:57','tranhuy'),(1,'2017-12-11 00:44:12','tranduyhung'),(2,'2017-12-11 00:48:38','tranhuy');
/*!40000 ALTER TABLE `userlogin_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_history`
--

DROP TABLE IF EXISTS `work_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_history` (
  `id_employee` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`id_employee`,`paid_date`),
  CONSTRAINT `work_history_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_history`
--

LOCK TABLES `work_history` WRITE;
/*!40000 ALTER TABLE `work_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-11  1:48:28
