let input = prompt(
  "Nhập vào mảng số nguyên 10 phần tử (cách nhau bởi dấu ','):",
);

let newArr = input.split(",").map(Number);

let k = +prompt("Nhập số nguyên X cần tìm trong mảng: ");

let flag = false;

for (let i = 0; i <= newArr.length; i++) {
  if (newArr[i] === k) {
    flag = true;
    break;
  }
}

if (flag) {
  alert("Number X is in the array");
} else {
  alert("Number X is not in the array");
}
