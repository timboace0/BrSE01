while (true) {
  let input = prompt(
    "Nhập vào mảng số nguyên 10 phần tử (cách nhau bởi dấu ','):",
  );

  if (input.split(",").length === 10) {
    let newArr = input.split(",").map(Number);

    let sortArr = newArr.sort((a, b) => b - a);
    alert(`Mảng đã sắp xếp thứ tự giảm dần: ${sortArr}`);
    break;
  }

  alert("Vui lòng nhập 10 phần tử");
}
