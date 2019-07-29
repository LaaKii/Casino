create schema casino;

CREATE TABLE casino.user (
  idUser INT NOT NULL AUTO_INCREMENT,
  firstname varchar(255),
  lastname varchar(255),
  email varchar(255),
  username varchar(255),
  password varchar(255),
  PRIMARY KEY (idUser)
  );
  
 CREATE TABLE casino.konto (
  idKonto INT NOT NULL AUTO_INCREMENT,
  idUser int,
  money int,
  PRIMARY KEY (idKonto),
  FOREIGN KEY (idUser) REFERENCES casino.user(idUser)
);

CREATE TABLE casino.games(
  idGame INT NOT NULL AUTO_INCREMENT,
  gameName varchar(255),
  PRIMARY KEY (idGame)
);
 
CREATE TABLE casino.transactions(
  idTransaction INT NOT NULL AUTO_INCREMENT,
  idGame INT,
  idKonto INT,
  transactionAmount INT,
  PRIMARY KEY (idTransaction),
  FOREIGN KEY (idKonto) REFERENCES casino.konto(idKonto)
);

CREATE TABLE casino.userLogin(
  idUserLogin INT NOT NULL AUTO_INCREMENT,
  idUser int,
  loginDate date,
  PRIMARY KEY (idUserLogin),
  FOREIGN KEY (idUser) REFERENCES casino.user(idUser)
);

ALTER TABLE casino.transactions ADD CONSTRAINT idGameFK FOREIGN KEY (idGame) REFERENCES casino.games(idGame);
use casino;
insert into games (gameName) values ('roulette');
insert into games (gameName) values ('DAILY LOGIN');
