package com.company.sales.web.screens.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Repair;

@UiController("sales_Repair.browse")
@UiDescriptor("repair-browse.xml")
@LookupComponent("repairsTable")
@LoadDataBeforeShow
public class RepairBrowse extends StandardLookup<Repair> {
}