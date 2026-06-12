let submitBtn = document.getElementById("submit-btn");
let email = document.getElementById("email");
let pwd = document.getElementById("pwd");

let savedPwd = document.getElementById("remember-pwd");

let currentUser = JSON.parse(localStorage.getItem("savedUser"));

if (currentUser && Date.now() < currentUser.expire) {
  email.value = currentUser.email;
  pwd.value = currentUser.pwd;
  savedPwd.checked = true;
} else {
  localStorage.removeItem("savedUser");
  savedPwd.checked = false;
}

submitBtn.addEventListener("click", (e) => {
  e.preventDefault();

  let inputEmail = document.getElementById("email").value;
  let inputPwd = document.getElementById("pwd").value;
  if (inputEmail === "" || inputEmail !== inputPwd) {
    alert("Email và Password không hợp lệ!");
  } else {
    alert("Đăng nhập thành công!");

    if (savedPwd.checked) {
      let saveUser = {
        email: inputEmail,
        pwd: inputPwd,
        expire: Date.now() + 24 * 60 * 60 * 1000,
      };
      localStorage.setItem("savedUser", JSON.stringify(saveUser));
    }

    window.location.href = "home.html";
  }
});

let showPwdBtn = document.getElementById("show-pwd");

showPwdBtn.addEventListener("click", (e) => {
  e.preventDefault();

  if (pwd.type === "password") {
    pwd.type = "text";
    showPwdBtn.textContent = "Hide Password";
  } else {
    pwd.type = "password";
    showPwdBtn.textContent = "Show Password";
  }
});
