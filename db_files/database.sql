create database if not exists expertexchange;
USE expertexchange;

create table if not exists companies (
    ID int not null AUTO_INCREMENT,     -- Firmen ID zur uniquisierung
    company varchar(200),           -- Firmenname
    industry varchar(200),          -- Branche
    street varchar(200),            -- Straße
    city varchar(25),               -- Stadt
    zip_code varchar(5),            -- PLZ
    region varchar(25),             -- Region
    webpage varchar(100),           -- Webseite
    email varchar(100),             -- Email Adresse
    phone_primary varchar(20),      -- Primäre Telefonnummer
    phone_mobile varchar(20),       -- Mobile / Sekundäre Telefonnummer
    salutation varchar(10),         -- Anrede
    first_name varchar(25),         -- Vorname
    last_name varchar(25),          -- Nachname
    PRIMARY KEY(ID)
);

create table if not exists knowhow_categories (
    knowhow_cat_id int not null AUTO_INCREMENT,
    knowhow varchar(200),
    knowhow_sub varchar(200),
    knowhow_example varchar(200),
    PRIMARY KEY(knowhow_cat_id)
);

create table if not exists ressource_categories (
    ressource_cat_id int,
    ressource varchar(200),
    ressource_sub varchar(200),
    ressource_example varchar(200),
    PRIMARY KEY(ressource_cat_id)
);

create table if not exists search_listings (
    ID int not null AUTO_INCREMENT,
    knowhow_cat_id int,
    knowhow_amount int,
    knowhow_skilllevel varchar(20),
    knowhow_availability_since date,
    knowhow_availability_until date,
    ressource_cat_id int,
    ressource_availability_since date,
    ressource_availability_until date,
    listing_company_id int,
    PRIMARY KEY (ID),
    FOREIGN KEY (knowhow_cat_id) REFERENCES knowhow_categories(knowhow_cat_id),
    FOREIGN KEY (ressource_cat_id) REFERENCES ressource_categories(ressource_cat_id),
    FOREIGN KEY (listing_company_id) REFERENCES companies(ID)
);

create table if not exists bidding_listings (
    ID int not null AUTO_INCREMENT,
    knowhow_cat_id int,
    knowhow_amount int,
    knowhow_skilllevel varchar(20),
    knowhow_availability_since date,
    knowhow_availability_until date,
    ressource_cat_id int,
    ressource_availability_since date,
    ressource_availability_until date,
    listing_company_id int,
    PRIMARY KEY (ID),
    FOREIGN KEY (knowhow_cat_id) REFERENCES knowhow_categories(knowhow_cat_id),
    FOREIGN KEY (ressource_cat_id) REFERENCES ressource_categories(ressource_cat_id),
    FOREIGN KEY (listing_company_id) REFERENCES companies(ID)
);