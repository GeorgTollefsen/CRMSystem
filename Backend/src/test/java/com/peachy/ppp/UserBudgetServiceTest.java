package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyBudgetEntity;
import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.UserBudgetEntity;
import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.services.CompanyBudgetService;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.UserBudgetService;
import com.peachy.ppp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class UserBudgetServiceTest {
    @Autowired
    UserBudgetService userBudgetService;
    @Autowired
    CompanyService companyService;
    @Autowired
    UserService userService;

    @Test
    void should_create_budget(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserBudgetEntity ube = userBudgetService.createUserBudget(1200D, 2200D, 3300D, 330000D, ue);
        assertTrue(ube.getId().toString() != null);
    }

    @Test
    void should_find_budget_from_user(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserBudgetEntity ube = userBudgetService.createUserBudget(1200D, 2200D, 3300D, 330000D, ue);
        assertTrue(userBudgetService.getBudgetFromUser(ue) == ube);
    }
}
