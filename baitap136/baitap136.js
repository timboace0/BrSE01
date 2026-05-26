const newArr = [13,1,6,54,99,76,82,36,51,1,22,27,70,1,88];

let input = Number(prompt("Nhập số nguyên để kiểm tra: "));
let count = 0;

for(let i = 0; i <= newArr.length - 1; i++){
    if(newArr[i] === input){
        count++;
    }
}

alert(`Trong mảng ${newArr}
    
có tổng cộng ${count} phần tử có giá trị ${input}
    `);