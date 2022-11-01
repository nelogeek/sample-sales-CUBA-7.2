package com.company.sales.entity;

import javax.persistence.*;

@Table(name = "SALES_INDIVIDUALS")
@Entity(name = "sales_Individuals")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("INDIVIDUALS")
public class Individuals extends Person {
    private static final long serialVersionUID = -7798049629464532788L;

    @Column(name = "POLE_INDIVIDUALS")
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}