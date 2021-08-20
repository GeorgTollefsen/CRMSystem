package com.peachy.ppp;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.ProductEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.CustomerService;
import com.peachy.ppp.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Transactional
@SpringBootTest(classes = TestApplication.class)
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Autowired
    CompanyService companyService;

    @Test
    void should_create_product(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        assertTrue(pe.getId().toString() != null);
    }

    @Test
    void should_find_all_products_from_a_company(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        ProductEntity pe2 = productService.createProduct("Rødekors 399m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        ProductEntity pe3 = productService.createProduct("Rødekors 499m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        List<ProductEntity> list = productService.findAllProductsBasedOnCompany(ce);
        assertTrue(!list.isEmpty());
    }

    @Test
    void should_find_all_products(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        ProductEntity pe2 = productService.createProduct("Rødekors 399m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        ProductEntity pe3 = productService.createProduct("Rødekors 499m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        List<ProductEntity> list = productService.findAllProducts();
        assertTrue(!list.isEmpty());
    }
}
