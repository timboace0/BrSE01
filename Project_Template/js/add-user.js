let username = document.getElementById("username");
let email = document.getElementById("email");
let pwd = document.getElementById("password");
let role = document.getElementById("role");
let dob = document.getElementById("dob");
let sta = document.querySelector('input[name = "status"]:checked');
let description = document.querySelector(".description-text-input");

let hidePwd = document.querySelector(".fa-eye");
let showPwd = document.querySelector(".fa-eye-slash");

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
// console.log(username, email, pwd, role, dob, status, description);

let backBtn = document.querySelector(".back-btn");
// console.log(backBtn);
let addBtn = document.querySelector(".add-btn");

backBtn.addEventListener("click", (e) => {
  e.preventDefault();
  window.history.back();
});

addBtn.addEventListener("click", (e) => {
  e.preventDefault();
  if (!validateAddUser(username.value, email.value, pwd.value)) {
    return;
  }

  let newUser = {
    usercode: Date.now(),
    username: username.value,
    email: email.value,
    password: pwd.value,
    birthday: dob.value || "1989-10-02",
    description: description.value || "none",
    role: role.value,
    status: sta.value,
  };

  let userList = JSON.parse(localStorage.getItem("userList")) || [];

  userList.push(newUser);

  localStorage.setItem("userList", JSON.stringify(userList));

  Swal.fire({
    icon: "success",
    title: "Tạo tài khoản mới thành công!",
    text: `Bạn vừa tạo tài khoản cho: ${username.value}`,
  }).then(function () {
    window.location.href = "./dashboard.html";
  });
});

function validateAddUser(username, email, password) {
  if (username === "" && email === "" && password === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Bạn phải nhập đầy đủ các trường!",
    });
    return false;
  }
  if (username === "" && email === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Username và Email không được để trống!",
    });
    return false;
  }
  if (username === "" && password === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Username và Password không được để trống!",
    });
    return false;
  }
  if (email === "" && password === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Email và Password không được để trống!",
    });
    return false;
  }
  if (username === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Username không được để trống!",
    });
    return false;
  }
  if (email === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Email không được để trống!",
    });
    return false;
  }
  if (password === "") {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Password không được để trống!",
    });
    return false;
  }
  let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/gm;
  if (!emailRegex.test(email)) {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Vui lòng nhập đúng định dạng cho email!",
    });
    return false;
  }
  if (password.length < 8) {
    Swal.fire({
      icon: "error",
      title: "Lỗi",
      text: "Password phải từ 8 ký tự trở lên!",
    });
    return false;
  }
  return true;
}
