let serverUrl = "http://localhost:8080/";

let months = {
    "Jan":"01",
    "Feb":"02",
    "Mar":"03",
    "Apr":"04",
    "May":"05",
    "Jun":"06",
    "Jul":"07",
    "Aug":"08",
    "Sep":"09",
    "Oct":"10",
    "Nov":"11",
    "Dec":"12"
};

let getDate = ()=>{
    let date = document.getElementById("stopdate")
                        .value
                        .replace(",","")
                        .split(" ");

    return date[2] + "-" + months[date[0]] + "-" + date[1];
};

let getName = ()=>{
    let firstName = document.getElementById("first_name").value;
    let lastName = document.getElementById("last_name").value;

    return lastName + " " + firstName;
};

let makeUserRequest = ()=>{
    return {
        "user":{
            "userName": getName(),
            "email": document.getElementById("email").value,
            "stopDate": getDate(),
            "dailyDose": parseInt(document.getElementById("dailydose").value)
        },
        "item":{
            "name": document.getElementById("addiction-item").value,
            "cost": parseInt(document.getElementById("cost").value)
        }

  };
};

let fetchData = (url = ``, data = {}, method="POST") =>{
    return fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json());
};

let getData = (url = ``) =>{
    return fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(response => response.json());
};

function calculateData(userId) {
    fetchData(serverUrl + "calculate/" + userId)
        .then(data => {
            let mainContainer = document.getElementById("main-box");
            let textContainer = document.createElement("div");
            let moneyText = document.createElement("h1");
            mainContainer.innerHTML = "";

            textContainer.classList.add("center");
            textContainer.classList.add("text");
            textContainer.classList.add("black-text");
            textContainer.innerText = "That's how much money you saved:";
            moneyText.innerText = data + " Ft";

            mainContainer.appendChild(textContainer);
            mainContainer.appendChild(moneyText);

        })
        .catch(error => console.error(error));
}

document.addEventListener('DOMContentLoaded', () =>{
    let dateElems = document.querySelectorAll('.datepicker');
    let dateInstances = M.Datepicker.init(dateElems,{container: "body"});

    let modalElems = document.querySelectorAll('.modal');
    let modalInstances = M.Modal.init(modalElems);
    let sessionUserId = sessionStorage.getItem("userId");

    if(sessionUserId == null) {
        document.getElementById("submit").addEventListener("click",(event) =>{
            event.preventDefault();

            fetchData(serverUrl + "create-user",makeUserRequest())
                .then(data => {
                    let userId = data.id;

                    if(document.getElementById("come-back").checked){
                        sessionStorage.setItem("userId",userId);
                    }

                    calculateData(userId);
                })
                .catch(error => console.error(error));
        })
    } else{
        calculateData(sessionUserId);
    }


});
