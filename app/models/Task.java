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
public class Task extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String title;
    
    @Formats.DateTime(pattern="MM/dd/yy")
    public Date dueDate;
    
    @ManyToOne
    public User assignedTo;
    
    public String folder;
    
    @ManyToOne
    public Project project;
    
    // -- Queries
    
    public static Model.Finder<Long,Task> find = new Model.Finder(Long.class, Task.class);

}

