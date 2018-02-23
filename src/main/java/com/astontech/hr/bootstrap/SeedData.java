package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateElementAndElementTypes();
    }

    private void generateElementAndElementTypes() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        ElementType phoneType = new ElementType("Phone");

        List<Element> elementList2 = new ArrayList<>();
        elementList2.add(new Element("Home"));
        elementList2.add(new Element("Work"));
        elementList2.add(new Element("Cell"));

        phoneType.setElementList(elementList2);

        elementTypeService.saveElementType(phoneType);

        ElementType emailType = new ElementType("Email");

        List<Element> elementList3 = new ArrayList<>();
        elementList3.add(new Element("Personal"));
        elementList3.add(new Element("Business"));
        elementList3.add(new Element("Family"));

        emailType.setElementList(elementList3);

        elementTypeService.saveElementType(emailType);

    }




}
