CREATE TABLE user 
(ID BIGINT NOT NULL, 
id_user BIGINT,
login VARCHAR(255), 
password VARCHAR(255), 
firstName VARCHAR(255),
lastName VARCHAR(255),
active BOOLEAN,
registration BOOLEAN, 
PRIMARY KEY (ID));

CREATE TABLE role
(ID BIGINT NOT NULL,
id_role BIGINT,
name VARCHAR(255), 
PRIMARY KEY (ID));

CREATE TABLE user_authorities
(ID BIGINT NOT NULL,
id_user BIGINT,
id_role BIGINT,
PRIMARY KEY (ID));