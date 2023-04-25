--user 
CREATE TABLE user (
user_code int NOT NULL PRIMARY KEY,
user_password VARCHAR(20) NOT NULL,
user_type VARCHAR(3) NOT NULL,
user_name VARCHAR(10) NOT NULL,
gender VARCHAR(1) NOT NULL,
phone VARCHAR(13) NOT NULL,
address VARCHAR(20),
address_code VARCHAR(10),
birth_date VARCHAR(10),
account VARCHAR(20),
bank_office VARCHAR(10),
bank_name VARCHAR(10),
email VARCHAR(40) NOT NULL,
admission_date VARCHAR(10),
admission_type VARCHAR(10),
dep_name VARCHAR(10),
main_major VARCHAR(10)
sub_major VARCHAR(10),
graduate VARCHAR(10),
degree VARCHAR(10),
semester VARCHAR(10)
); 

-- lecture
CREATE TABLE lecture (
class_code VARCHAR(8) NOT NULL PRIMARY KEY,
user_code int NOT NULL,
major VARCHAR(20) NOT NULL,
department VARCHAR(20) NOT NULL,
class_name VARCHAR(20) NOT NULL,
classification VARCHAR(20) NOT NULL,
credit int NOT NULL,
classroom VARCHAR(20),
information VARCHAR(5000),
FOREIGN KEY (user_code) REFERENCES user(user_code),
);

-- lecture(view)
create view lecture_info as
SELECT
class_code,
major,
class_name,
(SELECT user_name FROM user WHERE l.user_code=user_code)as professor_name,
information
FROM lecture l;

-- department 
CREATE TABLE department (
dep_name VARCHAR(10) NOT NULL,
dep_code int NOT NULL UNIQUE,
PRIMARY KEY(dep_name, dep_code)
);

-- major
CREATE TABLE  major (
major_name VARCHAR(10) NOT NULL UNIQUE,
dep_code int NOT NULL,
major_code int NOT NULL,
PRIMARY KEY (dep_code, major_code),
FOREIGN KEY (dep_code) REFERENCES department(dep_code)
);

-- sc data
CREATE TABLE sc_data (
user_code int NOT NULL,
class_code VARCHAR(8) NOT NULL,
FOREIGN KEY (user_code) REFERENCES user(user_code),
FOREIGN KEY (class_code) REFERENCES lecture(class_code)
);

-- sc data(view)
CREATE VIEW scdata_view AS
SELECT 
user_code,
(SELECT user_name FROM user WHERE user_code=sc.user_code) AS user_name,
(SELECT main_major FROM user WHERE user_code = sc.user_code) AS major,
class_code,
(SELECT department FROM lecture WHERE class_code = sc.class_code) AS department,
(SELECT class_name FROM lecture WHERE class_code = sc.class_code) AS class_name,
(SELECT classification FROM lecture WHERE class_code = sc.class_code) AS classification,
grade
FROM sc_data sc;

-- board
CREATE TABLE board (
write_code int NOT NULL,
user_code int NOT NULL,
category VARCHAR(10) NOT NULL,
title VARCHAR(100) NOT NULL,
contants VARCHAR(5000) NOT NULL,
registered_date TIMESTAMP,
modified_date TIMESTAMP,
PRIMARY KEY(write_code, user_code),
FOREIGN KEY (user_code) REFERENCES user(user_code)
);

-- evalution
CREATE TABLE evalution (
class_code VARCHAR(8) NOT NULL,
user_code int NOT NULL,
grade VARCHAR(1) NOT NULL,
FOREIGN KEY (class_code) REFERENCES lecture(class_code),
FOREIGN KEY (user_code) REFERENCES user(user_code)
);

-- signup_class
CREATE TABLE signup_class (
user_code int NOT NULL,
class_code VARCHAR(8) NOT NULL,
FOREIGN KEY (user_code) REFERENCES user(user_code),
FOREIGN KEY (class_code) REFERENCES lecture(class_code)
);