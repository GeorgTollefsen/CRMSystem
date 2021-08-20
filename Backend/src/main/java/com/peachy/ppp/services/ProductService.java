package com.peachy.ppp.services;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.ProductEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    EntityManager em;

    public ProductEntity createProduct(
            String name,
            Integer sellerComission,
            Integer comission,
            String type,
            boolean monthly,
            Integer price,
            String productVendor,
            CompanyEntity company
    ){
        ProductEntity pe = new ProductEntity();
        pe.setName(name);
        pe.setSeller_comission(sellerComission);
        pe.setComission(comission);
        pe.setPrice(price);
        pe.setProduct_vendor(productVendor);
        pe.setTargetCompany(company);
        pe.setType(type);
        pe.setMonthly_subscription(monthly);
        String date = DateTime.now().toString();
        String date1 = DateTime.now().toString();
        pe.setCreatedat(date);
        pe.setUpdatedat(date1);

        try {
            em.persist(pe);
            return pe;
        }catch (Exception e){
            return null;
        }
    }

    public List<ProductEntity> findAllProductsBasedOnCompany(CompanyEntity ce){
        Query query = em.createQuery("SELECT x FROM ProductEntity x WHERE x.targetCompany.id =:id");
        query.setParameter("id", ce.getId());
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public List<ProductEntity> findAllProducts(){
        Query query = em.createQuery("SELECT x FROM ProductEntity x");
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }
}
