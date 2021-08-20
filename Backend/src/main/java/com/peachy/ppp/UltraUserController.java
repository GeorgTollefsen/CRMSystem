package com.peachy.ppp;

import com.peachy.ppp.DTO.*;
import com.peachy.ppp.entities.*;
import com.peachy.ppp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/api/ultrauser")
public class UltraUserController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;
    @Autowired
    private UserModuleSevice userModuleSevice;

    //***********************************
    //COMPANY
    //***********************************
    @PostMapping(value = "/createcompany",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public CompanyEntity createCompany(@RequestBody CompanyEntity company){
        System.out.println(company);
        return companyService.createCompany(company.getName(),
                company.getCompany_id(),
                company.getStreet(),
                company.getPostal_code(),
                company.getCity(),
                company.getCompany_contact(),
                company.getPhone(),
                company.getEmail());
    }

    //GET all companies
    @GetMapping(value = "/findallcompanies",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CompanyEntity> getAllCompanies(){
        return companyService.findAllCompanies();
    }

    @PostMapping(value = "/findcompany",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CompanyEntity getOneCompany(@RequestBody IdDTO id){
        return companyService.findCompany(id.getId());
    }

    //DELETE a company
    @PostMapping(value = "/deletecompany",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer deleteCompany(@RequestBody IdDTO id){
        return companyService.deleteCompany(id.getId());
    }

    //***********************************
    //USER
    //***********************************
    @PostMapping(value = "/createuser",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserEntity createUser(@RequestBody UserDTO user){
        CompanyEntity company = companyService.findCompany(user.getCompanyID());
        return userService.createUser(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getUser_role(),
                user.getBusiness_role(),
                company
        );
    }

    //DELETE user
    @PostMapping(value = "/deleteuser",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteUser(@RequestBody IdDTO id){
        return userService.deleteUser(id.getId());
    }

    //Find Single User
    @PostMapping(value = "/findsingleuser",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserEntity findSingleUser(@RequestBody IdDTO id){
        return userService.findUser(id.getId());
    }

    @PostMapping(value = "/updateuser",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean updateUser(@RequestBody UpdateUserDTO userInfo){
        System.out.println(userInfo);
        return userService.updateUser(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getUserRole(), userInfo.getBusinessRole());
    }

    //GET all users
    @GetMapping(value = "/findallusers",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserEntity> findAllUsers(){
        return userService.findAllUsers();
    }

    //ADD user to subscription plan
    @PostMapping(value = "/addusertosubscriptionplan",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean addUserToSubscriptionPlan(@RequestBody UserSubscriptionPlanDTO usersub){
        SubscriptionPlanEntity sub = subscriptionPlanService.findSubscriptionPlan(usersub.getSubscriptionPlanId());
        UserEntity user = userService.findUser(usersub.getUserId());
        return userService.addUserToSubscriptionPlan(user, sub);

    }


    //***********************************
    //CUSTOMER
    //***********************************
    @PostMapping(value = "/createcustomer",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer){
        return customerService.createCustomer(
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getStreet(),
                customer.getPostal_code(),
                customer.getCity(),
                customer.getPhone()
        );
    }

    //***********************************
    //TEAM
    //***********************************
    @PostMapping(value = "/createteam",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TeamEntity createTeam(@RequestBody TeamDTO team){
        CompanyEntity ce = companyService.findCompany(team.getCompanyID());
        return teamService.createTeam(team.getName(), ce);
    }

    //***********************************
    //PRODUCT
    //***********************************

    @PostMapping(value = "/createproduct",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProductEntity createProduct(@RequestBody ProductDTO product){
        CompanyEntity ce = companyService.findCompany(product.getCompanyID());
        return productService.createProduct(
                product.getName(),
                product.getSeller_comission(),
                product.getComission(),
                product.getType(),
                product.isMonthly_subscription(),
                product.getPrice(),
                product.getProduct_vendor(),
                ce
        );
    }
    //***********************************
    //SUBSCRIPTIONPLAN
    //***********************************
    @PostMapping(value = "/createsubscriptionplan",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public SubscriptionPlanEntity createSubscriptionPlan(@RequestBody SubscriptionPlanEntity subscriptionPlan){
        return subscriptionPlanService.createSubscriptionPlan(
                subscriptionPlan.getName(),
                subscriptionPlan.getMonthly_price()
        );
    }

    //***********************************
    //MODULES
    //***********************************
    @PostMapping(value = "/createusermodule",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserModuleEntity createUserModule(@RequestBody UserModuleDTO userModule){
        return userModuleSevice.createUserModule(userModule.getName());
    }

    //add user to module
    @PostMapping(value = "/addusertomodule",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean addUserToModule(@RequestBody AddUserToModuleDTO usermodule){
        UserEntity ue = userService.findUser(usermodule.getUserId());
        UserModuleEntity ume = userModuleSevice.findModule(usermodule.getModuleId());
        return userModuleSevice.addUserToModule(ue, ume);
    }

}
