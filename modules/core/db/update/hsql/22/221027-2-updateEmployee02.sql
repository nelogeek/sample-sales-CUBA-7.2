alter table SALES_EMPLOYEE alter column AUTOSERVICE rename to AUTOSERVICE__U63892 ^
alter table SALES_EMPLOYEE drop constraint FK_SALES_EMPLOYEE_AUTOSERVICE ;
alter table SALES_EMPLOYEE add column AUTOSERVICE_ID varchar(36) ;
