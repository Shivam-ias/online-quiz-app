CREATE DATABASE quizdb;

USE quizdb;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT,
    option_a TEXT,
    option_b TEXT,
    option_c TEXT,
    option_d TEXT,
    correct_answer VARCHAR(1)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO questions (question, option_a, option_b, option_c, option_d, correct_answer)
VALUES 
("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "C"),
("Who developed the theory of relativity?", "Newton", "Einstein", "Tesla", "Darwin", "B"),
("What is the largest planet in our solar system?", "Earth", "Mars", "Jupiter", "Saturn", "C");
