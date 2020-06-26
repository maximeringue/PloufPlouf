package com.example.demo.transientobj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cours implements Serializable {

    public String idCours;

    public String nom;

    public List<String> lstMembre = new ArrayList<>();

    public String getIdCours() {
        return idCours;
    }

    public void setIdCours(String idCours) {
        this.idCours = idCours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
