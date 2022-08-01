

CREATE TABLE link_news (
                                                  id INT NOT NULL AUTO_INCREMENT,
                                                  linkRSS VARCHAR(45) NULL DEFAULT NULL,
                                                  PRIMARY KEY (id))
;

CREATE TABLE  news (
                                             id INT NOT NULL AUTO_INCREMENT,
                                             title TINYTEXT NULL DEFAULT NULL,
                                             link MEDIUMTEXT NULL DEFAULT NULL,
                                             pubDate MEDIUMTEXT NULL DEFAULT NULL,
                                             creator MEDIUMTEXT NULL DEFAULT NULL,
                                             category MEDIUMTEXT NULL DEFAULT NULL,
                                             guid MEDIUMTEXT NULL DEFAULT NULL,
                                             description MEDIUMTEXT NULL DEFAULT NULL,
                                             PRIMARY KEY (id))
;

CREATE TABLE roles (
                                              id INT NOT NULL AUTO_INCREMENT,
                                              name VARCHAR(45) NULL DEFAULT NULL,
                                              PRIMARY KEY (id))
 ;

CREATE TABLE subscriptions (
                                                      id INT NOT NULL,
                                                      TitleOfSub MEDIUMTEXT NULL DEFAULT NULL,
                                                      Cost INT NULL DEFAULT NULL,
                                                      Status TINYINT NULL DEFAULT NULL,
                                                      Term DATE NULL DEFAULT NULL,
                                                      PRIMARY KEY (id))
;

CREATE TABLE user (
                                             id INT NOT NULL AUTO_INCREMENT,
                                             userName VARCHAR(45) NULL DEFAULT NULL,
                                             secondName VARCHAR(45) NULL DEFAULT NULL,
                                             phoneNumber VARCHAR(45) NULL DEFAULT NULL,
                                             password VARCHAR(200) NULL DEFAULT NULL,
                                             email VARCHAR(45) NULL DEFAULT NULL,
                                             PRIMARY KEY (id));

CREATE TABLE user_roles (
                                                   id INT NOT NULL AUTO_INCREMENT,
                                                   userId INT NULL DEFAULT NULL,
                                                   roleId INT NULL DEFAULT NULL,
                                                   PRIMARY KEY (id))

;