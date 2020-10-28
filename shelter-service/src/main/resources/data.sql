DROP TABLE IF EXISTS shelters;

CREATE TABLE shelters (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  shelter_name VARCHAR (250) NOT NULL ,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) DEFAULT NULL,
  description VARCHAR (250) DEFAULT NULL,
  phone_number VARCHAR (250) DEFAULT NULL,
  email VARCHAR (250) NOT NULL,
  postal_code VARCHAR (250) NOT NULL,
  max_size INT NOT NULL,
  last_updated DATE NOT NULL

);

INSERT INTO shelters (shelter_name, first_name, last_name, address, description, email, postal_code, max_size, last_updated) VALUES
  ('Shelter1','Aliko', 'Dangote', 'Prater street', 'You can adopt dogs and cats','smth@gmail.com','1083', 50, CURRENT_DATE),
  ('Shelter1','Bill', 'Gates', 'Kocsis street', 'You can adopt dogs and cats', 'smth2@gmail.com','1085', 20, CURRENT_DATE),
  ('Shelter1','Folrunsho', 'Alakija', 'Halley street', 'You can adopt dogs and cats','smth3@gmail.com','1086', 30, CURRENT_DATE);