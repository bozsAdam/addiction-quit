document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.datepicker');
    var instances = M.Datepicker.init(elems,{container: "body"});
});

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
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