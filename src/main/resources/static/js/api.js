API = function(){
    var current = null;

    function getTodos(onSuccess) {
        $.get("http://localhost:8080/api/todos", onSuccess);
    }

    function deleteTodo(id){
        $.ajax({
            url: 'http://localhost:8080/api/todos/' + id,
            type: 'DELETE',
            success: function(result) {
                console.log("Successfully deleted todo with id " + id);
            }
        });
    }

    function postTodo(todo, onSucess) {
        $.ajax({
            url: 'http://localhost:8080/api/todos/',
            type: 'POST',
            data : JSON.stringify(todo),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: onSucess
        });
    }

    return {
        post:postTodo,
        delete:deleteTodo,
        get:getTodos
    }
}();