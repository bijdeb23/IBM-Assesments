/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.40-MariaDB : Database - swissbankdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`swissbankdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `swissbankdb`;

/*Table structure for table `transactiondetails` */

DROP TABLE IF EXISTS `transactiondetails`;

CREATE TABLE `transactiondetails` (
  `userId` int(10) NOT NULL,
  `transactionTime` timestamp NULL DEFAULT NULL,
  `transactionType` varchar(30) DEFAULT NULL,
  `withdrawlAmount` int(10) DEFAULT NULL,
  `depositAmount` int(10) DEFAULT NULL,
  `balance` int(10) DEFAULT NULL,
  `accountNo` varchar(15) NOT NULL,
  `transactionSequence` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`transactionSequence`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `transactiondetails` */

insert  into `transactiondetails`(`userId`,`transactionTime`,`transactionType`,`withdrawlAmount`,`depositAmount`,`balance`,`accountNo`,`transactionSequence`) values 
(10001,'2019-05-24 12:30:38','Deposit by Static',NULL,1000,1000,'156000045674',1),
(10002,'2019-05-24 12:31:01','Deposit by Static',NULL,1000,1000,'156000045675',2),
(10001,'2019-05-25 00:11:00','Deposit by OWN',NULL,500,1500,'156000045674',3),
(10001,'2019-05-25 00:28:11','Withdraw by OWN',500,NULL,1000,'156000045674',4),
(10002,'2019-05-25 00:31:45','Withdraw by Fund Transfer',100,NULL,900,'156000045675',5),
(10001,'2019-05-25 00:31:45','Deposit by Fund Transfer',NULL,100,1100,'156000045674',6),
(10002,'2019-05-25 00:43:24','Deposit by OWN',NULL,100,1000,'156000045675',7);

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `userId` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phoneNo` varchar(15) DEFAULT NULL,
  `accountNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

insert  into `userdetails`(`userId`,`userName`,`password`,`phoneNo`,`accountNo`) values 
(10001,'bijoy','12345','8272927414','156000045674'),
(10002,'shadow','12345','7890754681','156000045675');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
