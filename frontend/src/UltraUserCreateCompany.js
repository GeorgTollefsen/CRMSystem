import React from 'react'


const UltraUserCreateCompany = ()=>{

    function handleSubmitNewCompany(e){
        e.preventDefault();
        fetch("/api/ultrauser/createcompany", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: document.getElementById("companyName").value,
                company_id: document.getElementById("companyNumber").value,
                street: document.getElementById("companyAddress").value,
                postal_code: document.getElementById("companyPostal").value,
                city: document.getElementById("companyCity").value,
                company_contact: document.getElementById("companyContact").value,
                phone: document.getElementById("companyPhone").value,
                email: document.getElementById("companyEmail").value
            })
        })
            .then(()=>{
                console.log("hello")
            });
        alert("company created");
    }

    return (
        <div>
            <div>
                <h1>Owner of the app things goes here. This means: create new admins, create new portals, assign modules</h1>
                <h3>Register new company</h3>
                <form id={"createCompany"}>
                    <label>Company name: </label><input type={"text"} id={"companyName"}/>
                    <label>Company number (org number): </label><input type={"text"} id={"companyNumber"} required/>
                    <label>Company Address: </label><input type={"text"} id={"companyAddress"} required/>
                    <label>Company Postal Code: </label><input type={"text"} id={"companyPostal"} required/>
                    <label>Company city: </label><input type={"text"} id={"companyCity"} required/>
                    <label>Company contact person: </label><input type={"text"} id={"companyContact"} required/>
                    <label>Company phone: </label><input type={"text"} id={"companyPhone"} required/>
                    <label>Company contact email: </label><input type={"email"} id={"companyEmail"} required/>
                    <button onClick={handleSubmitNewCompany}>Register</button>
                </form>
            </div>
            <div>

            </div>
        </div>
    )
}

export default UltraUserCreateCompany;