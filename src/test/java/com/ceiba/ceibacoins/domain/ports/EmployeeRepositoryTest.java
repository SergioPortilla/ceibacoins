package com.ceiba.ceibacoins.domain.ports;

import com.ceiba.ceibacoins.CeibacoinsApplication;
import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= CeibacoinsApplication.class)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void save() {
        Employee employee = new Employee(2323L, "Sergio", "portilla", new Date(), new Date(), 0.0, true);
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
        Assertions.assertThat(found).isEqualTo(employee);
    }

//    @Test
//    void findById() {
//    }
//
//    @Test
//    void findByStateEmployees() {
//    }
}

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = CeibacoinsApplication.class)
//@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
//@AutoConfigureMockMvc
//class EmployeeRepositoryTest {
//
//    @Autowired
//    private WebApplicationContext context;
//    private MockMvc mockMvc;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Transactional
//    @Rollback(true)
//    @Test
//    void save() throws Exception {
//
//        Employee employee = new Employee(2323L, "Sergio", "portilla", new Date(), new Date(), 0.0, true);
//
//        employeeRepository.save(employee);
//
//        Employee found = employeeRepository.findById(employee.getNuip());
//
////        Assertions.assertThat(found).isNotNull();
////        Assertions.assertThat(found).isEqualTo(employee);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ceibacoins")
//                .contentType(MediaType.APPLICATION_JSON);
//        mockMvc.perform(requestBuilder)
//                .andDo(print())
//                .andExpect(status()
//                        .isOk())
//                .andExpect(jsonPath("$[0].name", is(employee.getEmployeeName())))
//                .andExpect(jsonPath("$[0].status", is(employee.getState())));
//    }
//}