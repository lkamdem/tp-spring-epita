package com.formation.epita.infrastructure.bibliotheque;

import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IBibliothequeDAO extends JpaRepository<BibliothequeEntity, Long> {

    List<BibliothequeEntity> findByTypeBibliotheque(TypeBibliotheque typeBibliotheque);

    @Query("SELECT b FROM BibliothequeEntity b WHERE b.directeur.nom = ?1")
    BibliothequeEntity searchByNom_Directeur(String nom);


    @Query(value = "select * from Bibliotheque_Entity where prenom_directeur = :prenom", nativeQuery = true)
    BibliothequeEntity searchByPrenom_DirecteurNativeQuery(String prenom);


     Optional<BibliothequeEntity> findByNomBibliotheque(String nomBibliotheque);

     @Query(value = "select * from Bibliotheque_Entity where nom_bibliotheque like %:nom%", nativeQuery = true)
     Optional<BibliothequeEntity> customSearchByName(@Param("nom") String nom);
}

