
//create canvas
var canvas = document.createElement("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 512;
canvas.height = 480;
document.body.appendChild(canvas);

//bg image
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function() {
	bgReady = true;
};
bgImage.src = "img/background.png";

//hero image
var heroReady = false;
var heroImage = new Image();
heroImage.onload = function() {
	heroReady = true;
};
heroImage.src = "img/hero.png";

// monster image
var monsterReady = false;
var monsterImage = new Image();
monsterImage.onload = function() {
	monsterReady = true;
};
monsterImage.src = "img/monster.png";

// sound
var snd = new Audio("snd/Boing3.wav");

// game objects
var hero = {
	speed:256 //movement in pixels per second
};

var monster = {};

var monsterCaught = 0;

// handle keyboard controls
var keysDown = {};

addEventListener("keydown", function(e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function(e) {
	delete keysDown[e.keyCode];
}, false);

// reset the game when the player catches a monster
var reset = function() {
	hero.x = canvas.width / 2;
	hero.y = canvas.height / 2;

	// throw the monster somewhere
	monster.x = 32 + (Math.random() * (canvas.width - 64));
	monster.y = 32 + (Math.random() * (canvas.height - 64));
};

// update game objects
var update = function(modifier) {

	if (38 in keysDown) { 		// key up
		hero.y -= hero.speed * modifier;
	}

	if (40 in keysDown) { 		// key down
		hero.y += hero.speed * modifier;
	}

	if (37 in keysDown) { 		// key left
		hero.x -= hero.speed * modifier;
	}

	if (39 in keysDown) { 		// key right
		hero.x += hero.speed * modifier;
	}

	// are they touching?
	if (
		hero.x <= (monster.x + 32) 
		&& monster.x <= (hero.x + 32)
		&& hero.y <= (monster.y + 32)
		&& monster.y <= (hero.y + 32)
	) {
		if (snd.currentTime >0) {
			snd.cerrentTime = 0; //reset sound
		}		
		snd.play();
		++monsterCaught;
		reset();
	}
};

// draw everything
var render = function() {
	if (bgReady) {
		ctx.drawImage(bgImage, 0, 0);
	}

	if (heroReady) {
		ctx.drawImage(heroImage, hero.x, hero.y);
	}

	if (monsterReady) {
		ctx.drawImage(monsterImage, monster.x, monster.y);
	}

	// score
	ctx.fillStyle = "rgb(250, 250, 250)";
	ctx.font = "24px Helvetica";
	ctx.textAlign = "left";
	ctx.textBaseline = "top";
	ctx.fillText("Goblins caught: " + monsterCaught, 32, 32);
};

// the main game loop
var main = function() {
	var now = Date.now();
	var delta = now - then;

	update(delta / 1000);
	render();

	then = now;
};

reset();
var then = Date.now();
setInterval(main, 1); // execute as fast as possible
