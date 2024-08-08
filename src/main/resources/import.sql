-- this file will be used when intializing DB through JPA
-- see https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html

INSERT INTO company (name) VALUES ('Hart');

INSERT INTO bakery (name, address, company_id) VALUES ('Hart Vesterbro', 'Istedgade 61, 1650 København', (SELECT id FROM company WHERE name = 'Hart'));

INSERT INTO bakery (name, address, company_id) VALUES ('Hart Kødbyens', 'Høkerboderne 17, 1712 København', (SELECT id FROM company WHERE name = 'Hart'));

INSERT INTO bakery (name, address, company_id) VALUES ('Hart Frederiksberg', 'Gl. Kongevej 109, 1850 Frederiksberg C', (SELECT id FROM company WHERE name = 'Hart'));

INSERT INTO company (name) VALUES ('Buka');

INSERT INTO bakery (name, address, company_id) VALUES ('Buka Strøget', 'Frederiksberggade 21, 1459 København', (SELECT id FROM company WHERE name = 'Buka'));

INSERT INTO bakery (name, address, company_id) VALUES ('Buka Nytorv', 'Nytorv 3, 1450 København', (SELECT id FROM company WHERE name = 'Buka'));
