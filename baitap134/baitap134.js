let input = prompt("Nhập dãy số bất kỳ: ");
const newArr = input.split("");

let max = newArr[0];

for(let index in newArr){
    if(newArr[index] > max){
        max = newArr[index];
    }
}

alert(`Phần tử lớn nhất trong mảng là: ${max}`);