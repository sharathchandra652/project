/*
SQLyog Community v8.71 
MySQL - 5.5.30 : Database - cache
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cache` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cache`;

/*Table structure for table `interest` */

DROP TABLE IF EXISTS `interest`;

CREATE TABLE `interest` (
  `fid` int(10) NOT NULL AUTO_INCREMENT,
  `pcid` int(10) DEFAULT NULL,
  `ipaddress` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `packets` varchar(255) DEFAULT NULL,
  `npackets` int(10) DEFAULT NULL,
  `router` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `status1` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `pcid` (`pcid`),
  CONSTRAINT `interest_ibfk_1` FOREIGN KEY (`pcid`) REFERENCES `userdetails` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interest` */

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `ipaddress` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
