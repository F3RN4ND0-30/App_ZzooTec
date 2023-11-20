package com.example.app_zzootec.model;

import java.util.Date;

public class Categoria {
    private String id;
    private String nombre;
    private Date creationDate;

    public Categoria(String id, String nombre, Date creationDate) {
        this.id = id;
        this.nombre = nombre;
        this.creationDate = creationDate;
    }

    public Categoria() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
