alter table SALES_REPAIR alter column EMPLOYEE_ID rename to EMPLOYEE_ID__U89643 ^
alter table SALES_REPAIR drop constraint FK_SALES_REPAIR_EMPLOYEE ;
drop index IDX_SALES_REPAIR_EMPLOYEE ;
alter table SALES_REPAIR alter column AUTOSERVICE_ID rename to AUTOSERVICE_ID__U37104 ^
alter table SALES_REPAIR drop constraint FK_SALES_REPAIR_AUTOSERVICE ;
drop index IDX_SALES_REPAIR_AUTOSERVICE ;
alter table SALES_REPAIR add column EMPLOYEE varchar(36) ;
alter table SALES_REPAIR add column AUTOSERVICE varchar(36) ;
