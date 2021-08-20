package com.peachy.ppp;

import com.peachy.ppp.entities.CustomerEntity;
import com.peachy.ppp.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    void should_create_customer(){
        CustomerEntity ce = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        assertTrue(ce.getId().toString() != null);
    }

    @Test
    void should_retrieve_all_customers(){
        CustomerEntity ce = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        CustomerEntity ce1 = customerService.createCustomer("Georg", "Tollefsen", "Håkaleina 18", "3470", "Slemmestad", 41177776L);
        List<CustomerEntity> list = customerService.getAllCustomers();
        assertTrue(list.size() == 2);
    }
}
