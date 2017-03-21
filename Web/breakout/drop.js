var Drop = function(ctx, canvas, posy){
  this.x = Math.random() * canvas.width;
  this.yspeed = Math.random() + 1;

  this.ctx = ctx;
  this.canvas = canvas;

  this.posy = posy;


  //chinese characters - taken from the unicode charset
  var cchars = "田由甲申甴电甶男甸甹町画甼甽甾甿畀畁畂畃畄畅畆畇畈畉畊畋界畍畎畏畐畑";
  // half-width kana/katakana
  var jchars = "｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ";
  var digits = "0123456789";
  var lchars = "QWERTYUIOPASDFGHJKLZXCVBNM";

  this.chars = cchars + jchars + digits + lchars;

};

Drop.prototype = {
  show: function(x, y){
    var self = this;

    self.ctx.beginPath();

    self.ctx.fillStyle = "rgba(0, 0, 0, 0.05)";
    self.ctx.rect(0, 0, self.canvas.width, self.canvas.height);
    self.ctx.fill();

    self.ctx.closePath();


    self.ctx.beginPath();


    var char = self.chars[Math.floor(Math.random()*self.chars.length)]

    // self.ctx.rect(self.x, self.y, 1, 20);
    self.ctx.fillStyle = '#0F0';
    self.ctx.font = '14px';
    self.ctx.fillText(char, x, y);
    // self.ctx.fillStyle = '#0F0';
    self.ctx.fill();


    self.ctx.closePath();
  },
  fall: function(pos) {
    var self = this;

    if (pos > self.canvas.height && Math.random() > 0.975) {
        self.posy = 0;
    }
    self.posy++;

  },
};
