$(document).ready(function() {
    let name = $("#name");
    let homepage = $("#homepage");
    let endpoint = $("#endpoint");
    let version = $("#version");
    let scope = $("#scope");
    let description = $("#description");
    let email = $("#email");

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
        let name = "";
        let homepage = "";
        let endpoint = "";
        let version = "";
        let scope = "";
        let description = "";
        let email ="";
        successBadge.hide();
    }

    function allFieldsAreFilled () {
        if (!name.val()) {
            apinameRequiredBadge.show();
            return false;
        } else if (!homepage.val()) {
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
                name: name.val(),
                homepage: homepage.val(),
                endpoint: endpoint.val(),
                version: version.val(),
                scope: scope.val(),
                description: description.val(),
                email: email.val()
            });

    }

});
});