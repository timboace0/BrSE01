let bookData = [
  {
    bookId: 1,
    bookName: "Hello Peter",
    author: "Peter",
    published: 2022,
  },
  {
    bookId: 2,
    bookName: "Marina Adventure",
    author: "Khang Le",
    published: 2019,
  },
  {
    bookId: 3,
    bookName: "Old Trafford",
    author: "Rooney",
    published: 1999,
  },
];

while (true) {
  let userInput = +prompt(`Please input number below to use function:
    1. Create new book
    2. Display all book
    3. Search book by name
    4. Delete book by ID
    5. Exit
    `);
  switch (userInput) {
    case 1:
      let name = prompt("Please input name of the book:");
      let bookID = +prompt("Please input book ID (No duplicate):");
      let author = prompt("Please input book author:");
      let pYear = +prompt("Please input published Year:");

      let isExist = bookData.some(function (el) {
        return bookID === el.bookId;
      });

      if (isExist) {
        console.log("This ID has been defined");
      } else {
        bookData.push({
          bookId: bookID,
          bookName: name,
          author: author,
          published: pYear,
        });
        displayAllBook();
      }
      break;
    case 2:
      displayAllBook();
      break;
    case 3:
      let inputName = prompt("Please input book name to search: ");
      let bookFiltered = bookData.filter(function (el) {
        return el.bookName
          .toLowerCase()
          .includes(inputName.toLowerCase().trim());
      });
      if (bookFiltered.length === 0) {
        console.log("Can not find any book");
      } else {
        console.log(`List of filtered book:`);
        bookFiltered.forEach(function (el) {
          console.log(`Book ID: ${el.bookId}`);
          console.log(`Book Name: ${el.bookName}`);
          console.log(`Author: ${el.author}`);
          console.log(`Published Year: ${el.published}`);
          console.log("======================");
        });
      }
      break;
    case 4:
      let inputID = +prompt("Please input ID to delete:");
      let index = bookData.findIndex(function (el) {
        return inputID === el.bookId;
      });
      if (index === -1) {
        console.log("Can not find any ID to delete");
      } else {
        console.log("Delete successfully");
        bookData.splice(index, 1);
        displayAllBook();
      }
      break;
    case 5:
      console.log("Exit successfully");
      break;

    default:
      console.log("Cannnot compile");
      break;
  }
  if (userInput === 5) {
    break;
  }
}

function displayAllBook() {
  for (let index in bookData) {
    console.log(`Book ID: ${bookData[index].bookId}`);
    console.log(`Book Name: ${bookData[index].bookName}`);
    console.log(`Author: ${bookData[index].author}`);
    console.log(`Published Year: ${bookData[index].published}`);
    console.log("======================");
  }
}
