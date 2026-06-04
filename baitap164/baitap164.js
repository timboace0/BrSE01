let input = prompt("Nhập vào mảng số nguyên (cách nhau bởi dấu ','):");

let newArr = input.split(",").map(Number).reverse();

alert(`Mảng đã reversed: ${newArr}`);
