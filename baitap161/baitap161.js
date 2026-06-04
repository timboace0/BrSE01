let input = prompt("Nhập vào mảng số nguyên (cách nhau bởi dấu ','):");

let result = input.split(",").filter((el, index) => {
  return el >= 10;
});

alert(`Những số nguyên lớn hơn bằng 10: ${result.toString()}`);
