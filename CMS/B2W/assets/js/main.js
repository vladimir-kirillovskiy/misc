$(function() {
	// Chache window object
	var $window = $(window);

	// Parllax bg effect
	$('section[data-type="background"]').each(function(){

		var $bgobj = $(this); // assigning the object 

		$window.scroll(function(){
			// scroll the bg at var speed
			// the yPos is negative value because we're scrolling up
			var yPos = -($window.scrollTop() / $bgobj.data('speed'));

			// put togeather our final bg position
			var coords = '50% ' + yPos + 'px';
			// move the bg
			$bgobj.css({backgroundPosition: coords});
		}); // end window scroll

	}); 
});