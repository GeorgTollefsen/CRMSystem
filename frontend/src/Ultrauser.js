import React from 'react'
import {BrowserRouter, Link} from "react-router-dom";
import { Route, Switch } from "react-router";
import UltraUserCreateCompany from "./UltraUserCreateCompany";
import UltraUserDeleteCompany from "./UltraUserDeleteCompany";
import UltraUserCreateSubscriptionPlan from "./UltraUserCreateSubscriptionPlan";
import UltraUserCreateAdmin from "./UltraUserCreateAdmin";
import UltraUserAddSubscriptionToUser from "./UltraUserAddSubscriptionToUser";
import UltraUserShowAllUserDetails from "./UltraUserShowAllUserDetails";
import UltraUserCreateModule from "./UltraUserCreateModule";
import UltraUserAddUserToModule from "./UltraUserAddUserToModule";
import UltraUserEditUser from "./UltraUserEditUser";


const Ultrauser = () =>{


    return(
        <BrowserRouter>
            <Switch>
                <Route path={"/ultrauser/ultrauser"} exact>
                    <div className="container">
                        <div className="frontpage_div_grid">logo?</div>
                        <div className="frontpage_div_grid"><h1>Peach People Portal</h1></div>
                        <div></div>
                        <Link to={"/ultrauser/createcompany"}><div className="frontpage_div_grid"><h3>Registrer nytt Selskap</h3></div></Link>
                        <Link to={"/ultrauser/deletecompany"}><div className="frontpage_div_grid"><h3>Slett selskap</h3></div></Link>
                        <Link to={"/ultrauser/createsubplan"}><div className="frontpage_div_grid"><h3>Create Subscriptionplan</h3></div></Link>
                        <Link to={"/ultrauser/createuser"}><div className="frontpage_div_grid"><h3>Create Admin user</h3></div></Link>
                        <Link to={"/ultrauser/addsubscriptiontouser"}><div className="frontpage_div_grid"><h3>Add subscriptionplan to user</h3></div></Link>
                        <Link to={"/ultrauser/showallusers"}><div className="frontpage_div_grid"><h3>All user data</h3></div></Link>
                        <Link to={"/ultrauser/createusermodule"}><div className="frontpage_div_grid"><h3>Create User Module</h3></div></Link>
                        <Link to={"/ultrauser/addusertomodule"}><div className="frontpage_div_grid"><h3>Add User To Module</h3></div></Link>
                        <Link to={"/ultrauser/edituser"}><div className="frontpage_div_grid"><h3>Edit User</h3></div></Link>
                    </div></Route>
                <Route path={"/ultrauser/createcompany"}>
                    <UltraUserCreateCompany />
                </Route>
                <Route path={"/ultrauser/deletecompany"}>
                    <UltraUserDeleteCompany />
                </Route>
                <Route path={"/ultrauser/createsubplan"}>
                    <UltraUserCreateSubscriptionPlan />
                </Route>
                <Route path={"/ultrauser/ultrauser"}>
                    <Ultrauser />
                </Route>
                <Route path={"/ultrauser/createuser"}>
                    <UltraUserCreateAdmin />
                </Route>
                <Route path={"/ultrauser/addsubscriptiontouser"}>
                    <UltraUserAddSubscriptionToUser />
                </Route>
                <Route path={"/ultrauser/showallusers"}>
                    <UltraUserShowAllUserDetails />
                </Route>
                <Route path={"/ultrauser/createusermodule"}>
                    <UltraUserCreateModule />
                </Route>
                <Route path={"/ultrauser/addusertomodule"}>
                    <UltraUserAddUserToModule />
                </Route>
                <Route path={"/ultrauser/edituser"}>
                    <UltraUserEditUser />
                </Route>
                <Route>
                    <h1>404 Not Found</h1>
                </Route>
            </Switch>
        </BrowserRouter>
    )
};

export default Ultrauser;