import React, {useEffect, useState} from 'react'
import {BrowserRouter, Link} from "react-router-dom";
import { Route, Switch } from "react-router";
import UltraUserEditUser from "./UltraUserEditUser";



const UltraUserShowAllUserDetails = ()=>{

        const [user, setUser] = useState([]);

        const getUsers = ()=>{
            fetch("/api/ultrauser/findallusers")
                .then(res => res.json())
                .then(json => setUser(json))
                .then(()=> console.log(user))
        }

        useEffect(()=>{
            console.log(user)
            getUsers();

        }, []);


    return (
<BrowserRouter>
    <Switch>
        <Route path={"/ultrauser/showallusers"} exact>
        <div>
            <h3>User roles</h3>
            <table border={2}>
                <thead>
                <tr>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Monthly Cost</th>
                    <th>User Role</th>
                    <th>Company</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                {
// todo: fix dynamic, Kan fikses med en component i samme greia
                    user.map((userItem) => (
                        <tr key={userItem.email}>
                            <td>{userItem.email}</td>
                            <td>{userItem.name}</td>
                            <td>{userItem.targetSubscriptionPlan.monthly_price}</td>
                            <td>{userItem.user_role}</td>
                            <td>{userItem.targetCompany.name}</td>
                            <td><Link to={`/ultrauser/edituser?id=${userItem.id}`}>Edit</Link></td>
                            <td/>
                        </tr>

                    ))
                }
                </tbody>
            </table>
        </div>
        </Route>
        <Route path="/ultrauser/edituser">
            <UltraUserEditUser />
        </Route>
    </Switch>
</BrowserRouter>
    );
}

export default UltraUserShowAllUserDetails;