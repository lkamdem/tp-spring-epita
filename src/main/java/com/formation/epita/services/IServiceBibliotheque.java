package com.formation.epita.services;

import com.formation.epita.metier.bibliotheque.Bibliotheque;

import java.util.List;

public interface IServiceBibliotheque {

    void enregistrer(Bibliotheque bibliotheque);

    List<Bibliotheque> listerBibliothequeParType(String typeBibliotheque);

   void supprimer(String nom);

   Bibliotheque lireInfoBibliotheque(String nom);

   void modifierBibliotheque(Bibliotheque bibliotheque);

   Bibliotheque rechercheBibliParPrenomDirecteur(String prenom);

   Bibliotheque rechercheBibliParNomDirecteur(String nom);
}
