package com.formation.epita.infrastructure.adresse;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdresseEntity {

    @Column(name = "numero")
    private int numeroRue;

    @Column(name = "rue")
    private String nomRue;

    private int codePostal;

    private String ville;

    public AdresseEntity(int numeroRue, String nomRue, int codePostal, String ville) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public AdresseEntity() {
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
