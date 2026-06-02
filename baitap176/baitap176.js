let buttons = document.querySelectorAll("button");
let display = document.querySelector(".display");

let equal = document.querySelector(".equal");

let operator = "";

buttons.forEach(function (ele) {
  ele.addEventListener("click", () => {
    if (ele.textContent === "=") {
      return;
    } else if (ele.textContent === "C") {
      operator = "";
      display.value = "";
      display.style.color = "black";
      return;
    }
    operator += ele.textContent;
    display.value = operator;
  });
});

equal.addEventListener("click", () => {
  try {
    let result = eval(operator);
    display.value = result;

    if (!isFinite(result)) {
      display.style.color = "red";
      display.value = "Không thể chia 0";
      operator = "";
      return;
    }
  } catch (error) {
    display.style.color = "red";
    display.value = "Phép tính không hợp lệ";
  }
});
