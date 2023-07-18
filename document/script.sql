CREATE DATABASE bookstoredb;

CREATE TABLE users(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(30) NOT NULL,
	email varchar(50) NOT NULL,
	secret varchar(16) NOT NULL,
	dateInclusion datetime NOT NULL,
	UNIQUE KEY user_id (id)
)DEFAULT CHARSET=utf8mb4;

CREATE TABLE category (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(30) NOT NULL,
	dateInclusion datetime NOT NULL,
	UNIQUE KEY category_id (id)
)DEFAULT CHARSET=utf8mb4;

CREATE TABLE book (
 id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 title varchar(130) NOT NULL,
 author varchar(64) NOT NULL,
 description mediumtext NOT NULL,
 isbn varchar(15) NOT NULL,
 image blob NOT NULL,
 price float NOT NULL,
 publishDate date NOT NULL,
 lastUpdate datetime NOT NULL,
 categoryId int NOT NULL,
 dateInclusion datetime NOT NULL,
 UNIQUE KEY book_id (id),
 UNIQUE KEY book_title (title),
 KEY category_fk (categoryId),
 CONSTRAINT category_fk FOREIGN KEY (categoryId) REFERENCES  category (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(64) NOT NULL,
  fullname varchar(30) NOT NULL,
  address varchar(128) NOT NULL,
  city varchar(32) NOT NULL,
  country varchar(64) NOT NULL,
  phone varchar(15) NOT NULL,
  zipcode varchar(24) NOT NULL,
  secret varchar(16) NOT NULL,
  registerDate datetime NOT NULL,
  dateInclusion datetime NOT NULL,
  UNIQUE KEY customer_id (id),
  UNIQUE KEY customer_email (email)
)  DEFAULT CHARSET=utf8mb4;

CREATE TABLE review (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	book_id int  NOT NULL,
	customer_id int NOT NULL,
	RATING int NOT NULL,
	headline varchar(130) NOT NULL,
	comment varchar(128) NOT NULL,
	reviewTime datetime NOT NULL,
	dateInclusion datetime NOT NULL,
	UNIQUE KEY review_id (id),
	KEY book_fk_idx (book_id),
  	KEY customer_fk_idx (customer_id),
  	CONSTRAINT book_fk FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT customer_fk FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) DEFAULT CHARSET=utf8mb4;

CREATE TABLE book_order(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_id int  NOT NULL,
	orderDate datetime NOT NULL,
	shippingAdress varchar(256) NOT NULL,
	recipientName varchar(30) NOT NULL,
	recipientePhone varchar(15) NOT NULL,
	paymentMethod varchar(15) NOT NULL,
	status varchar(15) NOT NULL,
	total float NOT NULL,
	dateInclusion datetime NOT NULL,
	UNIQUE KEY order_id (id),
	KEY order_customer_id(customer_id),
	CONSTRAINT order_customer_fk FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)DEFAULT CHARSET=utf8mb4;

CREATE TABLE order_detail (
  order_id int DEFAULT NULL,
  book_id int DEFAULT NULL,
  quantity int NOT NULL,
  dateInclusion datetime NOT NULL,
  subtotal float NOT NULL,
  KEY detail_order_fk (order_id),
  KEY detail_book_fk (book_id),
  CONSTRAINT detail_book_fk FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT detail_order_fk FOREIGN KEY (order_id) REFERENCES book_order (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) CHARSET=utf8mb4;