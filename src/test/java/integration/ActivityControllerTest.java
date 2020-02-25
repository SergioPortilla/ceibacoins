package integration;

import com.ceiba.ceibacoins.CeibacoinsApplication;
import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= CeibacoinsApplication.class)
class ActivityControllerTest {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void getActivitiesTest() {
        List<Activity> activities;

        activities = activityRepository.findAll();
        entityManager.flush();

        Assertions.assertThat(activities).isNotNull();
    }

    @Test
    void findById() {
        Activity activity;
        Long codeActivity = 1L;

        activity = activityRepository.findById(codeActivity);
        entityManager.flush();

        Assertions.assertThat(activity).isNotNull();

    }
}