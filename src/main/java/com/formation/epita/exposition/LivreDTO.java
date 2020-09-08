package com.formation.epita.exposition;

import com.formation.epita.metier.bibliotheque.livre.GenreLitterature;
import jdk.nashorn.internal.objects.annotations.Getter;

public class LivreDTO {

    final String titre;
    final String auteur;

    final GenreLitterature genreLitterature;

    public LivreDTO(String titre, String auteur, GenreLitterature genreLitterature) {
        this.titre = titre;
        this.auteur = auteur;
        this.genreLitterature = genreLitterature;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public GenreLitterature getGenreLitterature() {
        return genreLitterature;
    }
}
