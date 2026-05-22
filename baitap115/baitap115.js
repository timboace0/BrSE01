let weight = Number(prompt("Nhập cân nặng (kg): "));
let height = Number(prompt("Nhập chiều cao (cm): "));

height = height/100;

let bmi = weight / (height * height);

let whoResult = "";
let idiResult = "";


// ===== WHO =====
if (bmi < 18.5) {
    whoResult = "Cân nặng thấp (gầy)";
} else if (bmi <= 24.9) {
    whoResult = "Bình thường";
} else if (bmi <= 29.9) {
    whoResult = "Tiền béo phì";
} else if (bmi <= 34.9) {
    whoResult = "Béo phì độ I";
} else if (bmi <= 39.9) {
    whoResult = "Béo phì độ II";
} else {
    whoResult = "Béo phì độ III";
}

// ===== IDI & WPRO =====
if (bmi < 18.5) {
    idiResult = "Cân nặng thấp (gầy)";
} else if (bmi <= 22.9) {
    idiResult = "Bình thường";
} else if (bmi <= 24.9) {
    idiResult = "Thừa cân";
} else if (bmi <= 29.9) {
    idiResult = "Béo phì độ I";
} else {
    idiResult = "Béo phì độ II";
}

alert(`
BMI của bạn: ${bmi.toFixed(1)}

Theo WHO:
${whoResult}

Theo IDI & WPRO:
${idiResult}
`);
