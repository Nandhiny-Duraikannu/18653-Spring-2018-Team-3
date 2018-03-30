$(document).ready(function() {
    let apiname = $("#apiname");
    let apihomepage = $("#apihomepage");
    let apiendpoint = $("#apiendpoint");
    let version = $("#version");
    let scope = $("#scope");
    let apidescription = $("#apidescription");
    let emailaddress = $("#emailaddress");

    // error badges
    let apinameRequiredBadge = $("#apinameRequiredBadge");
    let apihomepageRequiredBadge = $("#apihomepageRequiredBadge");
    let successBadge = $("#successBadge");

    // initialize the select dropdown
    $('select').formSelect();


    function hideAllErrorMessages () {
        apinameRequiredBadge.hide();
        apihomepageRequiredBadge.hide();

    }

    hideAllErrorMessages();
    successBadge.hide();

    function submitApi(api) {
        $.ajax({
            url: "/submitapi",
            type: "POST",
            data: JSON.stringify(api),
            headers: {
                "Content-Type": "application/json"
            },
            dataType: 'json',
            success: (data) => {
            console.info(data);
    }
    });
    }

    function clear()
    {
        let apiname = "";
        let apihomepage = "";
        let apiendpoint = "";
        let version = "";
        let scope = "";
        let apidescription = "";
        let emailaddress ="";
        successBadge.hide();
    }

    function allFieldsAreFilled () {
        if (!apiname.val()) {
            apinameRequiredBadge.show();
            return false;
        } else if (!apihomepage.val()) {
            apihomepageRequiredBadge.show();
            return false;
        } else {
            return true;
        }
    }

    $("#submitButton").click((e) => {
        e.preventDefault();
    hideAllErrorMessages();
    successBadge.show();
    console.log("submitbutton-hide all messages");
    if (allFieldsAreFilled()) {
           // $("#submitButton").addClass("disabled").attr("disabled", "disabled");
            submitApi({
                apiname: apiname.val(),
                apihomepage: apihomepage.val(),
                apiendpoint: apiendpoint.val(),
                version: version.val(),
                scope: scope.val(),
                apidescription: apidescription.val(),
                emailaddress: emailaddress.val()
            });

    }

});
});