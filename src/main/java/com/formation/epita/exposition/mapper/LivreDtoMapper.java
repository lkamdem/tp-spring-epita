package com.formation.epita.exposition.mapper;

import com.formation.epita.exposition.LivreDTO;
import com.formation.epita.metier.bibliotheque.livre.Livre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivreDtoMapper extends AbstractDtoMapper<LivreDTO, Livre> {

    @Override
    public Livre mapToDomaine(LivreDTO objetDto) {
        return new Livre(objetDto.getTitre(), objetDto.getAuteur(), objetDto.getGenreLitterature());
    }

    @Override
    public LivreDTO mapToDTO(Livre objetDomaine) {
        return new LivreDTO(objetDomaine.getTitre(), objetDomaine.getAuteur(), objetDomaine.getGenreLitterature());
    }

    @Override
    public List<Livre> mapLisToDomaine(List<LivreDTO> listDTO) {
        return listDTO.stream().map(e -> mapToDomaine(e)
        ).collect(Collectors.toList());
    }

    @Override
    public List<LivreDTO> mapLisToDTO(List<Livre> listDTO) {
        return listDTO.stream().map(e -> mapToDTO(e)
        ).collect(Collectors.toList());
    }
}
