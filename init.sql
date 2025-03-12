CREATE DATABASE payment_db;

CREATE USER 'appuser'@'%' IDENTIFIED BY 'apppassword';
GRANT ALL PRIVILEGES ON payment_db.* TO 'appuser'@'%';
FLUSH PRIVILEGES;

USE payment_db;

CREATE TABLE user_balance (
    user_id VARCHAR(50) PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL
);

INSERT INTO user_balance (user_id, balance) VALUES ('user1', 100.00);
INSERT INTO user_balance (user_id, balance) VALUES ('user2', 200.00);
INSERT INTO user_balance (user_id, balance) VALUES ('user3', 300.00);