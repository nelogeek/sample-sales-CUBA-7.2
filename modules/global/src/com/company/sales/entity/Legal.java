package com.company.sales.entity;

import javax.persistence.*;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("LEGAL")
@Table(name = "SALES_LEGAL")
@Entity(name = "sales_Legal")
public class Legal extends Person {
    private static final long serialVersionUID = -2499778906237903039L;

    @Column(name = "POLE_LEGAL")
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}