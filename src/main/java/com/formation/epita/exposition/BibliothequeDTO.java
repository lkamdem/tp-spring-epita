package com.formation.epita.exposition;


import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BibliothequeDTO {

    @Size(max = 6)
    final String nomBibliotheque;

    final TypeBibliotheque typeBibliotheque;

    @NotNull(message = "toto")
    final AdresseDTO adresseDTO;

    final List<LivreDTO> livres;

    public BibliothequeDTO(String nomBibliotheque, TypeBibliotheque typeBibliotheque,  AdresseDTO adresseDTO, List<LivreDTO> livres) {
        this.nomBibliotheque = nomBibliotheque;
        this.typeBibliotheque = typeBibliotheque;
        this.adresseDTO = adresseDTO;
        this.livres = livres;
    }


    public String getNomBibliotheque() {
        return nomBibliotheque;
    }

    public TypeBibliotheque getTypeBibliotheque() {
        return typeBibliotheque;
    }

    public AdresseDTO getAdresseDTO() {
        return adresseDTO;
    }

    public List<LivreDTO> getLivres() {
        return livres;
    }

}
