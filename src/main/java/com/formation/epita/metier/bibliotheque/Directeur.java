package com.formation.epita.metier.bibliotheque;


import com.formation.epita.metier.ddd.DDD;



@DDD.ValueObject
public class Directeur {


    private String nom;

    private String prenom;

    public Directeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Directeur.class){
            return false;
        } else {
            Directeur monObjet = (Directeur) obj;
            return (this.nom == monObjet.getNom() & this.prenom == monObjet.getPrenom());
        }
    }
}
