import React from 'react'

const UltraUserCreateSubscriptionPlan = ()=>{

    function handleCreatePlan(e) {
        e.preventDefault();
        fetch("/api/ultrauser/createsubscriptionplan", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: document.getElementById("name").value,
                monthly_price: document.getElementById("price").value
            })
        }).then(()=> alert("Plan created"));
    }

    return(
        <div>
            <h3>Create a plan</h3>
            <form>
                <label>Plan Name:</label><input type={"text"} id={"name"}/>
                <label>Monthly Price:</label><input type={"text"} id={"price"}/>
                <button onClick={handleCreatePlan}>Create</button>
            </form>
        </div>
    )
}

export default UltraUserCreateSubscriptionPlan;
