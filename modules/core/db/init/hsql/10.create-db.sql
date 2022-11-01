-- begin SALES_CUSTOMER
create table SALES_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    EMAIL varchar(100),
    --
    primary key (ID)
)^
-- end SALES_CUSTOMER
-- begin SALES_PRODUCT
create table SALES_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    PRICE decimal(19, 2) not null,
    SPECIAL boolean,
    --
    primary key (ID)
)^
-- end SALES_PRODUCT
-- begin SALES_ORDER
create table SALES_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ date not null,
    NUMBER_ varchar(255),
    AMOUNT decimal(19, 2),
    CUSTOMER_ID varchar(36),
    NUMBER_OF_SPECIAL_PRODUCTS integer,
    --
    primary key (ID)
)^
-- end SALES_ORDER
-- begin SALES_ORDER_LINE
create table SALES_ORDER_LINE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(36),
    PRODUCT_ID varchar(36) not null,
    QUANTITY decimal(19, 3) not null,
    --
    primary key (ID)
)^
-- end SALES_ORDER_LINE
-- begin SALES_CITY
create table SALES_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    DEFAULT_CITY boolean,
    CODE integer,
    --
    primary key (ID)
)^
-- end SALES_CITY
-- begin SALES_AUTOSERVICE
create table SALES_AUTOSERVICE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ADDRESS varchar(255) not null,
    PHONE varchar(255),
    CITY_ID varchar(36),
    --
    primary key (ID)
)^
-- end SALES_AUTOSERVICE
-- begin SALES_EMPLOYEE
create table SALES_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LAST_NAME varchar(255) not null,
    FIRST_NAME varchar(255) not null,
    AUTOSERVICE_ID varchar(36),
    BIRTHDAY date,
    SALARY decimal(19, 2),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end SALES_EMPLOYEE
-- begin SALES_REPAIR
create table SALES_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    AUTOSERVICE varchar(36),
    EMPLOYEE varchar(36),
    --
    primary key (ID)
)^
-- end SALES_REPAIR
-- begin SALES_PERSON
create table SALES_PERSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    LAST_NAME varchar(255),
    FIRST_NAME varchar(255),
    BIRTH_DAY date,
    --
    primary key (ID)
)^
-- end SALES_PERSON
-- begin SALES_INDIVIDUALS
create table SALES_INDIVIDUALS (
    ID varchar(36) not null,
    --
    POLE_INDIVIDUALS varchar(255),
    --
    primary key (ID)
)^
-- end SALES_INDIVIDUALS
-- begin SALES_LEGAL
create table SALES_LEGAL (
    ID varchar(36) not null,
    --
    POLE_LEGAL varchar(255),
    --
    primary key (ID)
)^
-- end SALES_LEGAL
-- begin SALES_AUTOSERVICE_PERSON_LINK
create table SALES_AUTOSERVICE_PERSON_LINK (
    AUTOSERVICE_ID varchar(36) not null,
    PERSON_ID varchar(36) not null,
    primary key (AUTOSERVICE_ID, PERSON_ID)
)^
-- end SALES_AUTOSERVICE_PERSON_LINK
