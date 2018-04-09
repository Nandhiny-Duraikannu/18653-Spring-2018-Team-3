
$('document').ready(function() {

    $('select').formSelect();

    let mashupSpecific = $("#mashupSpecific");
    mashupSpecific.hide();

    $('input[type=radio]').on('change',function() {
        mashupSpecific.show();
        mashupSpecific.eq( $('input[type=radio]').index( this ) ).hide();
    });
});



