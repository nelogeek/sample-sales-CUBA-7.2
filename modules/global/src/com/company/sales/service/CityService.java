package com.company.sales.service;

import com.company.sales.entity.City;

import java.util.UUID;


public interface CityService {
    String NAME = "sales_CityService";


    City getDefaultCity();

    void resetDefaultCity(Boolean check);


}