package com.company.sales.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Employee;

@UiController("sales_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}