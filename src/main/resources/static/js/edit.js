console.log("JS is working.")
let bioForm = document.getElementById('bioForm');
let bioEdit = document.getElementById('bioEdit');
let youtubeForm = document.getElementById('youtubeLink');
let youtubeEdit = document.getElementById('youtubeLinkEdit');

let request = new XMLHttpRequest();


// send the bio to the API as a PUT request on submit
bioForm.addEventListener('submit', (e) => {
    console.log(bioEdit.value)
    let url = "http://localhost:8081/api/v1/user/1/bio?bio=" + bioEdit.value;
    request.open("PUT", url, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send();
});

// send the youtube link to the API as a PUT request on submit
youtubeForm.addEventListener('submit', (e) => {
    console.log(youtubeEdit.value)
    let url = "http://localhost:8081/api/v1/user/1/youtube?youtubeLink=" + youtubeEdit.value;
    request.open("PUT", url, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send();
});