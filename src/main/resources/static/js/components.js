Vue.component('my-title',{
    props : {
        title : {
            type:String,
            required:true
        }
    },
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
            API.post(todo, (function (result) {
                this.$emit("added-todo", result);
                this.description = "";//clear
            }).bind(this));
        },
    },
    computed : {
        classObject: function(){
            return {
                'is-valid': this.description.length >=8,
                'is-invalid': this.description.length >= 1 && this.description.length < 8,
                'is-blank' : this.description.length === 0
            }
        },
        isFormValid: function () {
            return this.description.length >=8;
        }
    },
    template:'\
            <form novalidate>\
                <div class="row">\
                    <div class="col">\
                        <input v-model="description" :class="classObject" type="text" class="form-control"  id="Title" placeholder="What do you have to do ?">\
                        <!--<div class="valid-feedback">Your description has the right size</div>-->\
                        <div class="invalid-feedback">Must be at least 8 characters</div>\
                    </div>\
                    <div class="col">\
                        <button @click.stop.prevent="add" type="submit" :disabled="!isFormValid" class="btn btn-primary mb-2"><i class="fa fa-plus"></i> Add</button>\
                    </div>\
                 </div>\
             </form>'
});