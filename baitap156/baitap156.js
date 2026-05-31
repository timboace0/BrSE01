const arr1 = [1, 2, 3, 4, 5, 6]; // sum = 21
const arr2 = [10, 20, 30, 40, 50]; // sum = 150
const arr3 = [1, 3, 5, 7, 9]; // sum = 25

function sumArray(arr) {
  return arr.reduce((acc, cur) => {
    return acc + cur;
  }, 0);
}

console.log(sumArray(arr1));
console.log(sumArray(arr2));
console.log(sumArray(arr3));
