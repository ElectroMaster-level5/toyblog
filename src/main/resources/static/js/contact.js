function getRootPath_dc(){
    return window.location.protocol+"//"+window.location.host+"/";
}
$(document).ready(function() {
    $("button").click(function () {
        if (!$('#contact_form').valid()) {
            return false;
        }
        var url = getRootPath_dc() + "contact/sendMail";
        var name = $('#name').val();
        var email = $('#email').val();
        var subject = $('#subject').val();
        var messageContent = $('#messageContent').val();
        $.ajax({
            type: "POST",
            url: url,
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({
                "name": name,
                "email": email,
                "subject": subject,
                "messageContent": messageContent
            }),
            success: function (result) {
                if (result == 'success') {
                    $('#success_fb').show();
                    setTimeout(function() { $("#success_fb").hide(); }, 3000);
                } else {
                    $('#failed_fb').show();
                    setTimeout(function() { $("#failed_fb_fb").hide(); }, 3000);
                }
            }
        });

    });
});