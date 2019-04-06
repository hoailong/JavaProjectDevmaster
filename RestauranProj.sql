CREATE DATABASE RestaurantProj
GO 

USE RestaurantProj
GO

CREATE TABLE tblUser(
	UserId INT IDENTITY(1,1) NOT NULL,
	UserName VARCHAR(50) NOT NULL,
	Password VARCHAR(50) NOT NULL,
	FullName NVARCHAR(255) DEFAULT N'Vô Danh',
	GroupId INT NULL,
	Gender BIT NULL,
	Phone CHAR(50) NULL,
	Email VARCHAR(50) NULL,
	Address NVARCHAR(500) NULL,
	CONSTRAINT PK_User PRIMARY KEY(UserName)
)
GO

CREATE TABLE tblUserGroup(
	GroupId INT IDENTITY(1,1) NOT NULL ,
	GroupCode VARCHAR(50) NULL,
	GroupName NVARCHAR(50) NULL,
	CONSTRAINT PK_UserGroup PRIMARY KEY(GroupId)
)
GO

CREATE TABLE tblTable(
	TableId INT IDENTITY(1,1) NOT NULL,
	TableName NVARCHAR(50) NULL,
	Maxpeople INT NULL,
	Status BIT NULL
	CONSTRAINT PK_Table PRIMARY KEY(TableId)
)
GO

CREATE TABLE tblTime(
	TimeId INT IDENTITY(1,1) NOT NULL,
	TimeName VARCHAR(50) NULL,
	CONSTRAINT PK_Time PRIMARY KEY(TimeId)
)
GO

CREATE TABLE tblFood(
	FoodId INT IDENTITY(1,1) NOT NULL,
	FoodName NVARCHAR(200) NULL,
	FoodImage VARCHAR(100) NULL,
	FoodCost INT NULL,
	GroupId INT NULL,
	CONSTRAINT PK_Food PRIMARY KEY(FoodId)
)
GO

CREATE TABLE tblFoodGroup(
	GroupId INT IDENTITY(1,1) NOT NULL,
	GroupCode VARCHAR(100) NULL,
	GroupName NVARCHAR(100) NULL
	CONSTRAINT PK_FoodGroup PRIMARY KEY(GroupId)
)
GO

CREATE TABLE tblDrink(
	DrinkId INT IDENTITY(1,1) NOT NULL,
	DrinkName NVARCHAR(200) NULL,
	DrinkImage VARCHAR(100) NULL,
	DrinkCost INT NULL,
	GroupId INT NULL,
	CONSTRAINT PK_Drink PRIMARY KEY(DrinkId)
)
GO

CREATE TABLE tblOrders(
	OrderId int IDENTITY(1,1) NOT NULL,
	CustomerId int NOT NULL,
	DateOrder VARCHAR(15) NULL,
	TimeId int NULL,
	NumberPeople int NULL,
	Request NTEXT NULL,
	CONSTRAINT PK_Orders PRIMARY KEY(OrderId)
)

DROP TABLE dbo.tblOrders

--CREATE TABLE tblDrinkGroup(
--	GroupId INT IDENTITY(1,1) NOT NULL,
--	GroupCode VARCHAR(100) NULL,
--	GroupName NVARCHAR(100) NULL
--	CONSTRAINT PK_DrinkGroup PRIMARY KEY(GroupId)
--)
--GO

--CREATE TABLE tblOrder(
--	OrderId INT IDENTITY(1,1) NOT NULL,
--	TableId INT NOT NULL,
--	TimeId INT NOT NULL,
--	UserId INT NOT NULL
--	CONSTRAINT PK_Order PRIMARY KEY(OrderId,TableId,TimeId)
--)
--GO

CREATE TABLE tblNews(
	NewsId int IDENTITY(1,1) NOT NULL,
	Title NVARCHAR(255) NULL,
	Image VARCHAR(100) NULL,
	CreateDate DATE NULL,
	Content TEXT NULL
	CONSTRAINT PK_News PRIMARY KEY(NewsId)
)
GO 

ALTER TABLE dbo.tblUser ADD CONSTRAINT FK_User_GroupUser FOREIGN KEY(GroupId) REFERENCES dbo.tblUserGroup(GroupId)
ALTER TABLE dbo.tblFood ADD CONSTRAINT FK_Food_GroupFood FOREIGN KEY(GroupId) REFERENCES dbo.tblFoodGroup(GroupId)
ALTER TABLE dbo.tblDrink ADD CONSTRAINT FK_Drink_DrinkGroup FOREIGN KEY(GroupId) REFERENCES dbo.tblDrinkGroup(GroupId)
ALTER TABLE dbo.tblOrder ADD CONSTRAINT FK_Order_Table FOREIGN KEY(TableId) REFERENCES dbo.tblTable(TableId)
ALTER TABLE dbo.tblOrder ADD CONSTRAINT FK_Order_Time FOREIGN KEY(TimeId) REFERENCES dbo.tblTime(TimeId)
--update 
--ALTER TABLE dbo.tblOrders ADD CONSTRAINT FK_Orders_User FOREIGN KEY(CustomerId) REFERENCES dbo.tblUser(UserId)
ALTER TABLE dbo.tblOrders ADD CONSTRAINT FK_Orders_Time FOREIGN KEY(TimeId) REFERENCES dbo.tblTime(TimeId)

--ALTER TABLE dbo.tblOrder ADD CONSTRAINT FK_Order_User FOREIGN KEY(UserId) REFERENCES dbo.tblUser(UserId)
GO

INSERT dbo.tblUserGroup(GroupCode, GroupName ) VALUES  ('ADMIN', N'Admin')
INSERT dbo.tblUserGroup(GroupCode, GroupName ) VALUES  ('CUSTOMER', N'Customer')

INSERT dbo.tblUser(UserName ,Password ,FullName ,Gender ,Phone ,Email ,Address) VALUES  ('admin' ,'admin' ,N'Mr Hoài' ,1 ,'0969543024' ,'hoailong129@gmail.com' ,N'Thanh Xuân - Hà Nội')
INSERT dbo.tblUser(UserName ,Password ,FullName ,Gender ,Phone ,Email ,Address) VALUES  ('hoaiphan' ,'12345' ,N'Phan Văn Hoài' ,1 ,'0969543024' ,'hoailong129@gmail.com' ,N'Thanh Xuân - Hà Nội')

INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 1' ,4)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 2' ,4)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 3' ,6)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 4' ,6)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 5' ,8)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 6' ,8)
INSERT dbo.tblTable (TableName ,Maxpeople) VALUES  (N'Bàn 7' ,10)

INSERT dbo.tblTime (TimeName) VALUES  ('11:00')
INSERT dbo.tblTime (TimeName) VALUES  ('11:30')
INSERT dbo.tblTime (TimeName) VALUES  ('12:00')
INSERT dbo.tblTime (TimeName) VALUES  ('12:30')
INSERT dbo.tblTime (TimeName) VALUES  ('18:00')
INSERT dbo.tblTime (TimeName) VALUES  ('18:30')
INSERT dbo.tblTime (TimeName) VALUES  ('19:00')
INSERT dbo.tblTime (TimeName) VALUES  ('19:30')
INSERT dbo.tblTime (TimeName) VALUES  ('20:00')
INSERT dbo.tblTime (TimeName) VALUES  ('20:30')

--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-thuc-uong',N'Các loại thức uống')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-an-nhanh',N'Các món ăn nhanh')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('hai-san-tuoi-song',N'Hải sản tươi sống')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-xao-nuong',N'Các món Xào - Nướng')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-lau',N'Các món lẩu')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-an-moi',N'Các món ăn mới')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-manh-canh',N'Các món	Mặn - Canh')
--INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('cac-mon-an-dan-gian',N'Các món ăn dân gian')

INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('khai-vi',N'Khai vị')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('mon-thit',N'Món thịt')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('mon-hai-san',N'Món hải sản')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('mon-rau',N'Món rau')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('my-mien-pho',N'Mỳ - Miến - Phở')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('com-chao',N'Cơm - Cháo')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('canh-lau',N'Canh - Lẩu')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('trang-mieng',N'Tráng miệng')
INSERT dbo.tblFoodGroup(GroupCode,GroupName ) VALUES ('do-uong',N'Đồ uống')

INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Súp hải sản đậu phụ' ,'sup-hai-san-dau-phu.jpg' ,58000 ,9)
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Gói cuốn tôm thịt' ,'goi-cuon-tom-thit.jpg' ,35000 ,9)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Khoai tây chiên' ,'khoai-tay-chien.jpg' ,30000 ,9)		
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Nem rán Hà Nội' ,'nem-ran-ha-noi.jpg' ,50000 ,9)		
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Thịt ba chỉ rang cháy cạnh' ,'thit-ba-chi-rang-chay-canh.jpg' ,70000 ,10)			
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Sườn xào chua ngọt' ,'suon-xao-chua-ngot.jpg' ,80000 ,10)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Bò xào lúc lắc' ,'bo-xao-luc-lac.jpg' ,120000 ,10)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Tôm sú chiên xả ớt' ,'tom-su-chien-xa-ot.jpg' ,180000 ,11)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Ngao hấp gừng' ,'ngao-hap-gung.jpg' ,150000 ,11)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Cua xào sốt cay' ,'cua-xao-sot-cay.jpg' ,230000 ,11)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Mực trứng chiên xóc tỏi ớt' ,'muc-trung-chien-xoc-toi-ot.jpg' ,25000 ,11)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Ngọn su su xào tỏi' ,'ngon-su-su-xao-toi.jpg' ,45000 ,12)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Rau muống xào tỏi' ,'rau-muong-xao-toi.jpg' ,30000 ,12)	
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Phở bò xào giòn' ,'pho-bo-xao-gion.jpg' ,75000 ,13)		
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Cơm rang sò điệp' ,'com-rang-so-diep.jpg' ,55000 ,14)		
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Cơm chiên tôm trứng muối' ,'com-chien-tom-trung-muoi.jpg' ,80000 ,14)		
INSERT dbo.tblFood( FoodName ,FoodImage ,FoodCost ,GroupId) VALUES  ( N'Lẩu thái hải sản' ,'lau-thai-hai-san.jpg' ,400000 ,15)																																																																															
GO

DROP TABLE dbo.tblDrink
DROP TABLE dbo.tblDrinkGroup
