package com.formation.epita.infrastructure.mapper;

import com.formation.epita.infrastructure.directeur.DirecteurEntity;
import com.formation.epita.metier.bibliotheque.Directeur;
import com.formation.epita.metier.ddd.DDD;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DDD.InfrastructureService
public class DirecteurEntityMapper extends AbstractEntityMapper<DirecteurEntity, Directeur> {


    @Override
    public List<DirecteurEntity> mapListToEntity(List<Directeur> listDomaine) {
        return super.mapListToEntity(listDomaine);
    }

    @Override
    public List<Directeur> mapListToDomaine(List<DirecteurEntity> listDomaine) {
        return super.mapListToDomaine(listDomaine);
    }

    @Override
    public DirecteurEntity mapToEntity(Directeur objectDuDomaine) {
        DirecteurEntity directeurEntity = new DirecteurEntity();
        directeurEntity.setNom(objectDuDomaine.getNom());
        directeurEntity.setPrenom(objectDuDomaine.getPrenom());
        return directeurEntity;
    }

    @Override
    public Directeur mapToDomaine(DirecteurEntity objectEntity) {
        return new Directeur(objectEntity.getNom(), objectEntity.getPrenom());
    }
}
