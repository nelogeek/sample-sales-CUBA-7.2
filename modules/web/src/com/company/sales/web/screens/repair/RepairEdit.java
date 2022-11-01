package com.company.sales.web.screens.repair;

import com.company.sales.entity.Employee;

import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Repair;
import org.slf4j.Logger;

import javax.inject.Inject;

@UiController("sales_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RepairEdit.class);
    @Inject
    private InstanceContainer<Repair> repairDc;

    @Inject
    private LookupPickerField<Employee> employeeField;

    @Override
    protected void onChangeEvent(DataContext.ChangeEvent event) {
        repairDc.addItemPropertyChangeListener(e -> {
            if (e.getProperty().equals("autoservice")) {
                employeeField.setValue(null);
            }
        });
    }


    
}