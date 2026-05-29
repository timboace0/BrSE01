let original = {
  name: "Bob",
  age: 30,
};

let copy = Object.assign({}, original);
copy.name = "Charlie";
console.log("đối tượng original", original);
console.log("đối tượng copy", copy);
