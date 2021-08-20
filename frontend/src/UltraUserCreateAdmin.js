import React from 'react'

const UltraUserCreateAdmin = ()=>{

    function handleSubmitNewUser(e){
        e.preventDefault();
        fetch("/api/ultrauser/createuser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                password: document.getElementById("password").value,
                user_role: document.getElementById("userRole").value,
                business_role: document.getElementById("businessRole").value,
                companyID: document.getElementById("companyId").value,

            })
        })
            .then(()=>{
                console.log("User created")
            });
        alert("user created");
    }

    return(
        <div>
            <h3>Create an Admin user</h3>
            <form>
                <label>Name</label><input type={"text"} id={"name"}/>
                <label>Email</label><input type={"text"} id={"email"}/>
                <label>password</label><input type={"text"} id={"password"}/>
                <label>user role</label><input type={"text"} id={"userRole"}/>
                <label>business role</label><input type={"text"} id={"businessRole"}/>
                <label>company id</label><input type={"text"} id={"companyId"}/>
                <button onClick={handleSubmitNewUser}>Create</button>
            </form>
        </div>
    )
}

export default UltraUserCreateAdmin;
