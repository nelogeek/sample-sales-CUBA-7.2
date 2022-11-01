package com.company.sales.service;

import com.company.sales.entity.City;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import javax.inject.Inject;


@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private DataManager dataManager;
    @Inject
    private CityService cityService;

    @Override
    public City getDefaultCity() {
        City city = dataManager.load(City.class).query("select e from sales_City e where e.default_city = TRUE").one();

        return dataManager.commit(city);
    }

    @Override
    public void resetDefaultCity(Boolean check) {
        try {
            if (Boolean.TRUE.equals(check)){
                while (Boolean.TRUE.equals(cityService.getDefaultCity().getDefault_city())){
                    City city = cityService.getDefaultCity();
                    city.setDefault_city(false);
                    dataManager.commit(city);
                }
            }
        }
        catch (Exception ignored){}
    }

}