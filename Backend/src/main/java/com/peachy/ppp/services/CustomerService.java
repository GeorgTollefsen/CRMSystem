package com.peachy.ppp.services;

import com.peachy.ppp.entities.CustomerEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Service
public class CustomerService {
    @Autowired
    EntityManager em;

    public CustomerEntity createCustomer(
            String firstName,
            String lastName,
            String street,
            String postalCode,
            String city,
            Long phone
    ){
        CustomerEntity ce = new CustomerEntity();
        ce.setFirst_name(firstName);
        ce.setLast_name(lastName);
        ce.setStreet(street);
        ce.setPostal_code(postalCode);
        ce.setCity(city);
        ce.setPhone(phone);
        String date1 = DateTime.now().toString();
        String date2 = DateTime.now().toString();
        ce.setUpdatedat(date1);
        ce.setCreatedat(date2);

        try{
            em.persist(ce);
            return ce;
        }catch (Exception e){
            return null;
        }
    }

    public List<CustomerEntity> getAllCustomers(){
        TypedQuery<CustomerEntity> query = em.createQuery("SELECT x FROM CustomerEntity x", CustomerEntity.class);
        try{
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }
}
