package com.formation.epita.infrastructure.bibliotheque;

import com.formation.epita.infrastructure.mapper.BibliothequeEntityMapper;
import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.bibliotheque.IBibliothequeRepo;
import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import com.formation.epita.metier.ddd.DDD;
import com.formation.epita.metier.exception.BibliothequeNontrouveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@DDD.RepositoryImpl
public class BibliothequeRepository implements IBibliothequeRepo {

    @Autowired
    IBibliothequeDAO bibliothequeDAO;

    @Autowired
    BibliothequeEntityMapper bibliothequeEntityMapper;

    @Override
    public Bibliotheque rechercheParNom(String nom) {
        return bibliothequeEntityMapper.mapToDomain(bibliothequeDAO.searchByNom_Directeur(nom));
    }

    @Override
    public Bibliotheque readBibliothequeByName(String nomBibliotheque) {
        return bibliothequeEntityMapper.mapToDomain(bibliothequeDAO.customSearchByName(nomBibliotheque).orElseThrow(
                () -> new BibliothequeNontrouveException("La bibliotheque demandé n'existe pas")
        ));
    }

    @Override
    public void enregistrerBibliotheque(Bibliotheque bibliotheque) {
        BibliothequeEntity bibliothequeEntityAEnregistrer = bibliothequeEntityMapper.mapToEntity(bibliotheque);
        bibliothequeDAO.save(bibliothequeEntityAEnregistrer);
    }

    @Override
    public Bibliotheque rechercheParPrenom(String prenom) {
        return bibliothequeEntityMapper.mapToDomain(bibliothequeDAO.searchByPrenom_DirecteurNativeQuery(prenom));
    }


    @Override
    public void supprimerBibliotheque(Bibliotheque bibliotheque) {
        bibliothequeDAO.delete(bibliothequeEntityMapper.mapToEntity(bibliotheque));
    }

    @Override
    public List<Bibliotheque> rechercheBibliothequeParType(TypeBibliotheque type) {
        List<BibliothequeEntity> listEntity = bibliothequeDAO.findByTypeBibliotheque(type);

        return listEntity.stream()
                .map(element -> bibliothequeEntityMapper.mapToDomain(element))
                .collect(Collectors.toList());
    }
}
