while (true) {
  let arrA = prompt(
    "Nhập vào mảng A số nguyên 10 phần tử (cách nhau bởi dấu ','):",
  );
  let arrB = prompt(
    "Nhập vào mảng B số nguyên 10 phần tử (cách nhau bởi dấu ','):",
  );
  if (arrA.split(",").length === 10 && arrB.split(",").length === 10) {
    let newArrA = arrA.split(",").map(Number);
    let newArrB = arrB.split(",").map(Number);

    let arrC = newArrA.concat(newArrB);
    alert(`Mảng đã được nối: ${arrC}`);
    break;
  }

  alert("Vui lòng nhập 10 phần tử cho cả 2 mảng");
}
