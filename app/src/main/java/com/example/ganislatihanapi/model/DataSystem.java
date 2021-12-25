package com.example.ganislatihanapi.model;

import java.io.Serializable;
public class    DataSystem implements Serializable {
    String nameSystem, versi,  description, logo,developer,website,smodel;
    public DataSystem(String nameSystem, String versi, String description,String logo,String developer,String website,String smodel) {
        this.nameSystem = nameSystem;
        this.versi = versi;
        this.description = description;
        this.logo = logo;
        this.developer = developer;
        this.website = website;
        this.smodel = smodel;
    }

    public String getNameSystem() {
        return nameSystem;
    }

    public void setNameSystem(String namaSystem) {
        this.nameSystem= nameSystem;
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

