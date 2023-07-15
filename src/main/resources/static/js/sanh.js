window.onload = function() {
    $('#reg').hide();


}

function log() {
    $('#log').hide();
    $('#reg').fadeIn('slow');
    $('#reg').show();
    $(document).attr('title', '注册');
}

function reg() {
    $('#log').fadeIn('slow');
    $('#log').show();
    $('#reg').hide();
    $(document).attr('title', '登录');
}