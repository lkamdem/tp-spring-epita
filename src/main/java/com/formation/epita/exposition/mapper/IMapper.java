package com.formation.epita.exposition.mapper;

import java.util.List;

public interface IMapper<T,K> {

    K mapToDomain(T objetDto);

    T mapToDTO(K objetDomaine);

    List<K> mapLisToDomaine(List<T> listDTO);

    List<T> mapLisToDTO(List<K> listDTO);
}
