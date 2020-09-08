package com.formation.epita.infrastructure.bibliotheque.livre;

import com.formation.epita.infrastructure.bibliotheque.BibliothequeEntity;
import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.bibliotheque.livre.GenreLitterature;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LivreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;
    private int nombreDePage;

    @Enumerated(EnumType.STRING)
    private GenreLitterature genreLitterature;

//    @OneToMany(/*cascade = CascadeType.ALL, orphanRemoval = true,*/ fetch = FetchType.LAZY)
//    @JoinColumn(name = "livre_id", referencedColumnName = "id")
//    private List<BibliothequeEntity> bibliotheques = new ArrayList<>();

    public LivreEntity() {
    }

    public LivreEntity(String titre, String auteur, GenreLitterature genreLitterature) {
        this.titre = titre;
        this.auteur = auteur;
        this.genreLitterature = genreLitterature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public List<BibliothequeEntity> getBibliotheques() {
//        return bibliotheques;
//    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNombreDePage(int nombreDePage) {
        this.nombreDePage = nombreDePage;
    }

    public void setGenreLitterature(GenreLitterature genreLitterature) {
        this.genreLitterature = genreLitterature;
    }

//    public void setBibliotheques(List<BibliothequeEntity> bibliotheques) {
//        this.bibliotheques = bibliotheques;
//    }
}
