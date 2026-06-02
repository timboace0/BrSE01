let form = document.getElementById("form");

let submitBtn = document.getElementById("submit-btn");

form.addEventListener("submit", (event) => {
  event.preventDefault();
  if (form.email.value === "" || form.password.value === "") {
    alert("vui lòng điền đầy đủ thông tin");
  } else if (
    form.email.value === "huanrose@gmail.com" &&
    form.password.value === "123456"
  ) {
    alert("Đăng nhập thành công");
    form.submit();
  } else {
    alert("Đăng nhập thất bại");
  }
});
