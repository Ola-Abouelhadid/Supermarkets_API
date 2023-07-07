CREATE DATABASE  IF NOT EXISTS `SupermarketDB`;
USE `SupermarketDB`;

--
-- Table structure for table `supermarket`
--

DROP TABLE IF EXISTS `supermarket`;

CREATE TABLE `supermarket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `arabic_name` varchar(50) DEFAULT NULL,
  `english_name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `active` boolean DEFAULT true,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Data for table `supermarket`
--

INSERT INTO `supermarket` VALUES 
	(1,'أولاد سعود','Awlad Soud','6th district, Zahraa El Maadi, Cairo, Egypt',null,true),
	(2,'المهر','El Mohr','6th district, Zahraa El Maadi, Cairo, Egypt',null,true);

