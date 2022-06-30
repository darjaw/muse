console.log("JS is working.")

const form = document.getElementById('infoform')
const password = document.getElementById('password');
const confirm = document.getElementById('confirmpassword');
let request = new XMLHttpRequest();

// turn the form into a JSON object and submit it to the API as a POST request
form.addEventListener('submit', (e) => {
    if (password.value < 6) {
        alert("Password must be at least 6 characters long.")
        e.preventDefault()
    }
    if (password.value !== confirm.value) {
        e.preventDefault()
        alert("Passwords do not match.")
    }
    else {
        // e.preventDefault();
        let data = new FormData(form);
        console.log(Array.from(data))
        let formObj = {};
        for (let pair of data){
            formObj[pair[0]] = pair[1];
            console.log(JSON.stringify(formObj))
        }


        //api is http://localhost:8081/api/v1/users
        request.open("POST", "http://localhost:8081/api/v1/user", true);
        request.setRequestHeader("Content-Type", "application/json");
        request.send(JSON.stringify(formObj));
        form.reset();
    }

})