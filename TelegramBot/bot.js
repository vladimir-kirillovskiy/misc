// simple bot example to convert text to speech 
// using yandex speach 

var TelegramBot = require("node-telegram-bot-api");
var yandex = require("yandex-speech");		// text to speech
// var MultiGeocoder = require("multi-geocoder");	// yandex? geo location
var https = require("https");
var fs = require("fs");

var token = "";

var bot = new TelegramBot(token, {polling: true});

bot.on("message", function(msg){

	yandex.TTS({
		text: msg.text,
		file: "text.mp3"
	}, function(){
		bot.sendAudio(msg.chat.id, "text.mp3").then(console.log("Done"));
	});
 
});