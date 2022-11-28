package com.company.sales.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.management.ManagementFactory;
import java.util.List;

@Table(name = "SALES_AUTOSERVICE")
@Entity(name = "sales_Autoservice")
@NamePattern("%s|name")
public class Autoservice extends StandardEntity {
    private static final long serialVersionUID = 2342489254538074811L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinTable(name = "SALES_AUTOSERVICE_PERSON_LINK",
            joinColumns = @JoinColumn(name = "AUTOSERVICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
    @ManyToMany
    private List<Person> clients;

    @OneToMany(mappedBy = "autoservice")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    protected List<Employee> employees;

    @Column(name = "ADDRESS", nullable = false)
    @NotNull
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private City city;

    public List<Person> getClients() {
        return clients;
    }

    public void setClients(List<Person> clients) {
        this.clients = clients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}