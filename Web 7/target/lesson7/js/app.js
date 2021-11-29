window.notify = function (message) {
    $.notify(message, {
        position: "right bottom",
        className: "success"
    });
}


window.ajax = function (data, $error, successCallback) {
    const base = {
        type: "POST",
        url: "",
        dataType: "json",
        success: function (response) {
            if (response["error"]) {
                $error.text(response["error"]);
            } else {
                if (response["redirect"]) {
                    location.href = response["redirect"];
                } else {
                    successCallback(response);
                }
            }
        }
    };
    $.extend(base, data);
    $.ajax(base);
}
