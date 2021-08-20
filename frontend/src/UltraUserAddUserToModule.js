import React from 'react'


const UltraUserAddUserToModule = ()=> {

    function HandleAddUser(e) {
            e.preventDefault();
            fetch("/api/ultrauser/addusertomodule", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    userId: document.getElementById("user").value,
                    moduleId: document.getElementById("module").value,
                })
            })
                .then(()=>{
                    alert("Module created");
                });
        }
        return(
            <div>
                <h3>Add User To Module</h3>
                <label>User Id</label><input type={"text"} id={"user"}/>
                <label>Module Id</label><input type={"text"} id={"module"}/>
                <button onClick={HandleAddUser}>Add</button>
            </div>
        )

}

export default UltraUserAddUserToModule;