package com.company.sales.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "SALES_CITY")
@Entity(name = "sales_City")
@NamePattern("%s|name")
public class City extends StandardEntity {
    private static final long serialVersionUID = 8967926253253479965L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEFAULT_CITY")
    private Boolean default_city;

    @Column(name = "CODE")
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setDefault_city(Boolean default_city) {
        this.default_city = default_city;
    }

    public Boolean getDefault_city() {
        return default_city;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPhone_number() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}