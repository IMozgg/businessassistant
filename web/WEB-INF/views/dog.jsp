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

    var restPost = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            contentType: 'application/json;utf-8',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, error) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var restPut = function (id, name, description) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update',
            contentType: 'application/json;utf-8',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, error) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var restDelete = function (id) {
        var JSONObject = {
            'id': id
        };

        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            contentType: 'application/json;utf-8',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, error) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var restGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/get/all',
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

    <tr>
        <td>Add dog<code><strong>POST</strong></code></td>
        <td>/dog/add</td>
        <td>
            <form class="form-inline">
                name: <input id="postName" value="default name">
                description: <input id="postDescription" value="default description">

                <button type="button" onclick="restPost($('#postName').val(), $('#postDescription').val())">try</button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Update dog<code><strong>PUT</strong></code></td>
        <td>/dog/update</td>
        <td>
            <form class="form-inline">
                id: <input id="inputId" value="1">
                name: <input id="putName" value="default name">
                description: <input id="putDescription" value="default description">

                <button type="button" onclick="restPut(
                    $('#inputId').val(),
                    $('#putName').val(),
                    $('#putDescription').val())
                    "> try
                </button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Delete dog<code><strong>GET</strong></code></td>
        <td>/dog/delete/{id}</td>
        <td>
            <form class="form-inline">
                id: <input id="deleteId" value="1">
                <button type="button" onclick="restDelete(
                    $('#deleteId').val())
                    "> try
                </button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Get all dogs<code><strong>GET</strong></code></td>
        <td>/dog/get/all</td>
        <td>
            <form class="form-inline">
                <button type="button" onclick="restGetAll()">try</button>
            </form>
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
