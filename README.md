# 🧠 Online Quiz Application
A Java-based console application for conducting multiple-choice quizzes. The app connects to a MySQL database to store and retrieve questions, and allows user login and scoring.

## 🚀 Features
- ✅ User login system (credentials stored in database)
- ❓ Add and manage quiz questions in MySQL
- 🎯 Auto-score calculation at the end of the quiz
- 💾 Java + JDBC for database operations
- 🧾 SQL file included to create and populate tables

## 🛠️ Technologies Used
- Java (Core)
- JDBC (Java Database Connectivity)
- MySQL
- Git & GitHub

## 🧩 Project Structure



## 🧪 How to Run
1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/online-quiz-app.git


 CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question TEXT,
  option_a TEXT,
  option_b TEXT,
  option_c TEXT,
  option_d TEXT,
  correct_answer VARCHAR(1)
);


