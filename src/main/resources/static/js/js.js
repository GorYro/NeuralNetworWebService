


$(document).ready(function () {
    $("#btn").click(function () {
        $("#maincontainer1").css("opacity", "0");
        $("#maincontainer1").css("display", "none");
        $("#maincontainer2").css("opacity", "0");
        $("#maincontainer2").css("display", "none");
        $("#loader").css("display", "block");
        $("#loader").animate({opacity: 1}, 500);
    })

});