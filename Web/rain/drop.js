var Drop = function(ctx, canvas){
  this.x = Math.random() * canvas.width ;
  this.y = Math.random() * canvas.height  ;
  this.yspeed = Math.random() + 1;

  this.ctx = ctx;
  this.canvas = canvas;
};

Drop.prototype = {
  show: function(){
    var self = this;
    self.ctx.beginPath();
    self.ctx.rect(this.x, this.y, 1, 20);
    self.ctx.fillStyle = '#0099DD';
    self.ctx.fill();
    self.ctx.closePath();
  },
  fall: function(){
    var self = this;
    if (self.y > self.canvas.height) {
        self.y = -30;
        self.x = Math.random(0, 1) * self.canvas.width ;
    }
    self.y += self.yspeed;

  },
};
