package com.peachy.ppp.services;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.UserEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private EntityManager em;

    public CompanyEntity createCompany(
            String name,
            String comp_id,
            String street,
            String post_code,
            String city,
            String comp_contact,
            String phone,
            String email
    ){
        CompanyEntity entity = new CompanyEntity();
        entity.setName(name);
        entity.setCompany_id(comp_id);
        entity.setStreet(street);
        entity.setPostal_code(post_code);
        entity.setCity(city);
        entity.setCompany_contact(comp_contact);
        entity.setPhone(phone);
        entity.setEmail(email);
        String date = LocalDateTime.now().toString();
        String date2 = LocalDateTime.now().toString();
        entity.setCreatedat(date);
        entity.setUpdatedat(date2);
        em.persist(entity);
        return entity;
    }

    public  CompanyEntity findCompany(String uuid){
        return em.find(CompanyEntity.class, UUID.fromString(uuid));
    }

    public int deleteCompany(String uuid){
        try {
            CompanyEntity company = findCompany(uuid);
            em.remove(company);
            return 1;
        }catch (Exception e){
            return 0;
        }


    }

    public List<CompanyEntity> findAllCompanies(){
        TypedQuery<CompanyEntity> query = em.createQuery("SELECT x FROM CompanyEntity x", CompanyEntity.class);
        List<CompanyEntity> returnvalue = query.getResultList();
        return returnvalue;
    }

    //todo fix this and test it
    public boolean updateCompany(
        String uuid,
        String name,
        String comp_id,
        String street,
        String post_code,
        String city,
        String comp_contact,
        String phone,
        String email
    ){
        Query query = em.createQuery("UPDATE CompanyEntity x SET x.name = :name, x.company_id = :comp_id, x.street=:street, x.postal_code=:post_code, x.city=:city, x.company_contact=:comp_contact, x.phone=:phone, x.email=:email, x.updatedat=:updated where x.id =:id");
        query.setParameter("name", name);
        query.setParameter("comp_id", comp_id);
        query.setParameter("street", street);
        query.setParameter("post_code", post_code);
        query.setParameter("city", city);
        query.setParameter("comp_contact", comp_contact);
        query.setParameter("phone", phone);
        query.setParameter("email", email);
        query.setParameter("updated", DateTime.now().toString());
        query.setParameter("id", UUID.fromString(uuid));
        query.executeUpdate();
        return true;
    }

    public List<UserEntity> getAllUsers(CompanyEntity company){
        Query query = em.createQuery("SELECT x FROM UserEntity x WHERE x.targetCompany.id=:id");
        query.setParameter("id", company.getId());
        return query.getResultList();
    }
}
