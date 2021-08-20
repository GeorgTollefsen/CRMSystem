package com.peachy.ppp;
import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.SubscriptionPlanEntity;
import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.LoginTimeService;
import com.peachy.ppp.services.SubscriptionPlanService;
import com.peachy.ppp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class SubscriptionPlanServiceTest {
    @Autowired
    private CompanyService compService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @Test
    void should_create_subPlan(){

        SubscriptionPlanEntity spl = subscriptionPlanService.createSubscriptionPlan("Admin", 590);
        assertTrue(spl.getId() !=null);
    }

    @Test
    void should_find_plan_based_on_user(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        SubscriptionPlanEntity spl = subscriptionPlanService.createSubscriptionPlan("Admin", 590);
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        userService.addUserToSubscriptionPlan(x,spl);
        SubscriptionPlanEntity spl2 = subscriptionPlanService.getSubscriptionPlanBasedOnUser(x);
        assertTrue(spl == spl2);
    }


}
