alter table SALES_EMPLOYEE add constraint FK_SALES_EMPLOYEE_AUTOSERVICE foreign key (AUTOSERVICE) references SALES_AUTOSERVICE(ID);