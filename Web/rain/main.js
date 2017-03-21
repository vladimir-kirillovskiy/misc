var App = function(){
  this.canvas = document.getElementById("myCanvas");
  this.ctx = this.canvas.getContext("2d");

  this.drops = [];
};

App.prototype = {
  init: function(){
    var self = this;
    // make an array of drops
    for (i = 0; i < 300; i++) {
      self.drops.push(new Drop(self.ctx, self.canvas));
    }
  },
  draw: function(){
    var self = this;
    self.ctx.clearRect(0, 0, self.canvas.width, self.canvas.height);


    for (i = 0; i < self.drops.length; i++) {
      self.drops[i].show();
      self.drops[i].fall();
    }
    // a bit from ES6
    requestAnimationFrame(() => self.draw());
  }

};

var game = new App();
game.init();
game.draw();
