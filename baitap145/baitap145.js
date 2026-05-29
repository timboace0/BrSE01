let studentList = [
  {
    name: "Gia Bảo",
    age: 18,
    id: "SE174095",
  },
  {
    name: "Gia Huy",
    age: 23,
    id: "SE178544",
  },
];

while (true) {
  let userInput = prompt("Please input function C/R/D: ");
  if (userInput === "C") {
    let name = prompt("Input new student name:");
    let age = +prompt("Input new student age:");
    let id = prompt("Input new student ID:");
    let isExist = studentList.some(function (student) {
      return student.id === id;
    });
    if (isExist) {
      console.log("Student ID already Exist");
    } else {
      studentList.push({
        name: name,
        age: age,
        id: id,
      });
      displayStudentList();
    }
  } else if (userInput === "R") {
    displayStudentList();
  } else if (userInput === "D") {
    let idInput = prompt("Please input Student ID to delete: ");
    let index = studentList.findIndex(function (el, i) {
      return idInput === el.id;
    });
    if (index === -1) {
      console.log("ID not found");
    } else {
      studentList.splice(index, 1);
      displayStudentList();
    }
  } else if (userInput === "E") {
    console.log("Thanks for using the app");
    break;
  } else {
    console.log("Invalid command");
  }
}

function displayStudentList() {
  for (let index in studentList) {
    console.log(`fullName: ${studentList[index].name}`);
    console.log(`age: ${studentList[index].age}`);
    console.log(`studentID: ${studentList[index].id}`);
    console.log("======================");
  }
}
