package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementType();

    ElementType getById(Integer id);

    ElementType saveElementType(ElementType elementTypeName);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);


    //custom repository methods
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);



}



