package com.formation.epita.infrastructure.mapper;


import com.formation.epita.infrastructure.bibliotheque.BibliothequeEntity;
import com.formation.epita.infrastructure.bibliotheque.livre.LivreEntity;
import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.bibliotheque.livre.Livre;
import com.formation.epita.metier.ddd.DDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DDD.InfrastructureService
public class BibliothequeEntityMapper {

    @Autowired
    DirecteurEntityMapper directeurMapper;

    @Autowired
    AdresseEntityMapper adresseMapper;

    @Autowired
    LivreEntityMapper livreEntityMapper;

    public Bibliotheque mapToDomain(BibliothequeEntity bibliothequeEntity){
        Bibliotheque bibliotheque = new Bibliotheque(bibliothequeEntity.getNomBibliothe(),bibliothequeEntity.getTypeBibliotheque(),
                adresseMapper.mapToDomaine(bibliothequeEntity.getAdresse()));
        bibliotheque.identifierLaBibliotheque(bibliothequeEntity.getId());
        if (bibliothequeEntity.getDirecteur() != null){
            bibliotheque.nommmerDirecteur(directeurMapper.mapToDomaine(bibliothequeEntity.getDirecteur()));
        }
        for (LivreEntity livre : bibliothequeEntity.getLivres()) {
            bibliotheque.referencerLivre(livreEntityMapper.mapToDomaine(livre));
        }
        return bibliotheque;
    }

    public BibliothequeEntity mapToEntity(Bibliotheque bibliotheque){
        BibliothequeEntity bibliothequeEntity = new BibliothequeEntity(bibliotheque.getNomBibliotheque(),bibliotheque.getTypeBibliotheque(),
                adresseMapper.mapToEntity(bibliotheque.getAdresse()));
        bibliothequeEntity.setId(bibliotheque.getId());
        if (bibliotheque.getDirecteur() != null){
            bibliothequeEntity.setDirecteur(directeurMapper.mapToEntity(bibliotheque.getDirecteur()));
        }
        bibliothequeEntity.setLivres(livreEntityMapper.mapListToEntity(bibliotheque.getLivres()));
        return bibliothequeEntity;
    }
}
