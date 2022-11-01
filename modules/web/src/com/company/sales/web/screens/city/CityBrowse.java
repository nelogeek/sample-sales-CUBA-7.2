package com.company.sales.web.screens.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.City;

@UiController("sales_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow

public class CityBrowse extends StandardLookup<City> {



}