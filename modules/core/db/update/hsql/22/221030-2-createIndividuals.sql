alter table SALES_INDIVIDUALS add constraint FK_SALES_INDIVIDUALS_ID foreign key (ID) references SALES_PERSON(ID);
