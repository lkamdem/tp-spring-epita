package com.formation.epita.infrastructure.mapper;

import com.formation.epita.infrastructure.bibliotheque.livre.LivreEntity;
import com.formation.epita.metier.bibliotheque.livre.Livre;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractEntityMapper<T,K> {

    public T mapToEntity(K objectDuDomaine){
        return null;
    }

    public K mapToDomaine(T objectEntity){
        return null;
    }


    public List<T> mapListToEntity(List<K> listDomaine) {
        return listDomaine.stream().map(e -> mapToEntity(e) ).collect(Collectors.toList());
    }

    public List<K> mapListToDomaine(List<T> listDomaine) {
        return listDomaine.stream().map(e -> mapToDomaine(e) ).collect(Collectors.toList());
    }
}
