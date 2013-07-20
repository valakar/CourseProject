// @SOURCE:D:/Java/play/Course_Project/conf/routes
// @HASH:53235bcc75ddcffa83915bb7dfa205dd124a1837
// @DATE:Sat Jul 20 20:16:05 EEST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Projects_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Application_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Application_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:14
private[this] lazy val controllers_SignUp_blank4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:15
private[this] lazy val controllers_SignUp_submit5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:18
private[this] lazy val controllers_Projects_add6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects"))))
        

// @LINE:20
private[this] lazy val controllers_Projects_addGroup7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/groups"))))
        

// @LINE:21
private[this] lazy val controllers_Projects_deleteGroup8 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/groups"))))
        

// @LINE:22
private[this] lazy val controllers_Projects_renameGroup9 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/groups"))))
        

// @LINE:24
private[this] lazy val controllers_Projects_delete10 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true))))
        

// @LINE:25
private[this] lazy val controllers_Projects_rename11 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true))))
        

// @LINE:27
private[this] lazy val controllers_Projects_addUser12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true),StaticPart("/team"))))
        

// @LINE:28
private[this] lazy val controllers_Projects_removeUser13 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true),StaticPart("/team"))))
        

// @LINE:31
private[this] lazy val controllers_Notes_index14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true),StaticPart("/notes"))))
        

// @LINE:34
private[this] lazy val controllers_Notes_add15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("projects/"),DynamicPart("project", """[^/]+""",true),StaticPart("/new"))))
        

// @LINE:38
private[this] lazy val controllers_Application_javascriptRoutes16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
        

// @LINE:41
private[this] lazy val controllers_Assets_at17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Projects.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.SignUp.blank()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.SignUp.submit()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects""","""controllers.Projects.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/groups""","""controllers.Projects.addGroup()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/groups""","""controllers.Projects.deleteGroup(group:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/groups""","""controllers.Projects.renameGroup(group:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>""","""controllers.Projects.delete(project:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>""","""controllers.Projects.rename(project:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>/team""","""controllers.Projects.addUser(project:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>/team""","""controllers.Projects.removeUser(project:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>/notes""","""controllers.Notes.index(project:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """projects/$project<[^/]+>/new""","""controllers.Notes.add(project:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.Application.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Projects_index0(params) => {
   call { 
        invokeHandler(controllers.Projects.index(), HandlerDef(this, "controllers.Projects", "index", Nil,"GET", """ The home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Authentication""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Application_logout3(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:14
case controllers_SignUp_blank4(params) => {
   call { 
        invokeHandler(controllers.SignUp.blank(), HandlerDef(this, "controllers.SignUp", "blank", Nil,"GET", """ Sign up""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:15
case controllers_SignUp_submit5(params) => {
   call { 
        invokeHandler(controllers.SignUp.submit(), HandlerDef(this, "controllers.SignUp", "submit", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:18
case controllers_Projects_add6(params) => {
   call { 
        invokeHandler(controllers.Projects.add(), HandlerDef(this, "controllers.Projects", "add", Nil,"POST", """ Projects""", Routes.prefix + """projects"""))
   }
}
        

// @LINE:20
case controllers_Projects_addGroup7(params) => {
   call { 
        invokeHandler(controllers.Projects.addGroup(), HandlerDef(this, "controllers.Projects", "addGroup", Nil,"POST", """""", Routes.prefix + """projects/groups"""))
   }
}
        

// @LINE:21
case controllers_Projects_deleteGroup8(params) => {
   call(params.fromQuery[String]("group", None)) { (group) =>
        invokeHandler(controllers.Projects.deleteGroup(group), HandlerDef(this, "controllers.Projects", "deleteGroup", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """projects/groups"""))
   }
}
        

// @LINE:22
case controllers_Projects_renameGroup9(params) => {
   call(params.fromQuery[String]("group", None)) { (group) =>
        invokeHandler(controllers.Projects.renameGroup(group), HandlerDef(this, "controllers.Projects", "renameGroup", Seq(classOf[String]),"PUT", """""", Routes.prefix + """projects/groups"""))
   }
}
        

// @LINE:24
case controllers_Projects_delete10(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Projects.delete(project), HandlerDef(this, "controllers.Projects", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """projects/$project<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_Projects_rename11(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Projects.rename(project), HandlerDef(this, "controllers.Projects", "rename", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """projects/$project<[^/]+>"""))
   }
}
        

// @LINE:27
case controllers_Projects_addUser12(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Projects.addUser(project), HandlerDef(this, "controllers.Projects", "addUser", Seq(classOf[Long]),"POST", """""", Routes.prefix + """projects/$project<[^/]+>/team"""))
   }
}
        

// @LINE:28
case controllers_Projects_removeUser13(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Projects.removeUser(project), HandlerDef(this, "controllers.Projects", "removeUser", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """projects/$project<[^/]+>/team"""))
   }
}
        

// @LINE:31
case controllers_Notes_index14(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Notes.index(project), HandlerDef(this, "controllers.Notes", "index", Seq(classOf[Long]),"GET", """ Tasks""", Routes.prefix + """projects/$project<[^/]+>/notes"""))
   }
}
        

// @LINE:34
case controllers_Notes_add15(params) => {
   call(params.fromPath[Long]("project", None)) { (project) =>
        invokeHandler(controllers.Notes.add(project), HandlerDef(this, "controllers.Notes", "add", Seq(classOf[Long]),"GET", """ Add note""", Routes.prefix + """projects/$project<[^/]+>/new"""))
   }
}
        

// @LINE:38
case controllers_Application_javascriptRoutes16(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """ Javascript routing""", Routes.prefix + """assets/javascripts/routes"""))
   }
}
        

// @LINE:41
case controllers_Assets_at17(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /public path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        