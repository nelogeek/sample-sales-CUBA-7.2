package com.company.sales.web.screens.autoservice;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Autoservice;

@UiController("sales_Autoservice.edit")
@UiDescriptor("autoservice-edit.xml")
@EditedEntityContainer("autoserviceDc")
@LoadDataBeforeShow
public class AutoserviceEdit extends StandardEditor<Autoservice> {
}