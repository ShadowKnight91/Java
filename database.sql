CREATE TABLE User (
    User_id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    Role VARCHAR(50)
);

CREATE TABLE City (
    City_id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    State VARCHAR(255)
);

CREATE TABLE Restaurant (
    Restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
    City_id INT,
    Name VARCHAR(255),
    Address VARCHAR(255),
    FOREIGN KEY (City_id) REFERENCES City(City_id)
);

CREATE TABLE Theatre (
    Theatre_id INT PRIMARY KEY AUTO_INCREMENT,
    City_id INT,
    Name VARCHAR(255),
    Address VARCHAR(255),
    FOREIGN KEY (City_id) REFERENCES City(City_id)
);

CREATE TABLE Hotel (
    Hotel_id INT PRIMARY KEY AUTO_INCREMENT,
    City_id INT,
    Name VARCHAR(255),
    Address VARCHAR(255),
    FOREIGN KEY (City_id) REFERENCES City(City_id)
);

CREATE TABLE Landmark (
    Landmark_id INT PRIMARY KEY AUTO_INCREMENT,
    City_id INT,
    Name VARCHAR(255),
    Address VARCHAR(255),
    FOREIGN KEY (City_id) REFERENCES City(City_id)
);

CREATE TABLE Transportation_Mode (
    Transportation_Mode_id INT PRIMARY KEY AUTO_INCREMENT,
    Mode VARCHAR(50),
    Cost_Level VARCHAR(50)
);

CREATE TABLE User_City (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT,
    City_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (City_id) REFERENCES City(City_id)
);

CREATE TABLE User_Restaurant (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT,
    Restaurant_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (Restaurant_id) REFERENCES Restaurant(Restaurant_id)
);

CREATE TABLE User_Hotel (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT ,
    Hotel_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (Hotel_id) REFERENCES Hotel(Hotel_id)
);

CREATE TABLE User_Theatre (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT ,
    Theatre_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (Theatre_id) REFERENCES Theatre(Theatre_id)
);

CREATE TABLE User_Landmark (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT,
    Landmark_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (Landmark_id) REFERENCES Landmark(Landmark_id)
);

CREATE TABLE User_Transportation (
    Id INT PRIMARY KEY AUTO_INCREMENT,
	User_id INT,
    Transportation_id INT,
    FOREIGN KEY (User_id) REFERENCES User(User_id),
    FOREIGN KEY (Transportation_id) REFERENCES Transportation_Mode(Transportation_Mode_id)
);

-- Users
INSERT INTO User (Name, Email, Password, Role) VALUES
('John Doe', 'jd@gmail.com', 'password123', 'Admin'),
('Jane Smith', 'js@gmail.com', 'abc123', 'User'),
('Alice Johnson', 'aj@gmail.com', 'securepwd', 'User');

-- Cities
INSERT INTO City (Name, State) VALUES
('New York City', 'New York'),
('Los Angeles', 'California'),
('Chicago', 'Illinois');

-- Restaurants
INSERT INTO Restaurant (City_id, Name, Address) VALUES
(1, 'The Great Pizza', 'New York'),
(2, 'Taco Haven', 'California'),
(3, 'Deep Dish Delight', 'Illinois'),
(1, 'McDonalds', 'New York');

-- Theatres
INSERT INTO Theatre (City_id, Name, Address) VALUES
(1, 'Broadway Theater', 'New York'),
(2, 'Hollywood Cinema', 'California'),
(3, 'Windy City Playhouse', 'Illinois');

-- Shopping Marts
INSERT INTO Hotel (City_id, Name, Address) VALUES
(1, 'Hotel1', 'New York'),
(2, 'Hotel2', 'California'),
(3, 'Hotel3', 'Illinois');

-- Tourist Places
INSERT INTO Landmark (City_id, Name, Address) VALUES
(1, 'Statue of Liberty', 'New York'),
(2, 'Hollywood Walk of Fame', 'California'),
(3, 'Millennium Park', 'Illinois');

-- Transportation Modes
INSERT INTO Transportation_Mode (Mode, Cost_Level) VALUES
('Bus', 'Low'),
('Subway', 'Low'),
('Taxi', 'Medium');
