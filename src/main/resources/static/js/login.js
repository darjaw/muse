console.log("JS is working.")

const form = document.getElementById('infoform')
const username = document.getElementById('username');
const password = document.getElementById('password');
let request = new XMLHttpRequest();

// turn the form into a JSON object and submit it to the API as a POST request
form.addEventListener('submit', (e) => {

        let data = new FormData(form);
        console.log(Array.from(data))
        let formObj = {};
        for (let pair of data){
            formObj[pair[0]] = pair[1];
            console.log(JSON.stringify(formObj))
        }


        //api is http://localhost:8081/api/v1/users
        request.open("POST", "http://localhost:8081/login", true);
        request.setRequestHeader("Content-Type", "application/json");
        request.send(JSON.stringify(formObj));
        form.reset();
})