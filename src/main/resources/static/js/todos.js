TODO = function () {
    var findById = function (id, todos) {
        return todos.find(function (item) {
            return item.id === id;
        });
    }

    var countCompleted = function (todos) {
        var accumulator = function (counter, todo) {
            return counter + (todo.completed === true);
        };
        return todos.reduce(accumulator, 0);
    }


    var removeById = function (id, todos) {
        // get index of item
        var removeIndex = todos.map(function (todo) {
            return todo.id;
        }).indexOf(id);
        // remove object if found
        if (removeIndex >= 0) {
            todos.splice(removeIndex, 1);
        }
    }

    return {
        findById: findById,
        countCompleted: countCompleted,
        removeById: removeById
    }
}();