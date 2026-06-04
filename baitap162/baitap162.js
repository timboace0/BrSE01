while (true) {
  let input = prompt(
    "Nhập vào mảng số nguyên 10 phần tử (cách nhau bởi dấu ','):",
  );

  if (input.split(",").length === 10) {
    let newArr = input.split(",").map(Number);

    let maxIndex = newArr.reduce((acc, cur, index) => {
      return cur > newArr[acc] ? index : acc;
    }, 0);

    alert(
      `Phần tử lớn nhất của mảng là ${newArr[maxIndex]} nằm ở vị trí ${maxIndex}`,
    );
    break;
  }

  alert("Vui lòng nhập 10 phần tử");
}
