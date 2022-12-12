USE CRUISE_TRIPS;
DROP TABLE IF EXISTS ports_excursions;
DROP TABLE IF EXISTS ships_ports;
DROP TABLE IF EXISTS excursions;
DROP TABLE IF EXISTS ports;
DROP TABLE IF EXISTS itineraries;
DROP TABLE IF EXISTS ships;

CREATE TABLE ships (
ship_id INT AUTO_INCREMENT NOT NULL,
ship_name VARCHAR(45) NOT NULL,
ship_size INT NOT NULL,
guest_rating DECIMAL(2,1),
PRIMARY KEY (ship_id) 
);

CREATE TABLE itineraries (
itinerary_id INT AUTO_INCREMENT NOT NULL, 
ship_id INT NOT NULL,
num_days INT NOT NULL,
num_ports INT NOT NULL,
PRIMARY KEY (itinerary_id),
FOREIGN KEY (ship_id) REFERENCES ships (ship_id) ON DELETE CASCADE
);

CREATE TABLE ports (
port_id INT AUTO_INCREMENT NOT NULL,
port_abbr VARCHAR(3) NOT NULL, 
port_location VARCHAR(128) NOT NULL,
PRIMARY KEY (port_id)
);

CREATE TABLE excursions (
excursion_id INT AUTO_INCREMENT NOT NULL,
port_id INT NOT NULL,
excursion_name VARCHAR(45) NOT NULL,
exertion_level VARCHAR(10) NOT NULL,
adult_price DECIMAL(6,2) NOT NULL,
child_price DECIMAL(6,2),
PRIMARY KEY (excursion_id),
FOREIGN KEY (port_id) REFERENCES ports (port_id) ON DELETE CASCADE
);

CREATE TABLE ships_ports (
ship_id INT, 
port_id INT,
FOREIGN KEY (ship_id) REFERENCES ships (ship_id) ON DELETE CASCADE,
FOREIGN KEY (port_id) REFERENCES ports (port_id) ON DELETE CASCADE,
UNIQUE KEY (ship_id, port_id)
);

CREATE TABLE ports_excursions (
port_id INT NOT NULL,
excursion_id INT,
FOREIGN KEY (port_id) REFERENCES ports (port_id) ON DELETE CASCADE,
FOREIGN KEY (excursion_id) REFERENCES excursions (excursion_id) ON DELETE CASCADE,
UNIQUE KEY (port_id, excursion_id)
);
