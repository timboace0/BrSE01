const arr1 = [3, 5, 1, 8, -3, 7, 8];
const arr2 = [7, 12, 6, 9, 20, 56, 89];
const arr3 = [];
const arr4 = [0, 0, 0, 0, 0, 0];

function findMin(array) {
  if (!Array.isArray(array)) {
    console.log("Không phải là mảng");
    return;
  }
  if (array.length === 0) {
    console.log("Mảng không có phần tử");
    return;
  }

  return array.reduce((acc, cur) => {
    return Math.min(acc, cur);
  });
}

function checkUndefined(result) {
  if (result !== undefined) {
    console.log(result);
    return result;
  }
}
checkUndefined(findMin(arr1));
checkUndefined(findMin(arr2));
checkUndefined(findMin(arr3));
checkUndefined(findMin(arr4));
