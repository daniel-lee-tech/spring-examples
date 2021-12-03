CREATE DATABASE IF NOT EXISTS database_example ;
USE database_example;
CREATE TABLE IF NOT EXISTS users(
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    name varchar(30),
                                    email varchar(30)
);

INSERT INTO users VALUES(null, "dani@dani.com","hello");
