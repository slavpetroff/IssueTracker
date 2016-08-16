/**
 * Created by slavpetroff on 8/16/16.
 */
"use strict";

$(document).ready(function () {

    var form = $('#regForm');

    form.submit(function checkFields() {
        var currentAction = form.attr('action');
        var onErrorAction = currentAction.replace("user", "error");

        var passwordFieldValue = $('#password').val();
        var reEnteredPasswordValue = $('#rePassword').val();

        if (passwordFieldValue !== reEnteredPasswordValue) {
            currentAction = onErrorAction;
            form.attr('action', currentAction);
            form.attr('method', "get");
        }
    });
});