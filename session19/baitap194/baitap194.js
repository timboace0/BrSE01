let addBtn = document.getElementById("add-btn");
let editingTask = null;
let editingIndex = null;
let todoArr = JSON.parse(localStorage.getItem("todo")) || [];
renderTodo();
taskCount();
addBtn.addEventListener("click", (e) => {
  e.preventDefault();
  let inputTodo = document.getElementById("todo-input");

  if (inputTodo.value === "") {
    inputTodo.placeholder = "Hãy nhập gì đó!";
    inputTodo.classList.add("red-placeholder");
  } else {
    inputTodo.classList.remove("red-placeholder");
    inputTodo.placeholder = "Add your new todo";

    if (editingTask) {
      todoArr[editingIndex] = inputTodo.value;

      localStorage.setItem("todo", JSON.stringify(todoArr));

      renderTodo();

      editingTask = null;
      editingIndex = null;

      addBtn.innerHTML = '<i class="fa-solid fa-plus"></i>';

      inputTodo.value = "";

      return;
    }
    todoArr.push(inputTodo.value);

    localStorage.setItem("todo", JSON.stringify(todoArr));

    renderTodo();
    inputTodo.value = "";
  }
});

function deleteTask() {
  let delBtn = document.getElementsByClassName("delete-btn");

  for (let index = 0; index < delBtn.length; index++) {
    delBtn[index].addEventListener("click", function () {
      this.parentElement.parentElement.remove();
      let taskText =
        this.parentElement.parentElement.querySelector("span").textContent;

      todoArr = todoArr.filter((item) => item !== taskText);

      localStorage.setItem("todo", JSON.stringify(todoArr));
      taskCount();
    });
  }
}

function taskCount() {
  let taskCount = document.getElementById("task-count");
  let ul = document.getElementById("todo-list");

  taskCount.textContent = ul.childElementCount;
}

let clearBtn = document.getElementById("clear-btn");
clearBtn.addEventListener("click", (e) => {
  todoArr = [];

  localStorage.setItem("todo", JSON.stringify(todoArr));

  renderTodo();
  taskCount();
});

function update() {
  let updateBtn = document.getElementsByClassName("update-btn");
  for (let index = 0; index < updateBtn.length; index++) {
    updateBtn[index].addEventListener("click", function () {
      let li = this.parentElement.parentElement;
      //   console.log(li);
      let inputTodo = document.getElementById("todo-input");

      let taskContent = li.querySelector("span").textContent;
      inputTodo.value = taskContent;
      editingTask = li;
      editingIndex = index;
      addBtn.textContent = "Update";
      addBtn.style.fontSize = "18px";
    });
  }
}

function renderTodo() {
  let ul = document.getElementById("todo-list");

  ul.innerHTML = "";

  for (let i = 0; i < todoArr.length; i++) {
    let li = document.createElement("li");

    li.innerHTML = `
      <span>${todoArr[i]}</span>

      <div class="action-group">
        <button class="update-btn">
          <i class="fa-solid fa-pen"></i>
        </button>

        <button class="delete-btn">
          <i class="fa-solid fa-trash"></i>
        </button>
      </div>
    `;

    ul.appendChild(li);
  }

  deleteTask();
  update();
  taskCount();
}
