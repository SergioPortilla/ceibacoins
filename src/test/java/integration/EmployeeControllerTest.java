package integration;

import com.ceiba.ceibacoins.CeibacoinsApplication;
import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= CeibacoinsApplication.class)
class EmployeeControllerTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void save() {
        Employee employee = new Employee();
        employee.setNuip(2323L);
        employee.setEmployeeName("Sergio");
        employee.setEmployeeLastName("portilla");
        employee.setBirthday(new Date());
        employee.setEntry(new Date());
        employee.setCeibaCoins(0.0);
        employee.setState(true);
        employeeRepository.save(employee);
        entityManager.flush();

        Employee found = employeeRepository.findById(employee.getNuip());
        Assertions.assertThat(found).isNotNull();
        Assertions.assertThat(found).isEqualToComparingOnlyGivenFields(employee);
    }

    @Test
    void findById() {
        Employee found;

        found = employeeRepository.findById(1233899201L);

        Assertions.assertThat(found).isNotNull();
    }

    @Test
    void findByStateEmployees() {

        List<Employee> employees;

        employees= employeeRepository.findByStateEmployees(true);
        entityManager.flush();

        Assertions.assertThat(employees).isNotNull();

    }
}