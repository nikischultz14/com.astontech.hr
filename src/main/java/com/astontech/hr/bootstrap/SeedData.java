package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //generateElementAndElementTypes();
       // generateEmployeeAndProject();

        //generateContactAndAddress();
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

    private void generateEmployeeAndProject() {

        Employee employee1 = new Employee();
        employee1.setFirstName("Niki");
        employee1.setLastName("Schultz");
        employee1.setBackground("Java Developer");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Bipin");
        employee2.setLastName("Butala");
        employee2.setBackground("Java Developer as well");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Andy");
        employee3.setLastName("Reid");
        employee3.setBackground("DotNet Developer");
        employeeService.saveEmployee(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Tony");
        employee4.setLastName("Hawk");
        employee4.setBackground("Contact Center Engineer");
        employeeService.saveEmployee(employee4);


        Project project = new Project();
        project.setClientName("Target");
        project.setFieldRate(25);
        project.setProjectName("Develop New Database");
        projectService.saveProject(project);

        Project project1 = new Project();
        project1.setClientName("Best Buy");
        project1.setFieldRate(25);
        project1.setProjectName("Rewrite Database");
        projectService.saveProject(project1);

        Project project2 = new Project();
        project2.setClientName("Optum");
        project2.setFieldRate(30);
        project2.setProjectName("Work with Development Team");
        projectService.saveProject(project2);

        Project project3 = new Project();
        project3.setClientName("IBM");
        project3.setFieldRate(40);
        project3.setProjectName("Manage Development Team");
        projectService.saveProject(project3);





    }

    private void generateContactAndAddress() {

        Contact contact = new Contact();
        contact.setFirstName("Niki");
        contact.setLastName("Schultz");
        contact.setPhoneNumber("123-456-789");
        contact.setEmailAddress("niki@123.com");
        contactService.saveContact(contact);

        Contact contact1 = new Contact();
        contact1.setFirstName("Bob");
        contact1.setLastName("Jones");
        contact1.setPhoneNumber("123-456-789");
        contact1.setEmailAddress("niki@123.com");
        contactService.saveContact(contact1);

        Contact contact2 = new Contact();
        contact2.setFirstName("Tony");
        contact2.setLastName("Johnson");
        contact2.setPhoneNumber("123-456-789");
        contact2.setEmailAddress("niki@123.com");
        contactService.saveContact(contact2);

        Address address = new Address();
        address.setStreetAddress("222 Silver Street");
        address.setCity("Maplewood");
        address.setState("MN");
        address.setZipCode(55113);
        addressService.saveAddress(address);

        Address address1 = new Address();
        address1.setStreetAddress("567 Rose Road");
        address1.setCity("Hudson");
        address1.setState("WI");
        address1.setZipCode(54116);
        addressService.saveAddress(address1);

        Address address2 = new Address();
        address2.setStreetAddress("444 Blue Lane");
        address2.setCity("Saint Paul");
        address2.setState("MN");
        address2.setZipCode(55112);
        addressService.saveAddress(address2);


    }


}
