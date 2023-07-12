DROP TABLE client;
DROP TABLE supplier;
DROP TABLE bill;
DROP TABLE product;

CREATE TABLE client (
	id SERIAL,
 	firstName VARCHAR NOT NULL DEFAULT '---',
	lastName VARCHAR NOT NULL DEFAULT '---',
	dateOfBirth DATE NOT NULL,
	residency VARCHAR NOT NULL,
	CONSTRAINT clientNumber PRIMARY KEY (id)
);
 
CREATE TABLE supplier(
	id SERIAL,
	supplierName VARCHAR NOT NULL DEFAULT '---',
	residency VARCHAR NOT NULL,
	CONSTRAINT supplierNumber PRIMARY KEY (id)
);

CREATE TABLE bill(
	id SERIAL,
	typeOf VARCHAR,
	priceOf INTEGER,
	iva INTEGER,
	clientId INTEGER,
	supplierId INTEGER,
	CONSTRAINT billId PRIMARY KEY (id),
	CONSTRAINT clientId FOREIGN KEY (clientId) REFERENCES client(id),
	dateOf DATE,
	CONSTRAINT supplierId FOREIGN KEY (supplierId) REFERENCES supplier(id)
);

CREATE TABLE product(
	id SERIAL,
	description VARCHAR,
	production BOOLEAN,
	forSale BOOLEAN,
	activation DATE,
	deactivation DATE,
	CONSTRAINT productId PRIMARY KEY (id)
);

CREATE TABLE student(
	id SERIAL,
	first_name VARCHAR NOT NULL DEFAULT '---',
	last_name VARCHAR NOT NULL DEFAULT '---',
	gender ENUM,
	birthday DATE,
	avg DOUBLE,
	min_vote DOUBLE,
	max_vote DOUBLE
)

INSERT INTO client (firstName, lastName, dateOfBirth, residency) 
VALUES ('Mario', 'Rossi', '1985-07-10', 'Lombardia');
INSERT INTO client (firstName, lastName, dateOfBirth, residency) 
VALUES ('Giacomo', 'Leopardo', '1972-01-15', 'Sardegna');
INSERT INTO client (firstName, lastName, dateOfBirth, residency) 
VALUES ('Rotilio', 'Saltimbanchi', '1968-09-24', 'Campania');
INSERT INTO client (firstName, lastName, dateOfBirth, residency) 
VALUES ('Geppetto', 'Pinocchi', '1982-07-06', 'Molise');
INSERT INTO client (firstName, lastName, dateOfBirth, residency) 
VALUES ('Pierluigi', 'Bersani', '1982-08-12', 'Lazio');

SELECT * FROM client;

INSERT INTO supplier (supplierName, residency) 
VALUES ('Fornitore 1', 'Lazio');
INSERT INTO supplier (supplierName, residency) 
VALUES ('Fornitore 2', 'Umbria');
INSERT INTO supplier (supplierName, residency) 
VALUES ('Fornitore 3', 'Campania');
INSERT INTO supplier (supplierName, residency) 
VALUES ('Fornitore 4', 'Sardegna');

SELECT * FROM supplier;

INSERT INTO product (description, production, forSale, activation, deactivation) 
VALUES ('Prodotto 1', true, false, '2022-01-01', '2022-12-31');
INSERT INTO product (description, production, forSale, activation, deactivation) 
VALUES ('Prodotto 2', true, true, '2021-06-15', '2023-01-01');
INSERT INTO product (description, production, forSale, activation, deactivation) 
VALUES ('Prodotto 3', true, false, '2017-01-01', '2023-06-30');
INSERT INTO product (description, production, forSale, activation, deactivation) 
VALUES ('Prodotto 4', true, true, '2017-01-01', '2023-06-30');

SELECT * FROM product;

INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('A', 100, 20, 6, '2022-01-15', 5);
INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('A', 200, 10, 7, '2022-02-20', 6);
INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('B', 150, 20, 8, '2017-03-10', 7);
INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('B', 300, 20, 9, '2023-06-25', 8);
INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('A', 500, 20, 10, '2022-06-25', 6);
INSERT INTO bill (typeOf, priceOf, iva, clientId, dateOf, supplierId) 
VALUES ('C', 1000, 24, 8, '2017-06-25', 7);

SELECT * FROM bill;

SELECT * FROM client WHERE EXTRACT(YEAR FROM dateOfBirth) = '1982';

SELECT * FROM bill WHERE iva = 20;

SELECT EXTRACT(YEAR FROM dateOf) AS billYear, COUNT(*) AS billNumber, SUM(priceOf) AS priceSum
FROM bill
GROUP BY billYear;

SELECT * FROM product WHERE EXTRACT(YEAR FROM activation) = '2017' AND production = true OR EXTRACT(YEAR FROM activation) = '2017' AND forSale = true;

SELECT EXTRACT(YEAR FROM dateOf) AS billYear, COUNT(*) AS billNumber
FROM bill
GROUP BY billYear;

SELECT EXTRACT(YEAR FROM dateOf) AS billYear, COUNT(*) AS billNumber
FROM bill
WHERE typeOf = 'A'
GROUP BY billYear
HAVING COUNT(*)>2;

SELECT * FROM bill
JOIN supplier
ON bill.supplierId = supplier.id;

SELECT SUM(priceOf) AS allPrices, client.residency
FROM bill
JOIN client ON bill.clientID = client.id
GROUP BY client.residency;

SELECT COUNT(DISTINCT client.id) AS allClients
FROM client
JOIN bill ON client.id = bill.clientId
WHERE client.dateOfBirth >= '1980-01-01' 
AND client.dateOfBirth <= '1980-12-31'
AND bill.priceOf > 50;

SELECT CONCAT(client.firstName, '-', client.lastName) AS Designation
FROM client
WHERE residency = 'Lombardia';