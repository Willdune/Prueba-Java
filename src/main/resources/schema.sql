CREATE TABLE PRICES(
ID bigint PRIMARY KEY,
PRIORITY bigint,
BRAND_ID bigint,
PRODUCT_ID bigint,
CURRENCY VARCHAR(255),
START_DATE timestamp,
END_DATE timestamp,
PRICE float,
PRICE_LIST bigint
);