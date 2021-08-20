package com.peachy.ppp.services;

import com.peachy.ppp.entities.UserEntity;
import com.peachy.ppp.entities.UserModuleEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
@Transactional
public class UserModuleSevice {
    @Autowired
    EntityManager em;

    public UserModuleEntity createUserModule(String name){
        UserModuleEntity ume = new UserModuleEntity();
        ume.setName(name);
        String date1 = DateTime.now().toString();
        String date2 = DateTime.now().toString();
        ume.setUpdatedat(date1);
        ume.setCreatedat(date2);

        try{
            em.persist(ume);
            return ume;
        }catch (Exception e){
            return null;
        }
    }

    public boolean addUserToModule(UserEntity ue, UserModuleEntity ume){
        List<UserModuleEntity> listmodules = ue.getModules();
        listmodules.add(ume);
        ue.setModules(listmodules);
        List<UserEntity> listUsers = ume.getTargetUser();
        listUsers.add(ue);

        try {
            em.persist(ue);
            em.persist(ume);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<UserEntity> getUsersFromModule(UserModuleEntity ume){
        Query query = em.createQuery("SELECT x.targetUser from UserModuleEntity x where x.id=:id");
        query.setParameter("id", ume.getId());
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public UserModuleEntity findModule(String id){
        return em.find(UserModuleEntity.class, UUID.fromString(id));
    }
}
