let submitBtn = document.getElementById("submit-btn");

submitBtn.addEventListener("click", (e) => {
  e.preventDefault();
  let inputEmail = document.getElementById("email").value;
  let inputPwd = document.getElementById("pwd").value;
  let inputPwdConfirm = document.getElementById("pwd-confirm").value;
  if (inputEmail === "" || inputPwd === "") {
    alert("Vui lòng điền đầy đủ thông tin");
  } else if (inputPwd !== inputPwdConfirm) {
    alert("Mật khẩu xác nhận không khớp");
  } else {
    localStorage.setItem("email", inputEmail);
    localStorage.setItem("password", inputPwd);
    localStorage.setItem("password-confirm", inputPwd === inputPwdConfirm);
    alert("Đăng ký thành công!");
    document.getElementById("register-form").reset();
  }
});
