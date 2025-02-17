CREATE DATABASE IF NOT EXISTS crossskill;
USE crossskill;

CREATE TABLE department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255)
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    department_id INT
);

INSERT INTO department (name, location) VALUES ('Human Resources', 'China'), ('Engineering', 'Japan');

INSERT INTO employee (name, email, department_id) VALUES ('John Doe', 'john.doe@example.com', 1), ('Jane Smith', 'jane.smith@example.com', 2);