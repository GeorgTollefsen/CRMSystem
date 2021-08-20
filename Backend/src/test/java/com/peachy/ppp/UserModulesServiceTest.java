package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.entities.UserModuleEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.UserModuleSevice;
import com.peachy.ppp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Transactional
@SpringBootTest(classes = TestApplication.class)
public class UserModulesServiceTest {

    @Autowired
    CompanyService companyService;
    @Autowired
    UserService userService;
    @Autowired
    UserModuleSevice userModuleSevice;

    @Test
    void should_create_usermodule(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserModuleEntity ume = userModuleSevice.createUserModule("Regnskap");
        assertTrue(!ume.getId().toString().isBlank());
    }

    @Test
    void should_add_user_to_module(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserModuleEntity ume = userModuleSevice.createUserModule("Regnskap");
        assertTrue(userModuleSevice.addUserToModule(ue, ume));
    }

    @Test
    void should_give_users_from_module(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserEntity ue2 = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserEntity ue3 = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        UserModuleEntity ume = userModuleSevice.createUserModule("Regnskap");
        UserModuleEntity ume2 = userModuleSevice.createUserModule("Regnskap3");
        userModuleSevice.addUserToModule(ue, ume);
        userModuleSevice.addUserToModule(ue2, ume);
        userModuleSevice.addUserToModule(ue3, ume2);
        List<UserEntity> list = userModuleSevice.getUsersFromModule(ume);
        List<UserEntity> list2 = userModuleSevice.getUsersFromModule(ume2);
        assertTrue(list.size() == 2);
        assertTrue(list2.size() == 1);
    }


}
