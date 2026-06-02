let text = document.getElementById("text");

let btnHide = document.getElementById("btnHide");
let btnShow = document.getElementById("btnShow");

btnHide.addEventListener("click", () => {
  text.style.display = "none";
});

btnShow.addEventListener("click", () => {
  text.style.display = "";
});
