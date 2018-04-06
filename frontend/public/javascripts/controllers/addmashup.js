$('document').ready(function() {


    let mashupSpecific = $("#mashupSpecific");
    mashupSpecific.hide();
    let type = $("#type");
    $('input[type=radio]').on('change',function() {
        mashupSpecific.show();
        mashupSpecific.eq( $('input[type=radio]').index( this ) ).hide();
    });


    $(".add-row").click(function(){

        var markup = "<tr>\n" +
            "                                <td>\n" +
            "                                     <div class=\"input-field col s12\">\n" +
            "                                     <input  id=\"apiIds\" name=\"apiIds[]\" type=\"text\">\n" +
            "                                     </div>\n" +
            "                                </td>\n" +
            "                            </tr>";
        $('#mashupapis').append(markup);

    });


});



