package com.company.sales.web.screens.city;

import com.company.sales.service.CityService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.City;
import javax.inject.Inject;

@UiController("sales_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {

    @Inject
    private CityService cityService;
    @Inject
    private CheckBox default_cityField;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        cityService.resetDefaultCity(default_cityField.getValue());
    }

















}

