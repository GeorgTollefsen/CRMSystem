package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyBudgetEntity;
import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.services.CompanyBudgetService;
import com.peachy.ppp.services.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Transactional
@SpringBootTest(classes = TestApplication.class)
public class CompanyBudgetServiceTest {
    @Autowired
    CompanyBudgetService companyBudgetService;
    @Autowired
    CompanyService companyService;

    @Test
    void should_create_budget(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CompanyBudgetEntity cbe = companyBudgetService.createCompanyBudget(2400D, 12000D, 48000D, 600000D, ce);
        assertTrue(cbe.getId().toString() != null);
    }

    @Test
    void should_get_budget_from_company(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CompanyBudgetEntity cbe = companyBudgetService.createCompanyBudget(2400D, 12000D, 48000D, 600000D, ce);
        assertTrue(companyBudgetService.getBudgetFromCompany(ce).getId().toString() != null);
    }

}
