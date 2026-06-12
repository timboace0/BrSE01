let bookForm = document.getElementById("bookmark-form");
let openModalBtn = document.getElementById("open-modal-btn");

let closeModalBtn = document.getElementById("close-modal-btn");

let Modal = document.getElementById("bookmark-modal");

let bookmarkArr = JSON.parse(localStorage.getItem("bookmarks")) || [];
renderBookmark();

openModalBtn.addEventListener("click", function () {
  Modal.classList.remove("hidden");
});

closeModalBtn.addEventListener("click", function () {
  let webName = document.getElementById("website-name");
  let webUrl = document.getElementById("website-url");
  Modal.classList.add("hidden");
  webName.placeholder = "Enter website name";
  webUrl.placeholder = "https://example.com";
});

let saveBtn = document.getElementById("save-btn");

saveBtn.addEventListener("click", function (e) {
  e.preventDefault();
  let webName = document.getElementById("website-name");
  let webUrl = document.getElementById("website-url");
  if (webName.value === "" || webUrl.value === "") {
    webName.placeholder = "Vui lòng điền đầy đủ thông tin";
    webUrl.placeholder = "Vui lòng điền đầy đủ thông tin";
  } else {
    let newBookmark = {
      id: Date.now(),
      webName: webName.value,
      webUrl: webUrl.value,
    };
    bookmarkArr.push(newBookmark);

    localStorage.setItem("bookmarks", JSON.stringify(bookmarkArr));
    renderBookmark();

    Modal.classList.add("hidden");
    webName.value = "";
    webUrl.value = "";
  }
});

function delBookmark(id) {
  let index = bookmarkArr.findIndex((el) => {
    return el.id === id;
  });

  bookmarkArr.splice(index, 1);

  localStorage.setItem("bookmarks", JSON.stringify(bookmarkArr));
  renderBookmark();
}

function renderBookmark() {
  let bookmarkList = document.getElementById("bookmark-list");

  bookmarkList.innerHTML = "";

  bookmarkArr.forEach((element) => {
    bookmarkList.innerHTML += `<div class="bookmark-card">
   <button class="delete-btn" onClick = "delBookmark(${element.id})">×</button>
   <h3>${element.webName}</h3>
   <a>${element.webUrl}</a>
 </div>`;
  });
}
