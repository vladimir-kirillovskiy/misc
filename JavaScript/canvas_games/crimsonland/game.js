// Create the canvas
var CANVAS_WIDTH = 900;
var CANVAS_HEIGHT = 500;
var canvasElement = document.createElement("canvas");
var canvas = canvasElement.getContext("2d");
canvasElement.width = CANVAS_WIDTH;
canvasElement.height = CANVAS_HEIGHT;
document.body.appendChild(canvasElement);

//count dead enemies
var enemyDown = 0;
// angle for player rotation
var angle;

//images 
//player image
var playerReady = false;
var playerImage = new Image();
playerImage.onload = function() {
	playerReady = true;
};
playerImage.src = "img/025.png";

// monster image
var monsterReady = false;
var monsterImage = new Image();
monsterImage.onload = function() {
	monsterReady = true;
};
monsterImage.src = "img/ball.gif";


//mouse position
function getMousePos(canvasElement, evt) {
        var rect = canvasElement.getBoundingClientRect();
        return {
          x: evt.clientX - rect.left,
          y: evt.clientY - rect.top
		};
	}	

// mouse move
var mousePos = {};
canvasElement.addEventListener('mousemove', function(evt) {      	
	mousePos = getMousePos(canvasElement, evt);
	}, false);	

// handle keyboard controls
var keysDown = {};

addEventListener("keydown", function(e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function(e) {
	delete keysDown[e.keyCode];
}, false);


// on mouse press	
addEventListener('mousedown', function(evt) {  
	keysDown[evt.button] = true;
	}, false);	
	
addEventListener('mouseup', function(evt) {      		
	delete keysDown[evt.button];
	}, false);

// create player
var player = {
   color: "#00A",
   active: true,
	x: CANVAS_WIDTH/2,
	y: CANVAS_HEIGHT/2,
   width: 32,
   height: 32,
   draw: function() {
  
  
		//canvas.drawImage(playerImage, this.x, this.y);
	
	//rotate
	canvas.save();
	canvas.translate(this.x + this.width/2, this.y + this.height/2);
	
	canvas.rotate(angle-90);
	//canvas.fillStyle = this.color;
	//canvas.fillRect(this.width/2 * -1, this.height/2 * -1, this.width, this.height);
	if (playerReady) {
		canvas.drawImage(playerImage, this.width/2 * -1, this.height/2 * -1);
	}	
	canvas.restore();
		
  }
};

// create bullets
var playerBullets = [];

function Bullet(I) {
	I.active = true;

	I.xVelocity = I.speed * Math.cos(angle);
	I.yVelocity = I.speed * Math.sin(angle);
	I.width = 3;
	I.height = 3;
	I.color = "#000";

	I.inBounds = function() {
		return I.x >=0 && I.x <= CANVAS_WIDTH &&
		I.y >= 0 && I.y <= CANVAS_HEIGHT;
	};

	I.draw = function() {
		canvas.fillStyle = this.color;
		canvas.fillRect(this.x, this.y, this.width, this.height);
	};

	I.update = function() {
		I.x += I.xVelocity;
		I.y += I.yVelocity;

		I.active = I.active && I.inBounds();
	};
	return I;
}


player.shoot = function() {
	//console.log("Pew pew");
	var bulletPosition = this.midpoint();
	
	playerBullets.push(Bullet({
		speed: 5,
		x: bulletPosition.x,
		y: bulletPosition.y
	}));

};

player.midpoint = function() {
	return {
	x: this.x + this.width / 2,	
	y: this.y + this.height / 2
	};
};

player.explode = function() {
	this.active = false;
	// Extra Credit: Add an explosion graphic and then end the game
};



//create enemies

var enemies = [];

function Enemy(I) {
	I = I || {};

	I.active = true;
	I.age = Math.floor(Math.random() * 128);

	I.color = "#A2B";
	
	var side = Math.floor(Math.random()*4);
	if (side == 0) {
	I.x = CANVAS_WIDTH / 4 + Math.random() * CANVAS_WIDTH / 2;
	I.y = 0;
	} else if (side == 1) {
		I.x = CANVAS_WIDTH;
		I.y = CANVAS_HEIGHT / 4 + Math.random() * CANVAS_HEIGHT / 2;
	} else if (side == 2) {
		I.x = CANVAS_WIDTH / 4 + Math.random() * CANVAS_WIDTH / 2;
		I.y = CANVAS_HEIGHT;
	} else if (side == 3) {
		I.x = 0;
		I.y = CANVAS_HEIGHT / 4 + Math.random() * CANVAS_HEIGHT / 2;
	}

	I.xVelocity = 0;
	I.yVelocity = 0;

	I.width = 32;
	I.height = 32;

	I.inBounds = function() {
		return I.x >= 0 && I.x <= CANVAS_WIDTH &&
		I.y >= 0 && I.y <= CANVAS_HEIGHT;
	};

	I.draw = function() {
		if (monsterReady) {
			canvas.drawImage(monsterImage, this.x, this.y);
		}				
		
		//canvas.fillStyle = this.color;
		//canvas.fillRect(this.x, this.y, this.width, this.height);
	};

	I.update = function() {
			var enemyToPlayer = Math.atan2(player.y - I.y, player.x - I.x);
 			 I.x += I.xVelocity;
   		 I.y += I.yVelocity;

    		//I.xVelocity = 3 * Math.sin(I.age * Math.PI / 64);
			I.xVelocity = Math.cos(enemyToPlayer);
			I.yVelocity = Math.sin(enemyToPlayer);
    		I.age++;
			
   		 I.active = I.active && I.inBounds();
 	 };
	
	I.explode = function() {
   		this.active = false;
			++enemyDown;
  		// Extra Credit: Add an explosion graphic
  	};


 	 return I;
};

// colision detection
function collides(a, b) {
  return a.x < b.x + b.width &&
         a.x + a.width > b.x &&
         a.y < b.y + b.height &&
         a.y + a.height > b.y;
}

function handleCollisions() {
  playerBullets.forEach(function(bullet) {
    enemies.forEach(function(enemy) {
      if (collides(bullet, enemy)) {
        enemy.explode();
        bullet.active = false;
      }
    });
  });

  enemies.forEach(function(enemy) {
    if (collides(enemy, player)) {
      enemy.explode();
      player.explode();
    }
  });
}

function update(){
	
	if (32  in keysDown || 0 in keysDown) { 		// space	& left mouse
		player.shoot();
	}	
	// up and down not required for this game
	if (38 in keysDown || 87 in keysDown) { 		// key up & W
		player.y -= 5;
	}

	if (40 in keysDown || 83 in keysDown) { 		// key down & S
		player.y += 5;
	}

	if (37 in keysDown || 65 in keysDown) { 		// key left & A
		player.x -= 5;
	}

	if (39 in keysDown || 68 in keysDown) { 		// key right & D
		player.x += 5;
	}
	// should keep player within the bounds	
	player.x = Math.max(0, Math.min(CANVAS_WIDTH - player.width, player.x));
	player.y = Math.max(0, Math.min(CANVAS_HEIGHT - player.height, player.y));

	playerBullets.forEach(function(bullet){
		bullet.update();
	});

	playerBullets = playerBullets.filter(function(bullet){
		return bullet.active;
	});

	enemies.forEach(function(enemy) {
   		 enemy.update();
 	});

  	enemies = enemies.filter(function(enemy) {
  		return enemy.active;
 	});

 	if(Math.random() < 0.1) {
  		enemies.push(Enemy());
  	}
	// game over
	if (!player.active) {
		console.log('You\'re Dead!');
		
		canvas.fillStyle = "rgb(125, 125, 125)";
		canvas.font = "40px Helvetica";
		canvas.textAlign = "left";
		canvas.textBaseline = "top";
		canvas.fillText("You\'re Dead!", 115, 115);
		
		clearInterval(loopInterval);
	}

	handleCollisions();
	angle = Math.atan2(mousePos.y - player.y, mousePos.x - player.x); // * 180 / Math.PI;
	 
	
};

function draw(){
	canvas.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
	player.draw();
	playerBullets.forEach(function(bullet){
		bullet.draw();
	});

	enemies.forEach(function(enemy) {
    		enemy.draw();
  	});
  	
  	// score
	canvas.fillStyle = "rgb(125, 125, 125)";
	canvas.font = "20px Helvetica";
	canvas.textAlign = "left";
	canvas.textBaseline = "top";
	canvas.fillText("Enemies Down: " + enemyDown, 15, 15);
	if (!player.active) {
		
		canvas.fillStyle = "rgb(100, 100, 100)";
		canvas.font = "45px Helvetica";
		canvas.textAlign = "left";
		canvas.textBaseline = "top";
		canvas.fillText("You\'re Dead!", 115, 115);
		
	}
};

// game loop

function loop() {
	update();
	draw();
};
var FPS = 30;
var loopInterval = setInterval(loop, 1000 / FPS);