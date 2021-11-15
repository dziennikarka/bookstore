--DROP TABLE User;
--DROP TABLE Book;
--DROP TABLE Category;

CREATE TABLE Category (
  category_id          BIGINT PRIMARY KEY,
  name        VARCHAR(255) NOT NULL
 );

CREATE TABLE Book (
  isbn        VARCHAR(255) PRIMARY KEY,
  author      VARCHAR(255) NOT NULL,
  title       VARCHAR(255) NOT NULL,
  year        INTEGER NOT NULL,
  price       FLOAT NOT NULL,
  category_id  BIGINT NOT NULL REFERENCES Category(category_id) );

CREATE TABLE User(
 id    BIGINT PRIMARY KEY,
 username  VARCHAR(255) NOT NULL,
 password   VARCHAR(255) NOT NULL,
 email      VARCHAR(255) NOT NULL,
 role       VARCHAR(255) NOT NULL
);


--DROP SEQUENCE HIBERNATE_SEQUENCE;
CREATE SEQUENCE HIBERNATE_SEQUENCE;