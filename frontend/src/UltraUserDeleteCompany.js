import React from 'react'

const UltraUserDeleteCompany = ()=> {
    function handleDeleteCompany(e) {
        e.preventDefault()
        fetch("/api/ultrauser/deletecompany", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id: document.getElementById("delete").value
            })
    })
            .then(()=>
            alert("company may be deleted")
            )
    }
return(
    <div>
        <h3>Delete company</h3>
        <form>
            <input type={"text"} id={"delete"}/><button onClick={handleDeleteCompany}>Delete</button>
        </form>
    </div>
)
}

export default UltraUserDeleteCompany;
