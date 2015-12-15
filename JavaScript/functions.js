/**
* function to pad string from left side
*/
function padLeft(str, len, pad){
	return String(Array(len+1).join(pad) + str).slice(-len);
}

// convert from dec to bin and vice versa
function base_convert (number, frombase, tobase) {
	return parseInt(number + '', frombase | 0).toString(tobase | 0);
}

console.log(base_convert(101, 2, 10));		// from bin to dec = 5 
console.log(base_convert(10, 10, 2));		// from dec to bin = 1010 

//
// my js function for bit manipulation
// uses 3 parameters 
// $type - has 3 types - set, unset and check;
// check return 0 - false(not set), 1 - true(set)
// $interestBit - bit to work with
// $value passed value to work with
//

function flagHandle(type, interestBit, value) {

	var mask = 1 << interestBit - 1;

	switch(type){
		case 'set':
			value |= mask;
		break;
		case 'unset':
			value &= ~mask;
		break;
		case 'check':
			value = value & mask;
			if((value & mask)==0){
				value = 0;
			} else {
				value = 1;
			}
		break;
	}
	return value;
}


alert( flagHandle("set", 8, 12));

//Simple slide show
var myImage = document.getElementById("mainImage");

var imageArray = ["_images/overlook.jpg","_images/winery_sign.jpg","_images/lunch.jpg",
				  "_images/bigSur.jpg","_images/flag_photo.jpg","_images/mission_look.jpg"];
var imageIndex = 0;

function changeImage() {
	myImage.setAttribute("src",imageArray[imageIndex]);
	imageIndex++;
	if (imageIndex >= imageArray.length) {
		imageIndex = 0;
	}
}

// setInterval is also in milliseconds
var intervalHandle = setInterval(changeImage,5000);

myImage.onclick =  function() {
	clearInterval(intervalHandle);  //clear interval, stop slide show
};

