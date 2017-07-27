// 버튼이 클릭되었을 때의 동작.
function buttonClicked() {
	var userMove = null;
	userMove = document.getElementById("userMove").value;

	computerMove = getComputerMove();

	var finalResult = finalJudge(userMove, computerMove);
	showResult(finalResult, userMove, computerMove);
}

// 결과를 출력해준다.
function showResult(result, userMove, computerMove){
	alert(
			"\nYour Move : " + userMove +
			"\nComputerMove : "+computerMove +
			"\n\n" +result
	);
}

// 유저와 컴퓨터의 수를 읽어서 결과를 리턴한다.
function finalJudge(move_u, move_c) {
	//alert("user : "+move_u+" // "+"computer : "+move_c);
	if (move_u == move_c) {
		return "Draw";
	} else if (move_u == "rock" && move_c == "paper") {
		return "Lose!";
	} else if (move_u == "rock" && move_c == "scissors") {
		return "Win!";
	} else if (move_u == "paper" && move_c == "rock") {
		return "Win!";
	} else if (move_u == "paper" && move_c == "scissors") {
		return "Lose!";
	} else if (move_u == "scissors" && move_c == "rock") {
		return "Lose!";
	} else if (move_u == "scissors" && move_c == "paper") {
		return "Win!";
	} else {
		return "Error Occurred!!!";
	}
}

// 컴퓨터의 동작을 2개로 나누어서 실행하여, 컴퓨터의 가위바위보 계산결과를 내보낸다.
function getComputerMove() {
	var cal01 = process01();
	var cal02 = process02(cal01);

	return cal02;
}

// 과정 01 : 난수를 생성해서 내보낸다. 범위는 1 ~ 9.
function process01() {
	var result = null;
	var kicker = true;
	var randomNumber = 0;
	while (kicker) {
		randomNumber = Math.floor(Math.random() * 10);
		if (randomNumber != 0) {
			result = randomNumber;
			kicker = false;
		}
	}
	return result;
}

// 과정 02 : 가위/바위/보 중에 하나를 파라미터로 들어온 난수를 통해 문자열을 정하여 리턴한다.
function process02(comNum) {
	if (1 <= comNum && comNum <= 3) {
		return "rock";
	}
	if (4 <= comNum && comNum <= 6) {
		return "paper";
	}
	if (7 <= comNum && comNum <= 9) {
		return "scissors";
	}
}