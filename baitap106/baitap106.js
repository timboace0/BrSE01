
let math_score = Number(prompt("Nhập điểm môn toán: "));
let physics_score = Number(prompt("Nhập điểm môn vật lý: "));
let chemistry_score = Number(prompt("Nhập điểm môn hóa: "));

let avg_score = (math_score + physics_score + chemistry_score) /3;

let avg_score_fixed = avg_score.toFixed(2);

document.write(`Điểm môn toán: ${math_score} <br/>`);
document.write(`Điểm môn vật lý: ${physics_score} <br/>`);
document.write(`Điểm môn hóa: ${chemistry_score} <br/>`);
document.write("Điểm trung bình 3 môn là: " + avg_score_fixed + "đ");