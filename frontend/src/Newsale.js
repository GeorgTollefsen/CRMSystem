import React from 'react'

const Newsale = () =>{
    return(
        <div>
        <h1>New sales shall be registered here</h1>
            <form>
                <label>First Name</label><input type={"text"}/>
                <label>Last Name</label><input type={"text"}/>
                <label>Street</label><input type={"text"}/>
                <label>Postal Code</label><input type={"text"}/>
                <label>City</label><input type={"text"}/>
                <label>Phone number</label><input type={"text"}/>
                <label>Email</label><input type={"text"}/>
                <button>To Contract</button>
            </form>
        </div>
    )
};

export default Newsale;