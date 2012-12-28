--
-- Table structure for table `m_users`
--

DROP TABLE IF EXISTS `m_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `subscription_id` int(11) DEFAULT NULL,
  `subscription_expriry_date` datetime DEFAULT NULL,
  `date_of_registration` datetime DEFAULT NULL,
  `is_logged_in` bit(1) DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  `last_logout_time` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `login_id` varchar(100) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `m_user_address_mapping`
--

DROP TABLE IF EXISTS `m_user_address_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_user_address_mapping` (
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address_id_UNIQUE` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_subscription`
--

DROP TABLE IF EXISTS `m_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_subscription` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `subscription_type` tinyint(4) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `m_shop_category_mapping`
--

DROP TABLE IF EXISTS `m_shop_category_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_shop_category_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `category_id` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `m_shop_address_mapping`
--

DROP TABLE IF EXISTS `m_shop_address_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_shop_address_mapping` (
  `shop_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address_id_UNIQUE` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_shop`
--

DROP TABLE IF EXISTS `m_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL ,
  `subscription_id` int(11) NOT NULL,
  `subscription_expiry_date` datetime DEFAULT NULL,
  `logo_img` varchar(200) DEFAULT NULL,
  `is_activated` bit(1) NOT NULL DEFAULT b'0',
  `admin_user_id` int(11) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `m_product_category_mapping`
--

DROP TABLE IF EXISTS `m_product_category_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_product_category_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(200) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_product`
--

DROP TABLE IF EXISTS `m_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `craetor_id` bigint(20) DEFAULT NULL,
  `creattion_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modifier_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `m_category`
--

DROP TABLE IF EXISTS `m_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_category` (
  `id` varchar(200) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `parent_id` varchar(200) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creator_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `m_address`
--

DROP TABLE IF EXISTS `m_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_address` (
  `id` bigint(20) NOT NULL ,
  `postal_code` varchar(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `suburb` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;









