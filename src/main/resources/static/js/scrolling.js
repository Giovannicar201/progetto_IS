const observer = new IntersectionObserver((entries) => {

    entries.forEach((entry) =>{

        if (entry.isIntersecting) {

            entry.target.classList.add("show");
            entry.target.classList.remove("notShow");

        } else {

            entry.target.classList.add("notShow");
            entry.target.classList.remove("show");

        }

    });

});

const mostra = document.getElementsByClassName("col");
const show = document.getElementsByClassName("card");
const h1 = document.getElementsByClassName("h1");

for (let mostraElement of mostra) {
    observer.observe(mostraElement);
}

for (let showElement of show) {
    observer.observe(showElement);
}

for (let h1Element of h1) {
    observer.observe(h1Element);
}
