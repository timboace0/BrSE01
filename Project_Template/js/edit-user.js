let editingUserId = localStorage.getItem("editingUserId");

let listUser = JSON.parse(localStorage.getItem("userList")) || [];

let backBtn = document.querySelector(".back-btn");

let hidePwd = document.querySelector(".fa-eye");
let showPwd = document.querySelector(".fa-eye-slash");

let saveBtn = document.querySelector(".save-btn");

hidePwd.addEventListener("click", () => {
  pwd.type = "text";
  showPwd.style.display = "inline-block";
  hidePwd.style.display = "none";
});

showPwd.addEventListener("click", () => {
  pwd.type = "password";
  hidePwd.style.display = "inline-block";
  showPwd.style.display = "none";
});

let editingUser = listUser.find((user) => {
  return user.usercode === editingUserId;
});

let index = listUser.findIndex((user) => {
  return user.usercode === editingUser.usercode;
});

// console.log(index);

// console.log(editingUser);

let userCode = document.getElementById("user-code");
// console.log(userCode);

let username = document.getElementById("username");
let email = document.getElementById("email");
let pwd = document.getElementById("password");
let role = document.getElementById("role");
let dob = document.getElementById("dob");
let status = document.querySelectorAll('input[name = "status"]');
let description = document.querySelector(".description-text-input");

userCode.value = editingUser.usercode;
email.value = editingUser.email;
username.value = editingUser.username;
pwd.value = editingUser.password;
role.value = editingUser.role;
dob.value = editingUser.birthday;

let currentStatus = editingUser.status;
status.forEach((element) => {
  if (element.value === currentStatus) {
    element.checked = true;
  }
});

description.value = editingUser.description;

backBtn.addEventListener("click", (e) => {
  e.preventDefault();
  window.history.back();
});

saveBtn.addEventListener("click", (e) => {
  e.preventDefault();

  let checkCurrentStatus = document.querySelector(
    'input[name="status"]:checked',
  ).value;

  let editedUser = {
    usercode: userCode.value,
    username: username.value,
    email: email.value,
    password: pwd.value,
    birthday: dob.value,
    description: description.value,
    role: role.value,
    status: checkCurrentStatus,
  };

  if (JSON.stringify(editingUser) === JSON.stringify(editedUser)) {
    Swal.fire({
      icon: "info",
      title: "Không có dữ liệu thay đổi!",
    });

    return;
  }

  listUser[index] = editedUser;

  localStorage.setItem("userList", JSON.stringify(listUser));

  Swal.fire({
    icon: "success",
    title: "Cập nhật người dùng thành công!",
  }).then(function () {
    window.location.href = "./dashboard.html";
  });

  localStorage.removeItem("editingUserId");
});
