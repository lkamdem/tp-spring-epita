package com.formation.epita.infrastructure;

import com.formation.epita.infrastructure.bibliotheque.BibliothequeRepository;
import com.formation.epita.infrastructure.mapper.AdresseEntityMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BibliothequeRepositoryTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BibliothequeRepository bibliothequeRepository;

    @Autowired
    AdresseEntityMapper adresseEntityMapper;

//    @Test
//    @DisplayName("rechercheParNom retourne un objet bibliotheque dont le nom contient le nom transmis")
//    public void test1(){
//        //given
//        Adresse adresse = new Adresse(6,"aller des cerisiers",93130, "noisy le sec");
//        Bibliotheque bibliotheque = new Bibliotheque("Francois Mitterand", TypeBibliotheque.NATIONALE,adresse);
//        BibliothequeEntity bibliothequeEntity = new BibliothequeEntity("Francois Mitterand", TypeBibliotheque.NATIONALE,
//                adresseEntityMapper.mapToEntity(adresse));
//        BibliothequeEntity bibliothequeEntityPersiste = entityManager.persist(bibliothequeEntity);
//        //when
//        bibliothequeRepository.rechercheParNom("Francois");
//
//        //then
//        assertThat(bibliothequeEntityPersiste.getNomBibliothe()).contains("Francois");
//
//    }
}
