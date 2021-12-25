package com.example.ganislatihanapi.model;

import java.io.Serializable;
public class    DataSystem implements Serializable {
    String namaSystem, versi,  description, logo,developer,website,smodel;
    public DataSystem(String namaSystem, String versi, String description,String logo,String developer,String website,String smodel) {
        this.namaSystem = namaSystem;
        this.versi = versi;
        this.description = description;
        this.logo = logo;
        this.developer = developer;
        this.website = website;
        this.smodel = smodel;
    }

    public String getNamaSystem() {
        return namaSystem;
    }

    public void setNamaSystem(String namaSystem) {
        this.namaSystem= namaSystem;
    }

    public String getVersi() {
        return versi;
    }

    public void setVersi(String versi) {
        this.versi = versi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getSmodel() {
        return smodel;
    }

    public void setSmodel(String smodel) {
        this.smodel = smodel;
    }

}

