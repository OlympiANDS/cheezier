function start() {
    console.log("say what? at request.js view");
}

function clear() {
    $('#map').empty();
}

function render(position) {

    var requestButton = $('#requestButton');

    requestButton.text('SEND REQUEST');

    requestButton.click(function () {
        request();
    });

    let html = `
    <form class="form-inline">
    <label for="login">Login:</label>
    <input type="login" id="login" placeholder="Enter username" name="login">
    <br/>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" placeholder="Enter your password">
    </form>`;

    $('#map').append($(html));
}

function request() {
    window.location.hash = 'map';
    /*
    console.log($('#time').val());
    $.ajax({
        url: 'http://localhost:8080/cheezier/api/customer/' + '1'+'/request', // CHANGE FOR ID
        type: 'POST',
        data: JSON.stringify({
            login: $('#date').val() + ' ' + $('#time').val(),
            address: $('#position').val(),
            targetName: $('#name').val(),
            genre: $('#genre').val(),
            comments: $('#comments').val(),
        }),
        async: true,
        contentType: 'application/json',
        success: function () {
            //alert("Customer added with success!")
            console.log("Request successful!");
            window.location.hash = 'map';
        },
        error: function (error) {
            alert("Something went wrong!")
        }
    });
    */
}

export default {
    start,
    clear,
    render
};
