function isEven(number) {
  return number % 2 === 0;
}

let inputUser = +prompt("Nhập số nguyên bất kỳ: ");
alert(`Kết quả: ${isEven(inputUser)}`);
