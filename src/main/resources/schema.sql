-- this file will be used when intializing DB through JDBC
-- see https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html

DROP TABLE IF EXISTS bakery;
DROP TABLE IF EXISTS bun;
DROP TABLE IF EXISTS company;

CREATE TABLE company(
   id BIGINT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL UNIQUE,
   PRIMARY KEY(id)
);

CREATE TABLE bakery(
   id BIGINT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL,
   address VARCHAR(255) NOT NULL,
   company_id BIGINT,
   PRIMARY KEY(id),
   CONSTRAINT fk_company
      FOREIGN KEY(company_id) 
        REFERENCES company(id)
);

CREATE TABLE bun(
   id BIGINT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255) NOT NULL,
   company_id BIGINT,
   PRIMARY KEY(id),
   CONSTRAINT fk_company
      FOREIGN KEY(company_id) 
        REFERENCES company(id)
);

