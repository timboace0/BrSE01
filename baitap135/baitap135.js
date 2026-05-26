const randomArr = [];

for(let i = 1; i <= 20; i++){
    randomArr.push(Math.floor(Math.random() * (100 - 1 + 1)) + 1);
}

let sumOddNumber = 0;
let sumEvenNumber = 0;

for(let i = 0; i <= randomArr.length - 1; i++){
    if(randomArr[i] % 2 == 0){
        sumEvenNumber = sumEvenNumber + randomArr[i];
    } else {
        sumOddNumber = sumOddNumber + randomArr[i]; 
    }
}

alert(`Mảng ngẫu nhiên được tạo gồm ${randomArr.length} phần tử: ${randomArr}
    
Tổng giá trị các số lẻ trong mảng: ${sumOddNumber}
    
Tổng giá trị các số chẵn trong mảng: ${sumEvenNumber}
    `);