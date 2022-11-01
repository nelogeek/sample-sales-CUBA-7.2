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
    BIRTH_DAY timestamp,
    --
    primary key (ID)
);