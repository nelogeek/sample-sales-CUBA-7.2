package com.company.sales.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Employee;

@UiController("sales_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}