package controllers;

import controllers.Application.Login;
import play.*;
import play.libs.Crypto;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class SignUp extends Controller {
    
    /**
     * Defines a form wrapping the User class.
     */ 
    final static Form<User> signupForm = form(User.class);
  
    /**
     * Display a blank form.
     */ 
    public static Result blank() {
        return ok(form.render(signupForm));
    }
  
    /**
     * Display a form pre-filled with an existing account.
     */
    public static Result edit() {
        User existingUser = new User(
            "fakeuser", "fake@gmail.com", "secret");
        return ok(form.render(signupForm.fill(existingUser)));
    }
  
    /**
     * Handle the form submission.
     */
    public static Result submit() {
    	
        Form<User> filledForm = signupForm.bindFromRequest();
        
        // Check accept conditions
        if(!"true".equals(filledForm.field("accept").value())) {
            filledForm.reject("accept", "You must accept the terms and conditions");
        }
        
        // Check repeated password
        if(!filledForm.field("password").valueOr("").isEmpty()) {
            if(!filledForm.field("password").valueOr("").equals(filledForm.field("repeatPassword").value())) {
                filledForm.reject("repeatPassword", "Password don't match");
            }
        }
        
        // Check if the username is valid
        if(!filledForm.hasErrors()) {
            if(filledForm.get().name.equals("admin") || filledForm.get().name.equals("guest")) {
                filledForm.reject("name", "This username is already taken");
            }
        }
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
        	filledForm.get().save();
        	flash("success", "User " + filledForm.get().name + " has been created with pass: " + filledForm.get().password);
            return ok(
            	login.render(form(Login.class))
            );
//            return ok(summary.render(created));
        }
    }
  
}