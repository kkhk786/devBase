document.write("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
document.write("<br/>");
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

var i = 0;
for (i = 0; i <= 10; i++) {
	document.write("Hello javascript!");
	document.write("<br/>");
}

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
document.write("<br/>");
document.write("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

/** 
 * 자바스크립트의 기본 타입은 숫자, 문자열, 불린값을 비롯해 
 * null과 undefined라는 타입이 있다.
 * 이들 타입의 특징은 그 자체가 하나의 값을 나타낸다는 것이다.
 */

// number type
var intNum = 10;
var floatNum = 0.1;

// String type
var singleQuoteStr = 'single quote string';
var doubleQuoteStr = "double quote string";
var singleChar = 'a';

// boolean type
var boolVar = true;

// undefied type
var emptyVar;

// null type
var nullVar = null;

/**
 * 해당 변수의 타입을 자바스크립트의 typeof연산자를 이용해 출력한다.
 * typeof 연산자는 피연산자의 타입을 리턴한다.
*/

document.write("<br/>");
document.write(typeof intNum);
document.write("<br/>");
document.write(typeof floatNum);
document.write("<br/>");
document.write(typeof singleQuoteStr);
document.write("<br/>");
document.write(typeof doubleQuoteStr);
document.write("<br/>");
document.write(typeof singleChar);
document.write("<br/>");
document.write(typeof boolVar);
document.write("<br/>");
document.write(typeof emptyVar);
document.write("<br/>");
document.write(typeof nullVar);
document.write("<br/>");

/**
 * 자바스크립트는 느슨한 타입 체크 언어다. 엄격한 타입 체크 언어인 C언어는 변수를 선언할 때 
 * 변수에 저장할 데이터에 종류(문자, 정수, 실수 등)에 따라 char, int, float등의 
 * 예약어를 이용해서 변수의 데이터 타입을 지정해야 한다. 그리고 이렇게 지정된 변수의 데이터 
 * 타입에 맞게 해당 변수에 값을 저장하고 사용하는 것이 일반적이다.
 * 
 * 반면 자바스크립트는 변수를 선언할 때 타입을 미리 정하지 않고, var라는 한 가지 키워드로만 
 * 변수를 선언한다. 이렇게 선언된 변수에는 어떤 타입의 데이터라도 저장하는 것이 가능하다. 
 * 따라서 자바스크립트는 변수에 어떤 형태의 데이터를 저장하느냐에 따라 해당 변수의 타입이 
 * 결정된다. 이는 C나 자바같이 엄격한 타입 체크 언어에 익숙하다면 어색할 수도 있다.
*/

document.write("<br/>");
document.write("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
document.write("<br/>");
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
/**
 * C언어의 경우 정수냐 실수냐에 따라 int, long, float, double 등과 같은 다양한
 * 숫자 타입이 존재하지만, 자바스크립트는 하나의 숫자형만 존재한다. 자바스크립트에서는
 * 모든 숫자를 64비트 부동 소수점 형태로 저장하기 때문이다. 이는 C언어의 double 타입과
 * 유사하다. 따라서 var 키워드로 선언된 자바스크립트 변수에는 정수나 실수 구분 없이 그
 * 값을 바로 저장할 수 있으므로, intNum과 floatNum변수 모두 type연산자의 결과값이
 * number타입임을 확인할 수 있다.
 * 
 * 자바스크립트에서는 정수형이 따로 없고, 모든 숫자를 실수로 처리하므로 나눗셈 연산을 할
 * 때는 주의해야 한다. 다음 예제와 같은 연산을 C언어에서 할 경우는 5/2는 소수 부분을
 * 버린 2가 출력된다. 반면에 자바스크립트에서는 5와 2가 둘 다 정수가 아닌 실수로 취급
 * 되므로 소수 부분까지 출력된 2.5가 결과값이 된다. C언어에 익숙한 개발자의 경우는
 * 특히 주의해야 한다.
*/

var num = 5 / 2;

document.write(num);				// (출력값) 2.5
document.write("<br/>");
document.write(Math.floor(num));	// (출력값) 2
/**
 * C언어 나눗셈 연산 결과와 같이 소수 부분을 버린 정수 부분만을 구하고 싶다면,
 * Math.floor() 자바스크립트 메서드를 사용하면 된다.
*/

