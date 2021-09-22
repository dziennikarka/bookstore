DROP TABLE Book;

CREATE TABLE book (
  isbn        VARCHAR(255) PRIMARY KEY,
  author      VARCHAR(255) NOT NULL,
  title       VARCHAR(255) NOT NULL,
  year        INTEGER NOT NULL,
  price       FLOAT NOT NULL);