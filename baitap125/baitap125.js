let count = 20;

let a = 0,
  b = 1;

for (let i = 0; i < count; i++) {
  console.log(a);

  let nextNum = a + b;
  a = b;
  b = nextNum;
}
