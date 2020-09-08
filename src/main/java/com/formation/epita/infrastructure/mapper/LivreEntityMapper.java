package com.formation.epita.infrastructure.mapper;

import com.formation.epita.infrastructure.bibliotheque.livre.LivreEntity;
import com.formation.epita.metier.bibliotheque.livre.Livre;
import com.formation.epita.metier.ddd.DDD;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DDD.InfrastructureService
public class LivreEntityMapper extends AbstractEntityMapper<LivreEntity, Livre> {

    @Override
    public LivreEntity mapToEntity(Livre objectDuDomaine) {
        LivreEntity livreEntity = new LivreEntity(objectDuDomaine.getTitre(), objectDuDomaine.getAuteur(), objectDuDomaine.getGenreLitterature());
        livreEntity.setId(objectDuDomaine.getId());
        livreEntity.setNombreDePage(objectDuDomaine.getNombreDePage());
        return livreEntity;
    }

    @Override
    public Livre mapToDomaine(LivreEntity objectEntity) {
        Livre livre = new Livre(objectEntity.getTitre(), objectEntity.getAuteur(), objectEntity.getGenreLitterature());
        livre.identitierLeLivre(objectEntity.getId());
        livre.completerInformationLivre(objectEntity.getNombreDePage());
        return livre;
    }

    @Override
    public List<LivreEntity> mapListToEntity(List<Livre> listDomaine) {
        return super.mapListToEntity(listDomaine);
    }

    @Override
    public List<Livre> mapListToDomaine(List<LivreEntity> listDomaine) {
        return super.mapListToDomaine(listDomaine);
    }
}
