INSERT INTO companies (ID,company,industry,city,region,webpage,email,phone_primary, phone_mobile) VALUES
('1', 'EAN Elektroanlagen Neuenhagen GmbH', 'Elektroinstallation', 'Neuenhagen', 'MOL', 'www.ean-elektro-gmbh.de', 'tbecker@ean-elektro-gmbh.de', '0162-1320050', '02494-2482910'),
('2', 'Seitzinger & Popp GmbH', 'Maschinenbau', 'Nürnberg', 'Mittelfranken', 'www.seitzinger-popp.de', 'kontakt@seitzinger-popp-de', '0171-4173522', '02494-2429492');

INSERT INTO knowhow_categories (knowhow_cat_id, knowhow, knowhow_sub, knowhow_example) VALUES
('1', 'Programmierung', 'Smart-Home', 'LCN, KNX, Homematic, LON'),
('2', 'Programmierung', 'Programmiersprachen', 'C#, C++, Python, Java');

INSERT INTO ressource_categories (ressource_cat_id, ressource, ressource_sub, ressource_example) VALUES
('1', 'Fahrzeuge', 'Personen', 'PKW, Bus, Sprinter'),
('2', 'Fahrzeuge', 'Spezial', 'Hubsteiger, Hebebühnen');

INSERT INTO search_listings (ID, knowhow_cat_id, knowhow_amount, knowhow_skilllevel, knowhow_availability_until, listing_company_id) VALUES -- Knowhow Inserat
('1', '1', '2', 'Experte', '2020-04-30', '1'),
('2', '2', '4', 'Experte', '2020-04-30', '2');

INSERT INTO search_listings (ID, ressource_cat_id, ressource_availability_until, listing_company_id) VALUES -- Ressource Inserat
('3', '1', '2020-04-30', '1'),
('4', '2', '2020-04-30', '2');

INSERT INTO search_listings (ID, knowhow_cat_id, knowhow_amount, knowhow_skilllevel, knowhow_availability_until, ressource_cat_id, ressource_availability_until, listing_company_id) VALUES -- Knowhow und Ressource
('5', '2', '2', 'Fortgeschritten', '2020-04-30', '2', '2020-04-30', '2'),
('6', '1', '1', 'Experte', '2020-04-30', '2', '2020-04-30', '2');


INSERT INTO bidding_listings (ID, knowhow_cat_id, knowhow_amount, knowhow_skilllevel, knowhow_availability_until, listing_company_id) VALUES -- Knowhow Inserat
('1', '1', '2', 'Experte', '2020-04-30', '1'),
('2', '2', '4', 'Experte', '2020-04-30', '2');

INSERT INTO bidding_listings (ID, ressource_cat_id, ressource_availability_until, listing_company_id) VALUES -- Ressource Inserat
('3', '1', '2020-04-30', '1'),
('4', '2', '2020-04-30', '2');

INSERT INTO bidding_listings (ID, knowhow_cat_id, knowhow_amount, knowhow_skilllevel, knowhow_availability_until, ressource_cat_id, ressource_availability_until, listing_company_id) VALUES -- Knowhow und Ressource
('5', '2', '2', 'Fortgeschritten', '2020-04-30', '2', '2020-04-30', '2'),
('6', '1', '1', 'Experte', '2020-04-30', '2', '2020-04-30', '2');

