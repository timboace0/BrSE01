// C - R - U -D
let studentList = [
  {
    id: Date.now(),
    name: "Gia Khang",
    age: 21,
    class: "A1",
  },
  {
    id: Date.now(),
    name: "Mai Phượng",
    age: 22,
    class: "B1",
  },
];
// R:

function renderStudents() {
  let tBody = document.getElementById("table-body");
  tBody.innerHTML = "";
  studentList.forEach((elements) => {
    let tr = document.createElement("tr");

    tr.innerHTML = `<td>${elements.name}</td>
            <td>${elements.age}</td>
            <td>${elements.class}</td>
            <td>
              <div class="action-buttons">
                <button class="btn-edit">Sửa</button>
                <button class="btn-delete">Xóa</button>
              </div>
            </td>`;

    tBody.appendChild(tr);
  });

  DelStudents();
}

renderStudents();

let addBtn = document.getElementById("btn-add");
// console.log(inputName, inputAge, inputClass);

addBtn.addEventListener("click", (e) => {
  e.preventDefault();

  let inputName = document.getElementById("name").value;
  let inputAge = document.getElementById("age").value;
  let inputClass = document.getElementById("class").value;

  if (inputName === "" || inputAge === "" || inputClass === "") {
    alert("Vui lòng điền đầy đủ thông tin");
  } else {
    let newStudents = {
      id: Date.now(),
      name: inputName,
      age: inputAge,
      class: inputClass,
    };

    studentList.push(newStudents);
    renderStudents();
    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("class").value = "";
  }
});

// console.log(btnDel);
function DelStudents() {
  let btnDel = document.getElementsByClassName("btn-delete");

  for (let index = 0; index < btnDel.length; index++) {
    btnDel[index].addEventListener("click", (e) => {
      studentList.splice(index, 1);
      renderStudents();
    });
  }
}
