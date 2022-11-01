package com.company.sales.web.screens.individuals;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Individuals;

@UiController("sales_Individuals.edit")
@UiDescriptor("individuals-edit.xml")
@EditedEntityContainer("individualsDc")
@LoadDataBeforeShow
public class IndividualsEdit extends StandardEditor<Individuals> {
}