let todoList = ["Xin việc ở Google", "Mua biệt thự"];
let addBtn = document.getElementById("submit-btn");
let listItem = document.querySelector(".card-item");

let isEditingIndex = null;

// console.log(listItem);
renderTodoList();
function renderTodoList() {
  let inputText = document.getElementById("input");
  todoList.forEach((element, index) => {
    let li = document.createElement("li");
    li.className = "item";
    li.textContent = element;

    let btn = document.createElement("button");
    btn.className = "del-btn";
    btn.textContent = "Xóa";

    btn.addEventListener("click", (e) => {
      e.stopPropagation();

      todoList.splice(index, 1);

      listItem.innerHTML = "";
      renderTodoList();
    });

    let updateBtn = document.createElement("button");
    updateBtn.textContent = "U";
    updateBtn.className = "update-btn";

    updateBtn.addEventListener("click", (e) => {
      e.stopPropagation();
      inputText.value = element;
      isEditingIndex = index;

      addBtn.textContent = "Cập nhật";
    });

    li.appendChild(updateBtn);

    li.appendChild(btn);

    li.addEventListener("click", () => {
      li.classList.toggle("done");
    });

    listItem.appendChild(li);
  });
}

// add:

// console.log(addBtn);

addBtn.addEventListener("click", (e) => {
  e.preventDefault();

  let inputText = document.getElementById("input");
  if (inputText.value === "") {
    inputText.placeholder = "Vui lòng nhập gì đó";
  } else {
    inputText.placeholder = "Title...";

    if (isEditingIndex != null) {
      todoList[isEditingIndex] = inputText.value;
      listItem.innerHTML = "";
      renderTodoList();
      inputText.value = "";
      isEditingIndex = null;
      addBtn.textContent = "Thêm";
      return;
    }
    todoList.push(inputText.value);
    // console.log(todoList);
    listItem.innerHTML = "";
    renderTodoList();
    inputText.value = "";
  }
});
