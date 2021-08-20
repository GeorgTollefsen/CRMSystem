package com.peachy.ppp.services;

import com.peachy.ppp.entities.SubscriptionPlanEntity;
import com.peachy.ppp.entities.UserEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.UUID;

@Service
@Transactional
public class SubscriptionPlanService {
    @Autowired
    EntityManager em;

    public SubscriptionPlanEntity createSubscriptionPlan( String name, Integer monthlyPrice){
        SubscriptionPlanEntity spe = new SubscriptionPlanEntity();
        spe.setName(name);
        spe.setMonthly_price(monthlyPrice);
        String date1 = DateTime.now().toString();
        String date2 = DateTime.now().toString();
        spe.setCreatedat(date1);
        spe.setUpdatedat(date2);
        try{
            em.persist(spe);
            return spe;
        }catch (Exception e){
            return null;
        }
    }

    public SubscriptionPlanEntity findSubscriptionPlan(String uuid){
        return em.find(SubscriptionPlanEntity.class, UUID.fromString(uuid));
    }

    public SubscriptionPlanEntity getSubscriptionPlanBasedOnUser(UserEntity ue){
        Query query = em.createQuery("SELECT x.targetSubscriptionPlan FROM UserEntity x WHERE x.id=:id");
        query.setParameter("id", ue.getId());
        return (SubscriptionPlanEntity) query.getResultList().get(0);
    }
}
