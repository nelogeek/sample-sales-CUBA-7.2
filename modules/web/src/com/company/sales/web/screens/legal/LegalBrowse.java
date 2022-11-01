package com.company.sales.web.screens.legal;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Legal;

@UiController("sales_Legal.browse")
@UiDescriptor("legal-browse.xml")
@LookupComponent("legalsTable")
@LoadDataBeforeShow
public class LegalBrowse extends StandardLookup<Legal> {
}