import React, {useEffect, useState} from 'react'


const UltraUserEditUser = () => {
    const [user, setUser] = useState([]);
    const parameter = new URLSearchParams(window.location.search);
    const id = parameter.get('id');
    function handleFindUserData(){
        fetch("/api/ultrauser/findsingleuser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id: id,
            })
        })
            .then(response =>
                response.json())
            .then(json=>{
             document.getElementById("name").value = json.name
             document.getElementById("email").value = json.email
             document.getElementById("userRole").value = json.user_role
             document.getElementById("businessRole").value = json.business_role
            })
    }

    useEffect(()=>{
        console.log(user)
        handleFindUserData()
    }, []);

    function handleEditUser(e) {
        e.preventDefault()
        fetch("/api/ultrauser/updateuser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id: id,
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                userRole: document.getElementById("userRole").value,
                businessRole: document.getElementById("businessRole").value,
            })
        })
    }


    return (
        <div>
            <h3>hei</h3>
            <form>
                <label>Name</label><input type={"text"} id={"name"}/>
                <label>Email</label><input type={"text"} id={"email"}/>
                <label>password</label><input type={"text"} id={"password"}/>
                <label>user role</label><input type={"text"} id={"userRole"}/>
                <label>business role</label><input type={"text"} id={"businessRole"}/>
                <button onClick={handleEditUser}>Edit</button>
            </form>
        </div>
    )
}

export default UltraUserEditUser;