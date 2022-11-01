package com.company.sales.web.screens.legal;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Legal;

@UiController("sales_Legal.edit")
@UiDescriptor("legal-edit.xml")
@EditedEntityContainer("legalDc")
@LoadDataBeforeShow
public class LegalEdit extends StandardEditor<Legal> {
}