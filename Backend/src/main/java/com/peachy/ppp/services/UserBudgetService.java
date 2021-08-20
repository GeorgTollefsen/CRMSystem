package com.peachy.ppp.services;

import com.peachy.ppp.entities.CompanyBudgetEntity;
import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.UserBudgetEntity;
import com.peachy.ppp.entities.UserEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
@Transactional
public class UserBudgetService {

    @Autowired
    EntityManager em;

    public UserBudgetEntity createUserBudget(
            Double dailyBudget,
            Double weeklyBudget,
            Double monthlyBudget,
            Double yearlyBudget,
            UserEntity user
    ){
        UserBudgetEntity ube = new UserBudgetEntity();
        ube.setDaily_budget(dailyBudget);
        ube.setWeekly_budget(weeklyBudget);
        ube.setMonthly_budget(monthlyBudget);
        ube.setYearly_budget(yearlyBudget);
        ube.setTargetUser(user);
        String date = DateTime.now().toString();
        String date2 = DateTime.now().toString();
        ube.setCreatedat(date);
        ube.setUpdatedat(date2);
        try{
            em.persist(ube);
            return ube;
        }catch (Exception e){
            return null;
        }
    }

    public UserBudgetEntity getBudgetFromUser(UserEntity ue){
        Query query = em.createQuery("SELECT x.budget FROM UserEntity x where x.id=:id");
        query.setParameter("id", ue.getId());
        try {
            return (UserBudgetEntity) query.getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }
}
