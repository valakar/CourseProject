(function() {
  var AppRouter, Drawer, Group, NoteFolder, NoteItem, Notes, Project, log;
  var __slice = Array.prototype.slice, __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; }, __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
    for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; }
    function ctor() { this.constructor = child; }
    ctor.prototype = parent.prototype;
    child.prototype = new ctor;
    child.__super__ = parent.prototype;
    return child;
  };
  log = function() {
    var args;
    args = 1 <= arguments.length ? __slice.call(arguments, 0) : [];
    if (console.log != null) {
      return console.log.apply(console, args);
    }
  };
  $(".options dt, .users dt").live("click", function(e) {
    e.preventDefault();
    if ($(e.target).parent().hasClass("opened")) {
      $(e.target).parent().removeClass("opened");
    } else {
      $(e.target).parent().addClass("opened");
      $(document).one("click", function() {
        return $(e.target).parent().removeClass("opened");
      });
    }
    return false;
  });
  $.fn.editInPlace = function() {
    var method, options;
    method = arguments[0], options = 2 <= arguments.length ? __slice.call(arguments, 1) : [];
    return this.each(function() {
      var methods;
      methods = {
        init: function(options) {
          var cancel, valid;
          valid = __bind(function(e) {
            var newValue;
            newValue = this.input.val();
            return options.onChange.call(options.context, newValue);
          }, this);
          cancel = __bind(function(e) {
            this.el.show();
            return this.input.hide();
          }, this);
          this.el = $(this).dblclick(methods.edit);
          return this.input = $("<input type='text' />").insertBefore(this.el).keyup(function(e) {
            switch (e.keyCode) {
              case 13:
                return $(this).blur();
              case 27:
                return cancel(e);
            }
          }).blur(valid).hide();
        },
        edit: function() {
          this.input.val(this.el.text()).show().focus().select();
          return this.el.hide();
        },
        close: function(newName) {
          this.el.text(newName).show();
          return this.input.hide();
        }
      };
      if (methods[method]) {
        return methods[method].apply(this, options);
      } else if (typeof method === 'object') {
        return methods.init.call(this, method);
      } else {
        return $.error("Method " + method + " does not exist.");
      }
    });
  };
  Drawer = (function() {
    __extends(Drawer, Backbone.View);
    function Drawer() {
      Drawer.__super__.constructor.apply(this, arguments);
    }
    Drawer.prototype.initialize = function() {
      $("#newGroup").click(this.addGroup);
      return this.el.children("li").each(function(i, group) {
        new Group({
          el: $(group)
        });
        return $("li", group).each(function(i, project) {
          return new Project({
            el: $(project)
          });
        });
      });
    };
    Drawer.prototype.addGroup = function() {
      return jsRoutes.controllers.Projects.addGroup().ajax({
        success: function(data) {
          var _view;
          _view = new Group({
            el: $(data).appendTo("#projects")
          });
          return _view.el.find(".groupName").editInPlace("edit");
        },
        error: function(err) {}
      });
    };
    return Drawer;
  })();
  Group = (function() {
    __extends(Group, Backbone.View);
    function Group() {
      this.renameGroup = __bind(this.renameGroup, this);
      Group.__super__.constructor.apply(this, arguments);
    }
    Group.prototype.events = {
      "click    .toggle": "toggle",
      "click    .newProject": "newProject",
      "click    .deleteGroup": "deleteGroup"
    };
    Group.prototype.initialize = function() {
      this.id = this.el.attr("data-group");
      return this.name = $(".groupName", this.el).editInPlace({
        context: this,
        onChange: this.renameGroup
      });
    };
    Group.prototype.newProject = function(e) {
      e.preventDefault();
      this.el.removeClass("closed");
      return jsRoutes.controllers.Projects.add().ajax({
        context: this,
        data: {
          group: this.el.attr("data-group")
        },
        success: function(tpl) {
          var _list, _view;
          _list = $("ul", this.el);
          _view = new Project({
            el: $(tpl).appendTo(_list)
          });
          return _view.el.find(".name").editInPlace("edit");
        },
        error: function(err) {
          return $.error("Error: " + err);
        }
      });
    };
    Group.prototype.deleteGroup = function(e) {
      var id;
      e.preventDefault();
      if (!confirm("Remove group and projects inside?")) {
        false;
      }
      id = this.el.attr("data-group-id");
      this.loading(true);
      return jsRoutes.controllers.Projects.deleteGroup(this.id).ajax({
        context: this,
        success: function() {
          this.el.remove();
          return this.loading(false);
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
    };
    Group.prototype.renameGroup = function(name) {
      this.loading(true);
      return jsRoutes.controllers.Projects.renameGroup(this.id).ajax({
        context: this,
        data: {
          name: name
        },
        success: function(data) {
          this.loading(false);
          this.name.editInPlace("close", data);
          this.el.attr("data-group", data);
          return this.id = this.el.attr("data-group");
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
    };
    Group.prototype.toggle = function(e) {
      e.preventDefault();
      this.el.toggleClass("closed");
      return false;
    };
    Group.prototype.loading = function(display) {
      if (display) {
        this.el.children(".options").hide();
        return this.el.children(".loader").show();
      } else {
        this.el.children(".options").show();
        return this.el.children(".loader").hide();
      }
    };
    return Group;
  })();
  Project = (function() {
    __extends(Project, Backbone.View);
    function Project() {
      Project.__super__.constructor.apply(this, arguments);
    }
    Project.prototype.events = {
      "click      .delete": "deleteProject"
    };
    Project.prototype.initialize = function() {
      this.id = this.el.attr("data-project");
      return this.name = $(".name", this.el).editInPlace({
        context: this,
        onChange: this.renameProject
      });
    };
    Project.prototype.renameProject = function(name) {
      this.loading(true);
      return jsRoutes.controllers.Projects.rename(this.id).ajax({
        context: this,
        data: {
          name: name
        },
        success: function(data) {
          this.loading(false);
          return this.name.editInPlace("close", data);
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
    };
    Project.prototype.deleteProject = function(e) {
      e.preventDefault();
      this.loading(true);
      jsRoutes.controllers.Projects["delete"](this.id).ajax({
        context: this,
        success: function() {
          this.el.remove();
          return this.loading(false);
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
      return false;
    };
    Project.prototype.loading = function(display) {
      if (display) {
        this.el.children(".delete").hide();
        return this.el.children(".loader").show();
      } else {
        this.el.children(".delete").show();
        return this.el.children(".loader").hide();
      }
    };
    return Project;
  })();
  AppRouter = (function() {
    __extends(AppRouter, Backbone.Router);
    function AppRouter() {
      AppRouter.__super__.constructor.apply(this, arguments);
    }
    AppRouter.prototype.initialize = function() {
      return this.currentApp = new Notes({
        el: $("#main")
      });
    };
    AppRouter.prototype.routes = {
      "/": "index",
      "/projects/:project/notes": "notes"
    };
    AppRouter.prototype.index = function() {
      return $("#main").load("/ #main");
    };
    AppRouter.prototype.notes = function(project) {
      var currentApp;
      currentApp = this.currentApp;
      return $("#main").load("/projects/" + project + "/notes", function(tpl) {
        return currentApp.render(project);
      });
    };
    return AppRouter;
  })();
  Notes = (function() {
    __extends(Notes, Backbone.View);
    function Notes() {
      Notes.__super__.constructor.apply(this, arguments);
    }
    Notes.prototype.events = {
      "click .newFolder": "newFolder",
      "click .list .action": "removeUser",
      "click .addUserList .action": "addUser"
    };
    Notes.prototype.render = function(project) {
      this.project = project;
      return this.folders = $.map($(".folder", this.el), __bind(function(folder) {
        return new NoteFolder({
          el: $(folder),
          project: this.project
        });
      }, this));
    };
    Notes.prototype.newFolder = function(e) {
      e.preventDefault();
      jsRoutes.controllers.Notes.addFolder(this.project).ajax({
        context: this,
        success: function(tpl) {
          var newFolder;
          newFolder = new NoteFolder({
            el: $(tpl).insertBefore(".newFolder"),
            project: this.project
          });
          return newFolder.el.find("header > h3").editInPlace("edit");
        },
        error: function(err) {
          return $.error("Error: " + err);
        }
      });
      return false;
    };
    Notes.prototype.removeUser = function(e) {
      e.preventDefault();
      jsRoutes.controllers.Projects.removeUser(this.project).ajax({
        context: this,
        data: {
          user: $(e.target).parent().data('user-id')
        },
        success: function() {
          return $(e.target).parent().appendTo(".addUserList");
        },
        error: function(err) {
          return $.error("Error: " + err);
        }
      });
      return false;
    };
    Notes.prototype.addUser = function(e) {
      e.preventDefault();
      jsRoutes.controllers.Projects.addUser(this.project).ajax({
        context: this,
        data: {
          user: $(e.target).parent().data('user-id')
        },
        success: function() {
          return $(e.target).parent().appendTo(".users .list");
        },
        error: function(err) {
          return $.error("Error: " + err);
        }
      });
      return false;
    };
    return Notes;
  })();
  NoteFolder = (function() {
    __extends(NoteFolder, Backbone.View);
    function NoteFolder() {
      this.deleteNote = __bind(this.deleteNote, this);
      this.refreshCount = __bind(this.refreshCount, this);
      this.toggleAll = __bind(this.toggleAll, this);
      this.deleteFolder = __bind(this.deleteFolder, this);
      this.deleteAllNotes = __bind(this.deleteAllNotes, this);
      this.deleteCompleteNotes = __bind(this.deleteCompleteNotes, this);
      this.renameFolder = __bind(this.renameFolder, this);
      this.newNote = __bind(this.newNote, this);
      this.initialize = __bind(this.initialize, this);
      NoteFolder.__super__.constructor.apply(this, arguments);
    }
    NoteFolder.prototype.events = {
      "click .deleteCompleteNotes": "deleteCompleteNotes",
      "click .deleteAllNotes": "deleteAllNotes",
      "click .deleteFolder": "deleteFolder",
      "change header>input": "toggleAll",
      "submit .addNote": "newNote"
    };
    NoteFolder.prototype.initialize = function(options) {
      this.project = options.project;
      this.notes = $.map($(".list li", this.el), __bind(function(item) {
        var newNote;
        newNote = new NoteItem({
          el: $(item),
          folder: this
        });
        newNote.bind("change", this.refreshCount);
        return newNote.bind("delete", this.deleteNote);
      }, this));
      this.counter = this.el.find(".counter");
      this.id = this.el.attr("data-folder-id");
      this.name = $("header > h3", this.el).editInPlace({
        context: this,
        onChange: this.renameFolder
      });
      return this.refreshCount();
    };
    NoteFolder.prototype.newNote = function(e) {
      var form, noteBody, url;
      e.preventDefault();
      $(document).focus();
      form = $(e.target);
      noteBody = $("input[name=noteBody]", form).val();
      url = form.attr("action");
      jsRoutes.controllers.Notes.add(this.project, this.id).ajax({
        url: url,
        type: "POST",
        context: this,
        data: {
          title: $("input[name=noteBody]", form).val(),
          dueDate: $("input[name=dueDate]", form).val(),
          assignedTo: {
            email: $("input[name=assignedTo]", form).val()
          }
        },
        success: function(tpl) {
          var newNote;
          newNote = new NoteItem({
            el: $(tpl),
            folder: this
          });
          this.el.find("ul").append(newNote.el);
          this.notes.push(newNote);
          return form.find("input[type=text]").val("").first().focus();
        },
        error: function(err) {
          return alert("Something went wrong:" + err);
        }
      });
      return false;
    };
    NoteFolder.prototype.renameFolder = function(name) {
      this.loading(true);
      return jsRoutes.controllers.Notes.renameFolder(this.project, this.id).ajax({
        context: this,
        data: {
          name: name
        },
        success: function(data) {
          this.loading(false);
          this.name.editInPlace("close", data);
          this.el.attr("data-folder-id", data);
          return this.id = this.el.attr("data-folder-id");
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
    };
    NoteFolder.prototype.deleteCompleteNotes = function(e) {
      e.preventDefault();
      $.each(this.notes, function(i, item) {
        if (item.el.find(".done:checked").length > 0) {
          item.deleteNote();
        }
        return true;
      });
      return false;
    };
    NoteFolder.prototype.deleteAllNotes = function(e) {
      e.preventDefault();
      $.each(this.notes, function(i, item) {
        item.deleteNote();
        return true;
      });
      return false;
    };
    NoteFolder.prototype.deleteFolder = function(e) {
      e.preventDefault();
      this.el.remove();
      return false;
    };
    NoteFolder.prototype.toggleAll = function(e) {
      var val;
      val = $(e.target).is(":checked");
      return $.each(this.notes, function(i, item) {
        item.toggle(val);
        return true;
      });
    };
    NoteFolder.prototype.refreshCount = function() {
      var count;
      count = this.notes.filter(function(item) {
        return item.el.find(".done:checked").length === 0;
      }).length;
      return this.counter.text(count);
    };
    NoteFolder.prototype.deleteNote = function(note) {
      this.notes = _.without(this.notes, notes);
      return this.refreshCount();
    };
    NoteFolder.prototype.loading = function(display) {
      if (display) {
        this.el.find("header .options").hide();
        return this.el.find("header .loader").show();
      } else {
        this.el.find("header .options").show();
        return this.el.find("header .loader").hide();
      }
    };
    return NoteFolder;
  })();
  NoteItem = (function() {
    __extends(NoteItem, Backbone.View);
    function NoteItem() {
      this.onToggle = __bind(this.onToggle, this);
      this.toggle = __bind(this.toggle, this);
      this.editNote = __bind(this.editNote, this);
      this.deleteNote = __bind(this.deleteNote, this);
      NoteItem.__super__.constructor.apply(this, arguments);
    }
    NoteItem.prototype.events = {
      "change .done": "onToggle",
      "click .deleteNote": "deleteNote",
      "dblclick h4": "editNote"
    };
    NoteItem.prototype.initialize = function(options) {
      this.check = this.el.find(".done");
      this.id = this.el.attr("data-note-id");
      return this.folder = options.folder;
    };
    NoteItem.prototype.deleteNote = function(e) {
      if (e != null) {
        e.preventDefault();
      }
      this.loading(false);
      jsRoutes.controllers.Notes["delete"](this.id).ajax({
        context: this,
        data: {
          name: name
        },
        success: function(data) {
          this.loading(false);
          this.el.remove();
          return this.trigger("delete", this);
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
      return false;
    };
    NoteItem.prototype.editNote = function(e) {
      e.preventDefault();
      alert("not implemented yet.");
      return false;
    };
    NoteItem.prototype.toggle = function(val) {
      this.loading(true);
      return jsRoutes.controllers.Notes.update(this.id).ajax({
        context: this,
        data: {
          done: val
        },
        success: function(data) {
          this.loading(false);
          this.check.attr("checked", val);
          return this.trigger("change", this);
        },
        error: function(err) {
          this.loading(false);
          return $.error("Error: " + err);
        }
      });
    };
    NoteItem.prototype.onToggle = function(e) {
      var val;
      e.preventDefault();
      val = this.check.is(":checked");
      log(val);
      this.toggle(val);
      return false;
    };
    NoteItem.prototype.loading = function(display) {
      if (display) {
        this.el.find(".delete").hide();
        return this.el.find(".loader").show();
      } else {
        this.el.find(".delete").show();
        return this.el.find(".loader").hide();
      }
    };
    return NoteItem;
  })();
  $(function() {
    var app, drawer;
    app = new AppRouter();
    drawer = new Drawer({
      el: $("#projects")
    });
    return Backbone.history.start({
      pushHistory: true
    });
  });
}).call(this);
