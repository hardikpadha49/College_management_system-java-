create database if not exists sms_db;
use sms_db;
create table users(id int primary key auto_increment,username varchar(50) unique not null,password varchar(100) not null,role enum('ADMIN','TEACHER','STUDENT','PARENT') not null);
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE,
    roll_no VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    class_name VARCHAR(50) NOT NULL,
    
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
CREATE TABLE teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE,
    name VARCHAR(100) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
CREATE TABLE parent (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    student_id INT NOT NULL,
    
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
        
    FOREIGN KEY (student_id) REFERENCES student(id)
        ON DELETE CASCADE
);
CREATE TABLE marks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject VARCHAR(100) NOT NULL,
    marks INT NOT NULL CHECK (marks BETWEEN 0 AND 100),
    
    FOREIGN KEY (student_id) REFERENCES student(id)
        ON DELETE CASCADE
);