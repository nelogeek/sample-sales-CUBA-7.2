alter table SALES_AUTOSERVICE alter column CITY_ID rename to CITY_ID__U24822 ^
alter table SALES_AUTOSERVICE drop constraint FK_SALES_AUTOSERVICE_CITY ;
drop index IDX_SALES_AUTOSERVICE_CITY ;
alter table SALES_AUTOSERVICE add column CITY varchar(36) ;
