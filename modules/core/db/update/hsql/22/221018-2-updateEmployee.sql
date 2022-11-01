update SALES_EMPLOYEE set LAST_NAME = '' where LAST_NAME is null ;
alter table SALES_EMPLOYEE alter column LAST_NAME set not null ;
update SALES_EMPLOYEE set FIRST_NAME = '' where FIRST_NAME is null ;
alter table SALES_EMPLOYEE alter column FIRST_NAME set not null ;
