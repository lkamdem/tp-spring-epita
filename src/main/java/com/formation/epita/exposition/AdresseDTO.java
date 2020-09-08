package com.formation.epita.exposition;


public class AdresseDTO {

    final int numeroRue;

    final String nomRue;

    final int codePostal;

    final String ville;

    public AdresseDTO(int numeroRue, String nomRue, int codePostal, String ville) {
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
}
