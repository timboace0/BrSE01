let name = "";
let age = 0,
  sum = 0,
  mul = 1;
let seriNumber, str;
let result = "";
let primeCheck = 0;
let oddEven, inputSum;
let input;
while (input !== 10) {
  input = +prompt(`Lựa chọn Menu:
1. Nhập tên người dùng
2. Nhập tuổi người dùng
3. In tên và tuổi
4. In bảng cửu chương
5. Kiểm tra chẵn/lẻ
6. Tính tổng 1 đến N
7. In dãy số
8. Kiểm tra số nguyên tố
9. Đảo chuỗi
10. Thoát`);
  switch (input) {
    case 1:
      name = prompt("Nhập tên bạn:");
      break;
    case 2:
      age = +prompt("Nhập tuổi bạn:");
      break;
    case 3:
      alert(`Bạn tên ${name} và ${age} tuổi `);
      break;
    case 4:
      mul = +prompt("Chọn số để in bảng cửu chương:");
      for (let i = 1; i <= 10; i++) {
        result += `${mul} * ${i} = ${mul * i}\n`;
      }
      alert(result);
      break;
    case 5:
      oddEven = +prompt("Nhập số để kiểm tra chẵn lẻ:");
      if (oddEven % 2 == 0) {
        alert(`${oddEven} là số chẵn`);
      } else {
        alert(`${oddEven} là số lẻ`);
      }
      break;
    case 6:
      inputSum = +prompt("Nhập số tự nhiên N để tính tổng:");
      sum = 0;
      for (let i = 1; i <= inputSum; i++) {
        sum += i;
      }
      alert(`Tổng là ${sum}`);
      break;
    case 7:
      seriNumber = prompt("Nhập dãy số muốn in:");
      alert(seriNumber.split(""));
      break;
    case 8:
      primeCheck = +prompt("Nhập số kiểm tra số nguyên tố:");
      let isPrime = true;
      if (primeCheck < 2) {
        isPrime = false;
      }
      for (let i = 2; i < Math.sqrt(primeCheck); i++) {
        if (primeCheck % i === 0) {
          isPrime = false;
          break;
        }
        if (isPrime) {
          alert(`${primeCheck} là số nguyên tố`);
        } else {
          alert(`${primeCheck} KHÔNG là số nguyên tố`);
        }
      }
      break;
    case 9:
      str = prompt("Nhập chuỗi muốn đảo ngược:");
      let strReverse = str.split("").reverse().join("");
      alert(strReverse);
      break;
    case 10:
      alert("Bạn đã thoát chương trình");
      input = 10;
      break;
    default:
      alert("Chương trình lỗi");
      break;
  }
}
