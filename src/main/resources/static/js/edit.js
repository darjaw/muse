console.log("JS is working.")

// send the bio to the API as a PUT request on submit
let form = document.getElementById('bioForm');
let bioEdit = document.getElementById('bioEdit');
form.addEventListener('submit', (e) => {

    console.log(bioEdit.value)
    let url = "http://localhost:8081/api/v1/user/1/bio?bio=" + bioEdit.value;
    let request = new XMLHttpRequest();
    request.open("PUT", url, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send();
});