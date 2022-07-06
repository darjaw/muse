console.log("JS is working.")
let select = document.getElementById('selectOption');

select.addEventListener('click', (e) => {
    console.log(select.value)
});