package com.example.ganislatihanapi.model;
import java.io.Serializable;
public class DataSystem implements Serializable {
    String nameSystem,  link,  description, logo;
    public DataSystem (String nameSystem,  String baca_lebih_lanjut, String description, String logo) {
        this.nameSystem = nameSystem;
        this.link = baca_lebih_lanjut;
        this.description = description;
        this.logo = logo;
    }

    public String getNameSystem() {
        return nameSystem;
    }

    public void setNameSystem(String nameSystem) {
        this.nameSystem= nameSystem;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

}



