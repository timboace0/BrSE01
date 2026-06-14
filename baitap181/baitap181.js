let newPerson = {
  id: 1,
  name: "John",
  age: 18,
  address: "123 Luden Street",
  phoneNum: "0938761955",
};

document.write("Tên người dùng từ mảng: ", newPerson.name + "<br>");
document.write("Tuổi người dùng: ", newPerson.age + "<br>");
document.write("Địa chỉ người dùng: ", newPerson.address + "<br>");
document.write("Sđt người dùng: ", newPerson.phoneNum + "<br>");

let student = { id: 1, name: "Nguyễn Văn A", gender: "nam", age: 20, mark: 8 };

let newStudent = {
  id: 2,
  name: "Nguyễn Văn B",
  gender: "nam",
  age: 18,
  mark: 9,
};

let students = [];
students.push(student);
students.push(newStudent);
let container = document.getElementById("student-container");
for (let i = 0; i < students.length; i++) {
  container.innerHTML += `<h3>Học sinh ${i + 1}</h3>

    <table class="main-table">
      <thead>
        <tr>
          <th>Key</th>
          <th>Value</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>id</td>
          <td>${students[i].id}</td>
        </tr>
        <tr>
          <td>name</td>
          <td>${students[i].name}</td>
        </tr>
        <tr>
          <td>gender</td>
          <td>${students[i].gender}</td>
        </tr>
        <tr>
          <td>age</td>
          <td>${students[i].age}</td>
        </tr>
        <tr>
          <td>mark</td>
          <td>${students[i].mark}</td>
        </tr>
      </tbody>
    </table>
    <br>
  `;
}

let topStu = students.reduce((acc, cur) => {
  return cur.mark > acc.mark ? cur : acc;
});
console.log(topStu);

document.write("THÔNG TIN HỌC SINH ĐIỂM CAO NHẤT:" + "<br>");
document.write("ID: ", topStu.id + "<br>");
document.write("TÊN: ", topStu.name + "<br>");
document.write("GIỚI TÍNH: ", topStu.gender + "<br>");
document.write("TUỔI: ", topStu.age + "<br>");
document.write("ĐIỂM: ", topStu.mark + "<br>");
