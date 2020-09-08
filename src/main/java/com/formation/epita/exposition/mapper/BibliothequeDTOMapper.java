package com.formation.epita.exposition.mapper;

import com.formation.epita.exposition.BibliothequeDTO;
import com.formation.epita.exposition.LivreDTO;
import com.formation.epita.metier.bibliotheque.Bibliotheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BibliothequeDTOMapper extends AbstractDtoMapper<BibliothequeDTO, Bibliotheque> {

    @Autowired
    AdresseDtoMapper monAdresseDTOMapper;

    @Autowired
    LivreDtoMapper monLivreDTOMapper;

    public Bibliotheque mapToDomaine(BibliothequeDTO bibliothequeDTO) {
        Bibliotheque maBibliothequeDuDomaine = new Bibliotheque(bibliothequeDTO.getNomBibliotheque(), bibliothequeDTO.getTypeBibliotheque(),
                monAdresseDTOMapper.mapToDomaine(bibliothequeDTO.getAdresseDTO()));


        for (LivreDTO livreDto : bibliothequeDTO.getLivres()) {
            maBibliothequeDuDomaine.referencerLivre(monLivreDTOMapper.mapToDomaine(livreDto));
        }
//            bibliothequeDTO.getLivres().stream().map(
//                    e -> maBibliothequeDuDomaine.referencerLivre(monLivreDTOMapper.mapToDomaine(e))
//            );


        return maBibliothequeDuDomaine;
    }

    public BibliothequeDTO mapToDTO(Bibliotheque bibliotheque){
        return new BibliothequeDTO(bibliotheque.getNomBibliotheque(), bibliotheque.getTypeBibliotheque()
                ,monAdresseDTOMapper.mapToDTO(bibliotheque.getAdresse()), monLivreDTOMapper.mapLisToDTO(bibliotheque.getLivres()));

    }

    public List<BibliothequeDTO> mapToListDTO(List<Bibliotheque> listBibliotheque){
        return listBibliotheque.stream().map(
                e -> mapToDTO(e)
        ).collect(Collectors.toList());
    }

}
