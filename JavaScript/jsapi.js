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


// youtube API


// Your use of the YouTube API must comply with the Terms of Service:
// https://developers.google.com/youtube/terms

// script file included into html file
//  <script src="https://apis.google.com/js/client.js?onload=onClientLoad" type="text/javascript"></script>

// Helper function to display JavaScript value on HTML page.
function showResponse(response) {
    var responseString = JSON.stringify(response, '', 2);
    document.getElementById('response').innerHTML += responseString;
}

// Called automatically when JavaScript client library is loaded.
function onClientLoad() {
    gapi.client.load('youtube', 'v3', onYouTubeApiLoad);
}

// Called automatically when YouTube API interface is loaded (see line 9).
function onYouTubeApiLoad() {
    // This API key is intended for use only in this lesson.
    // See https://goo.gl/PdPA1 to get a key for your own applications.
    gapi.client.setApiKey('AIzaSyCR5In4DZaTP6IEZQ0r1JceuvluJRzQNLE');

    search();
}

function search() {
    // Use the JavaScript client library to create a search.list() API call.
    var request = gapi.client.youtube.search.list({
        part: 'snippet',
        q: 'drag racing'
    });
    
    // Send the request to the API server,
    // and invoke onSearchRepsonse() with the response.
    request.execute(onSearchResponse);
}

// Called automatically with the response of the YouTube API request.
function onSearchResponse(response) {
    showResponse(response);
}