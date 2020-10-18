function getUsers() {
    $.ajax({
        url:"/api/users",
        type:"POST",
        contentType:"application/JSON",
        success:function (data) {
            $.each(data.users, function (index, value) {
                $("#users").append("<div>" + value.username + "</div>")
            });
        },
        error:function (data) {
            console.log("ERROR from server: getUsers() failed")
        }
    });
}

function addUser(username) {
    var user ={};
    user["username"] = username;
    $.ajax({
        url:"/api/addUser",
        type:"POST",
        contentType:"application/JSON",
        data:JSON.stringify(user),
        success:function (data) {
            $("#users").prepend("<div>" + data.username + "</div>")
        }
    })
}