/**
 * Created by slavpetroff on 8/15/16.
 */

$(document).ready(function () {
    var id = $('#option').val();
    console.log(id);
    var form = $('#regForm');
    var action = form.attr('action');
    console.log(action);
    var newAction = action.replace("projectId", id);
    console.log(newAction);

    form.attr('action', newAction);
});
