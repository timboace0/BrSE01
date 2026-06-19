let signOutBtn = document.querySelector(".sign-out-link");
let tbody = document.getElementById("table-body");
let listUser = JSON.parse(localStorage.getItem("userList")) || [];

let currentPage = 1;
let perPage = 5;
let totalPage = 0;
// console.log(totalPage);

let perUser = [];

let arrowLeft = document.querySelector(".arrow-left");
let arrowRight = document.querySelector(".arrow-right");

// 5 phan tu dau tien
perUser = listUser.slice(
  (currentPage - 1) * perPage,
  (currentPage - 1) * perPage + perPage,
);
// console.log(perUser);

function renderPageNumber() {
  let paginationList = document.getElementById("pagination-list");
  paginationList.innerHTML = "";
  totalPage = Math.ceil(listUser.length / perPage);
  for (let i = 1; i <= totalPage; i++) {
    let activeClass = i === currentPage ? "highlight" : "";
    paginationList.innerHTML += `<li class="${activeClass}" onClick="handlePageNumber(${i})">${i}</li>`;
  }
}

arrowLeft.addEventListener("click", () => {
  if (currentPage > 1) {
    currentPage--;
    perUser = listUser.slice(
      (currentPage - 1) * perPage,
      (currentPage - 1) * perPage + perPage,
    );
    renderUser(perUser);
  }
});

arrowRight.addEventListener("click", () => {
  if (currentPage < totalPage) {
    currentPage++;
    perUser = listUser.slice(
      (currentPage - 1) * perPage,
      (currentPage - 1) * perPage + perPage,
    );
    renderUser(perUser);
  }
});

function handlePageNumber(num) {
  currentPage = num;
  // console.log(currentPage);
  perUser = listUser.slice(
    (currentPage - 1) * perPage,
    (currentPage - 1) * perPage + perPage,
  );
  renderUser(perUser);
}

signOutBtn.addEventListener("click", (e) => {
  e.preventDefault();
  localStorage.removeItem("savedUser");
  window.location.href = "./sign-in.html";
});

renderUser(perUser);

function renderUser(users) {
  tbody.innerHTML = "";

  users.forEach((element) => {
    let tr = document.createElement("tr");

    let statusClass = element.status === "Active" ? "active" : "deactive";

    tr.innerHTML = `<td>${element.usercode}</td>
    <td>${element.username}</td>
    <td>${element.email}</td>
    <td>${element.role}</td>
    <td>${element.birthday}</td>
    <td class = "${statusClass}">${element.status}</td>
    <td><button class="edit-btn" id=${element.usercode}>Sửa</button>
    <button class="del-btn" id=${element.usercode}>Xóa</button>
    </td>`;
    tbody.appendChild(tr);
  });
  renderPageNumber();
}

// let editBtn = document.querySelector(".edit-btn");
// let delBtn = document.querySelector(".del-btn");

tbody.addEventListener("click", (e) => {
  let targetId = Number(e.target.id);
  if (e.target.classList.contains("edit-btn")) {
    localStorage.setItem("editingUserId", e.target.id);
    window.location.href = "./edit-user.html";
  }
  if (e.target.classList.contains("del-btn")) {
    // console.log("delete function");
    let index = listUser.findIndex((item) => {
      return item.usercode === targetId;
    });
    // console.log(index);
    listUser.splice(index, 1);
    renderUser(listUser);
    // localStorage.setItem("userList", JSON.stringify(listUser));
  }
});

let inputSearch = document.getElementById("search-box");
inputSearch.addEventListener("input", () => {
  let keyword = inputSearch.value.toLowerCase();

  let filteredUsers = listUser.filter((user) => {
    return user.username.toLowerCase().includes(keyword);
  });

  renderUser(filteredUsers);
});
