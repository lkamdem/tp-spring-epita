package com.formation.epita.infrastructure.bibliotheque;

import com.formation.epita.infrastructure.adresse.AdresseEntity;
import com.formation.epita.infrastructure.bibliotheque.livre.LivreEntity;
import com.formation.epita.infrastructure.directeur.DirecteurEntity;
import com.formation.epita.metier.bibliotheque.Adresse;
import com.formation.epita.metier.bibliotheque.Directeur;
import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import com.formation.epita.metier.bibliotheque.livre.Livre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BibliothequeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomBibliotheque;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private TypeBibliotheque typeBibliotheque;

    @Embedded
    private AdresseEntity adresse;

    @Embedded
    private DirecteurEntity directeur;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "bibliotheque_id", referencedColumnName = "id")
    private List<LivreEntity> livres = new ArrayList<>();


    public BibliothequeEntity() {
    }

    public BibliothequeEntity(String nomBibliotheque, TypeBibliotheque typeBibliotheque, AdresseEntity adresse) {
        this.id = id;
        this.nomBibliotheque = nomBibliotheque;
        this.typeBibliotheque = typeBibliotheque;
        this.adresse = adresse;
    }

    public String getNomBibliothe() {
        return nomBibliotheque;
    }

    public void setNomBibliothe(String nomBibliothe) {
        this.nomBibliotheque = nomBibliothe;
    }

    public Long getId() {
        return id;
    }

    public TypeBibliotheque getTypeBibliotheque() {
        return typeBibliotheque;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public DirecteurEntity getDirecteur() {
        return directeur;
    }

    public List<LivreEntity> getLivres() {
        return livres;
    }


    public void setNomBibliotheque(String nomBibliotheque) {
        this.nomBibliotheque = nomBibliotheque;
    }

    public void setTypeBibliotheque(TypeBibliotheque typeBibliotheque) {
        this.typeBibliotheque = typeBibliotheque;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }

    public void setDirecteur(DirecteurEntity directeur) {
        this.directeur = directeur;
    }

    public void setLivres(List<LivreEntity> livres) {
        this.livres = livres;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
