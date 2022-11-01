package com.company.sales.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "SALES_EMPLOYEE")
@Entity(name = "sales_Employee")
@NamePattern("%s %s|last_name,first_name")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = -9039757987005485482L;

    @Column(name = "LAST_NAME", nullable = false)
    @NotNull
    private String last_name;

    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    private String first_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOSERVICE_ID")
    private Autoservice autoservice;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "EMAIL")
    @Email
    private String email;

    public Autoservice getAutoservice() {
        return autoservice;
    }

    public void setAutoservice(Autoservice autoservice) {
        this.autoservice = autoservice;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}