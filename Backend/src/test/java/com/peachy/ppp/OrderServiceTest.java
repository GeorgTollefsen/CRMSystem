package com.peachy.ppp;
import com.peachy.ppp.entities.*;
import com.peachy.ppp.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.net.UnknownServiceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    TeamService teamService;

    @Test
    void should_create_order(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CustomerEntity custe = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        OrderEntity oe = orderService.createOrder(pe, custe, ue);

        assertTrue(oe.getId().toString() != null);
    }

    @Test
    void should_get_orders_from_user(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CustomerEntity custe = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        OrderEntity oe = orderService.createOrder(pe, custe, ue);
        OrderEntity oe1 = orderService.createOrder(pe, custe, ue);
        OrderEntity oe2 = orderService.createOrder(pe, custe, ue);
        List<OrderEntity> list = orderService.getAllOrdersFromUser(ue);
        assertTrue(list.size() == 3);
    }

    @Test
    void should_get_all_orders_from_company(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CustomerEntity custe = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        OrderEntity oe = orderService.createOrder(pe, custe, ue);
        OrderEntity oe1 = orderService.createOrder(pe, custe, ue);
        OrderEntity oe2 = orderService.createOrder(pe, custe, ue);
        List<OrderEntity> list = orderService.getAllOrdersFromCompany(ce);
        assertTrue(list.size()==3);
    }
    @Test
    void should_get_all_orders_from_customer(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CustomerEntity custe = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        OrderEntity oe = orderService.createOrder(pe, custe, ue);
        OrderEntity oe1 = orderService.createOrder(pe, custe, ue);
        OrderEntity oe2 = orderService.createOrder(pe, custe, ue);
        List<OrderEntity> list = orderService.getAllOrdersFromCustomer(custe);
        assertTrue(list.size()==3);
    }

    @Test
    void setup_all(){
        CompanyEntity ce = companyService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CustomerEntity custe = customerService.createCustomer("Jannicke", "Stephansen-Smith", "Håkaleina 18", "3470", "Slemmestad", 90749833L);
        ProductEntity pe = productService.createProduct("Rødekors 299m", 400, 1600, "Contract", true, 299, "Røde kors", ce);
        UserEntity ue = userService.createUser("Georg", "georgto@me.com", "123", "Ultrauser", "Administrator", ce);
        TeamEntity te = teamService.createTeam("Ballz", ce);

        OrderEntity oe = orderService.createOrder(pe, custe, ue);
    }

}
