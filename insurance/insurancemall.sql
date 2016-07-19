-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: insurancemall
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `certificateType` varchar(20) DEFAULT NULL,
  `certificateNum` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `certificateNum` (`certificateNum`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES (1,'abc','居民身份证','123','123','广东','深圳');
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combo`
--

DROP TABLE IF EXISTS `combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `insuranceId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo`
--

LOCK TABLES `combo` WRITE;
/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
INSERT INTO `combo` VALUES (1,0,1,'基础款'),(2,0,1,'标准款'),(3,0,1,'加强款'),(4,0,2,'基础款'),(5,0,2,'标准款'),(6,0,2,'加强款'),(7,0,3,'基础款'),(8,0,3,'标准款'),(9,0,3,'加强款'),(10,0,4,'基础款'),(11,0,4,'标准款'),(12,0,4,'加强款'),(13,1,5,'基础款'),(14,1,6,'基础款'),(15,1,6,'标准款'),(16,1,6,'加强款'),(17,2,7,'基础款'),(18,2,7,'标准款'),(19,2,7,'加强款'),(20,2,7,'豪华款'),(21,2,7,'土豪款'),(22,2,7,'任性款'),(23,2,8,'基础款'),(24,2,8,'标准款'),(25,2,8,'加强款'),(26,3,9,'基础款'),(27,3,9,'标准款'),(28,3,9,'加强款'),(29,3,10,'基础款'),(30,3,10,'标准款'),(31,3,10,'加强款');
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `coverage` double DEFAULT NULL,
  `coverageCompany` varchar(10) DEFAULT NULL,
  `insuranceId` int(11) DEFAULT NULL,
  `comboId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail`
--

LOCK TABLES `detail` WRITE;
/*!40000 ALTER TABLE `detail` DISABLE KEYS */;
INSERT INTO `detail` VALUES (1,0,'飞机意外伤害','被保人以乘客身份乘坐民航客机遭受意外',100,'万元',1,1),(2,0,'火车意外伤害','被保人以乘客身份乘坐火车、高铁、动车遭受意外',50,'万元',1,1),(3,0,'意外伤害身故、残疾和烧烫伤','被保人在驾驶激动车辆时遭受意外伤害',10,'万元',2,4),(4,0,'意外伤害医疗','被保人在驾驶激动车辆时遭受意外伤害',2,'万元',2,4),(5,0,'道路交通意外身故/残疾','被保人因发生道路交通事故遭受意外伤害',20,'万元',3,7),(6,0,'道路交通意外伤害医疗','被保人被保人因发生交易意外伤害事故在约定医院就医',2,'万元',3,7),(7,0,'意外伤害身故和残疾','被保人因在手意外伤害导致身故或残疾',10,'万元',4,10),(8,0,'意外伤害医疗','被保人因在手意外伤害导致残疾，治疗所需费用',2,'万元',4,10),(9,1,'旅行意外身故、残疾保险','被保人在旅行时因意外伤害导致身故、残疾、烧烫伤',10,'万元',5,13),(10,1,'旅行意外医疗','被保人在旅行时因意外伤害导致身故、残疾、烧烫伤在约定医院接受治疗',1,'万元',5,13),(11,1,'旅行以外','被保人在旅行时因意外伤害导致身故、残疾、烧烫伤',10,'万元',6,14),(12,1,'旅行以外医疗','被保人在旅行时因意外伤害导致身故、残疾、烧烫伤在约定医院接受治疗',1,'万元',6,14),(13,2,'个人账户资金损失保险','被保人的个人名下所有银行卡、网银账户、第三方帐户、理财帐户提供保障',5,'万元',7,17),(14,2,'挂失补卡费用','被保人的个人帐户因进行挂失、冻结而支付的手续费',200,'元',7,17),(15,2,'房屋损失','承包由于火灾、台风、暴雨、泥石流等原因造成的损失',50,'万元',8,23),(16,3,'航班延误4小时以上','起飞延误4小时及以上赔200元/次',200,'元',9,26),(17,3,'航空意外身故、残疾保险','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',10,29),(18,0,'飞机意外伤害','被保人以乘客身份乘坐民航客机遭受意外',200,'万元',1,2),(19,0,'火车意外伤害','被保人以乘客身份乘坐民航客机遭受意外',100,'万元',1,2),(20,0,'轮船意外伤害','被保人以乘客身份乘坐民航客机遭受意外',100,'万元',1,2),(21,0,'飞机意外伤害','被保人以乘客身份乘坐民航客机遭受意外',500,'万元',1,3),(22,0,'火车意外伤害','被保人以乘客身份乘坐民航客机遭受意外',200,'万元',1,3),(23,0,'轮船意外伤害','被保人以乘客身份乘坐民航客机遭受意外',200,'万元',1,3),(24,0,'道路交通','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',1,3),(25,0,'意外伤害身故、残疾和烧烫伤','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',2,5),(26,0,'意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',4,'万元',2,5),(27,0,'意外伤害身故、残疾和烧烫伤','被保人以乘客身份乘坐民航客机遭受意外',50,'万元',2,6),(28,0,'意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',10,'万元',2,6),(29,0,'道路交通意外身故/残疾','被保人以乘客身份乘坐民航客机遭受意外',30,'万元',3,8),(30,0,'道路交通意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',5,'万元',3,8),(31,0,'道路交通意外身故/残疾','被保人以乘客身份乘坐民航客机遭受意外',50,'万元',3,9),(32,0,'道路交通意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',10,'万元',3,9),(33,0,'道路交通意外身故/残疾','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',4,11),(34,0,'道路交通意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',2,'万元',4,11),(35,0,'住院误工津贴','被保人以乘客身份乘坐民航客机遭受意外',20,'元/天',4,11),(36,0,'住院护理津贴','被保人以乘客身份乘坐民航客机遭受意外',20,'元/天',4,11),(37,0,'道路交通意外身故/残疾','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',4,12),(38,0,'道路交通意外伤害医疗','被保人以乘客身份乘坐民航客机遭受意外',2,'万元',4,12),(39,0,'住院误工津贴','被保人以乘客身份乘坐民航客机遭受意外',50,'元/天',4,12),(40,0,'住院护理津贴','被保人以乘客身份乘坐民航客机遭受意外',50,'元/天',4,12),(43,1,'旅行意外','被保人以乘客身份乘坐民航客机遭受意外',18,'万元',6,15),(44,1,'旅行意外医疗','被保人以乘客身份乘坐民航客机遭受意外',2,'万元',6,15),(45,1,'住院误工津贴','被保人以乘客身份乘坐民航客机遭受意外',30,'元/天',6,15),(46,1,'飞机意外','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',6,15),(47,1,'旅行意外','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',6,16),(48,1,'旅行意外医疗','被保人以乘客身份乘坐民航客机遭受意外',5,'万元',6,16),(49,1,'住院误工津贴','被保人以乘客身份乘坐民航客机遭受意外',50,'元/天',6,16),(50,1,'飞机意外','被保人以乘客身份乘坐民航客机遭受意外',50,'万元',6,16),(51,2,'个人账户资金损失保险','被保人以乘客身份乘坐民航客机遭受意外',10,'万元',7,18),(52,2,'挂失补卡费用','被保人以乘客身份乘坐民航客机遭受意外',200,'元',7,18),(53,2,'个人账户资金损失保险','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',7,19),(54,2,'挂失补卡费用','被保人以乘客身份乘坐民航客机遭受意外',200,'元',7,19),(55,2,'个人账户资金损失保险','被保人以乘客身份乘坐民航客机遭受意外',30,'万元',7,20),(56,2,'挂失补卡费用','被保人以乘客身份乘坐民航客机遭受意外',500,'元',7,20),(57,2,'个人账户资金损失保险','被保人以乘客身份乘坐民航客机遭受意外',50,'万元',7,21),(58,2,'挂失补卡费用','被保人以乘客身份乘坐民航客机遭受意外',500,'元',7,21),(59,2,'个人账户资金损失保险','被保人以乘客身份乘坐民航客机遭受意外',100,'万元',7,22),(60,2,'挂失补卡费用','被保人以乘客身份乘坐民航客机遭受意外',500,'元',7,22),(61,2,'房屋损失','被保人以乘客身份乘坐民航客机遭受意外',100,'万元',8,24),(62,2,'房屋装修损失','被保人以乘客身份乘坐民航客机遭受意外',10,'万元',8,24),(63,2,'室内财产损失','被保人以乘客身份乘坐民航客机遭受意外',5,'万',8,24),(64,2,'房屋损失','被保人以乘客身份乘坐民航客机遭受意外',200,'万元',8,25),(65,2,'房屋装修损失','被保人以乘客身份乘坐民航客机遭受意外',20,'万元',8,25),(66,2,'室内财产损失','被保人以乘客身份乘坐民航客机遭受意外',20,'万',8,25),(67,2,'附加盗抢综合险','被保人以乘客身份乘坐民航客机遭受意外',10,'万元',8,25),(68,3,'航空延误4小时以上','被保人以乘客身份乘坐民航客机遭受意外',400,'元',9,27),(69,3,'航空延误4小时以上','被保人以乘客身份乘坐民航客机遭受意外',600,'元',9,28),(70,3,'航空意外身故、残疾保险','被保人以乘客身份乘坐民航客机遭受意外',500,'万元',9,30),(71,3,'航空意外身故、残疾保险','被保人以乘客身份乘坐民航客机遭受意外',500,'万元',9,31);
/*!40000 ALTER TABLE `detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `price` double DEFAULT '0',
  `title` varchar(200) DEFAULT NULL,
  `suitAges` varchar(200) DEFAULT NULL,
  `suitDesc` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `coverageDesc` varchar(200) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (1,0,'/img/traffic.png',25,'交通意外险','18岁-80岁','适合日常出行、差旅人士','海陆空全面保障','航空意外保障高达500万',NULL),(2,0,'/img/safe.png',85,'驾驶人意外伤害险','18岁-80岁','适合驾驶人','驾驶出行安全放心','意外伤害保障高达50万、医疗10万',NULL),(3,0,'/img/worry_free.png',120,'全车无忧险','18岁-80岁','适合车主及家人','提供住院津贴及紧急医疗救援','意外伤害保障高达50万、医疗10万',NULL),(4,0,'/img/mpay112.png',7,'综合意外保障','18岁-80岁','全面满足工作保障需求','误工津贴、紧急医疗救援服务','意外伤害保障高达20万',NULL),(5,1,'/img/self_driving.png',12,'国内自驾游险','18岁-80岁','适合自驾旅游人士','24小时道路救援','旅行意外伤害保障高达10万',NULL),(6,1,'/img/domestic_travel.png',3,'国内自助游险','18岁-80岁','适合热爱旅游人士','住宿意外伤害保障高达20万','旅行意外伤害保障高达10万',NULL),(7,2,'/img/professional_funds.png',38,'个人帐户资金损失险','18岁-80岁','银行卡、网银、第三方、理财均可保','国内外特色援助服务','资金损失保障高达100万',NULL),(8,2,'/img/mna12.png',176,'家庭财产保障','18岁-80岁','家庭安全卫士','房屋主体及市内财产全面保护','房屋损失保障高达200万',NULL),(9,3,'/img/air_delay.png',19,'航空延误险','18岁-80岁','适合飞机出行人士','航空延误我买单','',NULL),(10,3,'/img/accident.png',1,'航空意外险','18岁-80岁','适合飞机出行人士','乘坐飞机安全放心','航空意外保障高达500万',NULL);
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mimetype`
--

DROP TABLE IF EXISTS `mimetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mimetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mimetype`
--

LOCK TABLES `mimetype` WRITE;
/*!40000 ALTER TABLE `mimetype` DISABLE KEYS */;
INSERT INTO `mimetype` VALUES (1,0,'安全随行'),(2,1,'快乐旅游'),(3,2,'钱包安全'),(4,3,'更多保险');
/*!40000 ALTER TABLE `mimetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userPhone` varchar(50) DEFAULT NULL,
  `transactionNum` varchar(50) DEFAULT NULL,
  `proposalFormNum` varchar(50) DEFAULT NULL,
  `applicantId` int(11) DEFAULT NULL,
  `recognizeeId` int(11) DEFAULT NULL,
  `insuranceId` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `beginDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `bookDate` varchar(20) DEFAULT NULL,
  `timeLt` int(11) DEFAULT NULL,
  `timeCompany` varchar(5) DEFAULT NULL,
  `comboId` int(11) DEFAULT NULL,
  `payState` enum('待支付','已支付') DEFAULT '待支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `transactionNum` (`transactionNum`),
  UNIQUE KEY `propsalFormNum` (`proposalFormNum`),
  UNIQUE KEY `proposalFormNum` (`proposalFormNum`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'123','2814415650','7475471020',1,1,7,25,'2015-06-26 00:00','2016-06-26 24:00','2015-06-26 06:36:28',1,'年',17,'待支付'),(2,'123','3189709494','3244543746',1,2,7,25,'2015-06-26 00:00','2016-06-26 24:00','2015-06-26 06:47:03',1,'年',17,'待支付');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recognizee`
--

DROP TABLE IF EXISTS `recognizee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recognizee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `certificateType` varchar(20) DEFAULT NULL,
  `certificateNum` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `certificateNum` (`certificateNum`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recognizee`
--

LOCK TABLES `recognizee` WRITE;
/*!40000 ALTER TABLE `recognizee` DISABLE KEYS */;
INSERT INTO `recognizee` VALUES (1,'def','居民身份证','def','456',NULL,NULL),(2,'www','居民身份证','www','123',NULL,NULL);
/*!40000 ALTER TABLE `recognizee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,24),(2,24),(3,1);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `insuranceId` int(11) DEFAULT NULL,
  `timeLt` int(11) DEFAULT NULL,
  `timeCompany` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,0,1,20,'天'),(2,0,1,30,'天'),(3,0,1,1,'年'),(4,0,2,60,'天'),(5,0,2,1,'年'),(6,0,3,30,'天'),(7,0,3,60,'天'),(8,0,4,10,'天'),(9,0,4,20,'天'),(10,0,4,30,'天'),(11,0,4,40,'天'),(12,1,5,3,'天'),(13,1,5,5,'天'),(14,1,5,7,'天'),(15,1,5,15,'天'),(16,1,6,3,'天'),(17,1,6,5,'天'),(18,1,6,7,'天'),(19,1,6,15,'天'),(20,2,7,1,'年'),(21,2,7,2,'年'),(22,2,7,5,'年'),(23,2,7,10,'年'),(24,2,8,1,'年'),(25,2,8,3,'年'),(26,2,8,5,'年'),(27,2,8,10,'年'),(28,3,9,1,'天'),(29,3,9,3,'天'),(30,3,9,5,'天'),(31,3,10,1,'天'),(32,3,10,3,'天'),(33,3,10,5,'天'),(34,3,10,7,'天'),(35,3,10,10,'天');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'15012345678'),(2,'15072498239'),(5,'15727060402'),(1,'18566228249'),(4,'18966228249');
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

-- Dump completed on 2015-06-26 17:00:11
