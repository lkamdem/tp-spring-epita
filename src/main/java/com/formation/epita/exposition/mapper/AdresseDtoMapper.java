package com.formation.epita.exposition.mapper;

import com.formation.epita.exposition.AdresseDTO;
import com.formation.epita.metier.bibliotheque.Adresse;
import org.springframework.stereotype.Component;

@Component
public class AdresseDtoMapper extends AbstractDtoMapper<AdresseDTO,Adresse> {


    public Adresse mapToDomaine(AdresseDTO adresseDTO){
        return new Adresse(adresseDTO.getNumeroRue(),adresseDTO.getNomRue(),adresseDTO.getCodePostal(),adresseDTO.getVille());
    }

    public AdresseDTO mapToDTO(Adresse adresse){
        return new AdresseDTO(adresse.getNumeroRue(), adresse.getNomRue(), adresse.getCodePostal(),adresse.getVille());
    }


}
