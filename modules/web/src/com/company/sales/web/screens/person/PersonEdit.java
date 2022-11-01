package com.company.sales.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Person;

@UiController("sales_Person.edit")
@UiDescriptor("person-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonEdit extends StandardEditor<Person> {
}