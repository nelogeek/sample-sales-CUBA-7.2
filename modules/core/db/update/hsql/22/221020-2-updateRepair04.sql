alter table SALES_REPAIR add constraint FK_SALES_REPAIR_EMPLOYEE foreign key (EMPLOYEE_ID) references SALES_EMPLOYEE(ID);
