let input = document.querySelector(".input-item");
// console.log(input);

let btn = document.querySelectorAll("button.item");

let delBtn = document.querySelector(".delete-item");

btn.forEach((button) => {
  button.addEventListener("click", () => {
    input.value += button.textContent;
  });
});

delBtn.addEventListener("click", () => {
  input.value = input.value.slice(0, -1);
});
