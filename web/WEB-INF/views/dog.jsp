<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is dogs page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<script>
    var service = 'http://localhost:8080/dog';

    var restGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, error) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>

<body>
<h1>Dog's info</h1>

<table class="table">
    <tr>
        <th>Request</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>GET dog by id <code><strong>GET</strong></code></td>
        <td>/dog/get/{id}</td>
        <td>
            id: <input id="getDogId" value=""/>
            <button type="button" onclick="restGet($('#getDogId').val())">try</button>
        </td>
    </tr>
</table>

<div class="panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="class-body" id="response"></div>
</div>
</body>
</html>
