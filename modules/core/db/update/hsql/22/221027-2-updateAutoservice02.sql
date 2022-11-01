alter table SALES_AUTOSERVICE alter column CITY rename to CITY__U99799 ^
alter table SALES_AUTOSERVICE drop constraint FK_SALES_AUTOSERVICE_CITY ;
alter table SALES_AUTOSERVICE add column CITY_ID varchar(36) ;
