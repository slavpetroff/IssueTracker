/**
 * Created by slavpetroff on 8/15/16.
 */

$(document).ready(function () {
    var id = $('#option').val();
    var form = $('#regForm');
    var action = form.attr('action');
    var newAction = action.replace("projectId", id);

    form.attr('action', newAction);
});
