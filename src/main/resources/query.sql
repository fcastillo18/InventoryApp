/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Franklin Castillo
 * Created: Apr 11, 2018
 */

-- -- CREATE TABLE CLIENT(
-- --     ID_CLIENT INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
-- --     DOCUMENT VARCHAR(20),
-- --     NAME VARCHAR(50),
-- --     ADDRESS VARCHAR(100),
-- --     ZONE VARCHAR(50),
-- --     PHONE VARCHAR(20),
-- --     EMAIL VARCHAR(50),
-- --     NOTE VARCHAR(20),
-- --     CREATED_DATE TIMESTAMP DEFAULT 'NOW',
-- --     STATUS BOOLEAN
-- -- )
-- 
CREATE TABLE PRODUCT(
    ID_PRODUCT      INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    ID_SUPPLIER     INTEGER,
    PRODUCT_CODE    VARCHAR(50),
    DESCRIPCION     VARCHAR(200),
    CATEGORY        VARCHAR(50),
--     PRICE1          DECIMAL(10,2),
--     PRICE2          DECIMAL(10,2),
--     PRICE3          DECIMAL(10,2),
--     COST            DECIMAL(10,2),
--     AVG_COST        DECIMAL(10,2),
    MIN_STOCK       INTEGER,
    MAX_STOCK       INTEGER,
    CREATED_DATE    TIMESTAMP,
    STATUS          BOOLEAN
)
-- 
-- CREATE TABLE SUPPLIER(
--     ID_SUPPLIER     INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     DOCUMENT        VARCHAR(20),
--     NAME            VARCHAR(50),
--     ADDRESS         VARCHAR(100),
--     ZONE            VARCHAR(50),
--     PHONE           VARCHAR(20),
--     EMAIL           VARCHAR(50),
--     NOTE            VARCHAR(20),
--     CREATED_DATE    TIMESTAMP
--     STATUS          BOOLEAN
-- )
-- 
-- CREATE TABLE USERS(
--     ID_USER         INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     DOCUMENT        VARCHAR(20),
--     USER_NAME       VARCHAR(50),
--     PASSWORD        VARCHAR(50),
--     NAME            VARCHAR(50),
--     ADDRESS         VARCHAR(100),
--     ZONE            VARCHAR(50),
--     PHONE           VARCHAR(20),
--     EMAIL           VARCHAR(50),
--     NOTE            VARCHAR(20),
--     CREATED_DATE    TIMESTAMP
--     STATUS          BOOLEAN
-- )
-- 
CREATE TABLE INVENTORY(
    ID_INVENTORY    INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    ID_PRODUCT      INTEGER,
    ID_PROVEEDOR    INTEGER,
    PRICE1          DECIMAL(10,2),
    PRICE2          DECIMAL(10,2),
    PRICE3          DECIMAL(10,2),
    PRICE4          DECIMAL(10,2),
    COST            DECIMAL(10,2),
    TAX             INTEGER, --Relacionado cola la tabla taxes
    AVG_COST        DECIMAL(10,2),
    QUANTITY        INTEGER,
    LAST_UPDATED    TIMESTAMP
)
-- 
-- CREATE TABLE INVENTORY_TRANS(
--     ID_INV_TRANS    INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     ID_INVENTORY    INTEGER,
--     ID_PRODUCT      INTEGER,
--     ID_PROVEEDOR    INTEGER,
--     ID_CLIENT       INTEGER,
--     ID_USER         INTEGER,
--     TRANS_TYPE      VARCHAR(50),
--     DISCOUNT        DECIMAL(10,2),
--     QUANTITY        INTEGER,
--     PRICEXUNIT      DECIMAL(10,2),
--     TOTAL           DECIMAL(10,2),
--     CREATED_DATE    TIMESTAMP
-- )

-- CREATE TABLE INV_TRANS_MASTER(
--     ID_TRANS_MASTER 
-- )

CREATE TABLE TAXES(
    ID INTEGER,
    TAX_AMOUNT DECIMAL(10,2),
    TAX_DESCRIPTION VARCHAR(50)
)

CREATE TABLE INV_CONCEPTS(
    ID INTEGER,
    NAME VARCHAR(50),
    DESCRIPTION VARCHAR(100)
)

/**/

select * from client;

select * from supplier;

select * from product;

select * from inventory;

select *  from inventory_trans
--where year(created_Date) = 2018;

