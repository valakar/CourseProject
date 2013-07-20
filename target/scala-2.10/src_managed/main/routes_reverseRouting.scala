// @SOURCE:D:/Java/play/Course_Project/conf/routes
// @HASH:53235bcc75ddcffa83915bb7dfa205dd124a1837
// @DATE:Sat Jul 20 20:16:05 EEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:41
// @LINE:38
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:41
class ReverseAssets {
    

// @LINE:41
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
class ReverseSignUp {
    

// @LINE:15
def submit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:14
def blank(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                
    
}
                          

// @LINE:38
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:11
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:9
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:38
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
}
                                                
    
}
                          

// @LINE:34
// @LINE:31
class ReverseNotes {
    

// @LINE:34
def add(project:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project) + "/new")
}
                                                

// @LINE:31
def index(project:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project) + "/notes")
}
                                                
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:6
class ReverseProjects {
    

// @LINE:27
def addUser(project:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project) + "/team")
}
                                                

// @LINE:22
def renameGroup(group:String): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "projects/groups" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("group", group)))))
}
                                                

// @LINE:21
def deleteGroup(group:String): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "projects/groups" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("group", group)))))
}
                                                

// @LINE:24
def delete(project:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project))
}
                                                

// @LINE:20
def addGroup(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "projects/groups")
}
                                                

// @LINE:28
def removeUser(project:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project) + "/team")
}
                                                

// @LINE:25
def rename(project:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "projects/" + implicitly[PathBindable[Long]].unbind("project", project))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:18
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "projects")
}
                                                
    
}
                          
}
                  


// @LINE:41
// @LINE:38
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:41
class ReverseAssets {
    

// @LINE:41
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
class ReverseSignUp {
    

// @LINE:15
def submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SignUp.submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:14
def blank : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SignUp.blank",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        
    
}
              

// @LINE:38
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:38
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
      }
   """
)
                        
    
}
              

// @LINE:34
// @LINE:31
class ReverseNotes {
    

// @LINE:34
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Notes.add",
   """
      function(project) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project) + "/new"})
      }
   """
)
                        

// @LINE:31
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Notes.index",
   """
      function(project) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project) + "/notes"})
      }
   """
)
                        
    
}
              

// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:6
class ReverseProjects {
    

// @LINE:27
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.addUser",
   """
      function(project) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project) + "/team"})
      }
   """
)
                        

// @LINE:22
def renameGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.renameGroup",
   """
      function(group) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/groups" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("group", group)])})
      }
   """
)
                        

// @LINE:21
def deleteGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.deleteGroup",
   """
      function(group) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/groups" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("group", group)])})
      }
   """
)
                        

// @LINE:24
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.delete",
   """
      function(project) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project)})
      }
   """
)
                        

// @LINE:20
def addGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.addGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/groups"})
      }
   """
)
                        

// @LINE:28
def removeUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.removeUser",
   """
      function(project) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project) + "/team"})
      }
   """
)
                        

// @LINE:25
def rename : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.rename",
   """
      function(project) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("project", project)})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:18
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Projects.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:41
// @LINE:38
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:41
class ReverseAssets {
    

// @LINE:41
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /public path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
class ReverseSignUp {
    

// @LINE:15
def submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SignUp.submit(), HandlerDef(this, "controllers.SignUp", "submit", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:14
def blank(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SignUp.blank(), HandlerDef(this, "controllers.SignUp", "blank", Seq(), "GET", """ Sign up""", _prefix + """signup""")
)
                      
    
}
                          

// @LINE:38
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ Authentication""", _prefix + """login""")
)
                      

// @LINE:38
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """ Javascript routing""", _prefix + """assets/javascripts/routes""")
)
                      
    
}
                          

// @LINE:34
// @LINE:31
class ReverseNotes {
    

// @LINE:34
def add(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Notes.add(project), HandlerDef(this, "controllers.Notes", "add", Seq(classOf[Long]), "GET", """ Add note""", _prefix + """projects/$project<[^/]+>/new""")
)
                      

// @LINE:31
def index(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Notes.index(project), HandlerDef(this, "controllers.Notes", "index", Seq(classOf[Long]), "GET", """ Tasks""", _prefix + """projects/$project<[^/]+>/notes""")
)
                      
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:6
class ReverseProjects {
    

// @LINE:27
def addUser(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.addUser(project), HandlerDef(this, "controllers.Projects", "addUser", Seq(classOf[Long]), "POST", """""", _prefix + """projects/$project<[^/]+>/team""")
)
                      

// @LINE:22
def renameGroup(group:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.renameGroup(group), HandlerDef(this, "controllers.Projects", "renameGroup", Seq(classOf[String]), "PUT", """""", _prefix + """projects/groups""")
)
                      

// @LINE:21
def deleteGroup(group:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.deleteGroup(group), HandlerDef(this, "controllers.Projects", "deleteGroup", Seq(classOf[String]), "DELETE", """""", _prefix + """projects/groups""")
)
                      

// @LINE:24
def delete(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.delete(project), HandlerDef(this, "controllers.Projects", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """projects/$project<[^/]+>""")
)
                      

// @LINE:20
def addGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.addGroup(), HandlerDef(this, "controllers.Projects", "addGroup", Seq(), "POST", """""", _prefix + """projects/groups""")
)
                      

// @LINE:28
def removeUser(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.removeUser(project), HandlerDef(this, "controllers.Projects", "removeUser", Seq(classOf[Long]), "DELETE", """""", _prefix + """projects/$project<[^/]+>/team""")
)
                      

// @LINE:25
def rename(project:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.rename(project), HandlerDef(this, "controllers.Projects", "rename", Seq(classOf[Long]), "PUT", """""", _prefix + """projects/$project<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.index(), HandlerDef(this, "controllers.Projects", "index", Seq(), "GET", """ The home page""", _prefix + """""")
)
                      

// @LINE:18
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Projects.add(), HandlerDef(this, "controllers.Projects", "add", Seq(), "POST", """ Projects""", _prefix + """projects""")
)
                      
    
}
                          
}
                  
      