const newArr = [];


for(let i = 1; i <= 10; i++){
    let randomNumber = Math.floor(Math.random() * (100 - 1 + 1)) + 1;
    newArr.push(randomNumber);
}

document.write(newArr);
console.log(newArr);
