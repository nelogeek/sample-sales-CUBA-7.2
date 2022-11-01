alter table SALES_AUTOSERVICE add constraint FK_SALES_AUTOSERVICE_CITY foreign key (CITY) references SALES_CITY(ID);
