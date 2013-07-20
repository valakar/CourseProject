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
public class Tasks extends Controller {

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



}

