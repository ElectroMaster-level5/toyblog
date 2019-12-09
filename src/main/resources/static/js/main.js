$(document).ready(function(){
    $(".responsive-img-container").hover(function(e) {
        $(this).children(".overlay").css({"height":"100%"});
    }, function(e){
        $(this).children(".overlay").css({"height":"0"});
    })
});