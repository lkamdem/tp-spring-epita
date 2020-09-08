package com.formation.epita.infrastructure.directeur;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class DirecteurEntity {

    @Column(name = "nom_directeur")
    private String nom;

    @Column(name = "prenom_directeur")
    private String prenom;


    public DirecteurEntity() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
