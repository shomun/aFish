
DROP TABLE IF EXISTS `m_category_based_type`;
CREATE TABLE `m_category_based_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `name_resource_key` VARCHAR(200) NOT NULL,
  `desc_resource_key` VARCHAR(200) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modifier_id` bigint(20) DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;










