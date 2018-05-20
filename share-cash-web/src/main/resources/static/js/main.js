$(function () {
    $('form').submit(function (e) {
        e.preventDefault();
        var form = $(this);
        var action = form.attr('action');
        var inputs  = form.find("input, select, textarea");
        var data= {};

        $.each(inputs, function (idx, itm) {
            var inputName  = $(itm).attr('name');
            var inputValue = $(itm).val();
            var inputType  = $(itm).attr('type');
            var inputDisabled = $(itm).attr('disabled');

            if(inputType === 'submit' || inputType === 'button') return;

            if(inputDisabled) {
                return;
            }

            if (inputType === 'checkbox') {
                inputValue = $(itm).prop("checked") ;
            }

            data[inputName] = inputValue;
        });

        $.ajax({
            url : action,
            contentType: 'application/json',
            type : 'POST',
            async : true,
            beforeSend: function(request) {
                // TODO: dodac csrf
            },
            data: JSON.stringify(data),
            success: function (result) {
                document.open();
                document.write(result);
                document.close();
            },
            error: function (result) {
                // błąd
            }
        });
    });
});