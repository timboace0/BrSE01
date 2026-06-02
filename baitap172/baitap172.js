let btnToggle = document.getElementById("btn-toogle");

let toggleMode = document.querySelector(".dark-mode");

btnToggle.addEventListener("click", () => {
  toggleMode.classList.toggle("white-mode");
});
