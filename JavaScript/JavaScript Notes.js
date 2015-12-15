//JavaScript Reference
// https://developer.mozilla.org/en-US/docs/JavaScript/Reference

	/*Ternary*/
var playerOne;
var playerTwo
// condition ? true:false
var HighScore(playerOne > playerTwo) ? playerOne:playerTwo;

	/*Loops*/
// While, Do While, For
break;  //get out from loop
continue; //go to begining of the loop

	/*Arrays*/
var array = []; // create array
var array = Array(); //same
var arr = [10,20,3,4,5]; //create arr and set values
arr[0] = 10; //set value for index 0

console.log(arr);
console.log(arr.length);
console.log(arr.reverse());
console.log(arr.join());  //return single string
console.log(arr.sort());

var myArrayOfLinks = document.getElementsByTagName("p");
console.log(myArrayOfLinks);

	/*Numbers*/
var foo = "55"; //could be "abc"
var myNum = Number(foo); //makes it number, 
//if not number return NaN


 // if is NOT a Number !!
if ( isNaN(myNum) ) {
	console.log("It's not a number");
}

var x = 20.6;
var y = Math.round(x); // = 21

var a = 200, b = 10000, c = 4;
var biggest = Math.max(a,b,c);
var smallest = Math.min(a,b,c);


x = Math.PI;
y = Math.random();
a = Math.sqrt(c);
b = Math.log();

	/*Strings*/
var phrase = "He said \"that's fine\", and left.";
phrase = "This is a simple phrase.";
console.log(phrase.length);
console.log(phrase.toUpperCase());

var words = phrase.split(" "); //create array
var position = phrase.indexOf("simple"); // it returns -1 if the term is not found
// There is also .lastIndexOf()
var segm = phrase.slice(6,5);
//.substring() and .substr() - similar
string.trim() - trim variable from white spaces

	/*Date*/
var today = new Date(); //current date and time
var y2k = new Date(2000,0,1); // year, month, day. Month 0-11
var y2k = new Date(2000,0,1,0,0,0); // year, month, day, hours, minutes, seconds.
today.getMonth(); // 0-11
today.getFullYear();
today.getDate(); //1-31 day of month
today.getDay(); // 0-6 day of week. 0 == sunday
today.getHours(); // 0-23
today.getTime(); // milliseconds since 1/1/1970

today.setMonth(5); // 0-11
today.setFullYear(2012);
today.setDay(0); // 0-6 day of week. 0 == sunday

var date1 = new Date(2000,0,1);
var date2 = new Date(2000,0,1);

if (date1 == date2) {} // false

if (date1.getTime() == date2.getTime()) {} //true

	/*Objects*/
//create object
var player = new Object();
// create property of object
player.name = "Fred";
player.score = 10000;
player.rank = 1;
//same but shorter
var player1 = {name:"Fred", score:10000, rank:1};
var player2 = {name:"Scot", score:100000, rank:2};

//create a method of object
function playerDetails() {
	//display info about each player
	console.log(this.name + "has a rank of: " +
	this.rank +	" and a score of: " + this.score );
}

player1.logDetails = playerDetails;
player2.logDetails = playerDetails;

player2.logDetails();

	/*DOM
	get elements*/

var myElement = document.getElementById("Id");
var myListItems = document.getElementsByTagName("li"); //makes array 

var mainTitle = document.getElementById("mainTitle");

console.log("This is an element of type: ", mainTitle.nodeType); // 1 
console.log("the Inner HTML is ", mainTitle.innerHTML); // Welcome to Explore California!
console.log("Child nodes:", mainTitle.childNodes.length); // 1

var myLinks = document.getElementsByTagName("a");
console.log("Links", myLinks.length); // 19 - <a> in document

var myListItems = document.getElementsByTagName("li");
var myFirstList = document.getElementById("abc");
var limitedList = myFirstList.getElementsByTagName("li");	
	
	/*changing content*/

myElement.getAttribute("align"); // "align" name of attribute
myElement.setAttribute("align", "left"); // "align" - name, "left" - value 

myElement.innerHTML = "New text"; // update content of element. Can include other tags.

	/*creating element*/

//myElement - <ul id="abc">
//create element
var myNewElement = document.createElement("li");
//make new element part of myElement
myElement.appendChild(myNewElement);
//set text
myNewElement.innerHTML = "New item text"; //could do but better:
//only text
var myText = document.createTextNode("New list item text");
myNewElement.appendChild(myText);

//appendChild alternatives 
var myNewElement = document.createElement("li");
var secondItem = myElement.getElementsByTagName("li")[1]; //second element in array, so second element in the list
myElement.insertBefore(myNewElement, secondItem); // so inserted in second position in the list

	/*Events*/

<button onclick = ""> ...

//element.event = ...
window.onload 
nameField.onblur

meElement.onclick = function() { 	//no name used
	//event handler code 
};  //Semicolumn needed!

//problem with crossbowserness
document.addEventListener('click', myFunction, false);
document.removeEventListener('click', myFunction, false);

//Internet Explorer 8 and <
document.attachEvent('onclick', myFunction);
// movie - 6-01

//use JQuery or other library for cross-browser code

window.onload = function() {  // when page loaded. Regardless where script placed in html
	// code
};
// window.onload  -- should be once per page

//focus/blur
fieldName.onfocus = function() {
	if (fieldName.value=="your email") {
		fieldName.value = "";
	}
};

fieldName.onblur = function() {
	if (fieldName.value == "") {
		fieldName.value = "your email";
	}
};

	/*Timers*/

// delay function start
setTimeout(functionName, 5000); // name of function and interval in milliseconds
// loop function with delay between loops
setInterval(functionName,5000);  // name of function and interval in milliseconds


arguments.caller() // is the function itself more generic way

	/*bit Manipulation */

var mask = 1 << 5; // gets the 6th bit

//To test if a bit is set:

if ((n & mask) != 0) {
  // bit is set
} else {
  // bit is not set
}
//To set a bit:

n |= mask;
//To clear a bit:

n &= ~mask;
//To toggle a bit:

n ^= mask;