package com.company.sales.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "SALES_PERSON")
@Entity(name = "sales_Person")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PERSON")
public class Person extends StandardEntity {
    private static final long serialVersionUID = -8134475750237255316L;


    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "BIRTH_DAY")
    private LocalDate birthDay;
    @JoinTable(name = "SALES_AUTOSERVICE_PERSON_LINK",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTOSERVICE_ID"))
    @ManyToMany
    private List<Autoservice> autoservices;

    public List<Autoservice> getAutoservices() {
        return autoservices;
    }

    public void setAutoservices(List<Autoservice> autoservices) {
        this.autoservices = autoservices;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}