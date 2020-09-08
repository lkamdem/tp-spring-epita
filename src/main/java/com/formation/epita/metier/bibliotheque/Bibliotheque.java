package com.formation.epita.metier.bibliotheque;

import com.formation.epita.metier.bibliotheque.livre.Livre;
import com.formation.epita.metier.ddd.DDD;

import java.util.ArrayList;
import java.util.List;

@DDD.Entity
public class Bibliotheque {

    private Long id;

    private String nomBibliotheque;

    private TypeBibliotheque typeBibliotheque;

    private Adresse adresse;

    private Directeur directeur;

    private List<Livre> livres = new ArrayList<>();


    public Bibliotheque(String nomBibliotheque, TypeBibliotheque typeBibliotheque, Adresse adresse) {
        this.nomBibliotheque = nomBibliotheque;
        this.typeBibliotheque = typeBibliotheque;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void identifierLaBibliotheque(Long id){
        this.id = id;
    }

    public String getNomBibliotheque() {
        return nomBibliotheque;
    }

    public TypeBibliotheque getTypeBibliotheque() {
        return typeBibliotheque;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Directeur getDirecteur() {
        return directeur;
    }

    public void modifierBibli(TypeBibliotheque nouveauType, Adresse nouvelleAdresse, Directeur nouveauDirecteur){
        if (nouveauType != null) {
            this.typeBibliotheque = nouveauType;
        }
        if (nouvelleAdresse != null) {
            this.adresse = nouvelleAdresse;
        }
        if (nouveauDirecteur != null){
            this.directeur = nouveauDirecteur;
        }
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void referencerLivre(Livre livre){
        this.livres.add(livre);
    }

    public void rebatiser(String nouveauNom){
        this.nomBibliotheque = nouveauNom;
    }

    public void nommmerDirecteur(Directeur directeur){
        this.directeur = directeur;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Bibliotheque.class){
            Bibliotheque monObjet = (Bibliotheque) obj;
            return (this.nomBibliotheque == monObjet.getNomBibliotheque() & this.directeur.equals(monObjet.getDirecteur())
                    & this.adresse.equals(monObjet.getAdresse()) & this.typeBibliotheque.ordinal() == monObjet.typeBibliotheque.ordinal()
                    & this.getLivres().equals(monObjet.getLivres()));
        }else{
            return false;
        }

    }
}
