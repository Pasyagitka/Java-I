USE Java_Souvenirs;


CREATE TABLE Producers(
	ProducerID nvarchar(50) PRIMARY KEY,
	Name nvarchar(50) NULL,
	Country nvarchar(50) NULL 
)

CREATE TABLE Souvenirs(
	Name nvarchar(50) PRIMARY KEY,
	ProducerID nvarchar(50) NULL FOREIGN KEY REFERENCES Producers(ProducerID),
	Date date  NULL,
	Price int  NULL 
)

INSERT INTO Producers (ProducerID, Name, Country) 
	VALUES	 ('1124', 'KORADO', 'Czech Republic'),
			 ('1434', 'Licon', 'Russia'),
			 ('4366', 'RBM', 'Russia'),
			 ('3255', 'LeBrama', 'Belarus'),
			 ('1464', 'TPR', 'Belarus');

SELECT * FROM Producers;

INSERT INTO Souvenirs(Name, ProducerID, Date, Price)
	VALUES ('Pen black', '1464', '2018-01-01', 14),
	 ('Pen white', '1464', '2017-06-22', 12),
	 ('Pencil', '1124', '2019-03-21', 4),
	 ('Magnet Minsk', '3255', '2020-10-12', 12),
	 ('Postcard Moscow', '1434', '2021-11-26', 45), 
	 ('Magnet green', '1124', '2015-08-30', 8),
	 ('Postcard', '1464', '2018-09-06', 31),
	 ('Postcard Grodno', '3255', '2017-03-11', 17),
	 ('Magnet', '1124', '2016-06-05', 9),
	 ('Pen', '1434', '2021-09-01', 15),
	 ('Pencil two-in-one', '1464', '2020-05-03', 18),
	 ('Postcard Brest', '3255', '2019-04-07', 21),
	 ('Pencil yellow', '1124', '2018-12-08', 20)

SELECT * FROM Souvenirs;

SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country 
FROM Souvenirs inner join Producers P on P.ProducerID = Souvenirs.ProducerID
                            WHERE P.Name='KORADO'