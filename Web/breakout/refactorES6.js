// ES6 rules
class App {
  constructor(canvas) {
    this.canvas = canvas;
    this.ctx = this.canvas.getContext("2d");

    // make it full screen
    this.canvas.height = window.innerHeight;
    this.canvas.width = window.innerWidth;

    this.fontSize = 14; // make it variable
    this.columns = canvas.width / this.fontSize;

    this.drops = [];
    this.init();
  }

  init() {
    var self = this;

    // make an array of drops
    for (var i = 0; i < self.columns; i++) {
     self.drops.push(new Drop(self.ctx, self.canvas, 1));
    }
  }

  draw() {
    var self = this;
    self.ctx.clearRect(0, 0, self.canvas.width, self.canvas.height);


    for (var i = 0; i < self.columns; i++) {
      self.drops[i].show(i * self.fontSize, self.drops[i].posy * self.fontSize);
      self.drops[i].fall(self.drops[i].posy * self.fontSize);

    }

    requestAnimationFrame(() => self.draw());
  }

}

var game = new App(document.getElementById("myCanvas"));
game.draw();
