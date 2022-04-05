CREATE TABLE BOOK_INFO (
    oid varchar(8) NOT NULL PRIMARY KEY,
    ISBN varchar(20),
    AUTHOR varchar (30),
    BOOK_NAME varchar(50),
    PRICE int,
    PUBLISHDATE varchar(10),
    PUBLISHER varchar(30),
    TRANSLATOR varchar(30)
);