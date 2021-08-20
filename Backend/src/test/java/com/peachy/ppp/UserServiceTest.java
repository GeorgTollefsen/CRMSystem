package com.peachy.ppp;

import com.peachy.ppp.entities.*;
import com.peachy.ppp.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Transactional
@SpringBootTest(classes = TestApplication.class)
public class UserServiceTest {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;
    @Autowired
    private UserModuleSevice userModuleSevice;

    @Test
    void should_create_user(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        System.out.println(x.toString());
        assertTrue(!x.getName().isEmpty());
    }

    @Test
    void should_get_single_user(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        UserEntity y = userService.findUser(x.getId().toString());
        assertTrue(x==y);
    }

    @Test
    void should_delete_user(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        boolean yesno = userService.deleteUser(x.getId().toString());
        assertTrue(yesno);
        UserEntity y = userService.findUser(x.getId().toString());
        assertTrue(y==null);
    }

    @Test
    void should_add_user_to_team(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        TeamEntity team = teamService.createTeam("Alpha team", newCompanyEntity);
        boolean yesno = userService.addUserToTeam(x,team);
        assertTrue(yesno);
    }
    //todo virker denne?
    @Test
    void should_find_all_users_in_team(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        TeamEntity team = teamService.createTeam("Alpha team", newCompanyEntity);
        boolean yesno = userService.addUserToTeam(x,team);
        List<UserEntity> list = userService.findAllUsersInTeam(team);
        assertTrue(!list.isEmpty());
    }

    @Test
    void should_add_subplan_to_user(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        SubscriptionPlanEntity spe = subscriptionPlanService.createSubscriptionPlan("Admin", 590);
        boolean yesno = userService.addUserToSubscriptionPlan(x, spe);
        System.out.println(userService.findUser(x.getId().toString()));
        assertTrue(yesno);
    }

    @Test
    void should_retrieve_all_modules_from_user(){
        CompanyEntity newCompanyEntity = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        UserModuleEntity ume = userModuleSevice.createUserModule("Regnskap");
        userModuleSevice.addUserToModule(x, ume);
        List<UserModuleEntity> list = userService.getModulesFromUser(x);
        //todo feiler
        assertTrue(!list.isEmpty());
    }



}
