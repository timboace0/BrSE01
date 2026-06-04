let input = prompt("Nhập vào mảng số nguyên (cách nhau bởi dấu ','):");

let newArr = input.split(",").map(Number);

let count = 0;

for (elements of newArr) {
  if (!isNaN(elements) && elements < 0) {
    count++;
  }
}

alert(`Số lượng số nguyên âm trong mảng: ${count}`);
