package com.formation.epita.infrastructure.mapper;

import com.formation.epita.infrastructure.adresse.AdresseEntity;
import com.formation.epita.metier.bibliotheque.Adresse;
import com.formation.epita.metier.ddd.DDD;
import org.springframework.stereotype.Component;

@Component
@DDD.InfrastructureService
public class AdresseEntityMapper extends AbstractEntityMapper<AdresseEntity, Adresse> {
    @Override
    public AdresseEntity mapToEntity(Adresse objectDuDomaine) {
        AdresseEntity adresseEntity = new AdresseEntity();
        adresseEntity.setNumeroRue(objectDuDomaine.getNumeroRue());
        adresseEntity.setNomRue(objectDuDomaine.getNomRue());
        adresseEntity.setCodePostal(objectDuDomaine.getCodePostal());
        adresseEntity.setVille(objectDuDomaine.getVille());
        return adresseEntity;
    }

    @Override
    public Adresse mapToDomaine(AdresseEntity objectEntity) {
        return new Adresse(objectEntity.getNumeroRue(), objectEntity.getNomRue(),
                objectEntity.getCodePostal(), objectEntity.getVille());
    }
}
