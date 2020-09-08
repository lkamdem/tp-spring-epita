package com.formation.epita.metier.bibliotheque;

import com.formation.epita.metier.ddd.DDD;

@DDD.ValueObject
public class Adresse {


    private int numeroRue;


    private String nomRue;

    private int codePostal;

    private String ville;

    public Adresse(int numeroRue, String nomRue, int codePostal, String ville) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getNumeroRue() {
        return numeroRue;
    }


    public String getNomRue() {
        return nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Adresse.class){
            return false;
        } else {
            Adresse monObjet = (Adresse) obj;
            return (this.numeroRue == monObjet.getNumeroRue() & this.nomRue == monObjet.getNomRue() &
                    this.codePostal == monObjet.getCodePostal() & this.ville == monObjet.getVille());
        }
    }
}
