package com.formation.epita.services;

import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.bibliotheque.IBibliothequeRepo;
import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import com.formation.epita.metier.ddd.DDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DDD.ApplicationService
public class BibliothequeService implements IServiceBibliotheque {


    @Autowired
    IBibliothequeRepo bibliothequeRepo;

    @Override
    public void enregistrer(Bibliotheque bibliotheque) {
        bibliothequeRepo.enregistrerBibliotheque(bibliotheque);
    }

    @Override
    public Bibliotheque lireInfoBibliotheque(String nomBibliotheque) {
        return bibliothequeRepo.readBibliothequeByName(nomBibliotheque);
    }

    @Override
    public Bibliotheque rechercheBibliParNomDirecteur(String nom) {
        return bibliothequeRepo.rechercheParNom(nom);
    }

    @Override
    public void modifierBibliotheque(Bibliotheque bibliotheque) {
//        Bibliotheque bibliothequeAModifier = bibliothequeDAO.findById(bibliotheque.getId()).orElseThrow(
//                () -> new RuntimeException("La bibliotheque à modifier n'existe pas")
//        );

//        Bibliotheque bibliothequeAModifier = bibliothequeDAO.searchByNom_Directeur(bibliotheque.getDirecteur().getNom());
        Bibliotheque bibliothequeAModifier = bibliothequeRepo.readBibliothequeByName(bibliotheque.getNomBibliotheque());

        bibliothequeAModifier.modifierBibli(bibliotheque.getTypeBibliotheque(), bibliotheque.getAdresse(), bibliotheque.getDirecteur());
        enregistrer(bibliothequeAModifier);
//        bibliothequeDAO.save(bibliothequeAModifier);

    }

    @Override
    public Bibliotheque rechercheBibliParPrenomDirecteur(String prenom) {
        return bibliothequeRepo.rechercheParPrenom(prenom);
    }

    @Override
    public void supprimer(String nomBibliotheque) {

        Bibliotheque bibliothequetrouve = bibliothequeRepo.readBibliothequeByName(nomBibliotheque);
        bibliothequeRepo.supprimerBibliotheque(bibliothequetrouve);

//        if (bibliothequetrouve.isPresent()){
//            bibliothequeDAO.delete(bibliothequetrouve.get());
//        } else {
//            throw new RuntimeException("La bibliothèque à supprimer n'existe pas");
//        }
    }

    @Override
    public List<Bibliotheque> listerBibliothequeParType(String typeBibliotheque) {
        TypeBibliotheque typeDemande;
        switch (typeBibliotheque.toUpperCase()){
            case "ASSOCIATIVE":
            typeDemande = TypeBibliotheque.ASSOCIATIVE;
            break;
            case "SCOLAIRE":
                typeDemande = TypeBibliotheque.SCOLAIRE;
                break;
            case "NATIONALE":
                typeDemande = TypeBibliotheque.NATIONALE;
                break;
            case "PUBLIQUE":
                typeDemande = TypeBibliotheque.PUBLIQUE;
                break;
            case "UNIVERITAIRE":
                typeDemande = TypeBibliotheque.UNIVERSITAIRE;
                break;
            default:
                typeDemande = TypeBibliotheque.PUBLIQUE;
                break;
    }
        return bibliothequeRepo.rechercheBibliothequeParType(typeDemande);

    }
}
