
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Franklin Castillo
 * Created: Apr 11, 2018
 */

--create database Inventory;
--go

drop table CLIENT;
go

CREATE TABLE CLIENT(
    ID_CLIENT INTEGER PRIMARY KEY IDENTITY (1, 1),
    DOCUMENT VARCHAR(20),
    NAME VARCHAR(50),
    ADDRESS VARCHAR(100),
    ZONE VARCHAR(50),
    PHONE VARCHAR(20),
    EMAIL VARCHAR(50),
    NOTE VARCHAR(20),
    CREATED_DATE DATE DEFAULT 'NOW',
    STATUS BIT
);
GO

drop table product;
GO

CREATE TABLE PRODUCT(
    ID_PRODUCT      INTEGER PRIMARY KEY IDENTITY (1, 1),
    ID_SUPPLIER     INTEGER,
    PRODUCT_CODE    VARCHAR(50),
    DESCRIPTION     VARCHAR(200),
    CATEGORY        VARCHAR(50),
    CREATED_DATE    DATE DEFAULT 'NOW',
    STATUS          BIT
);
GO

--https://stackoverflow.com/questions/31804210/derby-auto-increment-by-100-when-specified-as-1

drop table SUPPLIER;
GO

CREATE TABLE SUPPLIER(
    ID_SUPPLIER     INTEGER PRIMARY KEY IDENTITY (1, 1),
    DOCUMENT        VARCHAR(20),
    NAME            VARCHAR(50),
    ADDRESS         VARCHAR(100),
    ZONE            VARCHAR(50),
    PHONE           VARCHAR(20),
    EMAIL           VARCHAR(50),
    NOTE            VARCHAR(20),
    CREATED_DATE    DATE,
    STATUS          BIT
);
GO

drop table USERS;
GO

CREATE TABLE USERS(
    ID_USER         INTEGER PRIMARY KEY IDENTITY (1, 1),
    DOCUMENT        VARCHAR(20),
    USER_NAME       VARCHAR(50),
    PASSWORD        VARCHAR(50),
    NAME            VARCHAR(50),
    ADDRESS         VARCHAR(100),
    ZONE            VARCHAR(50),
    PHONE           VARCHAR(20),
    EMAIL           VARCHAR(50),
    NOTE            VARCHAR(20),
    CREATED_DATE    DATE DEFAULT 'NOW',
    STATUS          BIT
);
GO

-- select * from inventory
drop table inventory;
GO

CREATE TABLE INVENTORY(
    ID_INVENTORY    INTEGER PRIMARY KEY IDENTITY (1, 1),
    ID_PRODUCT      INTEGER,
    ID_SUPPLIER     INTEGER,
    PRICE1          DECIMAL(10,2),
    PRICE2          DECIMAL(10,2),
    PRICE3          DECIMAL(10,2),
    PRICE4          DECIMAL(10,2),
    COST            DECIMAL(10,2),
    AVG_COST        DECIMAL(10,2),
    TAX             INTEGER, --Relacionado cola la tabla taxes
    STOCK           INTEGER,
    MIN_STOCK       INTEGER,
--     IDEAL_STOCK       INTEGER,
    LAST_UPDATED    DATE DEFAULT 'NOW'
);
GO

DROP TABLE INVENTORY_TRANS;
GO

CREATE TABLE INVENTORY_TRANS(
    ID_INV_TRANS    INTEGER PRIMARY KEY IDENTITY (1, 1),
    NO_DOCUMENT     VARCHAR(50),
    ID_INVENTORY    INTEGER,
    ID_PRODUCT      INTEGER,
    ID_SUPPLIER     INTEGER,
    ID_CLIENT       INTEGER,
    ID_USER         INTEGER,
    TRANS_TYPE      VARCHAR(50),
    DISCOUNT        DECIMAL(10,2),
    QUANTITY        INTEGER,
    COSTXUNIT       DECIMAL(10,2),
    PRICEXUNIT      DECIMAL(10,2),
    TAX             DECIMAL(10,2),-- Para compras: 0.18 si es calculado y 0 cuando el precio incluye ITBIS
    TOTAL           DECIMAL(10,2),-- = (QUANTITY * COSTXUNIT) + (QUANTITY * COSTXUNIT * TAX) para el caso de Compras
                                  -- = (QUANTITY * PRICEXUNIT) + (QUANTITY * PRICEXUNIT * TAX) para el caso de Ventas
    CREATED_DATE    DATE DEFAULT 'NOW'
);
GO

DROP TABLE INV_TRANS_MASTER;
GO

CREATE TABLE INV_TRANS_MASTER(
    ID_TRANS_MASTER INTEGER PRIMARY KEY IDENTITY (1, 1),
    NO_INVOICE      VARCHAR(20),
    TOTAL           DECIMAL(10, 2),
    CREATED_DATE    DATE DEFAULT 'NOW'   
);
GO

DROP TABLE TAXES;
GO

CREATE TABLE TAXES(
    ID_TAX INTEGER,
    TAX_AMOUNT DECIMAL(10,2),
    TAX_DESCRIPTION VARCHAR(50)
);
GO

DROP TABLE INV_CONCEPTS;
GO

CREATE TABLE INV_CONCEPTS(
    ID INTEGER,
    NAME VARCHAR(50),
    DESCRIPTION VARCHAR(100)
);
GO


-- select * from client;
-- 
-- select * from supplier;
-- 
-- select * from product;
-- 
-- --where year(created_Date) = 2018;
-- select * from inventory;
-- 
-- select *  from inventory_trans
-- --where CREATED_DATE between '20180504' and '20180504'
-- 
-- where id_supplier = 2
-- 
-- 
-- SELECT *
-- FROM Product p, Inventory i WHERE p.ID_PRODUCT = i.ID_PRODUCT
-- and ( p.DESCRIPTION like '%otr%')
-- 
-- and (p.productCode like :productCode or p.description like :description
-- 
-- 
-- select  NO_DOCUMENT, sum(QUANTITY * COSTXUNIT) as TOTAL_COST, sum(QUANTITY * PRICEXUNIT) AS TOTAL_SALES,
--    sum(QUANTITY * PRICEXUNIT) - sum(QUANTITY * COSTXUNIT) AS PROFIT , CREATED_DATE
-- from inventory_trans
-- WHERE TRANS_TYPE = 'venta'
-- and date(CREATED_DATE) BETWEEN date('2018-05-03') and date('2018-05-04')
-- group by NO_DOCUMENT, CREATED_DATE
-- 
-- select *--no_document
-- from inventory_trans i 
-- where trans_type = 'venta'
-- and id_inv_trans = (
--                     select max(id_inv_trans)
--                     from inventory_trans i 
--                     where trans_type = 'venta'
--                     )
