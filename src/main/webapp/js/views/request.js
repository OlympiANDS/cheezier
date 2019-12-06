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
    <input type="hidden" id="position" value="`+ position +`">
    <label for="data">Date:</label>
    <input type="date" id="date" placeholder="Enter date" name="date">
    <br/>
    <label for="name">Hour:</label>
    <input type="time" id="time" placeholder="Time of surprise" name="time">
    <br/>
    <label for="name">Name:</label>
    <input type="name" id="name" placeholder="Surprise recipient name" name="name">
    <br/>
    <select name="genre" id="genre">
  <option value="starwars">Star Wars</option>
  <option value="lordoftherings">Lord of the Rings</option>
  <option value="bollywood">Bollywood</option>
  <option value="mariachis">Mariachis</option>
  <option value="ghostbusters">Ghostbusters</option>
  <option value="opera">Opera</option>
</select>
<br/>
<label for="comments">Special Comments:</label>
    <input type="comments" id="comments" placeholder="Special comments" name="comments">
    <br/>
  </form>`;

    $('#map').append($(html));
}

function request() {
    console.log($('#time').val());
    $.ajax({
        url: 'http://localhost:8080/cheezier/api/customer/' + '1' +'/request', // CHANGE FOR ID
        type: 'POST',
        data: JSON.stringify({
            scheduledTime: $('#date').val() + ' ' + $('#time').val(),
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
}

export default {
    start,
    clear,
    render
};
