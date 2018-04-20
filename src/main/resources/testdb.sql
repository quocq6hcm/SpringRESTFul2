DROP DATABASE IF EXISTS testdb;
CREATE DATABASE testdb;
USE testdb;
CREATE TABLE category (
  id   VARCHAR(50) PRIMARY KEY,
  NAME VARCHAR(100)
);

CREATE TABLE book (
  id          VARCHAR(50) PRIMARY KEY,
  name        VARCHAR(100),
  category_id VARCHAR(50),
  FOREIGN KEY (category_id) REFERENCES category (id)
);


INSERT INTO category VALUES ('ahihi', 'java');
INSERT INTO category VALUES ('ahihi1', 'C#');
INSERT INTO category VALUES ('ahihi2', 'Python');
