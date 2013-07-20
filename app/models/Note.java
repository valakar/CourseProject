package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Task entity managed by Ebean
 */
@Entity 
public class Note extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String title; // folder
    
    @Constraints.Required
    public String text; // title
    
    @Formats.DateTime(pattern="MM/dd/yy")
    public Date Date; //dueDate
    
    @ManyToOne
    public User assignedTo;

    @ManyToOne
    public Project project;
    
    // -- Queries
    
    public static Model.Finder<Long,Note> find = new Model.Finder(Long.class, Note.class);
    
    
    /**
     * Create a task
     */
    public static Note create(Note task, Long project, String folder) {
        task.project = Project.find.ref(project);
        //task.folder = folder;
        task.save();
        return task;
    }

    
    /**
     * Check if a user is the owner of this task
     */
    public static boolean isOwner(Long task, String user) {
        return find.where()
            .eq("project.members.email", user)
            .eq("id", task)
            .findRowCount() > 0;
    }

    // --

    public String toString() {
        return "Task(" + id + ") in project " + project;
    }

}

