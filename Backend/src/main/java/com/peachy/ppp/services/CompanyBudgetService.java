package com.peachy.ppp.services;

import com.peachy.ppp.entities.CompanyBudgetEntity;
import com.peachy.ppp.entities.CompanyEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;

@Service
@Transactional
public class CompanyBudgetService {
    @Autowired
    EntityManager em;

    public CompanyBudgetEntity createCompanyBudget(
            Double dailyBudget,
            Double weeklyBudget,
            Double monthlyBudget,
            Double yearlyBudget,
            CompanyEntity company
    ){
        CompanyBudgetEntity cbe = new CompanyBudgetEntity();
        cbe.setDaily_budget(dailyBudget);
        cbe.setWeekly_budget(weeklyBudget);
        cbe.setMonthly_budget(monthlyBudget);
        cbe.setYearly_budget(yearlyBudget);
        cbe.setTargetCompany(company);
        String date = DateTime.now().toString();
        String date2 = DateTime.now().toString();
        cbe.setCreatedat(date);
        cbe.setUpdatedat(date2);
        try{
            em.persist(cbe);
            return cbe;
        }catch (Exception e){
            return null;
        }
    }

    public CompanyBudgetEntity getBudgetFromCompany(CompanyEntity ce){
        Query query = em.createQuery("SELECT x.budget FROM CompanyEntity x where x.id=:id");
        query.setParameter("id", ce.getId());
        try {
            return (CompanyBudgetEntity) query.getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }
}
