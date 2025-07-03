var PROGRAM = (function() {
    var animation = function(){
        var wow = new WOW();
        wow.init();
    }
    var slimSelect = function(){
        var pageFilter = document.getElementsByClassName("slim_select");
        if(pageFilter.length > 0){
            var genderSl = new SlimSelect({
              select: '#gender',
              settings: {
                showSearch: false
              }
            });
            var materialSl = new SlimSelect({
              select: '#material',
              settings: {
                showSearch: false
              }
            });
            var sizeSl = new SlimSelect({
              select: '#size',
              settings: {
                showSearch: false
              }
            });
            var priceSl = new SlimSelect({
              select: '#price',
              settings: {
                showSearch: false
              }
            });
        }
    }
    

    return {
        _: function() {
            // animation();
            slimSelect();
        }
    };
})();

window.onload = function() {
    // PROGRAM._();
	
	$('.datepicker').datetimepicker({
        lang:'vi',
        timepicker:false,
        // formatTime: 'H:i',
        format:'d-m-Y',
        onClose: function(e,e1){
          try{
            var val = $(e1).val();
            var s= val.split(' ');
            var s1 = s[0].split('-');
            var s2 = s[1].split(':');
            var d = new Date(s1[2],s1[1]-1,s1[0],s2[0],s2[1],s2[2]);
            $(e1).next().val(d.getTime()/1000);
          }
          catch(ex){}
        }
      });
};
