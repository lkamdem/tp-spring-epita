package com.formation.epita.metier.bibliotheque.livre;

import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.ddd.DDD;


import java.util.List;

@DDD.Entity
public class Livre {

    private Long id;
    private String titre;
    private String auteur;
    private int nombreDePage;

    private GenreLitterature genreLitterature;

    private List<Bibliotheque> bibliotheques;


    public Livre(String titre, String auteur, GenreLitterature genreLitterature) {
        this.titre = titre;
        this.auteur = auteur;
        this.genreLitterature = genreLitterature;
    }


    public Long getId() {
        return id;
    }

    public void identitierLeLivre(Long id){
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNombreDePage() {
        return nombreDePage;
    }

    public GenreLitterature getGenreLitterature() {
        return genreLitterature;
    }

    public List<Bibliotheque> getBibliotheques() {
        return bibliotheques;
    }

    public void diffuserA(Bibliotheque bibliotheque){
        this.bibliotheques.add(bibliotheque);
    }

    public void completerInformationLivre(int nombreDePage){
        this.nombreDePage = nombreDePage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Livre.class){
            Livre monObjet = (Livre) obj;
            return (this.titre == monObjet.getTitre() & this.auteur == monObjet.getAuteur()
                    & this.genreLitterature.ordinal() == monObjet.getGenreLitterature().ordinal()
            & this.nombreDePage == monObjet.getNombreDePage());
        } else{
            return false;
        }
    }
}
