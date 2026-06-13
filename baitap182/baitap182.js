let products = [
  { id: 1, name: "Milk", count: 100 },
  {
    id: 2,
    name: "Orange",
    count: 100,
  },
  {
    id: 3,
    name: "Butter",
    count: 100,
  },
];

let newObj = { id: 4, name: "Snack", count: 100 };

products.push(newObj);

console.log(`mảng sau khi thêm object:`, products);

let index = products.findIndex((item) => item.id === 2);

products.splice(index, 1);

console.log(`mảng sau khi xóa object id = 2:`, products);

let obj3 = products.find((item) => item.id === 3);

obj3.count = 0;

console.log("mảng sau khi đổi id = 3 là 0:", products);

if (products.some((item) => (item.name = "Butter"))) {
  console.log(
    "Thông tin tìm thấy",
    products.find((item) => item.name === "Butter"),
  );
} else {
  console.log("Không tìm thấy từ khóa Butter");
}

let courses = [
  {
    id: 1,
    courseName: "HTML",
    completeStatus: false,
  },
  {
    id: 2,
    courseName: "CSS",
    completeStatus: false,
  },
  {
    id: 3,
    courseName: "Basic of javascript",
    completeStatus: false,
  },
  {
    id: 4,
    courseName: "Node package manager (npm)",
    completeStatus: false,
  },
  {
    id: 5,
    courseName: "Git",
    completeStatus: false,
  },
];

let input;

let check = true;

while (check) {
  input = prompt("Nhập vào 5 chữ cái C/R/U/D/E");
  switch (input) {
    case "C":
      let inputNewCourse = prompt("Nhập tên cho khóa học mới: ");
      let newCourse = {
        id: courses.length + 1,
        courseName: inputNewCourse,
        completeStatus: true,
      };
      courses.push(newCourse);
      alert("Thêm khóa học mới thành công!");

      break;
    case "R":
      renderCourses();
      break;
    case "U":
      let inputIndex = +prompt("Nhập vào vị trí muốn cập nhật:");
      if (inputIndex < Number(courses.length) && inputIndex >= 0) {
        let newNameCourse = prompt("Nhập tên khóa học để cập nhật:");
        let newStatus;
        while (true) {
          newStatus = prompt("Nhập vào trạng thái mới true|false:");
          if (newStatus === "true" || newStatus === "false") {
            break;
          }
          alert("Vui lòng chỉ nhập true hoặc false");
        }

        courses[inputIndex].courseName = newNameCourse;
        courses[inputIndex].completeStatus = newStatus;
        alert("Cập nhật hành công");
      } else {
        alert("Vui lòng nhập vị trí hợp lệ");
        break;
      }
      break;
    case "D":
      let indexDel = +prompt("Nhập vào vị trí muốn xóa:");
      if (indexDel < courses.length && indexDel >= 0) {
        courses.splice(indexDel, 1);
        alert("Xóa thành công");
        renderCourses();
      } else {
        alert("Vui lòng nhập vị trí hợp lệ");
        break;
      }
      break;
    case "E":
      check = false;
      alert("Cảm ơn bạn đã đến với Rikkei Academy");
      break;
    default:
      alert("Lỗi chương trình");
      break;
  }
}

function renderCourses() {
  let message = "";
  for (index in courses) {
    message += "===================\n";
    message += `Vị trí: ${index}\n`;
    message += `Tên khóa học: ${courses[index].courseName}\n`;
    message += `Trạng thái: ${courses[index].completeStatus}\n`;
    message += "===================\n";
  }
  alert(message);
}
