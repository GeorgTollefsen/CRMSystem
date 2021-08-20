package com.peachy.ppp.services;

import com.peachy.ppp.entities.*;
import org.h2.engine.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    EntityManager em;

    @Autowired
    CompanyService cs;

    public UserEntity createUser(
            String name,
            String email,
            String password,
            String user_role,
            String business_role,
            CompanyEntity company
    ){
        UserEntity ue = new UserEntity();
        ue.setName(name);
        ue.setEmail(email);
        ue.setPassword(password);
        ue.setUser_role(user_role);
        ue.setBusiness_role(business_role);
        ue.setTargetCompany(company);
        String datetime = DateTime.now().toString();
        String datetime2 = DateTime.now().toString();
        ue.setUpdatedat(datetime2);
        ue.setCreatedat(datetime);

        try {
            em.persist(ue);
            return ue;
        }catch (Exception e){
            return null;
        }
    }

    public UserEntity findUser(String id){
        TypedQuery<UserEntity> query = em.createQuery("SELECT x FROM UserEntity x WHERE x.id=:id", UserEntity.class);
        query.setParameter("id", UUID.fromString(id));
        UserEntity returnvalue;
        try {
            returnvalue = query.getSingleResult();
            return returnvalue;
        } catch (Exception e){
            return null;
        }
    }

    public boolean deleteUser(String uuid){
        try{
            UserEntity ue = em.find(UserEntity.class, UUID.fromString(uuid));
            em.remove(ue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<UserEntity> findAllUsers(){
        return em.createQuery("SELECT x FROM UserEntity x").getResultList();
    }

    public boolean addUserToTeam(UserEntity ue, TeamEntity te){
        Query query = em.createQuery("UPDATE UserEntity x SET x.targetTeam =:team WHERE x.id=:id");
        query.setParameter("team", te);
        query.setParameter("id", ue.getId());

        try {
            query.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<UserEntity> findAllUsersInTeam(TeamEntity te){
        Query query = em.createQuery("SELECT x FROM UserEntity x WHERE x.targetTeam=:team");
        query.setParameter("team", te);
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public boolean addUserToSubscriptionPlan(UserEntity ue, SubscriptionPlanEntity spe){
        ue.setTargetSubscriptionPlan(spe);
        try{
            em.persist(ue);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<UserModuleEntity> getModulesFromUser(UserEntity ue){
        Query query = em.createQuery("SELECT x.modules from UserEntity x where x.id=:id");
        query.setParameter("id", ue.getId());
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public boolean updateUser(String id, String name, String email, String userRole, String businessRole){
        UserEntity ue = em.find(UserEntity.class, UUID.fromString(id));
        ue.setName(name);
        ue.setEmail(email);
        ue.setUser_role(userRole);
        ue.setBusiness_role(businessRole);

        try {
            em.persist(ue);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
