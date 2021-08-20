import React from 'react'


const UltraUserAddSubscriptionToUser = ()=>{
    function handleAddUserToModule(e){
        e.preventDefault();
        fetch("/api/ultrauser/addusertosubscriptionplan", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                userId: document.getElementById("user").value,
                subscriptionPlanId: document.getElementById("subplan").value,
            })
        })
            .then(()=>{
                console.log("hello")
            });
        alert("Subscription added");
    }

    return(
        <div>
            <form>
                <label>Subscritpionplan ID</label><input type={"text"} id={"subplan"}/>
                <label>User ID</label><input type={"text"} id={"user"}/>
                <button onClick={handleAddUserToModule}>Add</button>
            </form>
        </div>
    )
}

export default UltraUserAddSubscriptionToUser;