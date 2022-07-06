const username = document.getElementById('userName');
const bio = document.getElementById('userBio');
const email = document.getElementById('email');

let request = new XMLHttpRequest();
request.onreadystatechange = function() {
   console.log("a string got here")
    if (request.readyState === XMLHttpRequest.DONE) {
        let profile = JSON.parse(request.responseText)

        console.log(profile.userName)
        username.innerText = profile.userName

        console.log(profile.bio)
        bio.innerText = profile.bio

        console.log(profile.email)
        email.innerText = profile.email
    }
}
// request.setRequestHeader("Content-Type", "application/json")
request.open('GET', 'http://localhost:8081/api/v1/user/1', true);
request.send(null);

