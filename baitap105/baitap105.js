let dollars = Number(prompt("Nhập số tiền Đô La Mỹ muốn đổi: "));

let vnd = dollars * 25000;

document.write(`Kết quả: ${dollars}$ đổi được ${vnd.toLocaleString("vi-VN")} vnđ.`);