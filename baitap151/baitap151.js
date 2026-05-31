let result = "";

function processConfirm(question) {
  let answer = confirm(question);
  if (answer) {
    result = "Excellent. We'll play a nice game of chess.";
  } else {
    result = "Maybe later then.";
  }
  return console.log(result);
}

processConfirm("Are you OK?");
