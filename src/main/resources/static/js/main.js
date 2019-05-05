let serverUrl = "http://localhost:8080/";

document.addEventListener('DOMContentLoaded', () =>{
    let dateElems = document.querySelectorAll('.datepicker');
    let dateInstances = M.Datepicker.init(dateElems,{container: "body"});

    let modalElems = document.querySelectorAll('.modal');
    let modalInstances = M.Modal.init(modalElems);
});

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
      "userName": getName(),
      "email": document.getElementById("email").value,
      "stopDate": getDate(),
      "dailyDose": parseInt(document.getElementById("dailydose").value)
  };
};

let makeItemRequest = ()=>{
    return {
        "name": document.getElementById("addiction-item").value,
        "cost": parseInt(document.getElementById("cost").value)
    };
};

let postData = (url = ``, data = {}) =>{
    return fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json());
};