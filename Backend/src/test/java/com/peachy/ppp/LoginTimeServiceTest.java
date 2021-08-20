package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.LoginTimeEntity;
import com.peachy.ppp.entities.TeamEntity;
import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.LoginTimeService;
import com.peachy.ppp.services.TeamService;
import com.peachy.ppp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class LoginTimeServiceTest {
    @Autowired
    private CompanyService compService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginTimeService loginTimeService;

    @Test
    void should_create_login(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        LoginTimeEntity login = loginTimeService.createLogin(x);
        assertTrue(!login.getCreatedat().isEmpty());
    }

    @Test
    void should_retrieve_all_logins_for_one_user(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        LoginTimeEntity login = loginTimeService.createLogin(x);
        LoginTimeEntity login2 = loginTimeService.createLogin(x);
        LoginTimeEntity login3 = loginTimeService.createLogin(x);
        LoginTimeEntity login4 = loginTimeService.createLogin(x);
        List<LoginTimeEntity> list = loginTimeService.getAllLoginForOneUser(x);
        assertTrue(list.size() == 4);
    }

    @Test
    void should_show_all_logins_today(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        LoginTimeEntity login = loginTimeService.createLogin(x);
        LoginTimeEntity login2 = loginTimeService.createLogin(x);
        LoginTimeEntity login3 = loginTimeService.createLogin(x);
        LoginTimeEntity login4 = loginTimeService.createLogin(x);
        List<LoginTimeEntity> list = loginTimeService.getTodaysLogin();
        assertTrue(list.size()== 4);
    }


}
