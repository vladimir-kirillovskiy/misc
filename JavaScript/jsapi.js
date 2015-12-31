// making requests:

var xhr = new XMLHttpRequest();
xhr.open("GET", "https://www.codecademy.com/", false);	// 3rd parameter - false means the exercise will wait until it gets a response from the server

xhr.send();
console.log(xhr.status); 		// 200
console.log(xhr.statusText);	// OK

/*
* Request Types
* GET: retrieves information from the specified source (you just saw this one!)
* POST: sends new information to the specified source.
* PUT: updates existing information of the specified source.
* DELETE: removes existing information from the specified source.
*/

/*
* Many APIs require an API key.  
* Some APIs require authentication using a protocol called OAuth.
*/

// Parsing XML 
var xhr = new XMLHttpRequest();
xhr.open("GET", "https://www.codecademy.com/files/samples/javascript_learn_apis.xml", false);

xhr.setRequestHeader('Content-Type', 'text/xml');
xhr.send();

xmlDocument = xhr.responseXML;
console.log(xmlDocument.childNodes['0'].textContent);

// Parsing JSON
var demo = '{"pets": { "name": "Jeffrey", "species": "Giraffe"}}';

var json = JSON.parse(demo);
console.log(json);