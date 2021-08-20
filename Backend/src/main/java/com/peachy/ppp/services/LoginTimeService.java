package com.peachy.ppp.services;

import com.peachy.ppp.entities.LoginTimeEntity;
import com.peachy.ppp.entities.UserEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class LoginTimeService {
    @Autowired
    EntityManager em;

    public LoginTimeEntity createLogin(UserEntity ue){
        LoginTimeEntity lte = new LoginTimeEntity();
        DateTime date1 = DateTime.now();
        DateTime date2 = DateTime.now();
        lte.setCreatedat(date1.toString());
        lte.setUpdatedat(date2.toString());
        lte.setTargetUser(ue);
        try {
            em.persist(lte);
            return lte;
        }catch (Exception e){
            return null;
        }
    }

    public List<LoginTimeEntity> getAllLoginForOneUser(UserEntity ue){
        Query query = em.createQuery("SELECT x FROM LoginTimeEntity x WHERE x.targetUser=:user");
        query.setParameter("user", ue);
        return query.getResultList();
    }

    public List<LoginTimeEntity> getTodaysLogin(){
        String today = DateTime.now().toString();
        int index= today.indexOf("T");
        String removeParts = today.substring(0, index);
        String correctString = "%".concat(removeParts).concat("%");

        Query query = em.createQuery("SELECT x FROM LoginTimeEntity x WHERE x.createdat like :date");
        query.setParameter("date", correctString);
        return query.getResultList();
    }
}
