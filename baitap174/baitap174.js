let yellow = document.getElementById("yellow");

let green = document.getElementById("green");

let grey = document.getElementById("grey");

let container = document.getElementById("container");

yellow.addEventListener("mouseover", () => {
  container.style.backgroundColor = "yellow";
});

green.addEventListener("mouseover", () => {
  container.style.backgroundColor = "green";
});

grey.addEventListener("mouseover", () => {
  container.style.backgroundColor = "grey";
});
