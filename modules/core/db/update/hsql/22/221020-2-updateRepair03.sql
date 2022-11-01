alter table SALES_REPAIR alter column EMPLOYEE_ID rename to EMPLOYEE_ID__U43122 ^
alter table SALES_REPAIR drop constraint FK_SALES_REPAIR_EMPLOYEE ;
drop index IDX_SALES_REPAIR_EMPLOYEE ;
alter table SALES_REPAIR add column EMPLOYEE_ID varchar(36) ;
