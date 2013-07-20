package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.libs.Crypto;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.Encrypted;

/**
 * User entity managed by Ebean
 */
@Entity 
@Table(name="account")
public class User extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    public String email;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String password;
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }
    
    // -- Queries
    
    public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);
    
    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
    	password = Crypto.encryptAES(password, "soldlyaparolya12");
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
    
    public String passEncrypt(String pass) {
    	return Crypto.encryptAES(pass);
    }
    
    // --
    
    public String toString() {
        return "User(" + email + ")";
    }

}

