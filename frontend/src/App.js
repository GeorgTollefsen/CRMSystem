import React from 'react';
import {BrowserRouter, Link} from "react-router-dom";
import { Route, Switch } from "react-router";

import Newsale from "./Newsale";
import Mysales from "./Mysales";
import Mybudget from "./Mybudget";
import Mybonus from "./Mybonus";
import Leaderboard from "./Leaderboard";
import Myprofile from "./Myprofile";
import Statistics from "./Statistics";
import Adminsettings from "./Adminsettings";
import Ultrauser from "./Ultrauser";

const App = () => {
    return(
        <BrowserRouter>
                <Switch>
                        <Route path={"/"} exact>
<div className="container">
        <div className="frontpage_div_grid">logo?</div>
        <div className="frontpage_div_grid"><h1>Peach People Portal</h1></div>
        <div></div>
        {/*<Link to={"/myteam"}><div className="frontpage_div_grid"><h3>Oversikt over mitt team</h3></div></Link>*/}
        <Link to={"/newsale"}><div className="frontpage_div_grid"><h3>Registrer nytt salg</h3></div></Link>
        <Link to={"/mysales"}><div className="frontpage_div_grid"><h3>Mine salg</h3></div></Link>
        <Link to={"/mybudget"}><div className="frontpage_div_grid"><h3>Mitt budjsett</h3></div></Link>
        <Link to={"/mybonus"}><div className="frontpage_div_grid"><h3>Min Bonus</h3></div></Link>
        <Link to={"/leaderboard"}><div className="frontpage_div_grid"><h3>Leaderboard</h3></div></Link>
        {/*<Link to={"/messages"}><div className="frontpage_div_grid"><h3>Meldinger</h3></div></Link>*/}
        {/*<Link to={"/notifications"}><div className="frontpage_div_grid"><h3>Varsler</h3></div></Link>*/}
        <Link to={"/myprofile"}><div className="frontpage_div_grid"><h3>Min profil</h3></div></Link>
        <Link to={"/admin/statistics"}><div className="frontpage_div_grid"><h3>Salgsoversikt -ADMIN</h3></div></Link>
        <Link to={"/admin/settings"}><div className="frontpage_div_grid"><h3>Oppsett -ADMIN</h3></div></Link>
        <Link to={"/ultrauser/ultrauser"}><div className="frontpage_div_grid"><h3>Ultrauser -Georg Only</h3></div></Link>
</div></Route>
                    <Route path={"/newsale"}>
                        <Newsale />
                    </Route>
                    <Route path={"/mysales"}>
                        <Mysales />
                    </Route>
                    <Route path={"/mybudget"}>
                        <Mybudget />
                    </Route>
                    <Route path={"/mybonus"}>
                        <Mybonus />
                    </Route>
                    <Route path={"/leaderboard"}>
                        <Leaderboard />
                    </Route>
                    <Route path={"/myprofile"}>
                        <Myprofile />
                    </Route>
                    <Route path={"/admin/statistics"}>
                        <Statistics />
                    </Route>
                    <Route path={"/admin/settings"}>
                        <Adminsettings />
                    </Route>
                    <Route path={"/ultrauser/ultrauser"}>
                        <Ultrauser />
                    </Route>
                    <Route>
                        <h1>404 Not Found</h1>
                    </Route>
                </Switch>
        </BrowserRouter>
    )
}

export default App;