package com.company.sales.web.screens.individuals;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Individuals;

@UiController("sales_Individuals.browse")
@UiDescriptor("individuals-browse.xml")
@LookupComponent("individualsesTable")
@LoadDataBeforeShow
public class IndividualsBrowse extends StandardLookup<Individuals> {
}