create table SALES_AUTOSERVICE_PERSON_LINK (
    AUTOSERVICE_ID varchar(36) not null,
    PERSON_ID varchar(36) not null,
    primary key (AUTOSERVICE_ID, PERSON_ID)
);
