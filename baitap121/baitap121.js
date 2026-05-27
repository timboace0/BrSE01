let input1 = +prompt("Nhập số a: ");
let input2 = +prompt("Nhập số b: ");
if (input1 % input2 == 0) {
  alert(`${input1} chia hết cho ${input2}`);
} else {
  alert(`${input1} KHÔNG chia hết cho ${input2}`);
}
