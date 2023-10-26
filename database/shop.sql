CREATE TABLE categories(
    categoryId NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    categoryName NVARCHAR2(255) NOT NULL UNIQUE,
    categoryStatus NUMBER DEFAULT 1,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL
);

CREATE TABLE PRODUCTS(
    productId NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    productName NVARCHAR2(255) NOT NULL,
    productStatus NUMBER DEFAULT 1,
    price FLOAT,
    image NVARCHAR2(255),
    description CLOB NULL, 
    categoryId INT,
    FOREIGN KEY(categoryId) REFERENCES categories(categoryId),
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL
);

CREATE TABLE roles(
    id INT GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NULL
);

CREATE TABLE users(
    id NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    userName VARCHAR2(50) NOT NULL,
	password VARCHAR2(200) NOT NULL,
	enabled NUMBER NOT NULL,
	fullName NVARCHAR2(50) NULL,
	gender NUMBER NULL,
	birthday DATE NULL,
	address NVARCHAR2(200) NULL,
	email VARCHAR2(100) NULL,
	telephone VARCHAR2(20) NULL
);

CREATE TABLE users_roles(
    id INT GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    userId INT NOT NULL,
    roleId INT NOT NULL, 
    FOREIGN KEY(userId) REFERENCES users(id),
    FOREIGN KEY(roleId) REFERENCES roles(id)
)

INSERT INTO roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO roles(name)  VALUES ('ROLE_USER');
INSERT INTO users (userName, password, enabled, fullName, gender, birthday, address, email, telephone)
VALUES ('admin', '$2a$12$Nj/u4S19cTuCVXhMmP1JLexUXyQN0IN/5FH//BL5VtyPTfiASCw4W', 1, 'HiChaoCau', 1, TO_DATE('2000-01-15', 'yyyy-mm-dd'), 'ha noi', 'admin@gmail.com', '012345679');
INSERT INTO users (userName, password, enabled, fullName, gender, birthday, address, email, telephone)
VALUES ('user', '$2a$12$0ExjRV72KLJ9dS0pPgvU2.xG82EMEusSaIww0YDtEWQsl/w5nlAvi', 1, 'HiChaoBan', 1, TO_DATE('2000-01-15', 'yyyy-mm-dd'), 'ha noi', 'user@gmail.com', '012345679');
