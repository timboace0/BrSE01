let openBtn = document.getElementById("open-btn");

let closeBtn = document.getElementById("close-btn");

let modal = document.getElementById("modal");

openBtn.addEventListener("click", () => {
  modal.style.display = "block";
});

closeBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

modal.addEventListener("click", (e) => {
  if (modal === e.target) {
    modal.style.display = "none";
  }
});
