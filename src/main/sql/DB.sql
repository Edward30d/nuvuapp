CREATE SCHEMA NUVU_SCHEME;

CREATE TABLE IF NOT EXISTS  NUVU_SCHEME.PEOPLE  (
    ID_PEOPLE SERIAL,
    ID_NUMBER NUMERIC(12) NOT NULL,
    ID_TYPE NUMERIC(1) NOT NULL,
    NAME VARCHAR(240) NOT NULL,
    LAST_NAME VARCHAR(240) NOT NULL,
    PHONE_NUMBER NUMERIC(10) NOT NULL,
    ADDRESS VARCHAR(300),
    EMAIL VARCHAR(300),
    PRIMARY KEY (ID_PEOPLE)
);

CREATE TABLE IF NOT EXISTS  NUVU_SCHEME.CATEGORY_CARD  (
    ID_CARD SERIAL,
    TYPE VARCHAR(240) NOT NULL,
    FRANCHISE VARCHAR(240) NOT NULL,
    PRIMARY KEY (ID_CARD)
);

CREATE TABLE NUVU_SCHEME.CREDIT_CARD  (
    ID_CREDIT_CARD SERIAL,
    ID_NUMBER NUMERIC(12) NOT NULL,
    DATE_EXPIRY VARCHAR(5) NOT NULL,
    CSV NUMERIC(3) NOT NULL,
    BALANCE NUMERIC NOT NULL,
    CATEGORY_CARD SERIAL,
    PEOPLE SERIAL,
    PRIMARY KEY (ID_CREDIT_CARD),
    CONSTRAINT CATEGORY_CARD_FK FOREIGN KEY (CATEGORY_CARD) REFERENCES NUVU_SCHEME.CATEGORY_CARD (ID_CARD),
    CONSTRAINT PEOPLE_FK FOREIGN KEY (PEOPLE) REFERENCES NUVU_SCHEME.PEOPLE (ID_PEOPLE),
    CONSTRAINT UNIQUE_KEY UNIQUE (PEOPLE,CATEGORY_CARD)
);

ALTER TABLE NUVU_SCHEME.CREDIT_CARD ADD CONSTRAINT UNIQUE_ID_NUMBER UNIQUE (ID_NUMBER);


CREATE TABLE NUVU_SCHEME.USER (
    ID_USER SERIAL,
    ENABLE BOOLEAN NOT NULL,
    PASSWORD VARCHAR(240) NOT NULL,
    USER_NAME VARCHAR(240) NOT NULL,
    PRIMARY KEY (ID_USER)
);


INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Black','Dinners Club');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Platinum','Dinners Club');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Gold','Dinners Club');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Clasic','Dinners Club');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Black','Visa');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Platinum','Visa');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Gold','Visa');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Clasic','Visa');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Black','Master Card');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Platinum','Master Card');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Gold','Master Card');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Clasic','Master Card');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Black','American Express');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Platinum','American Express');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Gold','American Express');
INSERT INTO NUVU_SCHEME.CATEGORY_CARD (TYPE,FRANCHISE) VALUES ('Clasic','American Express');


insert into NUVU_SCHEME.USER (ENABLE,PASSWORD,USER_NAME) values (true,'$2a$10$J3sv86TKGRBJs09R.GSBmeAKW7r3PbQn4mxkhRGQdshLCEZFaSRrK','Edward');


