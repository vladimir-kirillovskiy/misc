var Drop = function(ctx, canvas){
  this.x = Math.random() * canvas.width ;
  this.y = Math.random() * canvas.height  ;
  this.yspeed = Math.random() + 1;

  this.ctx = ctx;
  this.canvas = canvas;

  

  //chinese characters - taken from the unicode charset
  this.cchars = "田由甲申甴电甶男甸甹町画甼甽甾甿畀畁畂畃畄畅畆畇畈畉畊畋界畍畎畏畐畑";
  // half-width kana/katakana
  this.jchars = "｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ";
  this.digits = "0123456789";
  this.lchars = "QWERTYUIOPASDFGHJKLZXCVBNM";


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
