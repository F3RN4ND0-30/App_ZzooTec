package com.example.app_zzootec.model;

import java.util.Date;
import java.util.List;

public class Ventas {

    private Long id;
    private Object user;
    private List<String> itemInvoiceEntities;
    private Date creationDate;

    public Ventas() {
    }

    public Ventas(Long id, Object user, List<String> itemInvoiceEntities, Date creationDate) {
        this.id = id;
        this.user = user;
        this.itemInvoiceEntities = itemInvoiceEntities;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public List<String> getItemInvoiceEntities() {
        return itemInvoiceEntities;
    }

    public void setItemInvoiceEntities(List<String> itemInvoiceEntities) {
        this.itemInvoiceEntities = itemInvoiceEntities;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
