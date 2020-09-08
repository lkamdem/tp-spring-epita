package com.formation.epita.exposition.mapper;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractDtoMapper<T,K> {

    K mapToDomaine(T objetDto){
        return null;
    }

    T mapToDTO(K objetDomaine){
        return null;
    }

    List<K> mapLisToDomaine(List<T> listDTO){
        return listDTO.stream().map(e -> mapToDomaine(e)
        ).collect(Collectors.toList());
    }

    List<T> mapLisToDTO(List<K> listDTO){
        return listDTO.stream().map(e -> mapToDTO(e)
        ).collect(Collectors.toList());
    }
}
