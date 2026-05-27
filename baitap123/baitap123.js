let count = 0;

for (let i = 2; count < 20; i++) {
  let isPrime = true;
  for (let k = 2; k <= Math.sqrt(i); k++) {
    if (i % k === 0) {
      isPrime = false;
      break;
    }
  }
  if (isPrime) {
    console.log(i);
    count++;
  }
}
