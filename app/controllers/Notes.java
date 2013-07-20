package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import java.util.*;

import models.*;
import views.html.tasks.*;

/**
 * Manage tasks related operations.
 */
@Security.Authenticated(Secured.class)
public class Notes extends Controller {

    /**
     * Display the tasks panel for this project.
     */
    public static Result index(Long project) {
        if(Secured.isMemberOf(project)) {
            return ok(
                index.render(
                    Project.find.byId(project)
                )
            );
        } else {
            return forbidden();
        }
    }
    
    /**
     * Create a task in this project.
     */ 
    public static Result add(Long project) {
        if(Secured.isMemberOf(project)) {
            Form<Task> taskForm = form(Task.class).bindFromRequest();
            if(taskForm.hasErrors()) {
                return badRequest();
            } else {
                return ok(
                		
                    //item.render(Note.create(taskForm.get(), project, folder), true)
                );
            }
        } else {
            return forbidden();
        }
    } 
    
    public static Result save() {
    	return ok();
//        Form<Task> taskForm = form(Task.class);
//        return ok(
//            createForm.render(taskForm)
//        );
    }
    
}