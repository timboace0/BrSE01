let submitBtn = document.querySelector("button");
let isEditingId = null;

const courses = JSON.parse(localStorage.getItem("courses")) || [
  {
    id: 1,
    content: "Learn Javascript Session 01",
    dueDate: "2023-04-17",
    status: "Pending",
    assignedTo: "Anh Bách",
  },
  {
    id: 2,
    content: "Learn Javascript Session 2",
    dueDate: "2023-04-17",
    status: "Pending",
    assignedTo: "Lâm th`",
  },
  {
    id: 3,
    content: "Learn CSS Session 1",
    dueDate: "2023-04-17",
    status: "Pending",
    assignedTo: "Hiếu Ci ớt ớt",
  },
];

function renderCourse() {
  let tBody = document.getElementById("tbody");
  tBody.innerHTML = "";
  courses.forEach((elements, index) => {
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <td>${index + 1}</td>
        <td>${elements.content}</td>
        <td>${elements.dueDate}</td>
        <td>${elements.status}</td>
        <td>${elements.assignedTo}</td>
        <td class="action-buttons">
          <button class="btn btn-sm btn-secondary"
            onclick="showEdit(${elements.id})">
            Sửa
          </button>
          <button class="btn btn-sm btn-danger"
            onclick="handleDelete(${elements.id})">
            Xóa
          </button>
        </td>
      `;
    tBody.appendChild(tr);
  });
}

renderCourse();

// Create

let form = document.getElementById("form");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  let content = form.content.value;
  let dueDate = form.dueDate.value;
  let status = form.status.value;
  let assignedTo = form.assignedTo.value;

  let newTask = {
    id: Date.now(),
    content: content,
    dueDate: dueDate,
    status: status,
    assignedTo: assignedTo,
  };

  if (isEditingId === null) {
    courses.push(newTask);
    form.reset();
  } else {
    // tìm vị trí phần tử
    let index = courses.findIndex((elements) => elements.id === isEditingId);
    // update
    courses[index] = {
      id: isEditingId,
      content: form.content.value,
      dueDate: form.dueDate.value,
      status: form.status.value,
      assignedTo: form.assignedTo.value,
    };

    isEditingId = null;
    submitBtn.innerText = "Submit";
    form.reset();
  }

  localStorage.setItem("courses", JSON.stringify(courses));

  renderCourse();
});

// edit
function showEdit(id) {
  let filteredCourse = courses.find((course) => course.id === id);

  form.content.value = filteredCourse.content;
  form.dueDate.value = filteredCourse.dueDate;
  form.status.value = filteredCourse.status;
  form.assignedTo.value = filteredCourse.assignedTo;

  isEditingId = id;
  submitBtn.innerText = "Update";
}

// delete
function handleDelete(id) {
  let index = courses.findIndex((el) => {
    return el.id === id;
  });
  courses.splice(index, 1);

  localStorage.setItem("courses", JSON.stringify(courses));

  renderCourse();
}
