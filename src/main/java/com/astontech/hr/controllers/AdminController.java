package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.services.ElementTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = Logger.getLogger(AdminController.class);


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {

        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model) {
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);
        saveElementTypeAndElementsFromVO(elementVO);

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementType());
        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getById(id);

        model.addAttribute("elementType", elementType);
        return "/admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }




    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType, Model model,
                                    @RequestParam("inputNewElement") String newElement) {
        //notes: check if newElement(unbound text box) has a value, add it to the list

        if(!newElement.equals("")) {
            elementType.getElementList().add(new Element(newElement));
        }
        //notes: iterate thru the list of elements
        for(int i=0; i<elementType.getElementList().size(); i++ ) {
            //check to see if element's name is empty
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                //notes: element name is blank, remove it from the list
                elementType.getElementList().remove(i);
            }
        }




        elementTypeService.saveElementType(elementType);
        return "redirect:/admin/element/edit/" + elementType.getId();
    }








    private void saveElementTypeAndElementsFromVO(ElementVO elementVO) {
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()) {
            newElementList.add(new Element(str));
        }

        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);
    }



    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());

        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }

    }


}
