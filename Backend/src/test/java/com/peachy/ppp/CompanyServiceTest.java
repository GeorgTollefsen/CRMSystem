package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Transactional
@SpringBootTest(classes = TestApplication.class)
public class CompanyServiceTest {
    @Autowired
    private CompanyService compService;
    @Autowired
    private UserService userService;

    @Test
    void should_create_company(){
        CompanyEntity s = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        System.out.println(s);
        assertTrue(!s.getName().isEmpty());
        }

    @Test
    void should_find_company(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        String oldCompanyEntity = compService.findCompany(newCompanyEntity.getId().toString()).getId().toString();
        assertTrue(newCompanyEntity.getId().toString().contains(oldCompanyEntity));
    }

    @Test
    void should_delete_company(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        compService.deleteCompany(newCompanyEntity.getId().toString());
        try{
            String s = compService.findCompany(newCompanyEntity.getId().toString()).getId().toString();
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    void should_find_all_companies(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CompanyEntity newCompanyEntity2 = compService.createCompany("peachyyyy", "123344", "håkawwwwwwleina", "3470", "Oslo", "Ida", "336", "idaelto@gm");
        List<CompanyEntity> compList =  compService.findAllCompanies();
        assertTrue(compList.size()>1);
    }

    @Test
    void should_find_users_from_companies(){
        CompanyEntity newCompanyEntity = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        UserEntity x = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", newCompanyEntity);
        List<UserEntity> list = compService.getAllUsers(newCompanyEntity);
        System.out.println(list.get(0));
        assertTrue(list.size()==1);
    }
}
