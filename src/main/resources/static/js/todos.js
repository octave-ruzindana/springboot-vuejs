var findById = function (id, todos) {
    return todos.find(function (item) {
        return item.id === id;
    });
}

var toggleStatus = function (id, todos) {
    var found = findById(id, todos);
    found.completed = !found.completed;
}

var countCompleted = function (todos) {
    var accumulator = function (counter, todo) { return counter + (todo.completed === true); };
    return todos.reduce(accumulator, 0);
}