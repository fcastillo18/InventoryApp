/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Franklin Castillo
 * Created: Apr 11, 2018
 */

CREATE TABLE CLIENT(
    ID_CLIENT INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    DOCUMENT VARCHAR(20),
    NAME VARCHAR(50),
    ADDRESS VARCHAR(100),
    ZONE VARCHAR(50),
    PHONE VARCHAR(20),
    EMAIL VARCHAR(50),
    NOTE VARCHAR(20),
    CREATED_DATE TIMESTAMP DEFAULT 'NOW',
    STATUS BOOLEAN
)



