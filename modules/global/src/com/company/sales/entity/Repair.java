package com.company.sales.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@Table(name = "SALES_REPAIR")
@Entity(name = "sales_Repair")
@NamePattern("%s|name")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = -7697299695629445951L;

    @Column(name = "NAME")
    private String name;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOSERVICE")
    private Autoservice autoservice;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE")
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }



    public Autoservice getAutoservice() {
        return autoservice;
    }

    public void setAutoservice(Autoservice autoservice) {
        this.autoservice = autoservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}