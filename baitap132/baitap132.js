const arr = [2,55,76,99,254,13,64];

let userNumber = Number(prompt("Nhập số bất kỳ: "));
let _check = false;

for(let i = 0; i <= arr.length - 1; i++){
    if(userNumber === arr[i]){
        _check = true;
    };
};

if(_check){
    alert("Bingo");
} else {
    alert("Chúc bạn may mắn lần sau");
};