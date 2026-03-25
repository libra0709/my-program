-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot6j7op54a
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot6j7op54a`
--

/*!40000 DROP DATABASE IF EXISTS `springboot6j7op54a`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot6j7op54a` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot6j7op54a`;

--
-- Table structure for table `cangguan`
--

DROP TABLE IF EXISTS `cangguan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cangguan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cangguanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓管账号',
  `cangguanxingming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓管姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cangguanzhanghao` (`cangguanzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1744560170668 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cangguan`
--

LOCK TABLES `cangguan` WRITE;
/*!40000 ALTER TABLE `cangguan` DISABLE KEYS */;
INSERT INTO `cangguan` VALUES (21,'2025-04-13 15:46:55','仓管账号1','仓管姓名1','123456','13823888881','男',1,'upload/cangguan_touxiang1.jpg'),(22,'2025-04-13 15:46:55','仓管账号2','仓管姓名2','123456','13823888882','男',2,'upload/cangguan_touxiang2.jpg'),(23,'2025-04-13 15:46:55','仓管账号3','仓管姓名3','123456','13823888883','男',3,'upload/cangguan_touxiang3.jpg'),(24,'2025-04-13 15:46:55','仓管账号4','仓管姓名4','123456','13823888884','男',4,'upload/cangguan_touxiang4.jpg'),(25,'2025-04-13 15:46:55','仓管账号5','仓管姓名5','123456','13823888885','男',5,'upload/cangguan_touxiang5.jpg'),(26,'2025-04-13 15:46:55','仓管账号6','仓管姓名6','123456','13823888886','男',6,'upload/cangguan_touxiang6.jpg'),(27,'2025-04-13 15:46:55','仓管账号7','仓管姓名7','123456','13823888887','男',7,'upload/cangguan_touxiang7.jpg'),(28,'2025-04-13 15:46:55','仓管账号8','仓管姓名8','123456','13823888888','男',8,'upload/cangguan_touxiang8.jpg'),(1744560170667,'2025-04-13 16:02:50','22','李生','22','15874123698','女',25,'upload/1744560169442.png');
/*!40000 ALTER TABLE `cangguan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cangkuxinxi`
--

DROP TABLE IF EXISTS `cangkuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cangkuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cangkubianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓库编号',
  `cangkumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓库名称',
  `cangkutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '仓库图片',
  `huojiahaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货架号码',
  `cangkuweizhi` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓库位置',
  `cangkuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '仓库详情',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cangkubianhao` (`cangkubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='仓库信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cangkuxinxi`
--

LOCK TABLES `cangkuxinxi` WRITE;
/*!40000 ALTER TABLE `cangkuxinxi` DISABLE KEYS */;
INSERT INTO `cangkuxinxi` VALUES (1,'2025-04-13 15:46:55','仓库编号1','仓库名称1','upload/cangkuxinxi_cangkutupian1.jpg,upload/cangkuxinxi_cangkutupian2.jpg,upload/cangkuxinxi_cangkutupian3.jpg','货架号码1','仓库位置1','仓库详情1'),(2,'2025-04-13 15:46:55','仓库编号2','仓库名称2','upload/cangkuxinxi_cangkutupian2.jpg,upload/cangkuxinxi_cangkutupian3.jpg,upload/cangkuxinxi_cangkutupian4.jpg','货架号码2','仓库位置2','仓库详情2'),(3,'2025-04-13 15:46:55','仓库编号3','仓库名称3','upload/cangkuxinxi_cangkutupian3.jpg,upload/cangkuxinxi_cangkutupian4.jpg,upload/cangkuxinxi_cangkutupian5.jpg','货架号码3','仓库位置3','仓库详情3'),(4,'2025-04-13 15:46:55','仓库编号4','仓库名称4','upload/cangkuxinxi_cangkutupian4.jpg,upload/cangkuxinxi_cangkutupian5.jpg,upload/cangkuxinxi_cangkutupian6.jpg','货架号码4','仓库位置4','仓库详情4'),(5,'2025-04-13 15:46:55','仓库编号5','仓库名称5','upload/cangkuxinxi_cangkutupian5.jpg,upload/cangkuxinxi_cangkutupian6.jpg,upload/cangkuxinxi_cangkutupian7.jpg','货架号码5','仓库位置5','仓库详情5'),(6,'2025-04-13 15:46:55','仓库编号6','仓库名称6','upload/cangkuxinxi_cangkutupian6.jpg,upload/cangkuxinxi_cangkutupian7.jpg,upload/cangkuxinxi_cangkutupian8.jpg','货架号码6','仓库位置6','仓库详情6'),(7,'2025-04-13 15:46:55','仓库编号7','仓库名称7','upload/cangkuxinxi_cangkutupian7.jpg,upload/cangkuxinxi_cangkutupian8.jpg,upload/cangkuxinxi_cangkutupian1.jpg','货架号码7','仓库位置7','仓库详情7'),(8,'2025-04-13 15:46:55','仓库编号8','仓库名称8','upload/cangkuxinxi_cangkutupian8.jpg,upload/cangkuxinxi_cangkutupian1.jpg,upload/cangkuxinxi_cangkutupian2.jpg','货架号码8','仓库位置8','仓库详情8'),(9,'2025-04-13 16:03:41','15050','华南仓库','upload/1744560212977.png','150505','化二十几大乘','仓库详情仓库详情仓库详情仓库详情仓库详情');
/*!40000 ALTER TABLE `cangkuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangdiaodu`
--

DROP TABLE IF EXISTS `cheliangdiaodu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangdiaodu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  `cheliangtupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '车辆图片',
  `zaizhongleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '载重类型',
  `diaodushijian` date DEFAULT NULL COMMENT '调度时间',
  `diaoduyuanyin` longtext COLLATE utf8mb4_unicode_ci COMMENT '调度原因',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='车辆调度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangdiaodu`
--

LOCK TABLES `cheliangdiaodu` WRITE;
/*!40000 ALTER TABLE `cheliangdiaodu` DISABLE KEYS */;
INSERT INTO `cheliangdiaodu` VALUES (1,'2025-04-13 15:46:55','车辆名称1','车牌号码1','upload/cheliangdiaodu_cheliangtupian1.jpg,upload/cheliangdiaodu_cheliangtupian2.jpg,upload/cheliangdiaodu_cheliangtupian3.jpg','微卡','2025-04-13','调度原因1','司机账号1','司机姓名1'),(2,'2025-04-13 15:46:55','车辆名称2','车牌号码2','upload/cheliangdiaodu_cheliangtupian2.jpg,upload/cheliangdiaodu_cheliangtupian3.jpg,upload/cheliangdiaodu_cheliangtupian4.jpg','微卡','2025-04-13','调度原因2','司机账号2','司机姓名2'),(3,'2025-04-13 15:46:55','车辆名称3','车牌号码3','upload/cheliangdiaodu_cheliangtupian3.jpg,upload/cheliangdiaodu_cheliangtupian4.jpg,upload/cheliangdiaodu_cheliangtupian5.jpg','微卡','2025-04-13','调度原因3','司机账号3','司机姓名3'),(4,'2025-04-13 15:46:55','车辆名称4','车牌号码4','upload/cheliangdiaodu_cheliangtupian4.jpg,upload/cheliangdiaodu_cheliangtupian5.jpg,upload/cheliangdiaodu_cheliangtupian6.jpg','微卡','2025-04-13','调度原因4','司机账号4','司机姓名4'),(5,'2025-04-13 15:46:55','车辆名称5','车牌号码5','upload/cheliangdiaodu_cheliangtupian5.jpg,upload/cheliangdiaodu_cheliangtupian6.jpg,upload/cheliangdiaodu_cheliangtupian7.jpg','微卡','2025-04-13','调度原因5','司机账号5','司机姓名5'),(6,'2025-04-13 15:46:55','车辆名称6','车牌号码6','upload/cheliangdiaodu_cheliangtupian6.jpg,upload/cheliangdiaodu_cheliangtupian7.jpg,upload/cheliangdiaodu_cheliangtupian8.jpg','微卡','2025-04-13','调度原因6','司机账号6','司机姓名6'),(7,'2025-04-13 15:46:55','车辆名称7','车牌号码7','upload/cheliangdiaodu_cheliangtupian7.jpg,upload/cheliangdiaodu_cheliangtupian8.jpg,upload/cheliangdiaodu_cheliangtupian1.jpg','微卡','2025-04-13','调度原因7','司机账号7','司机姓名7'),(8,'2025-04-13 15:46:55','车辆名称8','车牌号码8','upload/cheliangdiaodu_cheliangtupian8.jpg,upload/cheliangdiaodu_cheliangtupian1.jpg,upload/cheliangdiaodu_cheliangtupian2.jpg','微卡','2025-04-13','调度原因8','司机账号8','司机姓名8'),(9,'2025-04-13 16:07:28','华南运输车','55555','upload/1744560287093.png','中卡','2025-04-14','调度原因\n调度原因\n调度原因\n调度原因\n','33','小一');
/*!40000 ALTER TABLE `cheliangdiaodu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangweibao`
--

DROP TABLE IF EXISTS `cheliangweibao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangweibao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  `weibaotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '维保图片',
  `zaizhongleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '载重类型',
  `hezaizhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '荷载重量',
  `weibaojindu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '维保进度',
  `weibaoshijian` date DEFAULT NULL COMMENT '维保时间',
  `weibaoxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '维保详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='车辆维保';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangweibao`
--

LOCK TABLES `cheliangweibao` WRITE;
/*!40000 ALTER TABLE `cheliangweibao` DISABLE KEYS */;
INSERT INTO `cheliangweibao` VALUES (1,'2025-04-13 15:46:55','车辆名称1','车牌号码1','upload/cheliangweibao_weibaotupian1.jpg,upload/cheliangweibao_weibaotupian2.jpg,upload/cheliangweibao_weibaotupian3.jpg','微卡','荷载重量1','已完成','2025-04-13','维保详情1'),(2,'2025-04-13 15:46:55','车辆名称2','车牌号码2','upload/cheliangweibao_weibaotupian2.jpg,upload/cheliangweibao_weibaotupian3.jpg,upload/cheliangweibao_weibaotupian4.jpg','微卡','荷载重量2','已完成','2025-04-13','维保详情2'),(3,'2025-04-13 15:46:55','车辆名称3','车牌号码3','upload/cheliangweibao_weibaotupian3.jpg,upload/cheliangweibao_weibaotupian4.jpg,upload/cheliangweibao_weibaotupian5.jpg','微卡','荷载重量3','已完成','2025-04-13','维保详情3'),(4,'2025-04-13 15:46:55','车辆名称4','车牌号码4','upload/cheliangweibao_weibaotupian4.jpg,upload/cheliangweibao_weibaotupian5.jpg,upload/cheliangweibao_weibaotupian6.jpg','微卡','荷载重量4','已完成','2025-04-13','维保详情4'),(5,'2025-04-13 15:46:55','车辆名称5','车牌号码5','upload/cheliangweibao_weibaotupian5.jpg,upload/cheliangweibao_weibaotupian6.jpg,upload/cheliangweibao_weibaotupian7.jpg','微卡','荷载重量5','已完成','2025-04-13','维保详情5'),(6,'2025-04-13 15:46:55','车辆名称6','车牌号码6','upload/cheliangweibao_weibaotupian6.jpg,upload/cheliangweibao_weibaotupian7.jpg,upload/cheliangweibao_weibaotupian8.jpg','微卡','荷载重量6','已完成','2025-04-13','维保详情6'),(7,'2025-04-13 15:46:55','车辆名称7','车牌号码7','upload/cheliangweibao_weibaotupian7.jpg,upload/cheliangweibao_weibaotupian8.jpg,upload/cheliangweibao_weibaotupian1.jpg','微卡','荷载重量7','已完成','2025-04-13','维保详情7'),(8,'2025-04-13 15:46:55','车辆名称8','车牌号码8','upload/cheliangweibao_weibaotupian8.jpg,upload/cheliangweibao_weibaotupian1.jpg,upload/cheliangweibao_weibaotupian2.jpg','微卡','荷载重量8','已完成','2025-04-13','维保详情8'),(9,'2025-04-13 16:07:37','车辆名称8','车牌号码8','upload/1744560453957.png','微卡','荷载重量8','已完成','2025-04-14','维保详情\n维保详情\n维保详情\n');
/*!40000 ALTER TABLE `cheliangweibao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangxinxi`
--

DROP TABLE IF EXISTS `cheliangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  `cheliangtupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '车辆图片',
  `cheliangxinghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆型号',
  `zaizhongleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '载重类型',
  `cheliangzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆状态',
  `hezaizhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '荷载重量',
  `jilushijian` date DEFAULT NULL COMMENT '记录时间',
  `cheliangxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '车辆详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='车辆信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangxinxi`
--

LOCK TABLES `cheliangxinxi` WRITE;
/*!40000 ALTER TABLE `cheliangxinxi` DISABLE KEYS */;
INSERT INTO `cheliangxinxi` VALUES (1,'2025-04-13 15:46:55','车辆名称1','车牌号码1','upload/cheliangxinxi_cheliangtupian1.jpg,upload/cheliangxinxi_cheliangtupian2.jpg,upload/cheliangxinxi_cheliangtupian3.jpg','车辆型号1','微卡','出车','荷载重量1','2025-04-13','车辆详情1'),(2,'2025-04-13 15:46:55','车辆名称2','车牌号码2','upload/cheliangxinxi_cheliangtupian2.jpg,upload/cheliangxinxi_cheliangtupian3.jpg,upload/cheliangxinxi_cheliangtupian4.jpg','车辆型号2','微卡','出车','荷载重量2','2025-04-13','车辆详情2'),(3,'2025-04-13 15:46:55','车辆名称3','车牌号码3','upload/cheliangxinxi_cheliangtupian3.jpg,upload/cheliangxinxi_cheliangtupian4.jpg,upload/cheliangxinxi_cheliangtupian5.jpg','车辆型号3','微卡','待命','荷载重量3','2025-04-13','车辆详情3'),(4,'2025-04-13 15:46:55','车辆名称4','车牌号码4','upload/cheliangxinxi_cheliangtupian4.jpg,upload/cheliangxinxi_cheliangtupian5.jpg,upload/cheliangxinxi_cheliangtupian6.jpg','车辆型号4','微卡','出车','荷载重量4','2025-04-13','车辆详情4'),(5,'2025-04-13 15:46:55','车辆名称5','车牌号码5','upload/cheliangxinxi_cheliangtupian5.jpg,upload/cheliangxinxi_cheliangtupian6.jpg,upload/cheliangxinxi_cheliangtupian7.jpg','车辆型号5','微卡','出车','荷载重量5','2025-04-13','车辆详情5'),(6,'2025-04-13 15:46:55','车辆名称6','车牌号码6','upload/cheliangxinxi_cheliangtupian6.jpg,upload/cheliangxinxi_cheliangtupian7.jpg,upload/cheliangxinxi_cheliangtupian8.jpg','车辆型号6','微卡','出车','荷载重量6','2025-04-13','车辆详情6'),(7,'2025-04-13 15:46:55','车辆名称7','车牌号码7','upload/cheliangxinxi_cheliangtupian7.jpg,upload/cheliangxinxi_cheliangtupian8.jpg,upload/cheliangxinxi_cheliangtupian1.jpg','车辆型号7','微卡','待命','荷载重量7','2025-04-13','车辆详情7'),(8,'2025-04-13 15:46:55','车辆名称8','车牌号码8','upload/cheliangxinxi_cheliangtupian8.jpg,upload/cheliangxinxi_cheliangtupian1.jpg,upload/cheliangxinxi_cheliangtupian2.jpg','车辆型号8','微卡','出车','荷载重量8','2025-04-13','车辆详情8'),(9,'2025-04-13 16:04:58','华南运输车','55555','upload/1744560287093.png','22','中卡','出车','50','2025-04-14','车辆详情\n车辆详情\n车辆详情\n车辆详情\n');
/*!40000 ALTER TABLE `cheliangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL),(2,'picture2','upload/picture2.jpg',NULL),(3,'picture3','upload/picture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dingdanxinxi`
--

DROP TABLE IF EXISTS `dingdanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dingdanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `shangpintupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '商品图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '购买数量',
  `shangpinjiage` double DEFAULT NULL COMMENT '商品价格',
  `goumaifeiyong` double DEFAULT NULL COMMENT '购买费用',
  `goumaishijian` date DEFAULT NULL COMMENT '购买时间',
  `dingdanzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送地址',
  `dingdanyaoqiu` longtext COLLATE utf8mb4_unicode_ci COMMENT '订单要求',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dingdanxinxi`
--

LOCK TABLES `dingdanxinxi` WRITE;
/*!40000 ALTER TABLE `dingdanxinxi` DISABLE KEYS */;
INSERT INTO `dingdanxinxi` VALUES (1,'2025-04-13 15:46:55','1111111111','商品名称1','商品分类1','upload/dingdanxinxi_shangpintupian1.jpg,upload/dingdanxinxi_shangpintupian2.jpg,upload/dingdanxinxi_shangpintupian3.jpg',1,1,1,'2025-04-13','已接单','用户账号1','用户姓名1','手机号码1','配送地址1','订单要求1'),(2,'2025-04-13 15:46:55','2222222222','商品名称2','商品分类2','upload/dingdanxinxi_shangpintupian2.jpg,upload/dingdanxinxi_shangpintupian3.jpg,upload/dingdanxinxi_shangpintupian4.jpg',2,2,2,'2025-04-13','已接单','用户账号2','用户姓名2','手机号码2','配送地址2','订单要求2'),(3,'2025-04-13 15:46:55','3333333333','商品名称3','商品分类3','upload/dingdanxinxi_shangpintupian3.jpg,upload/dingdanxinxi_shangpintupian4.jpg,upload/dingdanxinxi_shangpintupian5.jpg',3,3,3,'2025-04-13','已接单','用户账号3','用户姓名3','手机号码3','配送地址3','订单要求3'),(4,'2025-04-13 15:46:55','4444444444','商品名称4','商品分类4','upload/dingdanxinxi_shangpintupian4.jpg,upload/dingdanxinxi_shangpintupian5.jpg,upload/dingdanxinxi_shangpintupian6.jpg',4,4,4,'2025-04-13','已接单','用户账号4','用户姓名4','手机号码4','配送地址4','订单要求4'),(5,'2025-04-13 15:46:55','5555555555','商品名称5','商品分类5','upload/dingdanxinxi_shangpintupian5.jpg,upload/dingdanxinxi_shangpintupian6.jpg,upload/dingdanxinxi_shangpintupian7.jpg',5,5,5,'2025-04-13','已接单','用户账号5','用户姓名5','手机号码5','配送地址5','订单要求5'),(6,'2025-04-13 15:46:55','6666666666','商品名称6','商品分类6','upload/dingdanxinxi_shangpintupian6.jpg,upload/dingdanxinxi_shangpintupian7.jpg,upload/dingdanxinxi_shangpintupian8.jpg',6,6,6,'2025-04-13','已接单','用户账号6','用户姓名6','手机号码6','配送地址6','订单要求6'),(7,'2025-04-13 15:46:55','7777777777','商品名称7','商品分类7','upload/dingdanxinxi_shangpintupian7.jpg,upload/dingdanxinxi_shangpintupian8.jpg,upload/dingdanxinxi_shangpintupian1.jpg',7,7,7,'2025-04-13','已接单','用户账号7','用户姓名7','手机号码7','配送地址7','订单要求7'),(8,'2025-04-13 15:46:55','8888888888','商品名称8','商品分类8','upload/dingdanxinxi_shangpintupian8.jpg,upload/dingdanxinxi_shangpintupian1.jpg,upload/dingdanxinxi_shangpintupian2.jpg',8,8,8,'2025-04-13','已接单','用户账号8','用户姓名8','手机号码8','配送地址8','订单要求8'),(9,'2025-04-13 16:06:41','1744560392825','物资商品','家电类','upload/1744560237523.png',50,1800,90000,'2025-04-14','已接单','11','涉及这','15874123698','华南','订单要求\n订单要求\n订单要求\n订单要求\n');
/*!40000 ALTER TABLE `dingdanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussshangpinxinxi`
--

DROP TABLE IF EXISTS `discussshangpinxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussshangpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `istop` int(11) DEFAULT '0' COMMENT '置顶(1:置顶,0:非置顶)',
  `tuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '赞用户ids',
  `cuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '踩用户ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussshangpinxinxi`
--

LOCK TABLES `discussshangpinxinxi` WRITE;
/*!40000 ALTER TABLE `discussshangpinxinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussshangpinxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COLLATE utf8mb4_unicode_ci COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2025-04-13 15:46:55','[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\",\"parentMenuName\":\"用户管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":100099}],\"menu\":\"用户管理\",\"id\":1000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"员工\",\"menuJump\":\"列表\",\"tableName\":\"cangguan\",\"parentMenuName\":\"员工管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":200099}],\"menu\":\"员工管理\",\"id\":2000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"司机\",\"menuJump\":\"列表\",\"tableName\":\"siji\",\"parentMenuName\":\"司机管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":300099}],\"menu\":\"司机管理\",\"id\":3000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"仓库信息\",\"menuJump\":\"列表\",\"tableName\":\"cangkuxinxi\",\"parentMenuName\":\"仓库信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":400099}],\"menu\":\"仓库信息管理\",\"id\":4000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品库存量\",\"查看评论\",\"首页总数\",\"首页统计\",\"购买\",\"出库\",\"入库\",\"盘点\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品库存量\",\"查看评论\",\"首页总数\",\"首页统计\"],\"menu\":\"商品信息\",\"menuJump\":\"列表\",\"tableName\":\"shangpinxinxi\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"商品库存量\"},{\"menu\":\"查看评论\"},{\"menu\":\"首页总数\"},{\"menu\":\"首页统计\"},{\"menu\":\"购买\"},{\"menu\":\"出库\"},{\"menu\":\"入库\"},{\"menu\":\"盘点\"}],\"id\":600099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"商品分类\",\"menuJump\":\"列表\",\"tableName\":\"shangpinfenlei\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":500099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"销售金额\",\"首页总数\",\"首页统计\",\"分配\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"删除\",\"修改\",\"查看\",\"销售金额\",\"首页总数\",\"首页统计\",\"分配\"],\"menu\":\"订单信息\",\"menuJump\":\"列表\",\"tableName\":\"dingdanxinxi\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"销售金额\"},{\"menu\":\"首页总数\"},{\"menu\":\"首页统计\"},{\"menu\":\"分配\"}],\"id\":700099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"商品出库\",\"menuJump\":\"列表\",\"tableName\":\"shangpinchuku\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1400099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品入库量\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"商品入库量\",\"首页总数\",\"首页统计\"],\"menu\":\"商品入库\",\"menuJump\":\"列表\",\"tableName\":\"shangpinruku\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"商品入库量\"},{\"menu\":\"首页总数\"},{\"menu\":\"首页统计\"}],\"id\":1500099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"商品盘点\",\"menuJump\":\"列表\",\"tableName\":\"shangpinpandian\",\"parentMenuName\":\"商品信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1600099}],\"menu\":\"商品信息管理\",\"id\":6000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"运输\"],\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"运输任务\",\"menuJump\":\"列表\",\"tableName\":\"yunshurenwu\",\"parentMenuName\":\"运输任务管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"运输\"}],\"id\":800099}],\"menu\":\"运输任务管理\",\"id\":8000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"配送率占比\",\"首页总数\",\"首页统计\",\"监控\",\"异常\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"配送率占比\",\"首页总数\",\"首页统计\",\"监控\"],\"menu\":\"运输记录\",\"menuJump\":\"列表\",\"tableName\":\"yunshujilu\",\"parentMenuName\":\"运输记录管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"配送率占比\"},{\"menu\":\"首页总数\"},{\"menu\":\"首页统计\"},{\"menu\":\"监控\"},{\"menu\":\"异常\"}],\"id\":900099}],\"menu\":\"运输记录管理\",\"id\":9000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"调度\",\"维保\"],\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"调度\",\"维保\"],\"menu\":\"车辆信息\",\"menuJump\":\"列表\",\"tableName\":\"cheliangxinxi\",\"parentMenuName\":\"车辆信息管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"调度\"},{\"menu\":\"维保\"}],\"id\":1000099}],\"menu\":\"车辆信息管理\",\"id\":10000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆调度\",\"menuJump\":\"列表\",\"tableName\":\"cheliangdiaodu\",\"parentMenuName\":\"车辆调度管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1100099}],\"menu\":\"车辆调度管理\",\"id\":11000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆维保\",\"menuJump\":\"列表\",\"tableName\":\"cheliangweibao\",\"parentMenuName\":\"车辆维保管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1200099}],\"menu\":\"车辆维保管理\",\"id\":12000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"运输跟踪\",\"menuJump\":\"列表\",\"tableName\":\"yunshugenzong\",\"parentMenuName\":\"运输跟踪管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1300099}],\"menu\":\"运输跟踪管理\",\"id\":13000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"异常处理\",\"menuJump\":\"列表\",\"tableName\":\"yichangchuli\",\"parentMenuName\":\"异常处理管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1700099}],\"menu\":\"异常处理管理\",\"id\":17000},{\"child\":[{\"allButtons\":[\"查看\",\"删除\"],\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"系统日志\",\"tableName\":\"syslog\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"查看\"},{\"menu\":\"删除\"}],\"id\":1800099},{\"allButtons\":[\"查看\",\"编辑名称\",\"编辑父级\",\"编辑权限\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"编辑名称\",\"编辑父级\",\"编辑权限\",\"删除\"],\"menu\":\"菜单列表\",\"tableName\":\"menu\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"查看\"},{\"menu\":\"编辑名称\"},{\"menu\":\"编辑父级\"},{\"menu\":\"编辑权限\"},{\"menu\":\"删除\"}],\"id\":1900099}],\"menu\":\"系统管理\",\"id\":18000}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品库存量\",\"查看评论\",\"首页总数\",\"首页统计\",\"购买\",\"出库\",\"入库\",\"盘点\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"购买\"],\"menu\":\"商品信息\",\"menuJump\":\"列表\",\"tableName\":\"shangpinxinxi\"}],\"menu\":\"商品信息管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"销售金额\",\"首页总数\",\"首页统计\",\"分配\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"订单信息\",\"menuJump\":\"列表\",\"tableName\":\"dingdanxinxi\"}],\"menu\":\"订单信息管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"配送率占比\",\"首页总数\",\"首页统计\",\"监控\",\"异常\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\"],\"menu\":\"运输记录\",\"menuJump\":\"列表\",\"tableName\":\"yunshujilu\"}],\"menu\":\"运输记录管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"查看\"],\"menu\":\"仓库信息\",\"menuJump\":\"列表\",\"tableName\":\"cangkuxinxi\"}],\"menu\":\"仓库信息管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品库存量\",\"查看评论\",\"首页总数\",\"首页统计\",\"购买\",\"出库\",\"入库\",\"盘点\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"出库\",\"入库\",\"盘点\",\"首页统计\",\"首页总数\"],\"menu\":\"商品信息\",\"menuJump\":\"列表\",\"tableName\":\"shangpinxinxi\"}],\"menu\":\"商品信息管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"销售金额\",\"首页总数\",\"首页统计\",\"分配\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\"],\"menu\":\"订单信息\",\"menuJump\":\"列表\",\"tableName\":\"dingdanxinxi\"}],\"menu\":\"订单信息管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"商品出库\",\"menuJump\":\"列表\",\"tableName\":\"shangpinchuku\"}],\"menu\":\"商品出库管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"商品入库量\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"首页总数\",\"首页统计\"],\"menu\":\"商品入库\",\"menuJump\":\"列表\",\"tableName\":\"shangpinruku\"}],\"menu\":\"商品入库管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"商品盘点\",\"menuJump\":\"列表\",\"tableName\":\"shangpinpandian\"}],\"menu\":\"商品盘点管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"员工\",\"tableName\":\"cangguan\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"运输\"],\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"查看\",\"运输\"],\"menu\":\"运输任务\",\"menuJump\":\"列表\",\"tableName\":\"yunshurenwu\"}],\"menu\":\"运输任务管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"配送率占比\",\"首页总数\",\"首页统计\",\"监控\",\"异常\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"异常\"],\"menu\":\"运输记录\",\"menuJump\":\"列表\",\"tableName\":\"yunshujilu\"}],\"menu\":\"运输记录管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"车辆调度\",\"menuJump\":\"列表\",\"tableName\":\"cheliangdiaodu\"}],\"menu\":\"车辆调度管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"异常处理\",\"menuJump\":\"列表\",\"tableName\":\"yichangchuli\"}],\"menu\":\"异常处理管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"司机\",\"tableName\":\"siji\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinchuku`
--

DROP TABLE IF EXISTS `shangpinchuku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinchuku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `chukutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '出库图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '出库数量',
  `shangpinguige` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `chukushijian` date DEFAULT NULL COMMENT '出库时间',
  `chukubeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '出库备注',
  `cangguanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管账号',
  `cangguanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品出库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinchuku`
--

LOCK TABLES `shangpinchuku` WRITE;
/*!40000 ALTER TABLE `shangpinchuku` DISABLE KEYS */;
INSERT INTO `shangpinchuku` VALUES (1,'2025-04-13 15:46:55','商品名称1','商品分类1','upload/shangpinchuku_chukutupian1.jpg,upload/shangpinchuku_chukutupian2.jpg,upload/shangpinchuku_chukutupian3.jpg',1,'商品规格1','2025-04-13','出库备注1','仓管账号1','仓管姓名1'),(2,'2025-04-13 15:46:55','商品名称2','商品分类2','upload/shangpinchuku_chukutupian2.jpg,upload/shangpinchuku_chukutupian3.jpg,upload/shangpinchuku_chukutupian4.jpg',2,'商品规格2','2025-04-13','出库备注2','仓管账号2','仓管姓名2'),(3,'2025-04-13 15:46:55','商品名称3','商品分类3','upload/shangpinchuku_chukutupian3.jpg,upload/shangpinchuku_chukutupian4.jpg,upload/shangpinchuku_chukutupian5.jpg',3,'商品规格3','2025-04-13','出库备注3','仓管账号3','仓管姓名3'),(4,'2025-04-13 15:46:55','商品名称4','商品分类4','upload/shangpinchuku_chukutupian4.jpg,upload/shangpinchuku_chukutupian5.jpg,upload/shangpinchuku_chukutupian6.jpg',4,'商品规格4','2025-04-13','出库备注4','仓管账号4','仓管姓名4'),(5,'2025-04-13 15:46:55','商品名称5','商品分类5','upload/shangpinchuku_chukutupian5.jpg,upload/shangpinchuku_chukutupian6.jpg,upload/shangpinchuku_chukutupian7.jpg',5,'商品规格5','2025-04-13','出库备注5','仓管账号5','仓管姓名5'),(6,'2025-04-13 15:46:55','商品名称6','商品分类6','upload/shangpinchuku_chukutupian6.jpg,upload/shangpinchuku_chukutupian7.jpg,upload/shangpinchuku_chukutupian8.jpg',6,'商品规格6','2025-04-13','出库备注6','仓管账号6','仓管姓名6'),(7,'2025-04-13 15:46:55','商品名称7','商品分类7','upload/shangpinchuku_chukutupian7.jpg,upload/shangpinchuku_chukutupian8.jpg,upload/shangpinchuku_chukutupian1.jpg',7,'商品规格7','2025-04-13','出库备注7','仓管账号7','仓管姓名7'),(8,'2025-04-13 15:46:55','商品名称8','商品分类8','upload/shangpinchuku_chukutupian8.jpg,upload/shangpinchuku_chukutupian1.jpg,upload/shangpinchuku_chukutupian2.jpg',8,'商品规格8','2025-04-13','出库备注8','仓管账号8','仓管姓名8'),(9,'2025-04-13 16:09:02','物资商品','家电类','upload/1744560533784.png',10,'22','2025-04-14','出库备注\n出库备注\n出库备注\n','22','李生');
/*!40000 ALTER TABLE `shangpinchuku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinfenlei`
--

DROP TABLE IF EXISTS `shangpinfenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinfenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinfenlei`
--

LOCK TABLES `shangpinfenlei` WRITE;
/*!40000 ALTER TABLE `shangpinfenlei` DISABLE KEYS */;
INSERT INTO `shangpinfenlei` VALUES (1,'2025-04-13 15:46:55','商品分类1'),(2,'2025-04-13 15:46:55','商品分类2'),(3,'2025-04-13 15:46:55','商品分类3'),(4,'2025-04-13 15:46:55','商品分类4'),(5,'2025-04-13 15:46:55','商品分类5'),(6,'2025-04-13 15:46:55','商品分类6'),(7,'2025-04-13 15:46:55','商品分类7'),(8,'2025-04-13 15:46:55','商品分类8'),(9,'2025-04-13 16:03:52','家电类');
/*!40000 ALTER TABLE `shangpinfenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinpandian`
--

DROP TABLE IF EXISTS `shangpinpandian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinpandian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `pandiantupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '盘点图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '库存数量',
  `pandianshuliang` int(11) DEFAULT NULL COMMENT '盘点数量',
  `shangpinguige` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `cangguanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管账号',
  `cangguanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管姓名',
  `pandianbeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '盘点备注',
  `pandianshijian` date DEFAULT NULL COMMENT '盘点时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品盘点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinpandian`
--

LOCK TABLES `shangpinpandian` WRITE;
/*!40000 ALTER TABLE `shangpinpandian` DISABLE KEYS */;
INSERT INTO `shangpinpandian` VALUES (1,'2025-04-13 15:46:55','商品名称1','商品分类1','upload/shangpinpandian_pandiantupian1.jpg,upload/shangpinpandian_pandiantupian2.jpg,upload/shangpinpandian_pandiantupian3.jpg',1,1,'商品规格1','仓管账号1','仓管姓名1','盘点备注1','2025-04-13'),(2,'2025-04-13 15:46:55','商品名称2','商品分类2','upload/shangpinpandian_pandiantupian2.jpg,upload/shangpinpandian_pandiantupian3.jpg,upload/shangpinpandian_pandiantupian4.jpg',2,2,'商品规格2','仓管账号2','仓管姓名2','盘点备注2','2025-04-13'),(3,'2025-04-13 15:46:55','商品名称3','商品分类3','upload/shangpinpandian_pandiantupian3.jpg,upload/shangpinpandian_pandiantupian4.jpg,upload/shangpinpandian_pandiantupian5.jpg',3,3,'商品规格3','仓管账号3','仓管姓名3','盘点备注3','2025-04-13'),(4,'2025-04-13 15:46:55','商品名称4','商品分类4','upload/shangpinpandian_pandiantupian4.jpg,upload/shangpinpandian_pandiantupian5.jpg,upload/shangpinpandian_pandiantupian6.jpg',4,4,'商品规格4','仓管账号4','仓管姓名4','盘点备注4','2025-04-13'),(5,'2025-04-13 15:46:55','商品名称5','商品分类5','upload/shangpinpandian_pandiantupian5.jpg,upload/shangpinpandian_pandiantupian6.jpg,upload/shangpinpandian_pandiantupian7.jpg',5,5,'商品规格5','仓管账号5','仓管姓名5','盘点备注5','2025-04-13'),(6,'2025-04-13 15:46:55','商品名称6','商品分类6','upload/shangpinpandian_pandiantupian6.jpg,upload/shangpinpandian_pandiantupian7.jpg,upload/shangpinpandian_pandiantupian8.jpg',6,6,'商品规格6','仓管账号6','仓管姓名6','盘点备注6','2025-04-13'),(7,'2025-04-13 15:46:55','商品名称7','商品分类7','upload/shangpinpandian_pandiantupian7.jpg,upload/shangpinpandian_pandiantupian8.jpg,upload/shangpinpandian_pandiantupian1.jpg',7,7,'商品规格7','仓管账号7','仓管姓名7','盘点备注7','2025-04-13'),(8,'2025-04-13 15:46:55','商品名称8','商品分类8','upload/shangpinpandian_pandiantupian8.jpg,upload/shangpinpandian_pandiantupian1.jpg,upload/shangpinpandian_pandiantupian2.jpg',8,8,'商品规格8','仓管账号8','仓管姓名8','盘点备注8','2025-04-13'),(9,'2025-04-13 16:09:24','物资商品','家电类','upload/1744560562380.png',1120,1120,'22','22','李生','盘点备注\n盘点备注\n盘点备注\n','2025-04-14');
/*!40000 ALTER TABLE `shangpinpandian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinruku`
--

DROP TABLE IF EXISTS `shangpinruku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinruku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `rukutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '入库图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '入库数量',
  `shangpinguige` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `cangguanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管账号',
  `cangguanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓管姓名',
  `rukubeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '入库备注',
  `rukushijian` date DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinruku`
--

LOCK TABLES `shangpinruku` WRITE;
/*!40000 ALTER TABLE `shangpinruku` DISABLE KEYS */;
INSERT INTO `shangpinruku` VALUES (1,'2025-04-13 15:46:55','商品名称1','商品分类1','upload/shangpinruku_rukutupian1.jpg,upload/shangpinruku_rukutupian2.jpg,upload/shangpinruku_rukutupian3.jpg',1,'商品规格1','仓管账号1','仓管姓名1','入库备注1','2025-04-13'),(2,'2025-04-13 15:46:55','商品名称2','商品分类2','upload/shangpinruku_rukutupian2.jpg,upload/shangpinruku_rukutupian3.jpg,upload/shangpinruku_rukutupian4.jpg',2,'商品规格2','仓管账号2','仓管姓名2','入库备注2','2025-04-13'),(3,'2025-04-13 15:46:55','商品名称3','商品分类3','upload/shangpinruku_rukutupian3.jpg,upload/shangpinruku_rukutupian4.jpg,upload/shangpinruku_rukutupian5.jpg',3,'商品规格3','仓管账号3','仓管姓名3','入库备注3','2025-04-13'),(4,'2025-04-13 15:46:55','商品名称4','商品分类4','upload/shangpinruku_rukutupian4.jpg,upload/shangpinruku_rukutupian5.jpg,upload/shangpinruku_rukutupian6.jpg',4,'商品规格4','仓管账号4','仓管姓名4','入库备注4','2025-04-13'),(5,'2025-04-13 15:46:55','商品名称5','商品分类5','upload/shangpinruku_rukutupian5.jpg,upload/shangpinruku_rukutupian6.jpg,upload/shangpinruku_rukutupian7.jpg',5,'商品规格5','仓管账号5','仓管姓名5','入库备注5','2025-04-13'),(6,'2025-04-13 15:46:55','商品名称6','商品分类6','upload/shangpinruku_rukutupian6.jpg,upload/shangpinruku_rukutupian7.jpg,upload/shangpinruku_rukutupian8.jpg',6,'商品规格6','仓管账号6','仓管姓名6','入库备注6','2025-04-13'),(7,'2025-04-13 15:46:55','商品名称7','商品分类7','upload/shangpinruku_rukutupian7.jpg,upload/shangpinruku_rukutupian8.jpg,upload/shangpinruku_rukutupian1.jpg',7,'商品规格7','仓管账号7','仓管姓名7','入库备注7','2025-04-13'),(8,'2025-04-13 15:46:55','商品名称8','商品分类8','upload/shangpinruku_rukutupian8.jpg,upload/shangpinruku_rukutupian1.jpg,upload/shangpinruku_rukutupian2.jpg',8,'商品规格8','仓管账号8','仓管姓名8','入库备注8','2025-04-13'),(9,'2025-04-13 16:09:13','物资商品','家电类','upload/1744560550799.png',680,'22','22','李生','入库备注\n入库备注\n入库备注\n','2025-04-14');
/*!40000 ALTER TABLE `shangpinruku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinxinxi`
--

DROP TABLE IF EXISTS `shangpinxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `shangpintupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '商品图片',
  `shangpinguige` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '库存数量',
  `shangpinjiage` double DEFAULT NULL COMMENT '商品价格',
  `shengchanriqi` date DEFAULT NULL COMMENT '生产日期',
  `yingyangchengfen` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营养成分',
  `shangpinchandi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品产地',
  `shangjiashijian` date DEFAULT NULL COMMENT '上架时间',
  `shangpinjieshao` longtext COLLATE utf8mb4_unicode_ci COMMENT '商品介绍',
  `chucunweizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '储存位置',
  `cangkumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '仓库名称',
  `huojiahaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货架号码',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinxinxi`
--

LOCK TABLES `shangpinxinxi` WRITE;
/*!40000 ALTER TABLE `shangpinxinxi` DISABLE KEYS */;
INSERT INTO `shangpinxinxi` VALUES (1,'2025-04-13 15:46:55','商品名称1','商品分类1','upload/shangpinxinxi_shangpintupian1.jpg,upload/shangpinxinxi_shangpintupian2.jpg,upload/shangpinxinxi_shangpintupian3.jpg','商品规格1',1,1,'2025-04-13','营养成分1','商品产地1','2025-04-13','商品介绍1','储存位置1','仓库名称1','货架号码1',1,1,'2025-04-13 23:46:55',1,0,1),(2,'2025-04-13 15:46:55','商品名称2','商品分类2','upload/shangpinxinxi_shangpintupian2.jpg,upload/shangpinxinxi_shangpintupian3.jpg,upload/shangpinxinxi_shangpintupian4.jpg','商品规格2',2,2,'2025-04-13','营养成分2','商品产地2','2025-04-13','商品介绍2','储存位置2','仓库名称2','货架号码2',2,2,'2025-04-13 23:46:55',2,0,2),(3,'2025-04-13 15:46:55','商品名称3','商品分类3','upload/shangpinxinxi_shangpintupian3.jpg,upload/shangpinxinxi_shangpintupian4.jpg,upload/shangpinxinxi_shangpintupian5.jpg','商品规格3',3,3,'2025-04-13','营养成分3','商品产地3','2025-04-13','商品介绍3','储存位置3','仓库名称3','货架号码3',3,3,'2025-04-13 23:46:55',3,0,3),(4,'2025-04-13 15:46:55','商品名称4','商品分类4','upload/shangpinxinxi_shangpintupian4.jpg,upload/shangpinxinxi_shangpintupian5.jpg,upload/shangpinxinxi_shangpintupian6.jpg','商品规格4',4,4,'2025-04-13','营养成分4','商品产地4','2025-04-13','商品介绍4','储存位置4','仓库名称4','货架号码4',4,4,'2025-04-13 23:46:55',4,0,4),(5,'2025-04-13 15:46:55','商品名称5','商品分类5','upload/shangpinxinxi_shangpintupian5.jpg,upload/shangpinxinxi_shangpintupian6.jpg,upload/shangpinxinxi_shangpintupian7.jpg','商品规格5',5,5,'2025-04-13','营养成分5','商品产地5','2025-04-13','商品介绍5','储存位置5','仓库名称5','货架号码5',5,5,'2025-04-13 23:46:55',5,0,5),(6,'2025-04-13 15:46:55','商品名称6','商品分类6','upload/shangpinxinxi_shangpintupian6.jpg,upload/shangpinxinxi_shangpintupian7.jpg,upload/shangpinxinxi_shangpintupian8.jpg','商品规格6',6,6,'2025-04-13','营养成分6','商品产地6','2025-04-13','商品介绍6','储存位置6','仓库名称6','货架号码6',6,6,'2025-04-13 23:46:55',6,0,6),(7,'2025-04-13 15:46:55','商品名称7','商品分类7','upload/shangpinxinxi_shangpintupian7.jpg,upload/shangpinxinxi_shangpintupian8.jpg,upload/shangpinxinxi_shangpintupian1.jpg','商品规格7',7,7,'2025-04-13','营养成分7','商品产地7','2025-04-13','商品介绍7','储存位置7','仓库名称7','货架号码7',7,7,'2025-04-13 23:46:55',7,0,7),(8,'2025-04-13 15:46:55','商品名称8','商品分类8','upload/shangpinxinxi_shangpintupian8.jpg,upload/shangpinxinxi_shangpintupian1.jpg,upload/shangpinxinxi_shangpintupian2.jpg','商品规格8',8,8,'2025-04-13','营养成分8','商品产地8','2025-04-13','商品介绍8','储存位置8','仓库名称8','货架号码8',8,8,'2025-04-13 23:46:55',8,0,8),(9,'2025-04-13 16:04:23','物资商品','家电类','upload/1744560237523.png','22',1120,1800,'2025-01-14','','中国','2025-04-14','<p><span style=\"color: rgb(158, 158, 158);\">商品介绍商品介绍商品介绍商品介绍</span></p>','','','',0,0,NULL,0,0,0);
/*!40000 ALTER TABLE `shangpinxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siji`
--

DROP TABLE IF EXISTS `siji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `siji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '司机姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `jiashizheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '驾驶证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sijizhanghao` (`sijizhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1744560194760 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='司机';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siji`
--

LOCK TABLES `siji` WRITE;
/*!40000 ALTER TABLE `siji` DISABLE KEYS */;
INSERT INTO `siji` VALUES (31,'2025-04-13 15:46:55','司机账号1','司机姓名1','123456','13823888881','男',1,'upload/siji_touxiang1.jpg','驾驶证1'),(32,'2025-04-13 15:46:55','司机账号2','司机姓名2','123456','13823888882','男',2,'upload/siji_touxiang2.jpg','驾驶证2'),(33,'2025-04-13 15:46:55','司机账号3','司机姓名3','123456','13823888883','男',3,'upload/siji_touxiang3.jpg','驾驶证3'),(34,'2025-04-13 15:46:55','司机账号4','司机姓名4','123456','13823888884','男',4,'upload/siji_touxiang4.jpg','驾驶证4'),(35,'2025-04-13 15:46:55','司机账号5','司机姓名5','123456','13823888885','男',5,'upload/siji_touxiang5.jpg','驾驶证5'),(36,'2025-04-13 15:46:55','司机账号6','司机姓名6','123456','13823888886','男',6,'upload/siji_touxiang6.jpg','驾驶证6'),(37,'2025-04-13 15:46:55','司机账号7','司机姓名7','123456','13823888887','男',7,'upload/siji_touxiang7.jpg','驾驶证7'),(38,'2025-04-13 15:46:55','司机账号8','司机姓名8','123456','13823888888','男',8,'upload/siji_touxiang8.jpg','驾驶证8'),(1744560194759,'2025-04-13 16:03:14','33','小一','33','15874123698','男',35,'upload/1744560191359.jpg','55555');
/*!40000 ALTER TABLE `siji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'admin','users','管理员','v9mgbd4shvjlzr1n5qhr8ml1asdzubc2','2025-04-13 16:02:24','2025-04-13 17:09:35'),(2,1744560137440,'11','yonghu','用户','g6572kjwcpnnmkti4smxycqz8bdp3dx7','2025-04-13 16:06:24','2025-04-13 17:06:25'),(3,1744560194759,'33','siji','司机','7rfrfpl5p97qcm4ddxdrb37d9mhiylz4','2025-04-13 16:07:50','2025-04-13 17:07:50'),(4,1744560170667,'22','cangguan','仓管','e5a4be7diqdqimjmqcnhx8iadifos00x','2025-04-13 16:08:44','2025-04-13 17:08:44');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','upload/image1.jpg','管理员','2025-04-13 15:46:55');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yichangchuli`
--

DROP TABLE IF EXISTS `yichangchuli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yichangchuli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `chulitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '处理图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '运输数量',
  `gengxinshijian` date DEFAULT NULL COMMENT '更新时间',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送地址',
  `yichangyuanyin` longtext COLLATE utf8mb4_unicode_ci COMMENT '异常原因',
  `chulijilu` longtext COLLATE utf8mb4_unicode_ci COMMENT '处理记录',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='异常处理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yichangchuli`
--

LOCK TABLES `yichangchuli` WRITE;
/*!40000 ALTER TABLE `yichangchuli` DISABLE KEYS */;
INSERT INTO `yichangchuli` VALUES (1,'2025-04-13 15:46:55','订单编号1','商品名称1','商品分类1','upload/yichangchuli_chulitupian1.jpg,upload/yichangchuli_chulitupian2.jpg,upload/yichangchuli_chulitupian3.jpg',1,'2025-04-13','用户账号1','用户姓名1','手机号码1','配送地址1','异常原因1','处理记录1','司机账号1','司机姓名1','车辆名称1','车牌号码1'),(2,'2025-04-13 15:46:55','订单编号2','商品名称2','商品分类2','upload/yichangchuli_chulitupian2.jpg,upload/yichangchuli_chulitupian3.jpg,upload/yichangchuli_chulitupian4.jpg',2,'2025-04-13','用户账号2','用户姓名2','手机号码2','配送地址2','异常原因2','处理记录2','司机账号2','司机姓名2','车辆名称2','车牌号码2'),(3,'2025-04-13 15:46:55','订单编号3','商品名称3','商品分类3','upload/yichangchuli_chulitupian3.jpg,upload/yichangchuli_chulitupian4.jpg,upload/yichangchuli_chulitupian5.jpg',3,'2025-04-13','用户账号3','用户姓名3','手机号码3','配送地址3','异常原因3','处理记录3','司机账号3','司机姓名3','车辆名称3','车牌号码3'),(4,'2025-04-13 15:46:55','订单编号4','商品名称4','商品分类4','upload/yichangchuli_chulitupian4.jpg,upload/yichangchuli_chulitupian5.jpg,upload/yichangchuli_chulitupian6.jpg',4,'2025-04-13','用户账号4','用户姓名4','手机号码4','配送地址4','异常原因4','处理记录4','司机账号4','司机姓名4','车辆名称4','车牌号码4'),(5,'2025-04-13 15:46:55','订单编号5','商品名称5','商品分类5','upload/yichangchuli_chulitupian5.jpg,upload/yichangchuli_chulitupian6.jpg,upload/yichangchuli_chulitupian7.jpg',5,'2025-04-13','用户账号5','用户姓名5','手机号码5','配送地址5','异常原因5','处理记录5','司机账号5','司机姓名5','车辆名称5','车牌号码5'),(6,'2025-04-13 15:46:55','订单编号6','商品名称6','商品分类6','upload/yichangchuli_chulitupian6.jpg,upload/yichangchuli_chulitupian7.jpg,upload/yichangchuli_chulitupian8.jpg',6,'2025-04-13','用户账号6','用户姓名6','手机号码6','配送地址6','异常原因6','处理记录6','司机账号6','司机姓名6','车辆名称6','车牌号码6'),(7,'2025-04-13 15:46:55','订单编号7','商品名称7','商品分类7','upload/yichangchuli_chulitupian7.jpg,upload/yichangchuli_chulitupian8.jpg,upload/yichangchuli_chulitupian1.jpg',7,'2025-04-13','用户账号7','用户姓名7','手机号码7','配送地址7','异常原因7','处理记录7','司机账号7','司机姓名7','车辆名称7','车牌号码7'),(8,'2025-04-13 15:46:55','订单编号8','商品名称8','商品分类8','upload/yichangchuli_chulitupian8.jpg,upload/yichangchuli_chulitupian1.jpg,upload/yichangchuli_chulitupian2.jpg',8,'2025-04-13','用户账号8','用户姓名8','手机号码8','配送地址8','异常原因8','处理记录8','司机账号8','司机姓名8','车辆名称8','车牌号码8'),(9,'2025-04-13 16:08:32','1744560392825','物资商品','家电类','upload/1744560506676.png',50,'2025-04-14','11','涉及这','15874123698','华南','异常原因\n异常原因\n异常原因\n异常原因\n','处理记处理记处理记处理记','33','小一','华南运输车','55555');
/*!40000 ALTER TABLE `yichangchuli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1744560137441 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2025-04-13 15:46:55','用户账号1','用户姓名1','123456','13823888881','男',1,'upload/yonghu_touxiang1.jpg','地址1'),(12,'2025-04-13 15:46:55','用户账号2','用户姓名2','123456','13823888882','男',2,'upload/yonghu_touxiang2.jpg','地址2'),(13,'2025-04-13 15:46:55','用户账号3','用户姓名3','123456','13823888883','男',3,'upload/yonghu_touxiang3.jpg','地址3'),(14,'2025-04-13 15:46:55','用户账号4','用户姓名4','123456','13823888884','男',4,'upload/yonghu_touxiang4.jpg','地址4'),(15,'2025-04-13 15:46:55','用户账号5','用户姓名5','123456','13823888885','男',5,'upload/yonghu_touxiang5.jpg','地址5'),(16,'2025-04-13 15:46:55','用户账号6','用户姓名6','123456','13823888886','男',6,'upload/yonghu_touxiang6.jpg','地址6'),(17,'2025-04-13 15:46:55','用户账号7','用户姓名7','123456','13823888887','男',7,'upload/yonghu_touxiang7.jpg','地址7'),(18,'2025-04-13 15:46:55','用户账号8','用户姓名8','123456','13823888888','男',8,'upload/yonghu_touxiang8.jpg','地址8'),(1744560137440,'2025-04-13 16:02:17','11','涉及这','11','15874123698','女',25,'upload/1744560134224.jpg','华南');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunshugenzong`
--

DROP TABLE IF EXISTS `yunshugenzong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunshugenzong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `yunshutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '运输图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '运输数量',
  `jiankongshijian` date DEFAULT NULL COMMENT '监控时间',
  `jiankongzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '监控状态',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送地址',
  `jiankongxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '监控详情',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运输跟踪';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunshugenzong`
--

LOCK TABLES `yunshugenzong` WRITE;
/*!40000 ALTER TABLE `yunshugenzong` DISABLE KEYS */;
INSERT INTO `yunshugenzong` VALUES (1,'2025-04-13 15:46:55','订单编号1','商品名称1','商品分类1','upload/yunshugenzong_yunshutupian1.jpg,upload/yunshugenzong_yunshutupian2.jpg,upload/yunshugenzong_yunshutupian3.jpg',1,'2025-04-13','正常','用户账号1','用户姓名1','手机号码1','配送地址1','监控详情1','司机账号1','司机姓名1','车辆名称1','车牌号码1'),(2,'2025-04-13 15:46:55','订单编号2','商品名称2','商品分类2','upload/yunshugenzong_yunshutupian2.jpg,upload/yunshugenzong_yunshutupian3.jpg,upload/yunshugenzong_yunshutupian4.jpg',2,'2025-04-13','正常','用户账号2','用户姓名2','手机号码2','配送地址2','监控详情2','司机账号2','司机姓名2','车辆名称2','车牌号码2'),(3,'2025-04-13 15:46:55','订单编号3','商品名称3','商品分类3','upload/yunshugenzong_yunshutupian3.jpg,upload/yunshugenzong_yunshutupian4.jpg,upload/yunshugenzong_yunshutupian5.jpg',3,'2025-04-13','正常','用户账号3','用户姓名3','手机号码3','配送地址3','监控详情3','司机账号3','司机姓名3','车辆名称3','车牌号码3'),(4,'2025-04-13 15:46:55','订单编号4','商品名称4','商品分类4','upload/yunshugenzong_yunshutupian4.jpg,upload/yunshugenzong_yunshutupian5.jpg,upload/yunshugenzong_yunshutupian6.jpg',4,'2025-04-13','正常','用户账号4','用户姓名4','手机号码4','配送地址4','监控详情4','司机账号4','司机姓名4','车辆名称4','车牌号码4'),(5,'2025-04-13 15:46:55','订单编号5','商品名称5','商品分类5','upload/yunshugenzong_yunshutupian5.jpg,upload/yunshugenzong_yunshutupian6.jpg,upload/yunshugenzong_yunshutupian7.jpg',5,'2025-04-13','正常','用户账号5','用户姓名5','手机号码5','配送地址5','监控详情5','司机账号5','司机姓名5','车辆名称5','车牌号码5'),(6,'2025-04-13 15:46:55','订单编号6','商品名称6','商品分类6','upload/yunshugenzong_yunshutupian6.jpg,upload/yunshugenzong_yunshutupian7.jpg,upload/yunshugenzong_yunshutupian8.jpg',6,'2025-04-13','正常','用户账号6','用户姓名6','手机号码6','配送地址6','监控详情6','司机账号6','司机姓名6','车辆名称6','车牌号码6'),(7,'2025-04-13 15:46:55','订单编号7','商品名称7','商品分类7','upload/yunshugenzong_yunshutupian7.jpg,upload/yunshugenzong_yunshutupian8.jpg,upload/yunshugenzong_yunshutupian1.jpg',7,'2025-04-13','正常','用户账号7','用户姓名7','手机号码7','配送地址7','监控详情7','司机账号7','司机姓名7','车辆名称7','车牌号码7'),(8,'2025-04-13 15:46:55','订单编号8','商品名称8','商品分类8','upload/yunshugenzong_yunshutupian8.jpg,upload/yunshugenzong_yunshutupian1.jpg,upload/yunshugenzong_yunshutupian2.jpg',8,'2025-04-13','正常','用户账号8','用户姓名8','手机号码8','配送地址8','监控详情8','司机账号8','司机姓名8','车辆名称8','车牌号码8');
/*!40000 ALTER TABLE `yunshugenzong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunshujilu`
--

DROP TABLE IF EXISTS `yunshujilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunshujilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `yunshutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '运输图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '运输数量',
  `gengxinshijian` date DEFAULT NULL COMMENT '更新时间',
  `yunshuzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运输状态',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `qidian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '起点',
  `zhongdian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '终点',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送地址',
  `dingdanyaoqiu` longtext COLLATE utf8mb4_unicode_ci COMMENT '订单要求',
  `yunshuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '运输详情',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `cheliangmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆名称',
  `chepaihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运输记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunshujilu`
--

LOCK TABLES `yunshujilu` WRITE;
/*!40000 ALTER TABLE `yunshujilu` DISABLE KEYS */;
INSERT INTO `yunshujilu` VALUES (1,'2025-04-13 15:46:55','订单编号1','商品名称1','商品分类1','upload/yunshujilu_yunshutupian1.jpg,upload/yunshujilu_yunshutupian2.jpg,upload/yunshujilu_yunshutupian3.jpg',1,'2025-04-13','已完成','用户账号1','用户姓名1','手机号码1','起点1','终点1','配送地址1','订单要求1','运输详情1','司机账号1','司机姓名1','车辆名称1','车牌号码1'),(2,'2025-04-13 15:46:55','订单编号2','商品名称2','商品分类2','upload/yunshujilu_yunshutupian2.jpg,upload/yunshujilu_yunshutupian3.jpg,upload/yunshujilu_yunshutupian4.jpg',2,'2025-04-13','已完成','用户账号2','用户姓名2','手机号码2','起点2','终点2','配送地址2','订单要求2','运输详情2','司机账号2','司机姓名2','车辆名称2','车牌号码2'),(3,'2025-04-13 15:46:55','订单编号3','商品名称3','商品分类3','upload/yunshujilu_yunshutupian3.jpg,upload/yunshujilu_yunshutupian4.jpg,upload/yunshujilu_yunshutupian5.jpg',3,'2025-04-13','已完成','用户账号3','用户姓名3','手机号码3','起点3','终点3','配送地址3','订单要求3','运输详情3','司机账号3','司机姓名3','车辆名称3','车牌号码3'),(4,'2025-04-13 15:46:55','订单编号4','商品名称4','商品分类4','upload/yunshujilu_yunshutupian4.jpg,upload/yunshujilu_yunshutupian5.jpg,upload/yunshujilu_yunshutupian6.jpg',4,'2025-04-13','已完成','用户账号4','用户姓名4','手机号码4','起点4','终点4','配送地址4','订单要求4','运输详情4','司机账号4','司机姓名4','车辆名称4','车牌号码4'),(5,'2025-04-13 15:46:55','订单编号5','商品名称5','商品分类5','upload/yunshujilu_yunshutupian5.jpg,upload/yunshujilu_yunshutupian6.jpg,upload/yunshujilu_yunshutupian7.jpg',5,'2025-04-13','已完成','用户账号5','用户姓名5','手机号码5','起点5','终点5','配送地址5','订单要求5','运输详情5','司机账号5','司机姓名5','车辆名称5','车牌号码5'),(6,'2025-04-13 15:46:55','订单编号6','商品名称6','商品分类6','upload/yunshujilu_yunshutupian6.jpg,upload/yunshujilu_yunshutupian7.jpg,upload/yunshujilu_yunshutupian8.jpg',6,'2025-04-13','已完成','用户账号6','用户姓名6','手机号码6','起点6','终点6','配送地址6','订单要求6','运输详情6','司机账号6','司机姓名6','车辆名称6','车牌号码6'),(7,'2025-04-13 15:46:55','订单编号7','商品名称7','商品分类7','upload/yunshujilu_yunshutupian7.jpg,upload/yunshujilu_yunshutupian8.jpg,upload/yunshujilu_yunshutupian1.jpg',7,'2025-04-13','已完成','用户账号7','用户姓名7','手机号码7','起点7','终点7','配送地址7','订单要求7','运输详情7','司机账号7','司机姓名7','车辆名称7','车牌号码7'),(8,'2025-04-13 15:46:55','订单编号8','商品名称8','商品分类8','upload/yunshujilu_yunshutupian8.jpg,upload/yunshujilu_yunshutupian1.jpg,upload/yunshujilu_yunshutupian2.jpg',8,'2025-04-13','已完成','用户账号8','用户姓名8','手机号码8','起点8','终点8','配送地址8','订单要求8','运输详情8','司机账号8','司机姓名8','车辆名称8','车牌号码8'),(9,'2025-04-13 16:08:18','1744560392825','物资商品','家电类','upload/1744560478971.png',50,'2025-04-14','','11','涉及这','15874123698','115.783783;24.647786;江西省赣州市寻乌县丹溪乡139乡道','114.915863;26.854234;江西省吉安市泰和县澄江镇105国道','华南','订单要求\n订单要求\n订单要求\n订单要求\n','运输详情\n运输详情\n运输详情\n运输详情\n','33','小一','华南运输车','55555');
/*!40000 ALTER TABLE `yunshujilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunshurenwu`
--

DROP TABLE IF EXISTS `yunshurenwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunshurenwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `shangpinmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品分类',
  `shangpintupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '商品图片',
  `kucunshuliang` int(11) DEFAULT NULL COMMENT '运输数量',
  `fenpeishijian` date DEFAULT NULL COMMENT '分配时间',
  `yonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shoujihaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `dizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送地址',
  `dingdanyaoqiu` longtext COLLATE utf8mb4_unicode_ci COMMENT '订单要求',
  `fenpeixiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '分配详情',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `guihualuxian` longtext COLLATE utf8mb4_unicode_ci COMMENT '规划路线',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运输任务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunshurenwu`
--

LOCK TABLES `yunshurenwu` WRITE;
/*!40000 ALTER TABLE `yunshurenwu` DISABLE KEYS */;
INSERT INTO `yunshurenwu` VALUES (1,'2025-04-13 15:46:55','订单编号1','商品名称1','商品分类1','upload/yunshurenwu_shangpintupian1.jpg,upload/yunshurenwu_shangpintupian2.jpg,upload/yunshurenwu_shangpintupian3.jpg',1,'2025-04-13','用户账号1','用户姓名1','手机号码1','配送地址1','订单要求1','分配详情1','司机账号1','司机姓名1','规划路线1'),(2,'2025-04-13 15:46:55','订单编号2','商品名称2','商品分类2','upload/yunshurenwu_shangpintupian2.jpg,upload/yunshurenwu_shangpintupian3.jpg,upload/yunshurenwu_shangpintupian4.jpg',2,'2025-04-13','用户账号2','用户姓名2','手机号码2','配送地址2','订单要求2','分配详情2','司机账号2','司机姓名2','规划路线2'),(3,'2025-04-13 15:46:55','订单编号3','商品名称3','商品分类3','upload/yunshurenwu_shangpintupian3.jpg,upload/yunshurenwu_shangpintupian4.jpg,upload/yunshurenwu_shangpintupian5.jpg',3,'2025-04-13','用户账号3','用户姓名3','手机号码3','配送地址3','订单要求3','分配详情3','司机账号3','司机姓名3','规划路线3'),(4,'2025-04-13 15:46:55','订单编号4','商品名称4','商品分类4','upload/yunshurenwu_shangpintupian4.jpg,upload/yunshurenwu_shangpintupian5.jpg,upload/yunshurenwu_shangpintupian6.jpg',4,'2025-04-13','用户账号4','用户姓名4','手机号码4','配送地址4','订单要求4','分配详情4','司机账号4','司机姓名4','规划路线4'),(5,'2025-04-13 15:46:55','订单编号5','商品名称5','商品分类5','upload/yunshurenwu_shangpintupian5.jpg,upload/yunshurenwu_shangpintupian6.jpg,upload/yunshurenwu_shangpintupian7.jpg',5,'2025-04-13','用户账号5','用户姓名5','手机号码5','配送地址5','订单要求5','分配详情5','司机账号5','司机姓名5','规划路线5'),(6,'2025-04-13 15:46:55','订单编号6','商品名称6','商品分类6','upload/yunshurenwu_shangpintupian6.jpg,upload/yunshurenwu_shangpintupian7.jpg,upload/yunshurenwu_shangpintupian8.jpg',6,'2025-04-13','用户账号6','用户姓名6','手机号码6','配送地址6','订单要求6','分配详情6','司机账号6','司机姓名6','规划路线6'),(7,'2025-04-13 15:46:55','订单编号7','商品名称7','商品分类7','upload/yunshurenwu_shangpintupian7.jpg,upload/yunshurenwu_shangpintupian8.jpg,upload/yunshurenwu_shangpintupian1.jpg',7,'2025-04-13','用户账号7','用户姓名7','手机号码7','配送地址7','订单要求7','分配详情7','司机账号7','司机姓名7','规划路线7'),(8,'2025-04-13 15:46:55','订单编号8','商品名称8','商品分类8','upload/yunshurenwu_shangpintupian8.jpg,upload/yunshurenwu_shangpintupian1.jpg,upload/yunshurenwu_shangpintupian2.jpg',8,'2025-04-13','用户账号8','用户姓名8','手机号码8','配送地址8','订单要求8','分配详情8','司机账号8','司机姓名8','规划路线8'),(9,'2025-04-13 16:07:17','1744560392825','物资商品','家电类','upload/1744560237523.png',50,'2025-04-14','11','涉及这','15874123698','华南','订单要求\n订单要求\n订单要求\n订单要求\n','分配详情\n分配详情\n分配详情\n分配详情\n','33','小一','规划路线\n规划路线\n规划路线\n规划路线\n');
/*!40000 ALTER TABLE `yunshurenwu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-19 11:30:03
