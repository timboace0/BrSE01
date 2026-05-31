let input = prompt("Nhập chuỗi để kiểm tra: ");

function isPalindrome(str) {
  return str === str.split("").reverse().join("");
}

if (isPalindrome(input)) {
  alert("Đây là chuỗi đối xứng");
} else {
  alert("Đây KHÔNG phải chuỗi đối xứng");
}
