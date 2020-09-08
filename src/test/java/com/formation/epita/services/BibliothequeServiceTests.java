package com.formation.epita.services;

import com.formation.epita.metier.bibliotheque.Adresse;
import com.formation.epita.metier.bibliotheque.Bibliotheque;
import com.formation.epita.metier.bibliotheque.IBibliothequeRepo;
import com.formation.epita.metier.bibliotheque.TypeBibliotheque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;

@SpringBootTest
public class BibliothequeServiceTests {

    @MockBean
    IBibliothequeRepo bibliothequeRepo;

    @Autowired
    BibliothequeService bibliothequeService;

    @Test
    @DisplayName("enregistrer appelle le repo avec un objet type Bibliotheque")
    public void test1(){
        //given
        Adresse adresse = new Adresse(6, "allee des cerisiers",93130,"noisyle sec");
        Bibliotheque bibliotheque = new Bibliotheque("Francois Mitterand", TypeBibliotheque.NATIONALE,adresse);

        Mockito.doNothing().when(bibliothequeRepo).enregistrerBibliotheque(any(Bibliotheque.class));

        ArgumentCaptor<Bibliotheque> valueCapture = ArgumentCaptor.forClass(Bibliotheque.class);

        //when
            bibliothequeService.enregistrer(bibliotheque);
        //then
        Mockito.verify(bibliothequeRepo).enregistrerBibliotheque(valueCapture.capture());
        assertThat(valueCapture.getValue()).isInstanceOf(Bibliotheque.class);
    }

    @Test
    @DisplayName("lireBibliotheque retourne la bibliotheque correspondant au nom fourni")
    public void test2(){
        //given
        Adresse adresse = new Adresse(6, "allee des cerisiers",93130,"noisyle sec");
        Bibliotheque bibliotheque = new Bibliotheque("Francois Mitterand", TypeBibliotheque.NATIONALE,adresse);

        Mockito.when(bibliothequeRepo.readBibliothequeByName("Francois")).thenReturn(bibliotheque);

        //when
        Bibliotheque bibliothequeLu = bibliothequeService.lireInfoBibliotheque("Francois");

        //then
        assertThat(bibliothequeLu.getNomBibliotheque()).contains("Francois");

    }

    @Test
    @DisplayName("modifierBibliotheque appelle le repo.save avec un objet Bibliotheque contenant un id")
    public void test3(){
        //given
        Adresse adresse = new Adresse(6, "allee des cerisiers",93130,"noisyle sec");
        Bibliotheque bibliotheque = new Bibliotheque("Francois Mitterand", TypeBibliotheque.SCOLAIRE,adresse);

        Bibliotheque bibliothequeFull = new Bibliotheque("Francois Mitterand", TypeBibliotheque.NATIONALE,adresse);
        bibliothequeFull.identifierLaBibliotheque(1L);

        Mockito.when(bibliothequeRepo.readBibliothequeByName(any(String.class))).thenReturn(bibliothequeFull);

        ArgumentCaptor<Bibliotheque> valueCapture = ArgumentCaptor.forClass(Bibliotheque.class);

        //when
        bibliothequeService.modifierBibliotheque(bibliotheque);

        //then
        Mockito.verify(bibliothequeRepo).enregistrerBibliotheque(valueCapture.capture());
        assertThat(valueCapture.getValue().getId()).isEqualTo(1L);

    }

    @Test
    @DisplayName("modifierBibliotheque commence par rechercher la bibliotheque qu'on souhaite modifier")
    public void test4(){
        //given
        Adresse adresse = new Adresse(6, "allee des cerisiers",93130,"noisyle sec");
        Bibliotheque bibliotheque = new Bibliotheque("Francois Mitterand", TypeBibliotheque.SCOLAIRE,adresse);

        Bibliotheque bibliothequeFull = new Bibliotheque("Francois Mitterand", TypeBibliotheque.NATIONALE,adresse);
        bibliothequeFull.identifierLaBibliotheque(1L);

        InOrder inOrder = inOrder(bibliothequeRepo);

        Mockito.doNothing().when(bibliothequeRepo).enregistrerBibliotheque(any(Bibliotheque.class));
        Mockito.when(bibliothequeRepo.readBibliothequeByName(any(String.class))).thenReturn(bibliothequeFull);

        //when
        bibliothequeService.modifierBibliotheque(bibliotheque);
        //then
        inOrder.verify(bibliothequeRepo).readBibliothequeByName(any(String.class));
        inOrder.verify(bibliothequeRepo).enregistrerBibliotheque(any(Bibliotheque.class));
    }
}
