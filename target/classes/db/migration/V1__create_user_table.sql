CREATE  TABLE m_user (

  id BIGINT NOT NULL AUTO_INCREMENT ,
  login_id VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NULL ,
  email VARCHAR(100) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  is_logged_in BIT NOT NULL DEFAULT 0 ,
  last_login_ip VARCHAR(15) NULL ,
  PRIMARY KEY (id) );