package com.peachy.ppp.services;

import com.peachy.ppp.entities.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    EntityManager em;

    public OrderEntity createOrder(
            ProductEntity pe,
            CustomerEntity ce,
            UserEntity ue
    ){
        OrderEntity oe = new OrderEntity();
        List<ProductEntity> list = new ArrayList<>();
        list.add(pe);
        oe.setProducts(list);
        oe.setTargetCustomer(ce);
        oe.setTargetUser(ue);
        String date = DateTime.now().toString();
        String date1 = DateTime.now().toString();
        oe.setCreatedat(date);
        oe.setUpdatedat(date1);
        try {
            em.persist(oe);
            return oe;
        }catch (Exception e){
            return null;
        }
    }

    public OrderEntity getOrderFromOrdernumber(Long ordernumber){
        Query query = em.createQuery("SELECT x FROM OrderEntity x where x.order_number=:order");
        query.setParameter("order", ordernumber);
        return (OrderEntity) query.getResultList().get(0);
    }

    public List<OrderEntity> getAllOrdersFromUser(UserEntity ue){
        Query query = em.createQuery("SELECT x FROM OrderEntity x where x.targetUser.id=:id");
        query.setParameter("id", ue.getId());
        return query.getResultList();
    }

    public List<OrderEntity> getAllOrdersFromCompany(CompanyEntity ce){
        Query query = em.createQuery("SELECT x FROM OrderEntity x where x.targetUser.targetCompany.id=:id");
        query.setParameter("id", ce.getId());
        return query.getResultList();
    }

    public List<OrderEntity> getAllOrdersFromCustomer(CustomerEntity ce){
        Query query = em.createQuery("SELECT x FROM OrderEntity x where x.targetCustomer.id=:id");
        query.setParameter("id", ce.getId());
        return query.getResultList();
    }

}
