package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceSaveTest() {

        Employee employee2 = new Employee();
        employee2.setFirstName("Bipin");
        employee2.setLastName("Butala");
        employee2.setBackground("Java Developer as well");

        assertNull(employee2.getId());
        employeeService.saveEmployee(employee2);
        assertNotNull(employee2.getId());

        //fetch
        Employee fetchedEmployee = employeeService.getEmployeeById(employee2.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee2.getId(), fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("TonyTest");
        employeeService.saveEmployee(fetchedEmployee);

        Employee updatedEmployee = employeeService.getEmployeeById(fetchedEmployee.getId());
        assertEquals("TonyTest", updatedEmployee.getFirstName());







    }






}
