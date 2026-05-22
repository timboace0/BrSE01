let input = +prompt("Nhập số năm muốn kiểm tra: ");

if(input % 4 === 0 && input % 100 !== 0){
    document.write(`<h1> Năm ${input} đúng là năm nhuận </h1>`);
} else if(input % 100 === 0 && input % 400 !== 0){
    document.write(`<h1> Năm ${input} không phải là năm nhuận </h1>`);
} else if(input % 100 === 0 && input % 400 === 0) {
    document.write(`<h1> Năm ${input} đúng là năm nhuận </h1>`);
} else {
    document.write(`<h1> Năm ${input} không phải là năm nhuận </h1>`);
}

