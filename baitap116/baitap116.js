let input1, input2, operator; 

while(true){
    input1 = Number(prompt("Mời bạn nhập vào số a"));
    input2 = Number(prompt("Mời bạn nhập vào số b"));
    if(!Number.isNaN(input1) && !Number.isNaN(input2)){
        break;
    }
    alert("Vui lòng nhập số nhé!");
}

operator = prompt("Mời bạn nhập vào các phép tính (+,-,*,/)");

    while(  operator !== "+" &&
            operator !== "-" &&
            operator !== "*" &&
            operator !== "/" ) {
            alert("Vui lòng nhập đúng phép tính nhé!");
            operator = prompt("Nhập lại phép tính (+, -, *, /)");
            }
            switch(operator) {
                case "+":
                    alert(`kết quả của phép tính trên ${input1} + ${input2} = ${input1 + input2}`);
                    break;
                case "-":
                    alert(`kết quả của phép tính trên ${input1} - ${input2} = ${input1 - input2}`);
                    break;
                case "*":
                    alert(`kết quả của phép tính trên ${input1} * ${input2} = ${input1 * input2}`);
                    break;
                case "/":
                    alert(`kết quả của phép tính trên ${input1} / ${input2} = ${input1 / input2}`);
                    break;
            }

        



