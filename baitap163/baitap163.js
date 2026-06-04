let input = prompt("Nhập vào mảng số nguyên (cách nhau bởi dấu ','):");

let newArr = input.split(",").map(Number);

let max = newArr.reduce((acc, cur, index) => {
  return cur > acc ? newArr[index] : acc;
});

let sum = 0;
for (index in newArr) {
  sum += newArr[index];
}
let avg = sum / newArr.length;
alert(`Giá trị lớn nhất trong mảng: ${max}
Giá trị trung bình các phần tử trong mảng: ${avg} `);
