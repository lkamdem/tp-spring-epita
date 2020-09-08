package com.formation.epita.metier.bibliotheque;

import com.formation.epita.metier.ddd.DDD;

import java.util.List;

@DDD.Repository
public interface IBibliothequeRepo {

    void enregistrerBibliotheque(Bibliotheque bibliotheque);

//    Bibliotheque readBibliothequeById(Long id);

    void supprimerBibliotheque(Bibliotheque bibliotheque);

    List<Bibliotheque> rechercheBibliothequeParType(TypeBibliotheque type);

    Bibliotheque rechercheParPrenom(String prenom);

    Bibliotheque rechercheParNom (String nom);

    Bibliotheque readBibliothequeByName(String nomBibliotheque);
}
