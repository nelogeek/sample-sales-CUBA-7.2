alter table SALES_REPAIR add constraint FK_SALES_REPAIR_AUTOSERVICE foreign key (AUTOSERVICE) references SALES_AUTOSERVICE(ID);
