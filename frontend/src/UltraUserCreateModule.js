import React from 'react'


const UltraUserCreateModule = ()=>{

    function HandleCreateModule(e) {
        e.preventDefault();
        fetch("/api/ultrauser/createusermodule", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: document.getElementById("name").value,
            })
        })
            .then(()=>{
                alert("Module created");
            });
    }

    return(
        <div>
            <form>
                <label>Name:</label><input type={"text"} id={"name"}/>
                <button onClick={HandleCreateModule}>Create</button>
            </form>
        </div>
    )
}

export default UltraUserCreateModule;