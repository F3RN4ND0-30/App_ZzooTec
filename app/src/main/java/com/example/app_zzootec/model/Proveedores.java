package com.example.app_zzootec.model;

import java.util.Date;
import java.util.List;

public class Proveedores {

    private Long id;
    private String name;
    private String contact;
    private String identifierFiscal;
    private String type;
    private String bankInformation;
    private List<String> paymentTerms;
    private List<String> products;
    private List<String> purchases;
    private Boolean status;
    private List<String> notes;

    public Proveedores() {
    }

    public Proveedores(Long id, String name, String contact, String identifierFiscal, String type, String bankInformation, List<String> paymentTerms, List<String> products, List<String> purchases, Boolean status, List<String> notes) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.identifierFiscal = identifierFiscal;
        this.type = type;
        this.bankInformation = bankInformation;
        this.paymentTerms = paymentTerms;
        this.products = products;
        this.purchases = purchases;
        this.status = status;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdentifierFiscal() {
        return identifierFiscal;
    }

    public void setIdentifierFiscal(String identifierFiscal) {
        this.identifierFiscal = identifierFiscal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankInformation() {
        return bankInformation;
    }

    public void setBankInformation(String bankInformation) {
        this.bankInformation = bankInformation;
    }

    public List<String> getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(List<String> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<String> purchases) {
        this.purchases = purchases;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
