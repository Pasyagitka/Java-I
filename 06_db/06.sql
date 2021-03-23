USE master;
CREATE database Java_Souvenirs
ON PRIMARY
	(name = N'Java_Souvenirs_mdf', filename = N'E:\4 семестр\Java I\06_db\Java_Souvenirs.mdf', 
	size = 5MB, maxsize=10MB, filegrowth=1MB)
LOG ON 
	(name = N'Java_Souvenirs_log', filename = N'E:\4 семестр\Java I\06_db\Java_Souvenirs.ldf',       
	size=5MB,  maxsize=UNLIMITED, filegrowth=1MB)