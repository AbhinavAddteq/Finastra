$(document).ready(function () {
    console.log("viewFieldValue Script Loaded!");

    var viewFieldValueForm = $('form#viewFieldValueForm');

    AP.dialog.disableCloseOnSubmit();
    AP.events.on('dialog.button.click', function(data) {
        if(data.button.name === 'submit') {
            viewFieldValueForm.submit();
        }
    });
});