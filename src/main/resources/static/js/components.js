Vue.component('my-title',{
    props : ['title'],
    template : '<h1>{{title}}</h1>'
});

Vue.component('add-todo-form',{
    data : function (){
        return {
            description : ""
        }
    },
    methods :{
        add:function () {
            var todo = {id: 0, title: this.description, completed: false};
            console.log("Adding ..." + JSON.stringify(todo))
            API.post(todo, (function (result) {
                this.$emit("added-todo", result);
                console.log("Added todo with id " + JSON.stringify(result));
            }).bind(this));
        }
    },
    template:'\
            <form class="form-inline">\
                <div class="form-group mb-2 mx-2">\
                    <label for="Title" class="mx-2">Title</label>\
                    <input v-model="description" type="text" class="form-control" id="Title" placeholder="What do you have to do ?">\
                </div>\
                <button @click.stop.prevent="add" type="submit" class="btn btn-primary mb-2"><i class="fa fa-plus"></i> Add</button>\
            </form>'
});